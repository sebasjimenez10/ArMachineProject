/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author David
 */
public class GradeCalc {

    public Double CalculateGrade(JSONArray answer, JSONArray correct) {

        double contCorrectas = 0;
        double contTotal = answer.length();
        double notaTotal = -1;
        double maxNota = 5;

        try {
            for (int i = 0; i < answer.length(); i++) {

                if (((char)answer.getInt(i) + "").equals(correct.getString(i))) {
                    System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    contCorrectas++;
                }
            }
            System.out.println("Correctas: " + contCorrectas);
            System.out.println("Totales: " + contTotal);
            System.out.println("Maxima Nota: " + maxNota);

            notaTotal = (double) (contCorrectas / contTotal) * maxNota;

            System.out.println("Nota Total: " + notaTotal);
        } catch (JSONException ex) {
            Logger.getLogger(GradeCalc.class.getName()).log(Level.SEVERE, null, ex);
        }



        return notaTotal;
    }
}
