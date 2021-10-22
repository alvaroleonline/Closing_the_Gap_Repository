package app;

public class level2tableRow {
    String lga;
    String state;
    int countIndig;
    int countNonIndig;
    double percentIndig;
    double percentNonIndig;
    double gapScore;

    level2tableRow() {
        lga = "";
        state = "";
        countIndig = 0;
        countNonIndig = 0;
        percentIndig = 0.0;
        percentNonIndig = 0.0;
        gapScore = 0.0;
    }

    public void setLga(String input) {
        lga = input;
    }

    public void setState(String input) {
        state = input;
    }

    public void setCountIndig(int input) {
        countIndig = input;
    }
    
    public void setCountNonIndig(int input) {
        countNonIndig = input;
    }

    public void setPercentIndig(double input) {
        percentIndig = input;
    }

    public void setPercentNonIndig(double input) {
        percentNonIndig = input;
    }

    public void setGapScore(double input) {
        gapScore = input;
    }

    public String getLga() {
        return lga;
    }

    public String getState() {
        return state;
    }

    public int getCountIndig () {
        return countIndig;
    }

    public int getCountNonIndig () {
        return countNonIndig;
    }

    public double getPercentIndig () {
        return percentIndig;
    }

    public double getPercentNonIndig() {
        return percentNonIndig;
    }

    public double getGapScore() {
        return gapScore;
    }
 




}
