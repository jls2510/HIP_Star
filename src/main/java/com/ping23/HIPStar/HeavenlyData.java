package main.java.com.ping23.HIPStar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import main.java.com.ping23.util.DataUtilities;

public class HeavenlyData
{

    private HeavenlyData()
    {
    }

    public static void printStarData()
    {
        ResultSet resultSet = getStarDataResultSet();

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


    }

    /**
     * get star data result set
     */
    public static ResultSet getStarDataResultSet()
    {
        Connection connection = getHeavenlyConnection();

        // do some heavenly stuff
        Statement statement = null;
        ResultSet resultSet = null;

        String sql =
            "SELECT h.HIP, n.Name, s.IAU_con, c.Constellation, h.Vmag, h.SpType "
                + "FROM iau_star_names AS n "
                + "INNER JOIN hip_main AS h ON n.HIP = h.HIP "
                + "INNER JOIN star_con AS s ON h.HIP = s.HIP "
                + "INNER JOIN Constellation AS c ON s.IAU_con = c.IAU_abbreviation "
                + "ORDER BY s.IAU_con, n.Name;\r\n";

        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return resultSet;

    }

    /**
     * get heavenly connection
     */
    private static Connection getHeavenlyConnection()
    {
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

}
