package main.java.com.ping23.HIPStar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import main.java.com.ping23.HIPStar.model.Constellation;
import main.java.com.ping23.util.DataUtilities;

public class HeavenlyData
{

    /**
     * DataSource instance, for getting Connections to the database
     */
    private static DataSource datasource;

    /*
     * static initializer for datasource
     */
    static
    {
        try
        {
            // Look up the JNDI data source only once at init time
            // this stuff is defined in META-INF/context.xml
            Context envCtx = (Context) new InitialContext();
            datasource =
                (DataSource) envCtx.lookup("java:comp/env/jdbc/heavens");
        }
        catch (NamingException e)
        {
            // e.printStackTrace();
            System.out.println(
                "Couldn't create the datasource for the Web App; " 
                + "If you are running as a standalone then you can safely ignore this.");
        }
    }

    private HeavenlyData()
    {
    }

    public static List<Constellation> getConstellations()
    {
        List<Constellation> constellations = new ArrayList<Constellation>();
        
        String query =
            "SELECT SNo, IAU_abbreviation, Constellation FROM constellation;";

        ResultSet resultSet = null;
        try
        {
            resultSet = getResultSet(query);
            resultSet.beforeFirst();
            
            while (resultSet.next())
            {
                int anID = Integer.parseInt(resultSet.getString("SNo"));
                String IAU_abbreviation = resultSet.getString("IAU_abbreviation");
                String aName = resultSet.getString("Constellation");
                Constellation newConstellation = new Constellation(anID, IAU_abbreviation, aName);
                
                constellations.add(newConstellation);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            resultSet.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return constellations;
    }
    
    /**
     * get the full constellation name for the given abbreviation
     * @param iau_con the constellation name abbreviation
     * @return
     */
    public static String getConstellationFullname(String iau_con)
    {
        String constellationFullname = null;

        String query =
            "SELECT constellation.Constellation FROM constellation WHERE constellation.IAU_abbreviation = '"
                + iau_con + "';";

        ResultSet resultSet = null;
        try
        {
            resultSet = getResultSet(query);
            resultSet.beforeFirst();
            while (resultSet.next())
            {
                constellationFullname = resultSet.getString("Constellation");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            resultSet.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return constellationFullname;
    } // getConstellationFullname()

    public static void doSomething()
    {
        String query = getQuery("MessierObjects");
        ResultSet resultSet = null;
        try
        {
            resultSet = getResultSet(query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        outputQueryData(resultSet);

        try
        {
            resultSet.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    } // doSomething()

    public static String getQuery(String queryName)
    {
        String query = "";

        if (queryName == "StarNames")
        {
            query =
                "SELECT h.HIP, n.Name, s.IAU_con, c.Constellation, h.Vmag, h.SpType "
                    + "FROM iau_star_names AS n "
                    + "INNER JOIN hip_main AS h ON n.HIP = h.HIP "
                    + "INNER JOIN star_con AS s ON h.HIP = s.HIP "
                    + "INNER JOIN constellation AS c ON s.IAU_con = c.IAU_abbreviation "
                    + "ORDER BY s.IAU_con, n.Name;\r\n";
        }
        else if (queryName == "MessierObjects")
        {
            query =
                "SELECT m.M, c.Constellation FROM messier_catalog AS m JOIN constellation AS c ON m.Con = c.IAU_abbreviation "
                    + "ORDER BY m.Con";
        }
        else
        {
            query = "SELECT * FROM HIP;";
        }

        return query;
    }

    public static void outputQueryData(ResultSet resultSet)
    {
        try
        {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            resultSet.beforeFirst();
            while (resultSet.next())
            {
                // String HIP = resultSet.getString("HIP");
                // String name = resultSet.getString("Name");
                // String constellation = resultSet.getString("Constellation");

                for (int columnIndex =
                    1; columnIndex <= columnCount; ++columnIndex)
                {
                    String columnName =
                        resultSetMetaData.getColumnName(columnIndex);
                    Object value = resultSet.getObject(columnIndex);
                    System.out.print(
                        columnName + ": " + String.valueOf(value) + "; ");
                }

                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    } // outputQueryData()

    public static ResultSet getResultSet(String query) throws SQLException
    {
        //Connection connection = getHeavenlyConnection();
        Connection connection = datasource.getConnection();

        // do some heavenly stuff
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return resultSet;

    } // getResultSet()

    public static void printStarData()
    {
        String query =
            "SELECT h.HIP, n.Name, s.IAU_con, c.Constellation, h.Vmag, h.SpType "
                + "FROM iau_star_names AS n "
                + "INNER JOIN hip_main AS h ON n.HIP = h.HIP "
                + "INNER JOIN star_con AS s ON h.HIP = s.HIP "
                + "INNER JOIN constellation AS c ON s.IAU_con = c.IAU_abbreviation "
                + "ORDER BY s.IAU_con, n.Name;\r\n";

        ResultSet resultSet = null;
        try
        {
            resultSet = getResultSet(query);
            resultSet.beforeFirst();
            while (resultSet.next())
            {
                String HIP = resultSet.getString("HIP");
                String name = resultSet.getString("Name");
                String constellation = resultSet.getString("Constellation");

                System.out.println(HIP + " " + name + " " + constellation);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            resultSet.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    } // printStarData()

    /**
     * get heavenly connection
     */
    private static Connection getHeavenlyConnection()
    {
        //String url = "jdbc:mysql://pegasus.ping23.com:3306/heavens";
        String url = "jdbc:mysql://localhost:3306/heavens";
        String username = "jls";
        String password = "twisted23";

        Connection connection = null;

        try
        {
            connection = DataUtilities.getConnection(url, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * output the constellation name for the given IAU abbreviation
     */
    public static void outputConstellationName()
    {
        System.out
            .println("Constellation name = " + getConstellationFullname("Cas"));
    }

}
