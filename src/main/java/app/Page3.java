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
        
        /* Add HTML for the web form
         * We are giving two ways here
         *  - one for a text box
         *  - one for a drop down
         * 
         * Whitespace is used to help us understand the HTML!
         * 
         * IMPORTANT! the action speicifes the URL for POST!
         */
        html = html + "<form action='/page3.html' method='post'>";
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> movieDirector = jdbc.getMovieDirector();
        
        // Add HTML for the dropdown list

        html = html + "   <div class='form-group'>";
        html = html + "      <label for='movietype_drop'>Select the Movie Director (Dropdown):</label>";
        html = html + "      <select id='moviedirector_drop' name='moviedirector_drop'>";
        html = html + "         <option> </option>";
        for (String director : movieDirector) {
                html = html + "<option>" + director + "</option>";
            }
        html = html + "      </select>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='orderby_drop'>Order Movie Titles by:</label>";
        html = html + "      <select id='orderby_drop' name='orderby_drop'>";
        html = html + "         <option> </option>";
        html = html + "         <option> ASC </option>";
        html = html + "         <option> DESC </option>";
        html = html + "      </select>";
        html = html + "   </div>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='moviedirector_textbox'>Select the Movie Director (Textbox)</label>";
        html = html + "      <input class='form-control' id='moviedirector_textbox' name='moviedirector_textbox'>";
        html = html + "   </div>";

        html = html + "   <button type='submit' class='btn btn-primary'>Get all of the movies!</button>";

        html = html + "</form>";
        
        html = html + "</div>";



        //Col2 - Table
        html = html + "<div class='colTable'>";
        // html = html + "<h1>Overview</h1><hr class='in'>";

        String moviedirector_drop = context.formParam("moviedirector_drop");
        String orderby_drop = context.formParam("orderby_drop");
        // String movietype_drop = context.queryParam("movietype_drop");
        if (moviedirector_drop == null) {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            html = html + "<h2><i>No Results to show for dropbox</i></h2>";
        } else {
            // If NOT NULL, then lookup the movie by type!
            html = html + outputMovies(moviedirector_drop, orderby_drop);
        }

        String moviedirector_textbox = context.formParam("moviedirector_textbox");
        if (moviedirector_textbox == null || moviedirector_textbox == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            html = html + "<h2><i>No Results to show for textbox</i></h2>";
        } else {
            // If NOT NULL, then lookup the movie by type!
            html = html + outputMovies(moviedirector_textbox, orderby_drop);
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

    public String outputMovies(String director, String orderby) {
        String html = "";
        html = html + "<h1>" + director + " Movies</h1><hr class='in'>";
        
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> movies = jdbc.getMovieTitlesAndDirectors(director, orderby);

        
        
        // Add HTML for the movies list
        html = html + "<table><tr><th>Title</th><th>Stars</th></tr>";
        for (String movie : movies) {

            ArrayList<String> stars = new ArrayList<String>();
            if (movie.contains("\'")) {
                String[] splitmovie = movie.split("\'");
                stars = jdbc.getStarByMovie("%" + splitmovie[0] + "%");
            } else { 
                stars = jdbc.getStarByMovie(movie);
            }
            
            html = html + "<tr><td>" + movie + "</td><td><ul>";
            for (String star : stars) {
                html = html + "<li>" + star + "</li>";
            }
            html = html + "</ul></td></tr>";

        }
        html = html + "</table>";

        return html;
    }



    public class MovieStars {
        String movieTitle;
        ArrayList<String> movieStars;
        
        //class constructor
        public MovieStars() {
            movieTitle = "";
            movieStars = new ArrayList<String>();
        }
    
        //get and set methods for the class attributes
        public String getTitle() {
            return movieTitle;
        }
        public ArrayList<String> getStars() {
            return movieStars;
        }
    
        public void setTitle(String title) {
            movieTitle = title;
        }
        public void setStars(ArrayList<String> stars){
            movieStars = stars;
        }
    
    }

}
