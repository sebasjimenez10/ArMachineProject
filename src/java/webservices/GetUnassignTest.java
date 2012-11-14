/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Dao.DAOStudent;
import Dao.DAOStudentTest;
import Dao.DAOTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David
 */
@Stateless
@Path("/GetUnassignTest")
public class GetUnassignTest {
    
     @GET
    public String GetUnassignTest(@QueryParam("idStudent") String idStudent) {
        String rst = null;

        DAOStudent DAOs = new DAOStudent();
        String idProfessor = DAOs.GetIdProfessor(idStudent);
        DAOStudentTest DAOst = new DAOStudentTest();
        rst = DAOst.GetUnassignTest(idStudent, idProfessor);
        
        
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
    
}
