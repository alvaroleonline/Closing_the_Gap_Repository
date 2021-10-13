package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class Index implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        // Add the body
        html = html + "<body>";

        // Add HTML for the logo.png image
        

        // Header
        html = html + "<div id='header'>";
        html = html + "<div id='container-header' class='container'>";
        //Menu bar
        html = html + "<div class='menu'>";
        // Logo
        html = html + "<a href='/'><img src='logo.png' class='logo-main' /></a>";
        // Menu List
        html = html + "<ul>";
        html = html + "<li> <a href='page1.html'>Page 1</a> </li>";
        html = html + "<li> <a href='page2.html'>Page 2</a> </li>";
        html = html + "<li> <a href='page3.html'>Page 3</a> </li>";
        html = html + "<li> <a href='page4.html'>Page 4</a> </li>";
        html = html + "<li> <a href='page5.html'>Page 5</a> </li>";
        html = html + "<li> <a href='page6.html'>Page 6</a> </li>";
        html = html + "</ul>";
        html = html + "</div>";
        // Closes Header
        html = html + "</div>";
        html = html + "</div>";



        // Content
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";
        
        // Default Content Div
        html = html + "<div class='page-content'>";
        html = html + "<h1>Homepage</h1>" + "<hr>" + "<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>";
        html = html + "</div>";


        // Facts Container
        html = html + "<div class='card-wrapper'>";

        // Opens Fact
        html = html + "<div class='card-item'>";
        // Look up information from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        // Next we will ask this *class* for the movies
        int count = jdbc.getFirstFact();
        // Print out fact count
        html = html + "<p class='fact-count'>" + count + "%</p>";
        // Closes Fact
        html = html + "</div>";
        

        html = html + "<div class='card-item'></div>";
        html = html + "<div class='card-item'></div>";
        html = html + "</div>";
        
        //Closes Content
        html = html + "</div>";
        html = html + "</div>";






        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
