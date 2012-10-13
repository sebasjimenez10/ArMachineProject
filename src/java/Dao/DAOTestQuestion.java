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

public class DAOTestQuestion {

    public String registryTestQuestion(String testName, String sentence) {
        String resultado = "El Registro no se pudo Realizar";

        String[] arr = sentence.split(",");
        String idTest;
        String[] idQuestion = new String[arr.length];



        DAOTest DAOt = new DAOTest();
        idTest = DAOt.getIdtest(testName);

        DAOQuestion DAOq = new DAOQuestion();

        for (int i = 0; i < arr.length; i++) {

            idQuestion[i] = DAOq.getIdQuestion(arr[i]);
            System.out.println("idQuestion en la posicion " + i + " Es " + idQuestion[i]);
        }

        int rs[] = new int[idQuestion.length];
        String query;
        boolean error = false;

        if (idQuestion != null && idTest != null) {

            DbConnection db = new DbConnection();

            for (int i = 0; i < idQuestion.length; i++) {
                query = "INSERT INTO TestQuestion(idQuestion, idTest) VALUES (\"" + idQuestion[i] + "\",\"" + idTest + "\")";

                rs[i] = db.runSqlUpdate(query);
                System.out.println("El RS en " + i + " fue " + rs[i]);
                if (rs[i] == 0) {
                    error = true;
                    System.out.println("No se pudo registrar la pregunta " + arr[0]);
                }

            }
            if(error != true){
            
                resultado = "Registro con Errores";
            }else
            {
                resultado = "Registro Completo";
            }

        }

        return resultado;

        
    }
}
