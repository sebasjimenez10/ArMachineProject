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
@Path("/DeleteAssignTest")
public class DeleteAssignTest {

    @GET
    public String DeleteAssignTest(@QueryParam("idStudent") String idStudent, @QueryParam("idTest") String idTest) {

        String rst = null;
        DAOStudentTest DAOst = new DAOStudentTest();
        rst = DAOst.DeleteAssignTest(idStudent, idTest);

        return rst;
    }
}
