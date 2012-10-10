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
package armachine.Dao;

import Dao.DAOTag;
import armachine.connection.DbConnection;

public class DAOQuestion {
    
    public String registryQuestion(String sentence,String opcionA ,String opcionB ,String opcionC ,String opcionD ,String correct ,String idProfessor ,String tagName){
        
        String resultado = null;
        String idTag;
        
        DAOTag DAOt = new DAOTag();
        idTag = DAOt.getIdTag(tagName);
        
        if(idTag != null){
        
            String query = "INSERT INTO Question(sentence , idProfessor , idTag , optionA , optionB , optionC , optionD , correct) VALUES (\""+sentence+"\",\""+idProfessor+"\",\""+idTag+"\",\""+opcionA+"\",\""+opcionB+"\",\""+opcionC+"\",\""+opcionD+"\",\""+correct+"\")";
            System.out.println("La Sentencia es : "+query);
            
            DbConnection db = new DbConnection();
            int rs = db.runSqlUpdate(query);
            System.out.println("RESUL SET = "+rs);
            
            if(rs != 0){
            
                resultado = "Registro Completo";
            }
        }
        return resultado;
    }
}