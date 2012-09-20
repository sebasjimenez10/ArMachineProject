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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    public DbConnection(){
    
    }
    

    public Connection getConection() throws IOException, ClassNotFoundException, SQLException {

             Connection connection;

            Properties prop = new Properties();
            System.out.println("test");
            //prop.load(new FileInputStream(/*System.getProperty("user.home") +*/ "/mydb.cfg"));
            //System.out.println("user.home: "+System.getProperty("user.home"));
            String host = "jdbc:mysql://mysql-armachine.jelastic.servint.net/Armachine";//prop.getProperty("host").toString();
            String username = "root"; //prop.getProperty("username").toString();
            String password = "armachinep"; //prop.getProperty("password").toString();
            String driver = "com.mysql.jdbc.Driver"; //prop.getProperty("driver").toString();

            System.out.println("host: " + host + "\\username: " + username + "\\password: " + password + "\ndriver: " + driver);

            Class.forName(driver);
            System.out.println("--------------------------");
            System.out.println("DRIVER: " + driver);
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("    ESTA ES MI CONEXION    ");
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
}
