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
        html = html + "touchstone and tool for advocacy work in the area.<br><br></p>";
        html = html + "<p>Based on the information available to us, we are highlighting measures that relate to four of the Outcomes in the Agreement. "; 
        html = html + "The chosen outcomes and related measurements are as follows:<br><br></p>";

        //Outcomes collapsible tabs
        html = html + "<button class='collapsible'>Outcome area 1 - Aboriginal and Torres Strait Islander people enjoy long and healthy lives</button>";
        html = html + "<div class='contenthidden'><p>Life expectancy is an overarching target, which is dependent not only on health, but the social determinants (such as education, employment status, housing and income). Social determinants are estimated to be responsible for at least 34 per cent of the health gap between Indigenous and non‑Indigenous Australians. Behavioural risk factors, such as smoking, obesity, alcohol use and diet, accounted for around 19 per cent of the gap (AHMAC 2017).</p></div>";
        html = html + "<button class='collapsible'>Outcome area 5 - Aboriginal and Torres Strait Islander students achieve their full potential</button>";
        html = html + "<div class='contenthidden'><p>One of the main indicators of educational achievement is completing high school to Year 12. This is a prerequisite for many jobs and is seen as an indicator of aptitude and attitude (Biddle 2010). Indigenous Australians, who complete Year 12, or a higher qualification, are substantially more likely to be employed. They are also more likely to work full-time and in higher-skilled occupations than early school leavers (Shirodkar et al. 2018; Venn 2018).</p></div>";
        html = html + "<button class='collapsible'>Outcome area 6 - Aboriginal and Torres Strait Islander students reach their full potential through further education pathways</button>";
        html = html + "<div class='contenthidden'><p>Successfully progressing through and transitioning from school is important for children to improve social mobility and intergenerational outcomes. Education has a strong association with employability and income, health, and control over one’s life (Pagnini et al. 2014; World Bank 2018). Better education outcomes can also have positive intergenerational flow-on effects. More educated mothers, for example, have been associated with healthier children (Ewald and Boughton 2002; Schochet et al. 2020).</p></div>";
        html = html + "<button class='collapsible'>Outcome area 8 - Strong economic participation and development of Aboriginal and Torres Strait Islander people and communities</button>";
        html = html + "<div class='contenthidden'><p>Participation in employment provides financial and economic security and assists in opening the door to self-determination. Employment status also has associations with outcomes for health, social and emotional wellbeing, and living standards (Bambra 2011; Gray et al. 2014; Marmot 2015).<br><br>Progress against this target is measured using data from the National Aboriginal and Torres Strait Islander Health Survey (NATSIHS) 2018–19,1 based on the proportion of Indigenous Australians aged 15–64 years who are employed (employment-to-population ratio, referred to herein as the employment rate).</p></div>";
        html = html + "</div>";

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


        // Adds some JS
        html = html + "<script src='common.js'></script>";
        
        // Finish the HTML webpage
        html = html + "</body></html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
