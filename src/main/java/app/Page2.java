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
public class Page2 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Mission Statement</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";

        // Add the body
        html = html + "</head><body>";

        //navigation header
        html = html + "<header><div class='navbar'>";
        html = html + "<a href='/'>Home</a>";
        html = html + "<a class='current' href='mission.html'>Mission</a>";
        html = html + "<div class='subnav'>";
        html = html + "<button class='subnavbtn'>Outcome Data  <i class='fa fa-caret-down'></i></button>";
        html = html + "<div class='subnav-content'>";
        html = html + "<a href='page3.html'>Subtask 2.1</a>";
        html = html + "<a href='page4.html'>Subtask 2.2</a>";
        html = html + "<a href='page5.html'>Subtask 3.1</a>";
        html = html + "<a href='page6.html'>Subtask 3.2</a>";
        html = html + "</div></div></div></header>";


        // CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>Closing the Gap: Addressing the Challenge</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p> This website demonstrates progress on the socioeconomic outcomes of the 2020 National Agreement on Closing the Gap for Indigenous Australians. ";
        html = html + "The original Closing the Gap plan created in 2008 fell short on many of its targets. ";
        html = html + "It is our aim to pursue social change by keeping the targets at the forefront of the community's mind, ";
        html = html + "in the hope that this awareness creates the political pressure necessaryto meet the targets outlined in the report. ";
        html = html + "This online database seeks to strike a balance between dense amounts of information and ";
        html = html + "accessibility. We want our users to be able to see a high-level view of progress towards targets ";
        html = html + "with ease, as well as to be able to drill down into individual outcomes as required. Ideally having ";
        html = html + "access to this data will encourage greater community buy-in to achieve the targets, and act as a ";
        html = html + "touchstone and tool for advocacy work in the area.</p>";
        html = html + "<p>Based on the information available to us, we are highlighting measures that relate to four of the Outcomes in the Agreement. "; 
        html = html + "The chosen outcomes and related measurements are as follows: </p><ul>";
        html = html + "<li>Outcome 1: proportion of population aged 65+";
        html = html + "<li>Outcome 5: population aged 15+ that have completed year 12";
        html = html + "<li>Outcome 6: population aged 15+ that have completed Advanced Diploma or higher";
        html = html + "<li>Outcome 8: population aged 15+ that are employed</ul></div>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>Target Audiences</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Volutpat maecenas volutpat blandit aliquam etiam erat. Amet consectetur adipiscing elit ut aliquam purus. Nec ultrices dui sapien eget mi proin. Purus gravida quis blandit turpis cursus in hac habitasse. Est ultricies integer quis auctor elit sed vulputate mi sit. Vel pretium lectus quam id leo in vitae turpis massa. Velit scelerisque in dictum non consectetur a erat. Tellus at urna condimentum mattis pellentesque id nibh tortor id. Donec enim diam vulputate ut pharetra.</p></div>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>How to Use this Site</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Volutpat maecenas volutpat blandit aliquam etiam erat. Amet consectetur adipiscing elit ut aliquam purus. Nec ultrices dui sapien eget mi proin. Purus gravida quis blandit turpis cursus in hac habitasse. Est ultricies integer quis auctor elit sed vulputate mi sit. Vel pretium lectus quam id leo in vitae turpis massa. Velit scelerisque in dictum non consectetur a erat. Tellus at urna condimentum mattis pellentesque id nibh tortor id. Donec enim diam vulputate ut pharetra.</p></div>";
        


        //Closes Content
        html = html + "</div>";
        html = html + "</div>";

        //footer
        html = html + "<footer>2021 Work by Scott Dunsdon (s3918676) & Alvaro Pena Leon (s3909789).</footer>";
        

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Finish the HTML webpage
        html = html + "</body></html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
