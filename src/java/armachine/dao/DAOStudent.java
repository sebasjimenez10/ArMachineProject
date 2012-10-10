/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package armachine.dao;

import armachine.connection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erika Gomez
 * @author Sebastian Jimenez
 * @author David Sttivend
 * @author Ernesto Quintero
 */
public class DAOStudent {

    String studentName;
    String studentLastName;
    String studentEmail;
    String studentUser;
    String studentPassword;
    int studentId;

    public String StudentLogIn(String usr, String passw) {
        String resultado = null;
        try {
            String logIn = "SELECT studentName, studentLastName FROM Student WHERE studentUser = '" + usr + "' AND studentPassword = '" + passw + "'";
            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(logIn);
            if (rs.next()) {
                studentName = rs.getString("studentName");
                studentLastName = rs.getString("studentLastname");
                resultado = studentName + " " + studentLastName;
                return resultado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}