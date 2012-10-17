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

public class DAOTest {

    public String registryTest(String idProfessor, String testName, String testDescription, String testDate) {

        String resultado = "El Registro no se pudo realizar";
        String query = "INSERT INTO Test(idProfessor, nameTest,descriptionTest,dateTest) VALUES (\"" + idProfessor + "\",\"" + testName + "\",\"" + testDescription + "\",\"" + testDate + "\")";
        System.out.println("La Sentencia es : " + query);

        DbConnection db = new DbConnection();
        int rs = db.runSqlUpdate(query);

        if (rs != 0) {
            resultado = "Registro de Test Completo";
        }
        return resultado;
    }
    
    public String getTestNames(String idProfessor){
        
        String resultado = null;
        String query = "SELECT nameTest FROM Test WHERE idProfessor = \""+idProfessor+"\"";
       
        DbConnection db = new DbConnection();
        ResultSet rs = db.runSqlStatement(query);

        try {
            if (rs.next()) {
                resultado = rs.getString("nameTest");
              
                while(rs.next()) {
                  
                    resultado = resultado + ","+rs.getString("nameTest");
                    
                    
                }
                System.out.println("El resultado fue : "+ resultado);
            }


        } catch (SQLException ex) {
            Logger.getLogger(DAOTag.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return resultado;
    }    
}