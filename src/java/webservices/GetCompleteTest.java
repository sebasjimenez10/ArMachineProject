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
package webservices;

import Dao.DAOStudentTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David
 */
@Stateless
@Path("/GetCompleteTest")

public class GetCompleteTest {
    
    @GET
    public String GetCompleteTest(@QueryParam("idStudent")String idStudent){
    
        String rst = null;
        DAOStudentTest DAOst = new DAOStudentTest();
        rst = DAOst.GetCompleteTest(idStudent);
        return rst;
    }
    
}
