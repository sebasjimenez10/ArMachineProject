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

import armachine.connection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(DAOStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public String registryStudent(String name, String user, String lastName, String email, String password, String professor) {
        String idProfessor = null;
        String resultado = "No se pudo ejecutar el registro, Valide sus datos";

        DAOProfessor DAOp = new DAOProfessor();
        idProfessor = DAOp.searchProfessor(professor);

        if (idProfessor != null) {

            String query = "INSERT INTO Student(studentName, studentUser, studentLastName, studentEmail, studentPassword, idProfessor) VALUES (\"" + name + "\",\"" + user + "\",\"" + lastName + "\",\"" + email + "\",\"" + password + "\", " + idProfessor + " )";
            System.out.println("La sentencia es : " + query);

            DbConnection db = new DbConnection();
            int rs = db.runSqlUpdate(query);
            System.out.println("RESULT SET = " + rs);

            if (rs != 0) {
                System.out.println("Result Set = " + rs);
                resultado = "Registro Completo";
            }
        }
        return resultado;
    }
}
