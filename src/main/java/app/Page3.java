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
               "<title>LGA Statistics</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

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
        html = html + "<h1>Custom Charts</h1><hr class='in'>";
        
        html = html + "<form action='/page3.html' method='post'>";
        
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='outcomeDrop'>Select the Outcome Data to Display:</label>";
        html = html + "      <select id='outcomeDrop' name='outcomeDrop'>";
        html = html + "         <option> </option>";
        html = html + "         <option value = 'outcome1'> Outcome 1 - Life Expectancy</option>";
        html = html + "         <option value = 'outcome5'> Outcome 5 - School Completion</option>";
        html = html + "         <option value = 'outcome6'> Outcome 6 - Tertiary Education</option>";
        html = html + "         <option value = 'outcome8'> Outcome 8 - Employment</option>";
        html = html + "      </select>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='populationRadio'>Select the Population Segment:</label><br>";
        html = html + "      <input type='radio' id='all' name='populationRadio' value='All' checked='checked'> <label for='all'>All</label>";
        html = html + "      <input type='radio' id='female' name='populationRadio' value='Female'> <label for='female'>Females</label>";
        html = html + "      <input type='radio' id='male' name='populationRadio' value='Male'> <label for='male'>Males</label>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='displayAsRadio'>Display Data as:</label><br>";
        html = html + "      <input type='radio' id='percent' name='displayAsRadio' value='Percent' checked='checked'> <label for='percent'>Proportion of Population</label><br>";
        html = html + "      <input type='radio' id='count' name='displayAsRadio' value='Count'> <label for='count'>Raw Population Count</label>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='orderByDrop'>Order Table by:</label><br>";
        html = html + "      <select id='orderByDrop' name='orderByDrop'>";
        html = html + "         <option> Lga </option>";
        html = html + "         <option> Indigenous Results </option>";
        html = html + "         <option> Non-Indigenous Results </option>";
        html = html + "      </select>";
        html = html + "      <br>";
        html = html + "      <input type='radio' id='asc' name='orderRadio' value='ASC' checked='checked'> <label for='asc'>Ascending</label>";
        html = html + "      <input type='radio' id='desc' name='orderRadio' value='DESC'> <label for='desc'>Descending</label>";
        html = html + "   </div><br>";

        html = html + "   <button type='submit' class='btn btn-primary'>Generate Table Data</button>";

        html = html + "</form>";
        
        html = html + "</div>";


        //populate form submission results
        String outcomeDrop = context.formParam("outcomeDrop");
        String populationRadio = context.formParam("populationRadio");
        String displayAsRadio = context.formParam("displayAsRadio");
        String orderByDrop = context.formParam("orderByDrop");
        String orderRadio = context.formParam("orderRadio");



        //Col2 - Table
        html = html + "<div class='colTable'>";
        // html = html + "<h1>Overview</h1><hr class='in'>";

        html = html + "<h1>Test Query: Outcome 1</h1><h3>Raw data of Population aged over 65</h3><hr class='in'>";
        
        //Testing form submission results
        html = html + "<p>Outcome = " + outcomeDrop + "</p>";
        html = html + "<p>Population Segment = " + populationRadio + "</p>";
        html = html + "<p>Display Data As = " + displayAsRadio + "</p>";
        html = html + "<p>Order By = " + orderByDrop + " " + orderRadio + "</p>";

        //testQuery
        //ArrayList<level2tableRow> tableData = jdbc.testQuery();

        // Output into a table
        if (outcomeDrop == null) {
            html = html + "<h1>Please select table data options on the left</h1>";
        } else {
            //create and populate tableData from jdbc
            JDBCConnection jdbc = new JDBCConnection();
            ArrayList<level2tableRow> tableData = jdbc.dataByLga(outcomeDrop, populationRadio, displayAsRadio, orderByDrop, orderRadio);
            //start table
            html = html + "<table><tr>";
            html = html + "<th>Lga</th><th>Indigenous</th><th>Non-Indigenous</th>";
            html = html + "</tr>";

        for (level2tableRow row : tableData) {
            html = html + "<tr>";
            html = html + "<td>" + row.getLga() + "</td>";
            if (displayAsRadio.equals("Count")) {
                html = html + "<td>" + row.getCountIndig() + "</td>";
                html = html + "<td>" + row.getCountNonIndig() + "</td>";
            } else {
                if (row.getPercentIndig() > 100) {
                    html = html + "<td>100%</td>";
                } else {
                html = html + "<td>" + String.format("%.2f", row.getPercentIndig()) + "%</td>";
                }
                if (row.getPercentNonIndig() > 100) {
                    html = html + "<td>100</td>";
                } else {
                html = html + "<td>" + String.format("%.2f", row.getPercentNonIndig()) + "%</td>";
                }
            }

            html = html + "</tr>";
        }
        // Finish the table
        html = html + "</table>";
        }
        html = html + "</div>";


        // Closes 2nd DIV 
        html = html + "</div>";



        //CLOSES CONTENT
        html = html + "</div>";
        html = html + "</div>";



        //FOOTER
        //Closes Footer
        


        // Add some JS (external file)
        //html = html + "<link rel='javascript' type='text/css' href='common.css' />";
        html = html + "<script src='common.js'></script>";


        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
