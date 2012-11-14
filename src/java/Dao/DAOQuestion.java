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

public class DAOQuestion {

    public String registryQuestion(String sentence, String opcionA, String opcionB, String opcionC, String opcionD, String correct, String idProfessor, String tagName) {

        String resultado = "No se pudo realizar la Operación";
        String idTag;

        DAOTag DAOt = new DAOTag();
        idTag = DAOt.getIdTag(tagName);

        if (idTag != null) {

            String query = "INSERT INTO Question(sentence , idProfessor , idTag , optionA , optionB , optionC , optionD , correct) VALUES (\"" + sentence + "\",\"" + idProfessor + "\",\"" + idTag + "\",\"" + opcionA + "\",\"" + opcionB + "\",\"" + opcionC + "\",\"" + opcionD + "\",\"" + correct + "\")";
            System.out.println("La Sentencia es : " + query);

            DbConnection db = new DbConnection();
            int rs = db.runSqlUpdate(query);
            System.out.println("RESUL SET = " + rs);

            if (rs != 0) {

                resultado = "Registro Completo";
            }
        }
        return resultado;
    }

    public String getIdQuestion(String nombre) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT idQuestion FROM Question WHERE sentence = \"" + nombre + "\"";

        DbConnection db = new DbConnection();
        ResultSet rs = db.runSqlStatement(query);
        try {
            if (rs.next()) {

                result = rs.getString("idQuestion");
            } else {
                result = "Cero resultados";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public String getQuestion(String idProfessor) {

        String result = "No se pudo realizar la Consulta";
        String query = "SELECT sentence FROM Question WHERE idProfessor = \"" + idProfessor + "\"";
        JSONArray ja = new JSONArray();
        JSONObject js = new JSONObject();

        DbConnection db = new DbConnection();
        ResultSet rs = db.runSqlStatement(query);

        try {


            while (rs.next()) {

                ja.put(rs.getString("sentence"));

            }
            if (ja.length() > 0) {
                
                js.put("sentence", ja);

                result = js.toString();
            } else {
                result = "Cero Resultados";
            }

        } catch (JSONException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTag.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;

    }
}