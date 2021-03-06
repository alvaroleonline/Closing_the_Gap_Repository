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
public class Resources implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/resources.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Resources</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>";

        // Add the body
        html = html + "<body>";

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
        html = html + "<a class='current' href='resources.html'>Resources</a></div>";
        // Closes Header
        //html = html + "</div>";
        html = html + "</div>";

        // CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";
        
        //1st DIV: Default Content Div
        html = html + "<div class='content-title'>";
        html = html + "<h1>Additional Resources</h1>";
        html = html + "<hr class='white'>" + "<p>List of Aboriginal and Torres Strait Islander peak community organisations, national and jurisdictional.</p>";
        html = html + "</div>"; 


        // OPENS DIV RESOURCES
        html = html + "<div class='rowfullwidth'>";
        

        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='http://aief.com.au'>";
        html = html + "<h2>Australian Indigenous Education Foundation";
        html = html + "<p>Provides funding that enables Indigenous students to pursue their education at leading schools.</p><p id='gray500'>Category: Education</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


         // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://aida.org.au/'>";
        html = html + "<h2>Australian Indigenous Doctors' Association";
        html = html + "<p>Not-for-profit, member-based, professional association supporting Aboriginal and Torres Strait Islander medical students and doctors.</p><p id='gray500'>Category: Health</p></h2>";
        html = html + "</a>";
        html = html + "</div>";

 
         // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://aiatsis.gov.au/'>";
        html = html + "<h2>AIATSIS";
        html = html + "<p>The Australian Institute of Aboriginal and Torres Strait Islander Studies.</p><p id='gray500'>Category: Organization</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://firstnationsmedia.org.au'>";
        html = html + "<h2>First Nations Media Australia";
        html = html + "<p>National peak body for the Aboriginal and Torres Strait Islander media industry.</p><p id='gray500'>Category: Media</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://iaha.com.au'>";
        html = html + "<h2>IAHA Indigenous Allied Health Australia";
        html = html + "<p>Member-based Aboriginal and Torres Strait Islander allied health organisation.</p><p id='gray500'>Category: Health</p></h2>";
        html = html + "</a>";
        html = html + "</div>";

     
        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://www.naccho.org.au'>";
        html = html + "<h2>National Aboriginal Community Controlled Health Organisation";
        html = html + "<p>Leadership body for 143 ACCHOs across Australia.</p><p id='gray500'>Category: Health</p></h2>";
        html = html + "</a>";
        html = html + "</div>";

 
         // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://humanrights.gov.au'>";
        html = html + "<h2>National Congress of Australia's First Peoples";
        html = html + "<p>Implementation of the United Nations Declaration on the Rights of Indigenous Peoples.</p><p id='gray500'>Category: Organization</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://www.nationalfvpls.org/'>";
        html = html + "<h2>National Family Violence Prevention Legal Services Forum";
        html = html + "<p>Provides legal and non-legal supports to Aboriginal and Torres Strait Islander victims/ survivors of family violence.</p><p id='gray500'>Category: Organization</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://alc.org.au/'>";
        html = html + "<h2>NSW Aboriginal Land Council";
        html = html + "<p>Peak representative body in Aboriginal Affairs.</p><p id='gray500'>Category: Organization</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://www.snaicc.org.au/'>";
        html = html + "<h2>SNAICC - National Voice for Our Children";
        html = html + "<p>Non-governmental peak body for Aboriginal and Torres Strait Islander children.</p><p id='gray500'>Category: Education</p></h2>";
        html = html + "</a>";
        html = html + "</div>";


        // Resource
        html = html + "<div class='col4'>";
        html = html + "<a href='https://www.vaccho.org.au/'>";
        html = html + "<h2>Victorian Aboriginal Community Controlled Health Organisation (VACCHO)";
        html = html + "<p>Peak body for the health and wellbeing of Aboriginal peoples living in Victoria.</p><p id='gray500'>Category: Health</p></h2>";
        html = html + "</a>";
        html = html + "</div>";




        // To add more resource divs..


 
        // Closes DIV
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
