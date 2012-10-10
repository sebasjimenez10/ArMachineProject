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

/**
 *
 * @author David
 */
public class DAOTag {

    public String registryTag(String nombreTag, String professor) {

        String resultado = "El registro no se pudo realizar";
        String idProfessor;

        DAOProfessor DAOp = new DAOProfessor();
        idProfessor = DAOp.searchProfessor(professor);

        if (idProfessor != null) {

            String query = "INSERT INTO Tag(tag,idProfessor) VALUES (\"" + nombreTag + "\",\"" + idProfessor + "\")";
            System.out.println("La Sentencia es : " + query);

            DbConnection db = new DbConnection();
            int rs = db.runSqlUpdate(query);
            System.out.println("RESULT SET = " + rs);

            if (rs != 0) {
                resultado = "Registro Completo";
            }
        }
        return resultado;
    }

    public String getIdTag(String tagName) {

        String resultado = null;
        String query = "SELECT * FROM Tag WHERE tag = '" + tagName + "'";

        try {
            DbConnection db = new DbConnection();
            ResultSet rs = db.runSqlStatement(query);

            if (rs.next()) {
                resultado = rs.getString("idTag");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}