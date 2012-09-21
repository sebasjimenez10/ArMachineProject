/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package dao;

import connection.DbConnection;
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
public class DAOProfessor {

    String professorName;
    String professorLastName;
    String professorEmail;
    String professorUser;
    String professorPassword;
    int professorId;

    public String ProfessorLogIn(String usr, String passw) {
        String resultado = null;
        try {

            String logIn = "SELECT professorName, professorLastName FROM Professor WHERE professorUser = '" + usr + "' AND professorPassword = '" + passw + "'";
            System.out.println("La sentencia es : " + logIn);
            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(logIn);
            if (rs.next()) {
                professorName = rs.getString("professorName");
                professorLastName = rs.getString("professorLastname");
                resultado = professorName + " " + professorLastName;
                return resultado;
            }
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
