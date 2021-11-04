package app;

public class compareLGAdata {
    String lga;
    String state;
    int population;
    double density;
    double proportionIndig;
    double gapScore;

    compareLGAdata() {
        lga = "";
        state = "";
        population = 0;
        density = 0.0;
        proportionIndig = 0.0;
        gapScore = 0.0;
    }

    public void setLga(String input) {
        lga = input;
    }

    public void setState(String input) {
        state = input;
    }

    public void setPopulation(int input) {
        population = input;
    }

    public void setDensity(double input) {
        density = input;
    }

    public void setProportionIndig(double input) {
        proportionIndig = input;
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

    public int getPopulation () {
        return population;
    }

    public double getDensity () {
        return density;
    }

    public double getProportionIndig() {
        return proportionIndig;
    }

    public double getGapScore() {
        return gapScore;
    }
 




}
