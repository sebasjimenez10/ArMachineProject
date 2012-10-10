    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author Menes
 */
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    public DbConnection() {
    }

    public Connection getConection() throws IOException, ClassNotFoundException, SQLException {

        Connection connection;

        String host = "jdbc:mysql://mysql-armachinep.jelastic.servint.net/Armachine";
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
        ResultSet a = null;
        try {
            Statement statement = getConection().createStatement();
            a = statement.executeQuery(sentencia);
            return a;
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public int runSqlUpdate(String query) {
        int rst = 0;
        try {
            Statement statement = getConection().createStatement();
            rst = statement.executeUpdate(query);
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