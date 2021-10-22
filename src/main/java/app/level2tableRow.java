package app;

public class level2tableRow {
    String lga;
    String state;
    int rawDataIndig;
    int rawDataNonIndig;
    double percentIndig;
    double percentNonIndig;

    level2tableRow() {
        lga = "";
        state = "";
        rawDataIndig = 0;
        rawDataNonIndig = 0;
        percentIndig = 0.0;
        percentNonIndig = 0.0;
    }

    public void setLga(String input) {
        lga = input;
    }

    public void setState(String input) {
        state = input;
    }

    public void setRawIndig(int input) {
        rawDataIndig = input;
    }
    
    public void setRawNonIndig(int input) {
        rawDataNonIndig = input;
    }

    public void setPercentIndig(double input) {
        percentIndig = input;
    }

    public void setPercentNonIndig(double input) {
        percentNonIndig = input;
    }

    public String getLga() {
        return lga;
    }

    public String getState() {
        return state;
    }

    public int getRawIndig () {
        return rawDataIndig;
    }

    public int getRawNonIndig () {
        return rawDataNonIndig;
    }

    public double getPercentIndig () {
        return percentIndig;
    }

    public double getPercentNonIndig() {
        return percentNonIndig;
    }
 




}
