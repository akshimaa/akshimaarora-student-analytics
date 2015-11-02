/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csi.studentanalytics.model;

/**
 *
 * @author Madan Parameswaran
 */
public class Score {
    
    private enum Type {SAT, GRE, GMAT};
    private int score;
    private Type type;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        
        this.score = score;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
}
