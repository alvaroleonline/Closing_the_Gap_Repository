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
        html = html + "<a href='page3.html'>Data by LGA</a>";
        html = html + "<a href='page4.html'>Data by State</a>";
        html = html + "<a href='page5.html'>Subtask 3.1</a>";
        html = html + "<a href='page6.html'>Subtask 3.2</a>";
        html = html + "</div></div>";
        html = html + "<a href='resources.html'>Resources</a></div>";


        // CONTENT
        html = html + "<div id='content'>";
        html = html + "<div id='container-main' class='container'>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>Closing the Gap: Addressing the Challenge</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p> This website demonstrates progress on the socioeconomic outcomes of the 2020 National Agreement on Closing the Gap for Indigenous Australians. ";
        html = html + "The original Closing the Gap plan created in 2008 fell short on many of its targets. ";
        html = html + "It is our aim to pursue social change by keeping the targets at the forefront of the community's mind, ";
        html = html + "in the hope that this awareness creates the political pressure necessary to meet the targets outlined in the report. ";
        html = html + "<br><br></p>";
        html = html + "<p>Based on the information available to us, we are highlighting measures that relate to four of the Outcomes in the Agreement. "; 
        html = html + "The chosen outcomes and related measurements are as follows:<br><br></p>";

        //Outcomes collapsible tabs
        html = html + "<button class='collapsible'>Outcome area 1 - Aboriginal and Torres Strait Islander people enjoy long and healthy lives</button>";
        html = html + "<div class='contenthidden'><p>Life expectancy is an overarching target, which is dependent not only on health, but the social determinants (such as education, employment status, housing and income). Social determinants are estimated to be responsible for at least 34 per cent of the health gap between Indigenous and Non-Indigenous Australians. Behavioural risk factors, such as smoking, obesity, alcohol use and diet, accounted for around 19 per cent of the gap (<a id='missionlink' href='https://www.niaa.gov.au/sites/default/files/publications/2017-health-performance-framework-report_1.pdf'>AHMAC 2017</a>).</p>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>Official target: </b></div><div class='col204'><p>Close the Gap in life expectancy within a generation, by 2031.</p></div>" + "</div>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>How this site measures progress:</b></div><div class='col204'><p>Number of Indigenous people aged 65 or over, as a proportion of total Indigenous population.</p></div>" + "</div>";
        html = html + "<hr class='small'>";
        html = html + "</div>";

        html = html + "<button class='collapsible'>Outcome area 5 - Aboriginal and Torres Strait Islander students achieve their full potential</button>";
        html = html + "<div class='contenthidden'><p>One of the main indicators of educational achievement is completing high school to Year 12. This is a prerequisite for many jobs and is seen as an indicator of aptitude and attitude (<a id='missionlink'href='https://www.jstor.org/stable/24720925'>Biddle 2010</a>). Indigenous Australians, who complete Year 12, or a higher qualification, are substantially more likely to be employed. They are also more likely to work full-time and in higher-skilled occupations than early school leavers (<a id='missionlink' href='https://openresearch-repository.anu.edu.au/bitstream/1885/148675/1/CAEPR-WP-GROWTH-PUBLISH.pdf'>Shirodkar et al. 2018</a>; Venn 2018).</p>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>Official target: </b></div><div class='col204'><p>By 2031, increase the proportion of Aboriginal and Torres Strait Islander people (age 20-24) attaining year 12 or equivalent qualification to 96 per cent.</p></div>" + "</div>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>How this site measures progress: </b></div><div class='col204'><p>Number of Indigenous people aged 15 or over who have completed year 12.</p></div>" + "</div>";
        html = html + "<hr class='small'>";
        html = html + "</div>";

        html = html + "<button class='collapsible'>Outcome area 6 - Aboriginal and Torres Strait Islander students reach their full potential through further education pathways</button>";
        html = html + "<div class='contenthidden'><p>Successfully progressing through and transitioning from school is important for children to improve social mobility and intergenerational outcomes. Education has a strong association with employability and income, health, and control over one's life (Pagnini et al. 2014; <a id='missionlink' href='https://www.worldbank.org/en/publication/wdr2018'>World Bank 2018</a>). Better education outcomes can also have positive intergenerational flow-on effects. More educated mothers, for example, have been associated with healthier children (<a id='missionlink' href='https://www.researchgate.net/publication/237279667_Maternal_Education_and_Child_Health_An_Exploratory_Investigation_in_a_Central_Australian_Aboriginal_Community'>Ewald and Boughton 2002</a>; <a id='missionlink' href='https://journals.sagepub.com/doi/full/10.1177/0014402920926461'>Schochet et al. 2020</a>).</p>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>Official target: </b></div><div class='col204'><p>By 2031, increase the proportion of Aboriginal and Torres Strait Islander people aged 25-34 years who have completed a tertiary qualification (Certificate III and above) to 70 per cent.</p></div>" + "</div>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>How this site measures progress: </b></div><div class='col204'><p>Number of Indigenous people aged 15 or over who have completed tertiary qualifications equivalent to an Advanced Diploma and above.</p></div>" + "</div>";
        html = html + "<hr class='small'>";
        html = html + "</div>";

        html = html + "<button class='collapsible'>Outcome area 8 - Strong economic participation and development of Aboriginal and Torres Strait Islander people and communities</button>";
        html = html + "<div class='contenthidden'><p>Participation in employment provides financial and economic security and assists in opening the door to self-determination. Employment status also has associations with outcomes for health, social and emotional wellbeing, and living standards (<a id='missionlink' href='https://pubmed.ncbi.nlm.nih.gov/21282147/'>Bambra 2011</a>; Gray et al. 2014; <a id='missionlink' href='https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5837404/'>Marmot 2015</a>).</p>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>Official target: </b></div><div class='col204'><p>By 2031, increase the proportion of Aboriginal and Torres Strait Islander people aged 25-64 who are employed to 62 per cent.</p></div>" + "</div>";
        html = html + "<hr class='small'>" + "<div class='row4'>" + "<div class='col104'><b>How this site measures progress: </b></div><div class='col204'><p>Number of Indigenous people aged 15 or over who are employed.</p></div>" + "</div>";
        html = html + "<hr class='small'>";
        html = html + "</div>";
        
        html = html + "</div>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>Target Audiences</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p>This online database seeks to strike a balance between dense amounts of information and accessibility. We want our users to be able to see a high-level view of progress towards targets with ease, as well as to be able to drill down into individual outcomes as required. Ideally having access to this data will encourage greater community buy-in to achieve the targets, and act as a touchstone and tool for advocacy work in the area.</p></div>";

        html = html + "<div class = 'content-box'>";
        html = html + "<h1>How to Use this Site</h1>";
        html = html + "<hr class='in'>";
        html = html + "<p>Access the outcome data from the navigation menu at the top of the page - selecting how you would like to view the data: by Local Government Area (LGA), by State or one of the more detailed analysis pages listed. ";
        html = html + "Each page has it's own breakdown of options to select so that you can access data on each specific outcome, as well as how it is broken down, displayed and ordered.</p>";
        //TODO: insert information on how GapScore is calculated as well? 
        html = html + "</div>";

        html = html + "<div class='credits'>2021 Website built by Scott Dunsdon (s3918676) and Alvaro Pena Leon (s3909789). All material presented on this website is provided under a Creative Commons Attribution 4.0 International licence. Special mentions: Australian Government Productivity Comission- Closing the Gap Information Repository;  Australia Bureau of Statistics; Closing The Gap Report 2020.</div>";

        

        //Closes Content
        html = html + "</div>";
        html = html + "</div>";

        //footer
        html = html + "<footer></footer>";


        // Adds some JS
        html = html + "<script src='common.js'></script>";
        
        // Finish the HTML webpage
        html = html + "</body></html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
