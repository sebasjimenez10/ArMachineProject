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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author David
 */
public class DAOStudentAnswer {

    public String DoTest(String js) {
        String result = "No se pudo realizar la Operación";
        String query;
        DbConnection db = new DbConnection();
        String idTest;
        String idStudent;
        int rs;
        boolean error = false;

        try {
            JSONObject convert = new JSONObject(js);

            JSONArray idQuestion = convert.getJSONArray("questions");
            JSONArray answer = convert.getJSONArray("answers");


            idTest = convert.getString("idTest");
            idStudent = convert.getString("idStudent");

            for (int i = 0; i < idQuestion.length(); i++) {

                query = "INSERT INTO StudentAnswer( idTestQuestion, idStudent, idTest, answer) VALUES (\"" + idQuestion.get(i) + "\",\"" + idStudent + "\",\"" + idTest + "\",\"" + answer.get(i) + "\")";
                rs = db.runSqlUpdate(query);
                if (rs == 0) {
                    error = true;
                }

            }
            result = "Registro Completo";
            if (error == true) {
                result = "Registro con Errores";
            }

        } catch (JSONException ex) {
            Logger.getLogger(DAOStudentAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }
}
