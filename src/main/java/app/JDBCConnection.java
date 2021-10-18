package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies Database
 * This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/Movies.db";

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    //************************************************************* LEVEL 1.1 - INDEX PAGE *************************************************************

    //FACT 1
    public int getFirstFact() {
        int count1 = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT count(*) from MOVIE";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            count1 = results.getInt("count(*)");

            // Close the statement because we are done with it
            statement.close();
            // Exception 
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return count1;
    }


    //FACT 2
    public int getSecondFact() {
        int count2 = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT count(*) from MOVIE";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            count2 = results.getInt("count(*)");

            // Close the statement because we are done with it
            statement.close();
            // Exception 
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return count2;
    }


    //FACT 3
    public int getThirdFact() {
        int count3 = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT count(*) from MOVIE";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            count3 = results.getInt("count(*)");

            // Close the statement because we are done with it
            statement.close();
            // Exception 
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return count3;
    }



    //************************************************************* LEVEL 2.1 - LGA STATISTICS *************************************************************
    
    public ArrayList<String> getMovieTitlesAndDirectors(String director, String orderby) {
        ArrayList<String> movies = new ArrayList<String>();
        
        //keep this
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // edit from here
            String query = "SELECT m.mvtitle FROM movie m JOIN director d ON m.dirnumb = d.dirnumb WHERE dirname = '" + director + "' ORDER BY mvtitle " + orderby + "";
            //System.out.println(query);
        
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String movieName     = results.getString("mvtitle");
                movies.add(movieName);
            }

            // keep this
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        //edit this as needed
        return movies;
    }


    // METHOD FOR DROP DOWN DIRECTOR 
    public ArrayList<String> getMovieDirector() {
        ArrayList<String> director = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT distinct dirname from DIRECTOR;";
           // System.out.println(query);
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String movieDirector     = results.getString("dirname");
                director.add(movieDirector);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return director;
    }



    public ArrayList<String> getStarByMovie(String movie) {
        ArrayList<String> star = new ArrayList<String>();
        
        //keep this
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // edit from here
            String query = "SELECT s.starname FROM star as s JOIN movstar as ms ON s.starnumb = ms.starnumb JOIN movie as m ON m.mvnumb = ms.mvnumb WHERE m.mvtitle LIKE '" + movie + "'";
            //System.out.println(query);
        
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String movieStar     = results.getString("starname");
                star.add(movieStar);
            }

            // keep this
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        //edit this as needed
        return star;
    }
    
    
    

    //************************************************************* LEVEL 2.2 - STATE STATISTICS  *************************************************************
    
    
    /**
     * Get all of the Movies in the database
     */
    public ArrayList<String> getMovies() {
        ArrayList<String> movies = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM movie";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                int id              = results.getInt("mvnumb");
                String movieName     = results.getString("mvtitle");
                int year            = results.getInt("yrmde");
                String type         = results.getString("mvtype");

                // For now we will just store the movieName and ignore the id
                movies.add(movieName);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return movies;
    }
}
