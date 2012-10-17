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
    
    public String getQuestion(String idProfessor) {
    
        String resultado = null;
        String query = "SELECT sentence FROM Question WHERE idProfessor = \""+idProfessor+"\"";
       
        DbConnection db = new DbConnection();
        ResultSet rs = db.runSqlStatement(query);

        try {
            if (rs.next()) {
                resultado = rs.getString("sentence");
              
                while(rs.next()) {
                  
                    resultado = resultado + ","+rs.getString("sentence");
                    
                    
                }
                System.out.println("El resultado fue : "+ resultado);
            }


        } catch (SQLException ex) {
            Logger.getLogger(DAOTag.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return resultado;
    
    }
}