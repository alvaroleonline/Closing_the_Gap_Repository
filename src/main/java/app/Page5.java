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
public class Page5 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page5.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Outcome Data by Gap Score</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/af-2.3.7/b-2.0.1/r-2.2.9/sp-1.4.0/datatables.min.css'>";
        html = html + "<script type='text/javascript' src='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/datatables.min.js'></script>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='common.js'></script>";
        html = html + "<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>";
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";
        

        // Add the body
        html = html + "<body>";

        JDBCConnection jdbc = new JDBCConnection();


        // HEADER
        //navigation header
        html = html + "<div id='header'>";
        //html = html + "<div id='container-header' class='container'>";
        html = html + "<div class='navbar'>";
        html = html + "<a href='/'>Home</a>";
        html = html + "<a class='current' href='mission.html'>Mission</a>";
        html = html + "<div class='subnav'>";
        html = html + "<button class='subnavbtn'>Outcome Data  <i class='fa fa-caret-down'></i></button>";
        html = html + "<div class='subnav-content'>";
        html = html + "<a href='page3.html'>Data by LGA</a>";
        html = html + "<a href='page4.html'>Data by State</a>";
        html = html + "<a href='page5.html'>The Gap</a>";
        html = html + "<a href='page6.html'>Similar Attributes</a>";
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
        html = html + "<h1>Measuring the Gap</h1>";
        html = html + "<hr class='white'>" + "<p>Explore the socioeconomic outcome data for Indigenous Australians by Local Goverment Area.</p>";
        html = html + "</div>";


        // 1st DIV - Default Content Div
        html = html + "<div class='content-box'>";
        html = html + "<h2>Figures displaying the percentage for Indigenous and Non-Indigenous Australians on each socieconomic outcome.</h2>";
        html = html + "<hr class='in'>" + "<p>Gap Difference at a National Level.</p><br>";
        
        // Graph
        html = html + "<p class='percent'>%</p>";
        html = html + "<canvas id='myChart'></canvas>";
        // Outcome 1 
        double outcome1I = jdbc.getOutcome1I("Indigenous");
        double outcome1NonI = jdbc.getOutcome1NonI("Non-Indigenous");

        // Outcome 5 
        double outcome5I = jdbc.getOutcome5I("Indigenous");
        double outcome5NonI = jdbc.getOutcome5NonI("Non-Indigenous");

        // Outcome 6
        double outcome6I = jdbc.getOutcome6I("Indigenous");
        double outcome6NonI = jdbc.getOutcome6NonI("Non-Indigenous");
        
        // Outcome 8 
        double outcome8I = jdbc.getOutcome8I("Indigenous");
        double Outcome8NonI = jdbc.getOutcome8NonI("Non-Indigenous");

         
        // Script 
        html = html + "<script>const labels = ['Outcome 1', 'Outcome 5', 'Outcome 6', 'Outcome 8',];";
        html = html + "const data = {labels: labels, datasets: [";
        html = html + "{label: 'Indigenous', backgroundColor: 'rgb(255,118,0)', borderColor: 'rgb(255,118,0)', data: [" + String.format("%.1f", outcome1I) + "," + String.format("%.1f", outcome5I) + "," + String.format("%.1f", outcome6I) + "," + String.format("%.1f", outcome8I) + ",]},";
        html = html + "{label: 'Non-Indigenous', backgroundColor: 'rgb(26,35,126)', borderColor: 'rgb(26,35,126)', data: [" + String.format("%.1f", outcome1NonI) + "," + String.format("%.1f", outcome5NonI) + "," + String.format("%.1f", outcome6NonI) + "," + String.format("%.1f", Outcome8NonI) + ",]},";
        html = html + "]};";
        html = html + "const config = {type: 'bar', data: data, options: {responsive: true, interaction: {mode: 'index',intersect: false,}, plugins: {legend: {labels: {font: {size: 12}}, align: 'end', position: 'top'}, tooltip: {bodyFont: {size: 15}},}}};";
        html = html + "const myChart = new Chart(document.getElementById('myChart'), config);";
        html = html + "</script>";
        // Graph Closed
        
        html = html + "</div>";

       


        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";


        //populate form submission results
        String outcomeDrop = context.formParam("outcomeDrop");
        String populationDrop = context.formParam("populationDrop");
        String displayAsRadio = context.formParam("displayAsRadio");
        // String populationRange = context.formParam("populationRange");


        //Col1 - Chart
        html = html + "<div class='col1'>";
        html = html + "<h1>Custom Charts</h1><hr class='in'>";
        
        html = html + "<form action='/page5.html' method='post' oninput='x.value=parseInt(populationRange.value)'>";
        
        html = html + "   <div class='form-group'>";
        // html = html + "      <label for='outcomeDrop'>Select the Outcome Data to Display:</label>";
        html = html + "      <select id='outcomeDrop' name='outcomeDrop'>";
        html = html +           createDropOption("none", "Select Outcome", outcomeDrop);
        html = html +           createDropOption("outcome1", "Outcome 1 - Long & Healthy Lives", outcomeDrop);
        html = html +           createDropOption("outcome5", "Outcome 5 - School Completion", outcomeDrop);
        html = html +           createDropOption("outcome6", "Outcome 6 - Tertiary Education", outcomeDrop);
        html = html +           createDropOption("outcome8", "Outcome 8 - Economic Participation", outcomeDrop);
        html = html + "      </select>";
        html = html + "   </div>";


        html = html + "   <div class='form-group'>";
        html = html + "      <select id='populationDrop' name='populationDrop'>";
        html = html +           createDropOption("none", "Select the Population Segment", populationDrop);
        html = html +           createDropOption("All", "Total Population", populationDrop);
        html = html +           createDropOption("Female", "Female Population", populationDrop);
        html = html +           createDropOption("Male", "Male Population", populationDrop);
        html = html + "      </select>";
        html = html + "   </div>";

        /*
        html = html + "   <p class='displayTagRange'>Is in the range:</p>";
        html = html + "   <div class='form-range'>";
        html = html + "      <label for='rangelabel'>0</label>";
        html = html + "      <input type='range' id='populationRange' name='populationRange' value=''>";
        html = html + "      <label for='rangelabel'><output class='outputRange' name='x' for='populationRange'></output></label>%";
        html = html + "      ";
        html = html + "   </div>";
        */        

        html = html + "   <p class='displayTag'><br>Display Population Count as:</p><br>";
        html = html + "   <div class='form-radio'>";
        html = html +           createRadioBtn("percent", "Percent", "Percentage", displayAsRadio, true);
        html = html +           createRadioBtn("count", "Count", "Raw Numbers", displayAsRadio, false);
        html = html + "   </div>";
        


        html = html + "   <button type='submit' class='btn btn-primary'>Update Chart</button>";

        html = html + "</form>";

        
        html = html + "</div>";




        //Col2 - Table
        html = html + "<div class='colTable'>";
        // html = html + "<h1>Overview</h1><hr class='in'>";

        if (outcomeDrop == null || outcomeDrop.equals("none")) {
            html = html + "<h1>Investigate the Data</h1><hr class='in'><h2>Awaiting Selection: Please select table data options on the left</h2>";
        } else {
            int outcomeSelect = Integer.parseInt(outcomeDrop.substring(outcomeDrop.length()-1));
            switch (outcomeSelect) {
                case 1:
                    html = html + "<h1>Outcome 1: Long and Healthy Lives</h1><hr class='in'><h2>" + populationDrop + " population aged over 65";
                    break;
                case 5:
                    html = html + "<h1>Outcome 5: Secondary Education</h1><hr class='in'><h2>" + populationDrop + " population who have completed Year 12";
                    break;
                case 6:
                    html = html + "<h1>Outcome 6: Tertiary Education</h1><hr class='in'><h2>" + populationDrop + " population who have completed a tertiary qualification of Advanced Diploma or higher";
                    break;
                case 8:
                    html = html + "<h1>Outcome 8: Economic Participation</h1><hr class='in'><h2>" + populationDrop + " population who are employed";
                    break;
            }

            html = html + ", displayed as ";
            if (displayAsRadio.equals("Count")) {
                html = html + "raw count of population.";
            } else {
                if (outcomeSelect == 1) {
                    html = html + "percentage of total population.";
                } else {
                    html = html + "percentage of population aged over 15.";
                }
            }
            html = html + "</h2>";

        }
        
        /* Testing form submission results
        html = html + "<p>Outcome = " + outcomeDrop + "</p>";
        html = html + "<p>Population Segment = " + populationDrop + "</p>";
        html = html + "<p>Display Data As = " + countAsDrop + "</p>";
        html = html + "<p>Order By = " + orderByDrop + " " + orderRadio + "</p>"; */

        //testQuery
        //ArrayList<level2tableRow> tableData = jdbc.testQuery();

        // Output into a table
        if (outcomeDrop == null) {
            html = html + "";
        } else {
           
        //create and populate tableData from jdbc
        ArrayList<level2tableRow> tableData = jdbc.dataByGapScore(outcomeDrop, populationDrop, displayAsRadio);
            
        //start table
        html = html + "<table id='table_id' class='display'>";

        html = html + "<thead><tr>";
        if (displayAsRadio.equals("Count")) {
            html = html + "<th>Lga</th><th>State</th><th>Indigenous</th><th>Non-Indigenous</th><th>(%) Gap Difference</th>";
        } else {
            html = html + "<th>Lga</th><th>State</th><th>(%) Indigenous</th><th>(%) Non-Indigenous</th><th>(%) Gap Difference</th>";
        }
        html = html + "</tr></thead>";


        html = html + "<tbody>";
        for (level2tableRow row : tableData) {
            
            html = html + "<tr>";
            html = html + "<td><b id='blue'>" + row.getLga() + "</b></td>";
            html = html + "<td>" + row.getState() + "</td>";
            if (displayAsRadio.equals("Count")) {
                html = html + "<td>" + row.getCountIndig() + "</td>";
                html = html + "<td>" + row.getCountNonIndig() + "</td>";
            } else {
                if (row.getPercentIndig() > 100) {
                    html = html + "<td>100.0</td>";
                } else {
                html = html + "<td>" + String.format("%.1f", row.getPercentIndig()) + "</td>";
                }
                if (row.getPercentNonIndig() > 100) {
                    html = html + "<td>100.0</td>";
                } else {
                html = html + "<td>" + String.format("%.1f", row.getPercentNonIndig()) + "</td>";
                }
            }
            html = html + "<td>" + String.format("%.1f", row.getGapScore()) + "</td>";
            

            html = html + "</tr>";
        }
        html = html + "</tbody>";
        // Finish the table
        html = html + "</table>";
        }
        html = html + "</div>";

        // Closes 2nd DIV 
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


       //Col1 - Chart options
       html = html + "<div class='col1'>";
       html = html + "<h1>Measure the Gap</h1><hr class='in'>";
       
       html = html + "<form action='/page5.html' method='post'>";
       
        html = html + "   <div class='form-notdrop'>";
        html = html + "   <p class='displayTag'><label for='outcomeSelect'>Select Outcomes to generate GapScore from:</label></p>";
        html = html +           createCheckbox("outcome1", "gapScore1", "Outcome 1 - Life Expectancy", outcomeSelect);
        html = html +           createCheckbox("outcome5", "gapScore5", "Outcome 5 - School Completion", outcomeSelect);
        html = html +           createCheckbox("outcome6", "gapScore6", "Outcome 6 - Tertiary Education", outcomeSelect);
        html = html +           createCheckbox("outcome8", "gapScore8", "Outcome 8 - Employment", outcomeSelect);
        // html = html + "      <input type='checkbox' id='outcome1' name='outcome1' value='gapScore1'>";
        // html = html + "      <label for='outcome1'> Outcome 1 - Life Expectancy</label><br>";
        // html = html + "      <input type='checkbox' id='outcome5' name='outcome5' value='gapScore5'>";
        // html = html + "      <label for='outcome5'> Outcome 5 - School Completion</label><br>";
        // html = html + "      <input type='checkbox' id='outcome6' name='outcome6' value='gapScore6'>";
        // html = html + "      <label for='outcome6'> Outcome 6 - Tertiary Education</label><br>";
        // html = html + "      <input type='checkbox' id='outcome8' name='outcome8' value='gapScore8'>";
        // html = html + "      <label for='outcome8'> Outcome 8 - Employment</label><br>";
        html = html + "   </div>";

       html = html + "   <button type='submit' class='btn btn-primary'>Generate Table Data</button>";

       html = html + "</form>";
       
       html = html + "</div>";

       
       

    

       //Col - Table
       html = html + "<div class='colTable'>";
       html = html + "<h1>Closing the Gap</h1>" + "<hr class='in'>" + "<h2>Gap computed and measured against a national average for the range of outcomes selected.</h2><hr class='in'>";
       
       //Testing form submission results
       html = html + "<p>OutcomeSelect - Size = " + outcomeSelect.size() + " Contents = ";
       for (String outcome : outcomeSelect) {
           html = html + outcome + ", ";
       }
       html = html + "</p>";
       
       //testQuery
       // JDBCConnection jdbc = new JDBCConnection();
       // ArrayList<level2tableRow> tableData = jdbc.testQuery();

       //Output into a table
       if (outcomeSelect.size() == 0) {
           html = html + "";
       } else {
           //create and populate sourceLGA data from jdbc
           ArrayList<compareLGAdata> tableData = jdbc.sourceOutcome(outcomeSelect);
           //start table
           html = html + "<table id='table_id' class='display'>";
           html = html + "<thead><tr>";
           html = html + "<th>LGA</th><th>Total Population</th><th>Population/ km<sup>2</sup></th><th>(%) Indigenous Proportion</th><th>(%) Gap Score</th>";
           html = html + "</tr></thead>";

           html = html + "<tbody>";
           for (compareLGAdata row : tableData) {
           html = html + "<tr>";
           html = html + "<td><b id='blue'>" + row.getLga() + "</td>";
           html = html + "<td>" + row.getPopulation() + "</td>";
           html = html + "<td>" + String.format("%.1f", row.getDensity()) + "</td>";
           html = html + "<td>" + String.format("%.1f",row.getProportionIndig()) + "</td>";
           html = html + "<td>" + String.format("%.1f",row.getGapScore()) + "</td>";
           html = html + "</tr>";
           }

           // Finish the table
           html = html + "</tbody>";
           html = html + "</table>";

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
        //html = html + "      <a href='page4.html'>Data by State</a>";
        html = html + "      <a href='page4.html'>Data by State</a>";
        html = html + "      <a href='page6.html'>Similar Attributes</a>";
        html = html + "   </div>";
        html = html + "</div>";
        html = html + "</div>";
        

        //CLOSES CONTENT
        html = html + "</div>";
        html = html + "</div>";

        //FOOTER
        //Closes Footer
        
        // Add some JS (external file)
        
        

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
        String radio = "<input type='radio' class='radiobtn' id='" + id + "' name='displayAsRadio' value='" + value + "' ";
        
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
        String checkbox = "<input type='checkbox' id='" + id + "' name='" + id + "' value='" + value + "' ";
        if (lastSubmission.size() > 0 && lastSubmission.contains(value)) {
            checkbox = checkbox + "checked ='checked' ";
        }
        checkbox = checkbox + "><label for='" + id + "'>" + label + "</label><br>";
        return checkbox;
    }

}
