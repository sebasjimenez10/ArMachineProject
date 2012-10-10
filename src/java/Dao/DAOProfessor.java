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
package Dao;

import connection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            System.out.println("La sentencia es : " + logIn);
            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(logIn);
            if (rs.next()) {

                professorName = rs.getString("professorName");
                professorLastName = rs.getString("professorLastname");
                resultado = professorName + " " + professorLastName;

                return resultado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public String registryProfessor(String name, String user, String lastName, String email, String password) {
        String resultado = "No se pudo ejecutar el registro";

        String query = "INSERT INTO Professor(professorName, professorUser, professorLastName, professorEmail, professorPassword) VALUES (\"" + name + "\",\"" + user + "\",\"" + lastName + "\",\"" + email + "\",\"" + password + "\")";
        System.out.println("La sentencia es : " + query);
        DbConnection db = new DbConnection();
        int rs = db.runSqlUpdate(query);

        System.out.println("RESULT SET = " + rs);
        if (rs != 0) {
            System.out.println("Result Set = " + rs);
            resultado = "Registro Completo";
            return resultado;
        }
        return resultado;
    }

    public String searchProfessor(String name) {

        String resultado = null;
        String query = "SELECT * FROM Professor WHERE professorName = '" + name + "'";

        try {

            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(query);
            if (rs.next()) {

                resultado = rs.getString("idProfessor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}