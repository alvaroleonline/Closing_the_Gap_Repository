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
        html = html + "<head>" + 
               "<title>LGA Statistics</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/af-2.3.7/b-2.0.1/r-2.2.9/sp-1.4.0/datatables.min.css'>";
        html = html + "<script type='text/javascript' src='https://cdn.datatables.net/v/dt/jq-3.6.0/dt-1.11.3/datatables.min.js'></script>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='common.js'></script>";
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";
        

        // Add the body
        html = html + "<body>";


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
        html = html + "<a href='page3.html'>LGA Statistics</a>";
        html = html + "<a href='page4.html'>State Statistics</a>";
        html = html + "<a href='page5.html'>Subtask 3.1</a>";
        html = html + "<a href='page6.html'>Subtask 3.2</a>";
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
        html = html + "<h1>Outcome Statistics by LGA</h1>";
        html = html + "<hr class='white'>" + "<p>Explore the socioeconomic outcome data for Indigenous Australians by Local Goverment Area.</p>";
        html = html + "</div>";


        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";


        //Col1 - Chart
        html = html + "<div class='col1'>";
        html = html + "<h1>Choose LGA and Outcomes</h1><hr class='in'>";
        
        html = html + "<form action='/page6.html' method='post'>";
        
        html = html + "   <div class='form-notdrop'>";
        html = html + "   <p class='displayTag'><label for='outcomeSelect'>Select Outcomes to generate GapScore from:</label></p>";
        html = html + "      <input type='checkbox' id='outcome1' name='outcome1' value='outcome1'>";
        html = html + "      <label for='outcome1'> Outcome 1 - Life Expectancy</label><br>";
        html = html + "      <input type='checkbox' id='outcome5' name='outcome5' value='outcome5'>";
        html = html + "      <label for='outcome5'> Outcome 5 - School Completion</label><br>";
        html = html + "      <input type='checkbox' id='outcome6' name='outcome6' value='outcome6'>";
        html = html + "      <label for='outcome6'> Outcome 6 - Tertiary Education</label><br>";
        html = html + "      <input type='checkbox' id='outcome8' name='outcome8' value='outcome8'>";
        html = html + "      <label for='outcome8'> Outcome 8 - Employment</label><br>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <select id='lgaDrop' name='lgaDrop'>";
        html = html + "         <option value = 'none'>Select LGA to Compare Against:</option>";
        html = html + "         <option value = 'outcomeBest'> Best by selected GapScore</option>";
        html = html + "         <option value = 'outcomeWorst'> Worst by selected GapScore</option>";
        html = html + "         <option value = 'none'> --- Select by LGA Name --- </option>";
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> lgaNames = jdbc.getLGAs();
        for (String lga : lgaNames) {
            html = html + "         <option value = '" + lga + "'>" + lga + "</option>";
        }
        html = html + "      </select>";
        html = html + "   </div>";
        html = html + "   <p class='displayTag'>Compare to LGAs similar by:</p>";
        html = html + "   <div class='form-radio'>";
        html = html + "      <input type='radio' class='radiobtn' id='density' name='comparisonRadio' value='populationDensity' checked='checked'>";
        html = html + "          <label class ='radiolabel' for='populationDensity'>Population Density</label>";
        html = html + "      <input type='radio' class='radiobtn' id='proportionIndigenous' name='comparisonRadio' value='proportionIndigenous'>";
        html = html + "          <label class ='radiolabel' for='proportionIndigenous'>Proportion of Population who are Indigenous</label>";
        html = html + "   </div>";

        html = html + "   <button type='submit' class='btn btn-primary'>Generate Table Data</button>";

        html = html + "</form>";
        
        html = html + "</div>";

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

     

        //Col - Table
        html = html + "<div class='colTable'>";
        html = html + "<h1>Selected LGA</h1><h3>Raw data of Population aged over 65</h3><hr class='in'>";
        
        //Testing form submission results
        html = html + "<p>OutcomeSelect - Size = " + outcomeSelect.size() + " Contents = ";
        for (String outcome : outcomeSelect) {
            html = html + outcome + ", ";
        }
        html = html + "</p>";
        html = html + "<p>LGA Dropdown = " + lgaDrop + "</p>";
        html = html + "<p>Comparison Radio = " + comparisonRadio + "</p>";

        //testQuery
        // JDBCConnection jdbc = new JDBCConnection();
        // ArrayList<level2tableRow> tableData = jdbc.testQuery();

        // Output into a table
        // if (outcomeDrop == null) {
        //     html = html + "<h1>Please select table data options on the left</h1>";
        // } else {
            //create and populate tableData from jdbc
            // JDBCConnection jdbc = new JDBCConnection();
            // ArrayList<level2tableRow> tableData = jdbc.dataByState(outcomeDrop, populationRadio, displayAsRadio, orderByDrop, orderRadio);
        //     //start table
        //     html = html + "<table><tr>";
        //     html = html + "<th>State</th><th>Indigenous</th><th>Non-Indigenous</th>";
        //     html = html + "</tr>";

        //     for (level2tableRow row : tableData) {
        //         html = html + "<tr>";
        //         html = html + "<td>" + row.getState() + "</td>";
        //         if (displayAsRadio.equals("Count")) {
        //             html = html + "<td>" + row.getCountIndig() + "</td>";
        //             html = html + "<td>" + row.getCountNonIndig() + "</td>";
        //         } else {
        //             if (row.getPercentIndig() > 100) {
        //                 html = html + "<td>100%</td>";
        //             } else {
        //             html = html + "<td>" + String.format("%.2f", row.getPercentIndig()) + "%</td>";
        //             }
        //             if (row.getPercentNonIndig() > 100) {
        //                 html = html + "<td>100</td>";
        //             } else {
        //             html = html + "<td>" + String.format("%.2f", row.getPercentNonIndig()) + "%</td>";
        //             }
        //         }

        //         html = html + "</tr>";
        //     }
        // // Finish the table
        //     html = html + "</table>";
        //}
        html = html + "</div>";


        // Closes Row DIV 
        html = html + "</div>";

        html = html + "<div class='row3'>";

        html = html + "<div class='col1'>";
        html = html + "<h1>Define LGA Comparison</h1><hr class='in'>";
        
        //close column div
        html = html + "</div>";

        html = html + "<div class='colTable'>";
        html = html + "<h1>Comparison LGAs: Outcome 1</h1><h3>Raw data of Population aged over 65</h3><hr class='in'>";
        //close table column div
        html = html + "</div>";





        //CLOSES CONTENT
        html = html + "</div>";
        html = html + "</div>";



        //FOOTER
        //Closes Footer
        


        // Add some JS (external file)
        
        // html = html + "<script type='text/javascript' src='https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js'></script>";
        




        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
