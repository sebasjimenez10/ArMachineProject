/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import connection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author David
 */
public class DAOStudentTest {

    public String getScoreStudents(String idProfessor) {

        String result = "No se pudo realizar la Consulta";
        JSONObject js = new JSONObject();
        String query = "SELECT Student.studentName, Test.nameTest, StudentTest.grade FROM Student, Test, StudentTest WHERE Student.idProfessor =  \"" + idProfessor + "\" AND Test.idProfessor = \"" + idProfessor + "\" AND Student.idStudent = StudentTest.idStudent AND Test.idTest = StudentTest.idTest AND StudentTest.idState = 1";


        int length;
        String[] studentName;
        String[] nameTest;
        String[] grades;

        ResultSet rs = DbConnection.runSqlStatement(query);
        try {
            if (rs.last()) {
                length = rs.getRow();
                rs.beforeFirst();
                studentName = new String[length];
                nameTest = new String[length];
                grades = new String[length];

                int i = 0;
                while (rs.next()) {
                    studentName[i] = rs.getString("studentName");

                    nameTest[i] = rs.getString("nameTest");

                    grades[i] = rs.getString("grade");


                    i++;
                }
                js.put("studentname", studentName);
                js.put("testname", nameTest);
                js.put("grades", grades);
                result = js.toString();


            } else {
                result = "Cero resultados";
            }
        } catch (JSONException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public String GetUnassignTest(String idStudent, String idProfessor) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT nameTest FROM Test WHERE Test.idProfessor = \"" + idProfessor + "\" AND Test.idTest NOT IN(SELECT Test.idTest  FROM Test, StudentTest WHERE StudentTest.idTest = Test.idTest AND StudentTest.idStudent = \"" + idStudent + "\")";
        System.out.println("La Sentencia fue =" + query);
        ResultSet rs = DbConnection.runSqlStatement(query);
        try {
            if (rs.next()) {
                result = rs.getString("nameTest");
                while (rs.next()) {
                    result = result + "," + rs.getString("nameTest");
                }
                System.out.println("El Resultado fue = " + result);

            } else {
                result = "Cero resultados";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = "No se pudo realizar la consulta";
        }
        return result;

    }

    public String RegistryStudentTest(String idStudent, String idTest) {

        String result = "No se pudo realizar la Operación";
        String query = "INSERT INTO StudentTest(idStudent, idTest, idState) VALUES (\"" + idStudent + "\",\"" + idTest + "\",\"" + 3 + "\")";
        System.out.println("La sentencia es :" + query);
        int rs = DbConnection.runSqlUpdate(query);
        if (rs != 0) {
            System.out.println("Result Set = " + rs);
            result = "Registro Completo";
        }
        return result;

    }

    public String GetAssignTest(String idStudent) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT Test.nameTest FROM Test, StudentTest WHERE StudentTest.idStudent = \"" + idStudent + "\" AND StudentTest.idState = \"" + 3 + "\" AND StudentTest.idTest = Test.idTest";
        System.out.println("La sentenica es: " + query);
        ResultSet rs = DbConnection.runSqlStatement(query);
        try {
            if (rs.next()) {
                result = rs.getString("nameTest");

                while (rs.next()) {
                    result = result + "," + rs.getString("nameTest");
                }

            } else {
                result = "Cero resultados";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String GetMyScore(String idStudent) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT Test.nameTest, StudentTest.grade FROM Test, StudentTest WHERE StudentTest.idStudent = " + idStudent + " AND StudentTest.idState = \"" + 1 + "\" AND StudentTest.idTest = Test.idTest";
        String[] Notas;
        String[] Test;
        JSONObject js = new JSONObject();
        int length;


        ResultSet rs = DbConnection.runSqlStatement(query);
        try {
            if (rs.last()) {
                length = rs.getRow();
                rs.beforeFirst();
                Notas = new String[length];
                Test = new String[length];


                int i = 0;
                while (rs.next()) {
                    Notas[i] = rs.getString("grade");

                    Test[i] = rs.getString("nameTest");


                    i++;
                }

                js.put("testname", Test);
                js.put("grades", Notas);
                result = js.toString();


            } else {
                result = "Cero resultados";
            }
        } catch (JSONException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public String GetCompleteTest(String idStudent) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT Test.nameTest FROM Test, StudentTest WHERE StudentTest.idStudent = " + idStudent + " AND StudentTest.idState = 1 AND StudentTest.idTest = Test.idTest";
        System.out.println("La sentencia fue: " + query);
        ResultSet rs = DbConnection.runSqlStatement(query);

        try {
            if (rs.next()) {
                result = rs.getString("nameTest");

                while (rs.next()) {
                    result = result + "," + rs.getString("nameTest");
                }

            } else {
                result = "Cero resultados";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    public String DeleteAssignTest(String idStudent, String idTest) {

        String result = "No se pudo realizar la Consulta";
        String query = "DELETE FROM StudentTest WHERE StudentTest.idStudent = \"" + idStudent + "\" AND StudentTest.idTest = \"" + idTest + "\"";
        int rs = DbConnection.runSqlUpdate(query);
        if (rs == 0) {
            result = "No se pudo realizar la Operación";
        } else {
            result = "Delete Exitoso";
        }
        return result;

    }

    public String UpdateStudentTest(String idStudent, String idTest, double grade) {
        
        String result = "No se pudo realizar la Operacion";
        String query = "UPDATE StudentTest SET idState= 1, grade=\"" + grade + "\" WHERE idStudent = " + idStudent + " AND idTest = \"" + idTest + "\"";
        int rs = DbConnection.runSqlUpdate(query);
        if (rs != 0) {
            result = "Registro Completo";
        }
        return result;
    }
}
