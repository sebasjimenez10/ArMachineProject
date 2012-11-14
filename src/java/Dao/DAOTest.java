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
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class DAOTest {

    public String registryTest(String idProfessor, String testName, String testDescription, String testDate) {

        String resultado = "No se pudo realizar la Operación";
        String query = "INSERT INTO Test(idProfessor, nameTest,descriptionTest,dateTest) VALUES (\"" + idProfessor + "\",\"" + testName + "\",\"" + testDescription + "\",\"" + testDate + "\")";
        System.out.println("La Sentencia es : " + query);

        DbConnection db = new DbConnection();
        int rs = db.runSqlUpdate(query);

        if (rs != 0) {
            resultado = "Registro de Test Completo";
        }
        return resultado;
    }

    public String getIdtest(String testName) {

        String result = "No se pudo realizar la Consulta";

        String query = "SELECT idTest FROM Test WHERE nameTest = \"" + testName + "\"";
        System.out.println("La Sentencia es : " + query);
        try {

            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(query);

            if (rs.next()) {

                result = rs.getString("idTest");
            } else {
                result = "Cero resultados";
            }


        } catch (SQLException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String getTestNames(String idProfessor) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT nameTest, idTest FROM Test WHERE idProfessor = \"" + idProfessor + "\"";
        JSONObject js = new JSONObject();
        JSONArray idTest = new JSONArray();
        JSONArray nameTest = new JSONArray();

        DbConnection db = new DbConnection();
        ResultSet rs = db.runSqlStatement(query);

        try {
            if(!rs.isBeforeFirst()){
                result = "Cero resultados";
                return result;
            }
            while (rs.next()) {
                nameTest.put(rs.getString("nameTest"));
                idTest.put(rs.getString("idTest"));
            }

            js.put("nameTest", nameTest);
            js.put("idTest", idTest);

            result = js.toString();

        } catch (JSONException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}