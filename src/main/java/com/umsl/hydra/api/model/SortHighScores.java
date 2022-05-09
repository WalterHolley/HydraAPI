package com.umsl.hydra.api.model;

import java.util.Comparator;

public class SortHighScores implements Comparator<HighScore> {
    @Override
    public int compare(HighScore o1, HighScore o2) {
        int result = 0;
        if(o1.getDifficulty() > o2.getDifficulty())
            result = 1;

        if((o1.getDifficulty() == o2.getDifficulty()) && (o1.getRounds() < o2.getRounds())){
           result = 1;
        }

        return result;
    }
}
