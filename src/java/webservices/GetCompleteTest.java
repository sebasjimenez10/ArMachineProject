/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
