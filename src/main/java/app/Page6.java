package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Temporary HTML as an example page.
 * 
 * Based on the Project Workshop code examples.
 * This page currently:
 *  - Provides a link back to the index page
 *  - Displays the list of movies from the Movies Database using the JDBCConnection
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class Page6 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page6.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>";
        html = html + "   <title>Compare LGAs across various measures</title>";

        // Add some CSS (external file)
        html = html + "   <link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/af-2.3.7/b-2.0.1/r-2.2.9/sp-1.4.0/datatables.min.css'>";
        html = html + "   <script type='text/javascript' src='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/datatables.min.js'></script>";
        html = html + "   <link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "   <script src='common.js'></script>";
        html = html + "   <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";
    
        // Add the body
        html = html + "</head><body>";

        
        // HEADER
        //navigation header
        html = html + "<div id='header'>";
        //html = html + "<div id='container-header' class='container'>";
        html = html + "<div class='navbar'>";
        html = html + "<a href='/'>Home</a>";
        html = html + "<a href='info.html'>Information</a>";
        html = html + "<div class='subnav'>";
        html = html + "<button class='subnavbtn'>Outcome Data  <i class='fa fa-caret-down'></i></button>";
        html = html + "<div class='subnav-content'>";
        html = html + "<a href='page3.html'>Data by LGA</a>";
        html = html + "<a href='page4.html'>Data by State</a>";
        html = html + "<a href='page5.html'>Measuring the Gap</a>";
        html = html + "<a href='page6.html'>Compare LGAs</a>";
        html = html + "</div></div>";
        html = html + "<a href='resources.html'>Resources</a></div>";
        // CLOSES HEADER
        //html = html + "</div>";
        html = html + "</div>";


        // OPENS CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";

        // 1st DIV - Default Content Div
        html = html + "<div class='content-title'>";
        html = html + "<h1>Compare LGAs' Attributes using GapScore </h1>";
        html = html + "<hr class='white'>" + "<p>Compare the GapScore across Local Governments Areas using various measures including population, population density, and geographic area.</p>";
        html = html + "</div>";

        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";

        //populate form submission results
        ArrayList<String> outcomeSelect = new ArrayList<String>();
        if (context.formParam("outcome1") != null) {   
            outcomeSelect.add(context.formParam("outcome1"));
        }
        if (context.formParam("outcome5") != null) {   
            outcomeSelect.add(context.formParam("outcome5"));
        }
        if (context.formParam("outcome6") != null) {   
            outcomeSelect.add(context.formParam("outcome6"));
        }
        if (context.formParam("outcome8") != null) {   
            outcomeSelect.add(context.formParam("outcome8"));
        }
        String lgaDrop = context.formParam("lgaDrop");
        String comparisonRadio = context.formParam("comparisonRadio");
        String distanceDrop = context.formParam("distanceDrop");


        //Col1 - Chart options
        html = html + "<div class='col1'>";
        html = html + "<h1>Define GapScore and Choose LGA Comparison</h1><hr class='in'>";
        
        html = html + "<form action='/page6.html' method='post'>";
        
        html = html + "   <div class='form-notdrop'>";
        html = html + "   <p class='displayTag'><label for='outcomeSelect'>Select Outcomes to generate GapScore from:</label></p>";
        html = html +           createCheckbox("outcome1", "gapScore1", "Outcome 1 - Long & Healthy Lives", outcomeSelect);
        html = html +           createCheckbox("outcome5", "gapScore5", "Outcome 5 - School Completion", outcomeSelect);
        html = html +           createCheckbox("outcome6", "gapScore6", "Outcome 6 - Tertiary Education", outcomeSelect);
        html = html +           createCheckbox("outcome8", "gapScore8", "Outcome 8 - Employment", outcomeSelect);
        html = html + "   </div>";

        html = html + "   <br><div class='form-group'>";
        html = html + "      <select id='lgaDrop' name='lgaDrop'>";
        html = html +           createDropOption("none", "Select LGA to Compare Against:", lgaDrop);
        html = html +           createDropOption("none", " --- Select by GapScore --- ", lgaDrop);
        html = html +           createDropOption("outcomeBest", "LGA with Best GapScore for selected Outcomes", lgaDrop);
        html = html +           createDropOption("outcomeWorst", "LGA with Worst GapScore for selected Outcomes", lgaDrop);
        html = html +           createDropOption("none", " --- Select by LGA Name --- ", lgaDrop);
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> lgaNames = jdbc.getLGAs();
        for (String lga : lgaNames) {
            html = html +       createDropOption(lga, lga, lgaDrop);
        }
        html = html + "      </select>";
        html = html + "   </div>";

        html = html + "   <p class='displayTag'>Compare to LGAs similar by:</p>";
        html = html + "   <div class='form-radio'>";
        html = html +           createRadioBtn("score", "gapScore", "GapScore", comparisonRadio, true);
        html = html +           createRadioBtn("population", "lgaPopulation", "Total LGA Population", comparisonRadio, false);
        html = html +           createRadioBtn("density", "populationDensity", "LGA Population Density", comparisonRadio, false);
        html = html +           createRadioBtn("proportionIndigenous", "proportionIndigenous", "Proportion of LGA who are Indigenous", comparisonRadio, false);
        html = html +           createRadioBtn("distance", "distance", "Distance from Source LGA", comparisonRadio, false);

        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <select id='distanceDrop' name='distanceDrop'>";
        html = html +           createDropOption("50", "less than 50km", distanceDrop);
        html = html +           createDropOption("100", "less than 100km", distanceDrop);
        html = html +           createDropOption("150", "less than 150km", distanceDrop);
        html = html +           createDropOption("200", "less than 200km", distanceDrop);
        html = html +           createDropOption("250", "less than 250km", distanceDrop);
        html = html +           createDropOption("300", "less than 300km", distanceDrop);
        html = html + "      </select>";
        html = html + "   </div>";

        html = html + "   <button type='submit' class='btn btn-primary'>Update Chart</button>";

        html = html + "</form>";
        
        html = html + "</div>";

        //Col - Table
        html = html + "<div class='colTable'>";
        if (outcomeSelect.size() == 0 || lgaDrop == null || lgaDrop.equals("none")) {
            html = html + "<h1>Compare LGAs</h1><hr class='in'><h3>Awaiting Selection: Please select table data options on the left</h3>";
        } else {
            String comparisonText = "";
            String titleText;
            String lgaText;

            if (comparisonRadio.equals("gapScore")){
                comparisonText = "GapScore";
                titleText = "GapScore";
            } else if (comparisonRadio.equals("lgaPopulation")) {
                comparisonText = "total population";
                titleText = "Population";
            } else if (comparisonRadio.equals("populationDensity")) {
                comparisonText = "population density";
                titleText = "Density";
            } else if (comparisonRadio.equals("proportionIndigenous")) {    
                comparisonText = "proportion of the population that are Indigenous";
                titleText = "Indigenous Proportion";
            } else {    //distance
                titleText = "Distance";
            }
            
            if (lgaDrop.equals("outcomeBest")) {
                lgaText = "the LGA with best GapScore for selected outcomes";
            } else if (lgaDrop.equals("outcomeWorst")){
                lgaText = "the LGA with worst GapScore for selected outcomes";
            } else {
                lgaText = lgaDrop;
            }

            html = html + "<h1>LGAs Compared on " + titleText + "</h1>";
            if (comparisonRadio.equals("distance")){
                html = html + "<hr class='in'><h3>Displaying LGAs within " + distanceDrop + "km of " + lgaText + ".</h3>";
            } else {
                html = html + "<hr class='in'><h3>Displaying up to 10 LGAs that have the closest " + comparisonText + ", compared to " + lgaText + ".</h3>";
            }
            html = html + "<p>GapScore is a rating of 0 to 100, where 100 indicates the Indigenous population have met or exceeded the national average for the non-Indigenous population in the selected Outcome(s).</p>";
        }
        //Testing form submission results
        // html = html + "<p>OutcomeSelect - Size = " + outcomeSelect.size() + " Contents = ";
        // for (String outcome : outcomeSelect) {
        //     html = html + outcome + ", ";
        // }
        // html = html + "</p>";
        // html = html + "<p>LGA Dropdown = " + lgaDrop + "</p>";
        // html = html + "<p>Comparison Radio = " + comparisonRadio + "</p>";

        //testQuery
        // JDBCConnection jdbc = new JDBCConnection();
        // ArrayList<level2tableRow> tableData = jdbc.testQuery();

        //Output into a table
        if (outcomeSelect.size() == 0 || lgaDrop == null || lgaDrop.equals("none")) {
            html = html + "";
        } else {
            //create and populate sourceLGA data from jdbc
            compareLGAdata sourceLGA = jdbc.sourceLGA(outcomeSelect, lgaDrop);
            //start table
            html = html + "<table id='table_id2' class='display'>";
            html = html + "<thead><tr>";
            html = html + "<th>LGA</th><th>GapScore</th><th>Total Population</th><th>Population Density</th><th>Indigenous Proportion</th>";
            html = html + "</tr></thead>";

            html = html + "<tbody>";
            html = html + "<tr>";
            html = html + "<td><b id='blue'>" + sourceLGA.getLga() + ", " + sourceLGA.getState() + "</td>";
            html = html + "<td>" + String.format("%.1f",sourceLGA.getGapScore()) + "</td>";
            html = html + "<td>" + sourceLGA.getPopulation() + "</td>";
            html = html + "<td>" + String.format("%.2f", sourceLGA.getDensity()) + " p/km&#178;</td>";
            html = html + "<td>" + String.format("%.2f",sourceLGA.getProportionIndig()) + "%</td>";
            html = html + "</tr>";

            // Finish the table
            html = html + "</tbody>";
            html = html + "</table>";

            String sourceLgaName = sourceLGA.getLga();

            //for comparing LGAs by distance
            if (comparisonRadio.equals("distance")) {

                //pull table data for ALL LGAs except the source LGA
                ArrayList<compareLGAdata> tableData = jdbc.compareDistance(outcomeSelect, sourceLgaName);

                //convert source LGA coordinates to Radians
                double lat1 = Math.toRadians(sourceLGA.getLatitude());
                double long1 = Math.toRadians(sourceLGA.getLongitude());

                html = html + "<table id='table_id' class='display'>";
                html = html + "<thead><tr>";
                html = html + "<th>LGA</th><th>GapScore</th><th>Total Population</th><th>Population Density</th><th>Indigenous Proportion</th>";
                html = html + "</tr></thead>";

                html = html + "<tbody>";

                for (compareLGAdata row : tableData) {

                    //get the distance from source LGA for the LGA in current table row
                    double distance = getDistance(row, lat1, long1);

                    //if distance is less than the one selected by user, display LGA's data in table
                    if (distance < Integer.parseInt(distanceDrop)) {

                    html = html + "<tr>";
                    html = html + "<td><b id='blue'>" + row.getLga() + ", " + row.getState() + "</td>";
                    html = html + "<td>" + String.format("%.1f", row.getGapScore()) + "</td>";
                    html = html + "<td>" + row.getPopulation() + "</td>";
                    html = html + "<td>" + String.format("%.2f", row.getDensity()) + " p/km&#178;</td>";
                    html = html + "<td>" + String.format("%.2f", row.getProportionIndig()) + "%</td>";
                    html = html + "</tr>";

                    }
                }

                // Finish the table
                html = html + "</tbody>";
                html = html + "</table>";
            
            } else { 
                //for all other comparisons
                ArrayList<compareLGAdata> tableData = jdbc.compareLGA(outcomeSelect, lgaDrop, sourceLgaName, comparisonRadio);

                html = html + "<table id='table_id' class='display'>";
                html = html + "<thead><tr>";
                html = html + "<th>LGA</th><th>GapScore</th><th>Total Population</th><th>Population Density</th><th>Indigenous Proportion</th>";
                html = html + "</tr></thead>";

                html = html + "<tbody>";

                for (compareLGAdata row : tableData) {
                    html = html + "<tr>";
                    html = html + "<td><b id='blue'>" + row.getLga() + ", " + row.getState() + "</td>";
                    html = html + "<td>" + String.format("%.1f", row.getGapScore()) + "</td>";
                    html = html + "<td>" + row.getPopulation() + "</td>";
                    html = html + "<td>" + String.format("%.2f", row.getDensity()) + " p/km&#178;</td>";
                    html = html + "<td>" + String.format("%.2f", row.getProportionIndig()) + "%</td>";
                    html = html + "</tr>";
                }

                // Finish the table
                html = html + "</tbody>";
                html = html + "</table>";
            }
        }
        html = html + "</div>";

        // Closes Row DIV 
        html = html + "</div>";

        //New row and col DIV for switching charts
        html = html + "<div class='row3'>";
        html = html + "<div class='col1hide'>";
        html = html + "</div>";
        html = html + "<div class='colTable'>";
        html = html + "   <h2>Explore the data in different ways</h2><hr class='in'>";
        html = html + "   <div class='chart-switch'>";
        html = html + "      <a href='page3.html'>Data by LGA</a>";
        html = html + "      <a href='page4.html'>Data by State</a>";
        html = html + "      <a href='page5.html'>Measuring the Gap</a>";
        // html = html + "      <a href='page6.html'>Compare LGAs</a>";
        html = html + "   </div>";
        html = html + "</div>";
        html = html + "</div>";


        //CLOSES CONTENT
        html = html + "</div>";
        html = html + "</div>";

        //FOOTER
        //Closes Footer

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

    public String createDropOption(String value, String label, String lastSubmission) {
        String option = "<option value = '" + value + "' ";
        if (lastSubmission != null && !lastSubmission.equals("none") && lastSubmission.equals(value)) {
            option = option + "selected ";
        }
        option = option + "> " + label + "</option>";
        return option;
    }

    public String createRadioBtn(String id, String value, String label, String lastSubmission, boolean firstBtn) {
        String radio = "<input type='radio' class='radiobtn' id='" + id + "' name='comparisonRadio' value='" + value + "' ";
        
        //if the radio button is to be selected on page first load, firstBtn needs to be set to true
        if (firstBtn) {
            if (lastSubmission == null || lastSubmission.equals(value)) {
                radio = radio + "checked ='checked' ";
            }
        } else {
            if (lastSubmission != null && lastSubmission.equals(value)) {
                radio = radio + "checked ='checked' ";
            }
        }
        radio = radio + "><label class ='radiolabel' for='" + id + "'>" + label + "</label>";

        return radio;
    }

    public String createCheckbox(String id, String value, String label, ArrayList<String> lastSubmission) {
        String checkbox = "<label class='checkboxContainer'><input type='checkbox' id='" + id + "' name='" + id + "' value='" + value + "' ";
        if (lastSubmission.size() > 0 && lastSubmission.contains(value)) {
            checkbox = checkbox + "checked ='checked' ";
        }
        checkbox = checkbox + "><label for='" + id + "'>" + label + "</label><span class='checkmark'></span></label><br>";
        return checkbox;
    }


    public double getDistance (compareLGAdata currentLGA, double lat1, double long1) {
        double lat2 = Math.toRadians(currentLGA.getLatitude());
        double long2 = Math.toRadians(currentLGA.getLongitude());

        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.pow(Math.sin(dlon / 2),2);
             
        double c = 2 * Math.asin(Math.sqrt(a));
 
        // Radius of earth in kilometers
        double r = 6371;
 
        return (c * r);
    }

}
