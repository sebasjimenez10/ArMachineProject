/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DAOProfessor {

    String professorName;
    String professorLastName;
    String professorEmail;
    String professorUser;
    String professorPassword;
    int professorId;

    public String LogInProfessor(String usr, String passw) {
        String resultado = null;
        try {
            
            String logIn = "SELECT professorName, professorLastName FROM Professor WHERE professorUser = '" + usr + "' AND professorPassword = '" + passw + "'";
            System.out.println("La sentencia es : "+logIn);
            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(logIn);
           if(rs.next()){
                
                professorName = rs.getString("professorName");
                System.out.println("EL NOMBRE ES : "+professorName);
                professorLastName = rs.getString("professorLastname");
                System.out.println("EL APELLIDO ES : "+professorLastName);
                resultado = professorName + " " + professorLastName;
                
                return resultado;
           }
           return "EL RS ESTA VACIO";
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
