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
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";

        // Add the body
        html = html + "<body>";

        // Add HTML for the logo.png image
        

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
        // Closes Header
        //html = html + "</div>";
        html = html + "</div>";
        
        /*
        html = html + "<div id='header'>";
        html = html + "<div id='container-header' class='container'>";
        //Menu bar
        html = html + "<div class='menu'>";
        // Logo
        html = html + "<a href='/'><img src='logo.png' class='logo-main' /></a>";
        // Menu List
        html = html + "<ul>";
        html = html + "<li> <a href='page1.html'>Page 1</a> </li>";
        html = html + "<li> <a href='mission.html'>Page 2</a> </li>";
        html = html + "<li> <a href='page3.html'>Page 3</a> </li>";
        html = html + "<li> <a href='page4.html'>Page 4</a> </li>";
        html = html + "<li> <a href='page5.html'>Page 5</a> </li>";
        html = html + "<li> <a href='page6.html'>Page 6</a> </li>";
        html = html + "</ul>";
        html = html + "</div>";
        // Closes Header
        html = html + "</div>";
        html = html + "</div>"; */



        // CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";
        
        // 1st DIV: Default Content Div
        html = html + "<div class='content-title'>";
        html = html + "<h1>Closing the Gap</h1>";
        html = html + "<hr class='white'>" + "<p>A repository on the socioeconomic outcomes of the 2020 National Agreement on Closing the Gap for Indigenous Australians.</p>";
        html = html + "</div>";


        // 2nd DIV: Facts Container
        html = html + "<div class='row'>";
        
        // Look up information from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        
        // Fact 1
        html = html + "<div class='col3'>";
        html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        int count1 = jdbc.getFirstFact();
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>School Education</p><h1>" + count1 + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Indigenous people have completed Year 12.</p></span>";
        // Closes Fact
        html = html + "</a>";
        html = html + "</div>";
 
        // Fact 2
        html = html + "<div class='col3'>";
        html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        int count2 = jdbc.getSecondFact();
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>Life Expectancy</p><h1>" + count2 + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Indigenous people are over 65 years old.</p></span>";
        // Closes Fact
        html = html + "</a>";
        html = html + "</div>";

        // Fact 3
        html = html + "<div class='col3'>";
        html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        int count3 = jdbc.getThirdFact();
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>Employement</p><h1>" + count3 + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Indigenous population people in the labour force.</p></span>";
        // Closes Fact
        html = html + "</a>";
        html = html + "</div>";

        // Closes 2nd DIV
        html = html + "</div>";



        
        // 3rd DIV
        html = html + "<div class='row2'>";
        

        //col1
        
        html = html + "<div class='col1'>";
        html = html + "<img src='cover_image.jpg' class='img-cover'></img>";
        html = html + "<a href='mission.html'>";
        html = html + "<h1>Learn More<i class='fa fa-angle-right'></i></h1>";
        html = html + "</a>";
        html = html + "</div>";

        //col1
        html = html + "<div class='col2'>";
        html = html + "<h1>Resources</h1>";
        html = html + "<div class='resourcebox'>";
        html = html + "<hr class='in'>" + "<a href='mission.html'><p class='resourcelink'>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p></a>";
        html = html + "<hr class='in'>" + "<a href='mission.html'><p class='resourcelink'>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p></a>";
        html = html + "<hr class='in'>" + "<a href='mission.html'><p class='resourcelink'>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p></a>";
        html = html + "</div>";
        html = html + "</div>";


        // Closes 3rd DIV 
        html = html + "</div>";



        //Closes Content
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
