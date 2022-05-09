package com.umsl.hydra.api.model;

import java.util.Comparator;

public class SortHighScores implements Comparator<HighScore> {
    @Override
    public int compare(HighScore o1, HighScore o2) {
        return (o1.getDifficulty() - o2.getDifficulty()) - (o1.getRounds() - o2.getRounds());
    }
}
