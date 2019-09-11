package com.jiruffe.sennenpazuru.model;

public class Player {

    private int lp;

    public Player() {
        this(8000);
    }

    public Player(int lp) {
        this.lp = lp;
    }

    public String getLp() {
        return String.valueOf(lp);
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    private void makeSureLpNotLessThanZero() {
        if (lp < 0) {
            lp = 0;
        }
    }

    public void minus(int diff) {
        lp -= diff;
        makeSureLpNotLessThanZero();
    }

    public void plus(int diff) {
        lp += diff;
        makeSureLpNotLessThanZero();
    }

    public void multiply(int diff) {
        lp *= diff;
        makeSureLpNotLessThanZero();
    }

    public void divide(int diff) {
        lp /= diff;
        makeSureLpNotLessThanZero();
    }

}
