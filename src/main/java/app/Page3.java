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
public class Page3 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page3.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Outcome Data by LGA</title>";

        // Add some CSS .Js from datatables (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/af-2.3.7/b-2.0.1/r-2.2.9/sp-1.4.0/datatables.min.css'>";
        html = html + "<script type='text/javascript' src='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/datatables.min.js'></script>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='common.js'></script>";
 
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";

        
        

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
        html = html + "</div>";


        // OPENS CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";

        
        // 1st DIV - Default Content Div
        html = html + "<div class='content-title'>";
        html = html + "<h1>Outcome Data by LGA</h1>";
        html = html + "<hr class='white'>" + "<p>Explore the socioeconomic outcome data for Indigenous Australians by Local Goverment Area.</p>";
        html = html + "</div>";


        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";

        //populate form submission results
        String outcomeDrop = context.formParam("outcomeDrop");
        String populationDrop = context.formParam("populationDrop");
        String displayAsRadio = context.formParam("displayAsRadio");

        //Col1 - Chart options
        html = html + "<div class='col1'>";
        html = html + "<h1>Custom Charts</h1><hr class='in'>";
        html = html + "<form action='/page3.html' method='post'>";
        
        html = html + "   <div class='form-group'>";
        html = html + "      <select id='outcomeDrop' name='outcomeDrop'>";
        html = html +           createDropOption("none", "Select Outcome", outcomeDrop);
        html = html +           createDropOption("outcome1", "Outcome 1 - Long & Healthy Lives", outcomeDrop);
        html = html +           createDropOption("outcome5", "Outcome 5 - School Completion", outcomeDrop);
        html = html +           createDropOption("outcome6", "Outcome 6 - Tertiary Education", outcomeDrop);
        html = html +           createDropOption("outcome8", "Outcome 8 - Employment", outcomeDrop);
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
                    html = html + "<h1>Outcome 5: School Completion</h1><hr class='in'><h2>" + populationDrop + " population who have completed Year 12";
                    break;
                case 6:
                    html = html + "<h1>Outcome 6: Tertiary Education</h1><hr class='in'><h2>" + populationDrop + " population who have completed a tertiary qualification of Advanced Diploma or higher";
                    break;
                case 8:
                    html = html + "<h1>Outcome 8: Employment</h1><hr class='in'><h2>" + populationDrop + " population who are employed";
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
            html = html + "</h2><hr class='in'>";

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
            JDBCConnection jdbc = new JDBCConnection();
            ArrayList<level2tableRow> tableData = jdbc.dataByLga(outcomeDrop, populationDrop, displayAsRadio);
            //start table
            html = html + "<table id='table_id' class='display'>";
            html = html + "<thead><tr>";
            if (displayAsRadio.equals("Count")) {
                html = html + "<th>LGA</th><th>Indigenous</th><th>Non-Indigenous</th>";
            } else {
                html = html + "<th>LGA</th><th>(%) Indigenous</th><th>(%) Non-Indigenous</th>";
            }
            html = html + "</tr></thead>";

        html = html + "<tbody>";
        for (level2tableRow row : tableData) {
            
            html = html + "<tr>";
            html = html + "<td><b id='blue'>" + row.getLga() + "</b></td>";
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

            html = html + "</tr>";
        }
        html = html + "</tbody>";
        // Finish the table
        html = html + "</table>";
        }
        html = html + "</div>";


        // Closes 2nd DIV 
        html = html + "</div>";

        //New row and col DIV for switching charts
        html = html + "<div class='row3'>";
        html = html + "<div class='col1hide'>";
        html = html + "</div>";
        html = html + "<div class='colTable'>";
        html = html + "   <h2>Explore the data in different ways</h2><hr class='in'>";
        html = html + "   <div class='chart-switch'>";
        //html = html + "      <a href='page3.html'>Data by LGA</a>";
        html = html + "      <a href='page4.html'>Data by State</a>";
        html = html + "      <a href='page5.html'>Measuring the Gap</a>";
        html = html + "      <a href='page6.html'>Compare LGAs</a>";
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

}
