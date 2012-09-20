/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DbConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DAOStudent {
    
    
    String studentName;
    String studentLastName;
    String studentEmail;
    String studentUser;
    String studentPassword;
    int studentId;

    public String LogInStudent(String usr, String passw) {
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
