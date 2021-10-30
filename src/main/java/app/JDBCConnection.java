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
    private static final String DATABASE = "jdbc:sqlite:database/ctg.db";

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    //************************************************************* LEVEL 1.1 - INDEX PAGE *************************************************************

    //FACT 1
    public int getFirstFact1(String status) {
        int count1I = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count1I = results.getInt("(CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100");

            // Close statement
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
        return count1I;
    }

    public int getFirstFact2(String status) {
        int count1NonI = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count1NonI = results.getInt("(CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100");
            
            // Close statement
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
        return count1NonI;
    }


    //FACT 2
    public int getSecondFact1(String status) {
        int count2I = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count2I = results.getInt("(CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100");

            // Close statement
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
        return count2I;
    }

    public int getSecondFact2(String status) {
        int count2NonI = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count2NonI = results.getInt("(CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100");
            
            // Close statement
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
        return count2NonI;
    }



    //FACT 3
    public int getThirdFact1(String status) {
        int count3I = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count3I = results.getInt("(CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100");

            // Close statement
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
        return count3I;
    }

    public int getThirdFact2(String status) {
        int count3NonI = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            count3NonI = results.getInt("(CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100");
            
            // Close statement
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
        return count3NonI;
    }




    //************************************************************* LEVEL 2.1 - LGA STATISTICS *************************************************************
    
    public ArrayList<level2tableRow> dataByLga(String outcome, String population, String display) {
        //Create ArrayList of our tableRow class to store the returned data
        ArrayList<level2tableRow> level2TableData = new ArrayList<level2tableRow>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            
            String select1 = "";
            String select2 = "";
            String having = "";
            //String orderBy = "";


            if (display.equals("Count")) {
                select1 = "SUM(" + outcome + "_i)";
                select2 = "SUM(" + outcome + "_ni)";
            } else {
                select1 = "AVG(" + outcome + "_iPercent)";
                select2 = "AVG(" + outcome + "_niPercent)";
            }
            
            if (!population.equals("All")) {
                having = ", sex HAVING sex = '" + population + "'";
            }
            
            /*if (orderColumn.equals("Lga")) {
                orderBy = "lga";
            } else if (orderColumn.equals("Indigenous Results")) {
                orderBy = select1;
            } else {
                orderBy = select2;
            }*/

            String query = "SELECT lga, " + select1 + ", " + select2 + " FROM level2view GROUP BY lga" + having ;
            
            //test query output
            //System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results

            while (results.next()) {
                //create a new row of data
                level2tableRow row = new level2tableRow();

                //use Set methods to store individual values
                row.setLga(results.getString("lga"));

                if (display.equals("Count")) {
                    row.setCountIndig(results.getInt(select1));
                    row.setCountNonIndig(results.getInt(select2));
                } else {
                    row.setPercentIndig(results.getDouble(select1));
                    row.setPercentNonIndig(results.getDouble(select2));
                }
                //add this row to our ArrayList
                level2TableData.add(row);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
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

        // Finally we return all table data
        return level2TableData;
    }

    
    //************************************************************* LEVEL 2.2 - STATE STATISTICS  *************************************************************
    
    public ArrayList<level2tableRow> dataByState(String outcome, String population, String display, String orderColumn, String order) {
        //Create ArrayList of our tableRow class to store the returned data
        ArrayList<level2tableRow> level2TableData = new ArrayList<level2tableRow>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            
            String select1 = "";
            String select2 = "";
            String having = "";
            String orderBy = "";


            if (display.equals("Count")) {
                select1 = "SUM(" + outcome + "_i)";
                select2 = "SUM(" + outcome + "_ni)";
            } else {
                select1 = "AVG(" + outcome + "_iPercent)";
                select2 = "AVG(" + outcome + "_niPercent)";
            }
            
            if (!population.equals("All")) {
                having = ", sex HAVING sex = '" + population + "'";
            }
            
            if (orderColumn.equals("State")) {
                orderBy = "state";
            } else if (orderColumn.equals("Indigenous Results")) {
                orderBy = select1;
            } else {
                orderBy = select2;
            }

            String query = "SELECT state, " + select1 + ", " + select2 + " FROM level2view GROUP BY state" + having + " ORDER BY " + orderBy + " " + order;
            
            //test query output
            //System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results

            while (results.next()) {
                //create a new row of data
                level2tableRow row = new level2tableRow();

                //use Set methods to store individual values
                row.setState(results.getString("state"));

                if (display.equals("Count")) {
                    row.setCountIndig(results.getInt(select1));
                    row.setCountNonIndig(results.getInt(select2));
                } else {
                    row.setPercentIndig(results.getDouble(select1));
                    row.setPercentNonIndig(results.getDouble(select2));
                }
                //add this row to our ArrayList
                level2TableData.add(row);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
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

        // Finally we return all table data
        return level2TableData;
    }

    

//************************************************************* LEVEL 3.1 - GAPSCORE  *************************************************************





//************************************************************* LEVEL 3.2 - LGA COMPARISONS  *************************************************************





//************************************************************* TEST QUERY  *************************************************************


    public ArrayList<level2tableRow> testQuery() {
        //Create ArrayList of our tableRow class to store the returned data
        ArrayList<level2tableRow> level2TableData = new ArrayList<level2tableRow>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT state, SUM(outcome1_i), SUM(outcome1_ni) FROM level2view GROUP BY state";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results

            while (results.next()) {
                //create a new row of data
                level2tableRow row = new level2tableRow();

                //use Set methods to store individual values
                row.setState(results.getString("state"));
                row.setCountIndig(results.getInt("SUM(outcome1_i)"));
                row.setCountNonIndig(results.getInt("SUM(outcome1_ni)"));

                //add this row to our ArrayList
                level2TableData.add(row);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
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

        // Finally we return all table data
        return level2TableData;
    }

}