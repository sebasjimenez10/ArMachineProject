/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package connection;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erika Gomez
 * @author Sebastian Jimenez
 * @author David Sttivend
 * @author Ernesto Quintero
 */
public class DbConnection {

    public DbConnection() {
    }

    public Connection getConection() throws IOException, ClassNotFoundException, SQLException {

        Connection connection;

        String host = "jdbc:mysql://mysql-armachine.jelastic.servint.net/Armachine";
        String username = "root";
        String password = "armachinep";
        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver);
        System.out.println("DRIVER: " + driver);
        connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);
        return connection;
    }

    public ResultSet runSqlStatement(String sentencia) {
        ResultSet sqlQuery = null;
        try {
            Statement statement = getConection().createStatement();
            sqlQuery = statement.executeQuery(sentencia);
            return sqlQuery;
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqlQuery;
    }
}