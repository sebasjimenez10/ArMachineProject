/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import connection.DbConnection;

/**
 *
 * @author David
 */
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
