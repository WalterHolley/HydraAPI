package com.umsl.hydra.api.model;

public class GameRequest {

    private int action;
    private int[] directionSequence;

    public int getAction(){return action;}
    public int[] getDirectionSequence(){return directionSequence;}

    public void setAction(int action){
        if(action == 1 || action == 2)
            this.action = action;

    }

    /**
     * Set
     * @param sequence integer array of 3 values.  each value must be a 0 or 1.
     */
    public void setDirectionSequence(int[] sequence){
        if(sequence.length == 3){
            this.directionSequence = sequence;
        }
    }
}
