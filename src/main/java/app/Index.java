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
        html = html + "</head><body>";

        // Add HTML for the logo.png image
        

        // HEADER


        //navigation header
        html = html + "<div id='header'>";
        //html = html + "<div id='container-header' class='container'>";
        html = html + "<div class='navbar'>";
        html = html + "<a class='current' href='/'>Home</a>";
        html = html + "<a href='info.html'>Information</a>";
        html = html + "<div class='subnav'>";
        html = html + "<button class='subnavbtn'>Outcome Data <i class='fa fa-caret-down'></i></button>";
        html = html + "<div class='subnav-content'>";
        html = html + "<a href='page3.html'>Data by LGA</a>";
        html = html + "<a href='page4.html'>Data by State</a>";
        html = html + "<a href='page5.html'>Measuring the Gap</a>";
        html = html + "<a href='page6.html'>Compare LGAs</a>";
        html = html + "</div></div>";
        html = html + "<a href='resources.html'>Resources</a></div>";
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
        
        // Fact 2
        html = html + "<div class='col3'>";
        // html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        double outcome8I = jdbc.getOutcome8I("Indigenous");
        double outcome8NonI = jdbc.getOutcome8NonI("Non-Indigenous");
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>Employed Indigenous Population</p><h1>" +  String.format("%.1f", outcome8I) + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Compared to " + String.format("%.1f", outcome8NonI) +"% of Non-Indigenous</p></span>";
        // Closes Fact
        ///html = html + "</a>";
        html = html + "</div>";
 
        // Fact 2
        html = html + "<div class='col3'>";
        // html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        double outcome1I = jdbc.getOutcome1I("Indigenous");
        double outcome1NonI = jdbc.getOutcome1NonI("Non-Indigenous");
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>Indigenous population aged 65 or over</p><h1>" + String.format("%.1f", outcome1I) + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Compared to " + String.format("%.1f", outcome1NonI) +"% of Non-Indigenous</p></span>";
        // Closes Fact
        // html = html + "</a>";
        html = html + "</div>";

        // Fact 3
        html = html + "<div class='col3'>";
        // html = html + "<a href='page3.html'>";
        // Asks this *class* for the data
        double outcome6I = jdbc.getOutcome6I("Indigenous");
        double outcome6NonI = jdbc.getOutcome6NonI("Non-Indigenous");
        // Print out data
        html = html + "<span class='fact-count'><p class='outcome'>Completed higher education</p><h1>" + String.format("%.1f", outcome6I) + "%</h1></span>";
        html = html + "<span class='fact-hidden'><p>Compared to " + String.format("%.1f", outcome6NonI) +"% of Non-Indigenous</p></span>";
        // Closes Fact
        // html = html + "</a>";
        html = html + "</div>";

        // Closes 2nd DIV
        html = html + "</div>";


         // 4th DIV
         html = html + "<div class='row5'>";
 
         //col1
         html = html + "<div class='col1'>";
         html = html + "<a href='info.html'>";
         html = html + "<h1>Learn about the outcomes</h1>";
         html = html + "</a>";
         html = html + "</div>";

         //col2
         html = html + "<div class='col1'>";
         html = html + "<a href='page3.html'>";
         html = html + "<h1>Data</h1>";
         html = html + "</a>";
         html = html + "</div>";
 
         // Closes 4th DIV 
         html = html + "</div>";


        
        // 3rd DIV
        html = html + "<div class='row2'>";
        
        //col2
        html = html + "<div class='col2'>";
        html = html + "<h1>Resources</h1>";
        html = html + "<div class='resourcebox'>";
        html = html + "<hr class='in'>" + "<a href='https://www.naccho.org.au'><h2 class='resourcelink'>National Aboriginal Community Controlled Health Organisation<p id='gray500'>Category: Heath</p></h2></a>";
        html = html + "<hr class='in'>" + "<a href='https://firstnationsmedia.org.au'><h2 class='resourcelink'>First Nations Media Australia<p id='gray500'>Category: Media</p></h2></a>";
        html = html + "<hr class='in'>" + "<a href='https://humanrights.gov.au/'><h2 class='resourcelink'>National Congress of Australia's First Peoples<p id='gray500'>Category: Statutory Organisation</p></h2></a>";
        html = html + "<hr class='in'>" + "<a href='https://aiatsis.gov.au/'><h2 class='resourcelink'>AIATSIS<p id='gray500'>Category: Media</p></h2></a>";
        html = html + "</div>";
        html = html + "   <div class='chart-switch'>";
        html = html + "      <a href='resources.html' id='viewall'>View All</a>";
        html = html + "   </div>";
        html = html + "</div>";


        //col1
        html = html + "<div class='colimg' title='Photo by Photoholgic on Unsplash <https://unsplash.com>'>";
        // html = html + "<img src='cover_image.jpg' class='img-cover'></img>";
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
