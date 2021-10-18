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
               "<title>Movies</title>";

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
        html = html + "<a href='page3.html'>Subtask 2.1</a>";
        html = html + "<a href='page4.html'>Subtask 2.2</a>";
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
        html = html + "<h1>Socioeconomic outcome</h1>";
        html = html + "<hr class='white'>" + "<p>A repository on the socioeconomic outcomes of the 2020 National Agreement on Closing the Gap for Indigenous Australians.</p>";
        html = html + "</div>";


        // 2nd DIV - Chart and Table
        html = html + "<div class='row3'>";

        // Look up some information from JDBC - use JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();


        //Col2 - Chart
        html = html + "<div class='col1'>";
        html = html + "<h1>Custom Charts</h1><hr class='in'>";
        html = html + "</div>";

        //Col1 - Table
        html = html + "<div class='colTable'>";
        // Next we will ask this *class* for the movies
        ArrayList<String> movies = jdbc.getMovies();
        // Add HTML for the movies list
        html = html + "<h1>Movies</h1>" + "<ul>";
        // Finally we can print out all of the movies
        for (String movie : movies) {
            html = html + "<li>" + movie + "</li>";
        }
        // Finish the List HTML
        html = html + "</ul>";
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
