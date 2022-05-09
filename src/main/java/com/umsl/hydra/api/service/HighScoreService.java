package com.umsl.hydra.api.service;

import com.umsl.hydra.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import com.umsl.hydra.api.model.Repository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
AI Service - This is how the controller and
other services will interact with the game AI.
Use this area to gather needed information about the game session, then
pass that information along to the AI utility for performing the game decision.

You can also use this area to call on resources that need to be changed before or after
game AI functions.
 */

@Component
public class HighScoreService implements Repository<HighScore> {

    @Autowired
    private RedisTemplate<String, HighScore> redisTemplate;

    public RedisTemplate<String,HighScore> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String,HighScore> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }



    @Override
    public void put(HighScore item) {
        if(isValidScore(item))
            redisTemplate.opsForHash().put(item.getObjectKey(), item.getKey(), item);
    }

    @Override
    public void delete(HighScore item) {
        redisTemplate.opsForHash().delete(item.getObjectKey(), item.getKey());
    }

    @Override
    public List<HighScore> getItems() {
        List<HighScore> scores = new ArrayList<HighScore>();

        for(Object score : redisTemplate.opsForHash().values(HighScore.OBJECT_KEY)){
            scores.add((HighScore) score);
        }

        return scores;
    }

    public HighScore createScore(int difficultyCode, int roundsPlayed, String playerName){
        HighScore score;

        String id = String.valueOf(System.currentTimeMillis());
        score = new HighScore(id, difficultyCode, roundsPlayed, playerName);

        return score;
    }

    public HighScoreResponse getHighScores(){
        HighScoreResponse response = new HighScoreResponse();
        List<HighScore> scores = getItems();
        Collections.sort(scores);
        response.setHighScoreList(scores);
        return response;
    }

    private boolean isValidScore(HighScore score){
        List<HighScore> scores = getItems();
        boolean result = false;
        if(scores != null){
            if(scores.size() < GameConstants.LOWEST_SCORE_RANK){
                result = true;
            }
            else{
                scores.add(score);
                Collections.sort(scores, new SortHighScores());
                if(scores.get(GameConstants.LOWEST_SCORE_RANK) != score){
                    result = true;
                }
            }
        }

        return result;

    }
}
