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
public class Page4 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page4.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>State Statistics</title>";

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
        html = html + "</div></div></div>";
        // CLOSES HEADER
        //html = html + "</div>";
        html = html + "</div>";

        // OPENS CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";

        
        // 1st DIV - Default Content Div
        html = html + "<div class='content-title'>";
        html = html + "<h1>Outcome Statistics by State</h1>";
        html = html + "<hr class='white'>" + "<p>Explore the socioeconomic outcome data for Indigenous Australians by State.</p>";
        html = html + "</div>";


        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";

        // Look up some information from JDBC - use JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();


        //Col2 - Chart
        html = html + "<div class='col1'>";
        html = html + "<h1>Custom Charts</h1><hr class='in'>";
        //insert chart options 
        html = html + "//Placeholder for options";
        
        html = html + "</div>";

        //Col1 - Table
        html = html + "<div class='colTable'>";
        html = html + "<h1>Test Query: Outcome 1</h1><h3>Raw data of Population aged over 65</h3><hr class='in'>";
        
        //create and populate tableData from jdbc
        ArrayList<level2tableRow> tableData = jdbc.testQuery();
        // Output into a table
        html = html + "<table><tr>";
        html = html + "<th>State</th><th>Indigenous</th><th>Non-Indigenous</th>";
        html = html + "</tr>";
        for (level2tableRow row : tableData) {
            html = html + "<tr>";
            html = html + "<td>" + row.getState() + "</td>";
            html = html + "<td>" + row.getCountIndig() + "</td>";
            html = html + "<td>" + row.getCountNonIndig() + "</td>";
            html = html + "</tr>";
        }
        // Finish the table
        html = html + "</table>";
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
