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

    // Return Percentages for Indigenous and Non- Indigenous on every Outcome


    // OUTCOME 1

    public double getOutcome1I(String status) {
        double outcome1I = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome1I = results.getDouble("(CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100");

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
        return outcome1I;
    }

    public double getOutcome1NonI(String status) {
        double outcome1NonI = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome1NonI = results.getDouble("(CAST(SUM(o.population65plus) as FLOAT) / SUM(o.populationTotal)) * 100");
            
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
        return outcome1NonI;
    }


    // OUTCOME 5

     public double getOutcome5I(String status) {
        double outcome5I = 0.0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedY12) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome5I = results.getDouble("(CAST(SUM(o.completedY12) as FLOAT) / SUM(o.population15plus)) * 100");

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
        return outcome5I;
    }

    public double getOutcome5NonI(String status) {
        double outcome5NonI = 0.0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedY12) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome5NonI = results.getDouble("(CAST(SUM(o.completedY12) as FLOAT) / SUM(o.population15plus)) * 100");
            
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
        return outcome5NonI;
    }



    // OUTCOME 6

    public double getOutcome6I(String status) {
        double outcome6I = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome6I = results.getDouble("(CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100");

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
        return outcome6I;
    }

    public int getOutcome6NonI(String status) {
        int outcome6NonI = 0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome6NonI = results.getInt("(CAST(SUM(o.completedAdvDipPlus) as FLOAT) / SUM(o.population15plus)) * 100");
            
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
        return outcome6NonI;
    }


    // OUTCOME 8
    
    public double getOutcome8I(String status) {
        double outcome8I = 0.0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome8I = results.getDouble("(CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100");

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
        return outcome8I;
    }

    public double getOutcome8NonI(String status) {
        double outcome8NonI = 0.0;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT (CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100 FROM (lga l JOIN outcome o ON o.lgaCode = l.lgaCode) JOIN outcome o2 ON o.lgaCode = o2.lgaCode AND o.sex = o2.sex AND o.censusYear = o2.censusYear WHERE o.indigenousStatus = '" + status + "'";

            ResultSet results = statement.executeQuery(query);
            outcome8NonI = results.getDouble("(CAST(SUM(o.employed) as FLOAT) / SUM(o.population15plus)) * 100");
            
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
        return outcome8NonI;
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
    
    public ArrayList<level2tableRow> dataByState(String outcome, String population, String display) {
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
            
            String query = "SELECT state, " + select1 + ", " + select2 + " FROM level2view GROUP BY state" + having;
            
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
//************************************************************* LEVEL 2.2 - OLD VERSION with ORDER BY  *************************************************************


    public ArrayList<level2tableRow> dataByStateOLD(String outcome, String population, String display, String orderColumn, String order) {
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


public ArrayList<level2tableRow> dataByGapScore(String outcome, String population, String display, String range) {
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
        String select3 = "";
        //String orderBy = "";

        


        if (display.equals("Count")) {
            select1 = "SUM(" + outcome + "_i)";
            select2 = "SUM(" + outcome + "_ni)";
        } else {
            select1 = "AVG(" + outcome + "_iPercent)";
            select2 = "AVG(" + outcome + "_niPercent)";
        }

        select3 = "AVG(" + outcome + "_niPercent) - AVG(" + outcome + "_iPercent)";
        
        if (!population.equals("All")) {
            having = ", sex HAVING sex = '" + population + "' AND " + select3 + " <= " + range;
        }
        else {
            having = " HAVING " + select3 + " <= " + range;
        }

        
        

        String query = "SELECT lga, state, " + select1 + ", " + select2 + ", " + select3 + " FROM level2view GROUP BY lga" + having;
        
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
            row.setState(results.getString("state"));

            if (display.equals("Count")) {
                row.setCountIndig(results.getInt(select1));
                row.setCountNonIndig(results.getInt(select2));
            } else {
                row.setPercentIndig(results.getDouble(select1));
                row.setPercentNonIndig(results.getDouble(select2));
            }
            row.setGapScore(results.getDouble(select3));
            
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



public ArrayList<compareLGAdata> sourceOutcome (ArrayList<String> outcomeSelect) {
    //Create ArrayList of our tableRow class to store the returned data
    ArrayList<compareLGAdata> tableData = new ArrayList<compareLGAdata>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
        connection = DriverManager.getConnection(DATABASE);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        
        String gapScoreSelect = "(" + outcomeSelect.get(0);
        
        if (outcomeSelect.size() > 1) {
            for (int i = 1; i < outcomeSelect.size(); i++) {
                gapScoreSelect = gapScoreSelect + " + " + outcomeSelect.get(i);
            }
        }
        gapScoreSelect = gapScoreSelect + ") / " + outcomeSelect.size();
        

        String query = "SELECT lga, lgaPopulation, populationDensity, proportionIndigenous, " + gapScoreSelect + " FROM lgaCompareView";


        //test query output
        //System.out.println(query);

        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results

        while (results.next()) {
            compareLGAdata row = new compareLGAdata();
            
            row.setLga(results.getString("lga"));
            row.setPopulation(results.getInt("lgaPopulation"));
            row.setDensity(results.getDouble("populationDensity"));
            row.setProportionIndig(results.getDouble("proportionIndigenous"));
            row.setGapScore(results.getDouble(gapScoreSelect));

            tableData.add(row);
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
    return tableData;
}



//************************************************************* LEVEL 3.2 - LGA COMPARISONS  *************************************************************

public ArrayList<String> getLGAs() {

    ArrayList<String> lgaNames = new ArrayList<String>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
        connection = DriverManager.getConnection(DATABASE);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT DISTINCT lga FROM level2view ORDER BY lga";
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results

        while (results.next()) {
            lgaNames.add(results.getString("lga"));
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
    return lgaNames;
}

public compareLGAdata sourceLGA (ArrayList<String> outcomeSelect, String lgaDrop) {
    //Create ArrayList of our tableRow class to store the returned data
    compareLGAdata tableData = new compareLGAdata();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
        connection = DriverManager.getConnection(DATABASE);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        
        String gapScoreSelect = "(" + outcomeSelect.get(0);
        
        if (outcomeSelect.size() > 1) {
            for (int i = 1; i < outcomeSelect.size(); i++) {
                gapScoreSelect = gapScoreSelect + " + " + outcomeSelect.get(i);
            }
        }
        gapScoreSelect = gapScoreSelect + ") / " + outcomeSelect.size();
        

        String query = "SELECT lga, state, latitude, longitude, lgaPopulation, populationDensity, proportionIndigenous, " + gapScoreSelect + " FROM lgaCompareView ";

        if (lgaDrop.equals("outcomeBest")) {
            query = query + "ORDER BY " + gapScoreSelect + " DESC LIMIT 1";
        }
        else if (lgaDrop.equals("outcomeWorst")) {
            query = query + "ORDER BY " + gapScoreSelect + " LIMIT 1";
        } else {
            query = query + "WHERE lga = '" + lgaDrop + "'";
        }

        //test query output
        //System.out.println(query);

        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results

        while (results.next()) {
            
            tableData.setLga(results.getString("lga"));
            tableData.setState(results.getString("state"));
            tableData.setLatitude(results.getDouble("latitude"));
            tableData.setLongitude(results.getDouble("longitude"));
            tableData.setPopulation(results.getInt("lgaPopulation"));
            tableData.setDensity(results.getDouble("populationDensity"));
            tableData.setProportionIndig(results.getDouble("proportionIndigenous"));
            tableData.setGapScore(results.getDouble(gapScoreSelect));
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
    return tableData;
}

public ArrayList<compareLGAdata> compareLGA (ArrayList<String> outcomeSelect, String lgaDrop, String sourceLga, String comparison) {
    //Create ArrayList of our tableRow class to store the returned data
    ArrayList<compareLGAdata> tableData = new ArrayList<compareLGAdata>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
        connection = DriverManager.getConnection(DATABASE);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        
        String gapScoreSelect = "(" + outcomeSelect.get(0);
        
        if (outcomeSelect.size() > 1) {
            for (int i = 1; i < outcomeSelect.size(); i++) {
                gapScoreSelect = gapScoreSelect + " + " + outcomeSelect.get(i);
            }
        }
        gapScoreSelect = gapScoreSelect + ") / " + outcomeSelect.size();
        
        if (comparison.equals("gapScore")){
            comparison = gapScoreSelect;
        }

        

        String query = "SELECT lga, state, lgaPopulation, populationDensity, proportionIndigenous, " + gapScoreSelect + " FROM lgaCompareView ";
        query = query + "WHERE " + comparison + " <= (SELECT " + comparison + " from lgaCompareView WHERE lga = '" + sourceLga + "') AND lga IS NOT '" + sourceLga + "'";
        query = query + "ORDER BY " + comparison + " DESC "; 
        
        if (lgaDrop.equals("outcomeBest") && comparison.equals(gapScoreSelect)) {
            query = query + "LIMIT 10";
        } else {
            query = query + "LIMIT 5";
        }
 
        //test query output
        //System.out.println(query);

        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results

        while (results.next()) {
            compareLGAdata tableRow = new compareLGAdata();
            
            tableRow.setLga(results.getString("lga"));
            tableRow.setState(results.getString("state"));
            tableRow.setPopulation(results.getInt("lgaPopulation"));
            tableRow.setDensity(results.getDouble("populationDensity"));
            tableRow.setProportionIndig(results.getDouble("proportionIndigenous"));
            tableRow.setGapScore(results.getDouble(gapScoreSelect));

            tableData.add(tableRow);
        }

        String query2 = "SELECT lga, state, lgaPopulation, populationDensity, proportionIndigenous, " + gapScoreSelect + " FROM lgaCompareView ";
        query2 = query2 + "WHERE " + comparison + " > (SELECT " + comparison + " from lgaCompareView WHERE lga = '" + sourceLga + "') ";
        query2 = query2 + "ORDER BY " + comparison + " LIMIT 5";
        

        //test query output
        //System.out.println(query2);

        // Get Result
        ResultSet results2 = statement.executeQuery(query2);

        // Process all of the results

        while (results2.next()) {
            compareLGAdata tableRow = new compareLGAdata();
            
            tableRow.setLga(results2.getString("lga"));
            tableRow.setState(results2.getString("state"));
            tableRow.setPopulation(results2.getInt("lgaPopulation"));
            tableRow.setDensity(results2.getDouble("populationDensity"));
            tableRow.setProportionIndig(results2.getDouble("proportionIndigenous"));
            tableRow.setGapScore(results2.getDouble(gapScoreSelect));

            tableData.add(tableRow);
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
    return tableData;
}

public ArrayList<compareLGAdata> compareDistance (ArrayList<String> outcomeSelect, String sourceLga) {
    //Create ArrayList of our tableRow class to store the returned data
    ArrayList<compareLGAdata> tableData = new ArrayList<compareLGAdata>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base, prepare a new SQL Query & Set a timeout
        connection = DriverManager.getConnection(DATABASE);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        
        String gapScoreSelect = "(" + outcomeSelect.get(0);
        
        if (outcomeSelect.size() > 1) {
            for (int i = 1; i < outcomeSelect.size(); i++) {
                gapScoreSelect = gapScoreSelect + " + " + outcomeSelect.get(i);
            }
        }
        gapScoreSelect = gapScoreSelect + ") / " + outcomeSelect.size();
        

        String query = "SELECT lga, state, latitude, longitude, lgaPopulation, populationDensity, proportionIndigenous, " + gapScoreSelect + " FROM lgaCompareView ";
        query = query + "WHERE lga IS NOT '" + sourceLga + "'";
        
        //test query output
        //System.out.println(query);

        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results

        while (results.next()) {
            compareLGAdata tableRow = new compareLGAdata();
            
            tableRow.setLga(results.getString("lga"));
            tableRow.setState(results.getString("state"));
            tableRow.setLatitude(results.getDouble("latitude"));
            tableRow.setLongitude(results.getDouble("longitude"));
            tableRow.setPopulation(results.getInt("lgaPopulation"));
            tableRow.setDensity(results.getDouble("populationDensity"));
            tableRow.setProportionIndig(results.getDouble("proportionIndigenous"));
            tableRow.setGapScore(results.getDouble(gapScoreSelect));

            tableData.add(tableRow);
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
    return tableData;
}




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