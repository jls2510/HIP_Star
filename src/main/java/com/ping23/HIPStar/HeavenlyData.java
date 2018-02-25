package main.java.com.ping23.HIPStar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

import main.java.com.ping23.util.DataUtilities;

public class HeavenlyData
{

    private HeavenlyData()
    {
    }

    public static void doSomething()
    {
        String query = getQuery("MessierObjects");

        ResultSet resultSet = getResultSet(query);

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

    public static ResultSet getResultSet(String query)
    {
        Connection connection = getHeavenlyConnection();

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

        ResultSet resultSet = getResultSet(query);

        try
        {
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
        String url = "jdbc:mysql://pegasus:3306/heavens";
        //String url = "jdbc:mysql://localhost:3306/heavens";
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

}
