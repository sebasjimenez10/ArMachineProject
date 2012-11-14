/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
/**
 *
 * @author Erika Gomez
 * @author Sebastian Jimenez
 * @author David Sttivend
 * @author Ernesto Quintero
 */
package connection;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConection() throws IOException, ClassNotFoundException, SQLException {

        if (connection == null) {

            String host = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/armachinep";
            String username = "aroot";
            String password = "armachinep";
            
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver);
            System.out.println("DRIVER: " + driver);
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("CONNECTION: " + connection);

        }

        return connection;
    }

    public static ResultSet runSqlStatement(String sentencia) {
        ResultSet a = null;
        try {
            Statement statement = getConection().createStatement();
            a = statement.executeQuery(sentencia);
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public static int runSqlUpdate(String query) {
        int rst = 0;
        try {
            Statement statement = getConection().createStatement();
            rst = statement.executeUpdate(query);
            System.out.println("El Update devolvio: " + rst);
            return rst;
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
}