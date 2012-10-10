/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restfulws.service.hello;

import Dao.DAOProfessor;
import Dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Menes
 */
@Stateless
@Path("/ProfessorLogIn")
public class LogInProfessor {

    @GET
    public String testDb(@QueryParam("Professor") String usr, @QueryParam("Password") String passw) {
        //invoke el DAO
        DAOProfessor DAOp = new DAOProfessor();

        String rst = DAOp.LogInProfessor(usr, passw);
        if (rst == null) {
            return "Invalid Professor";
        }
        return rst;
    }
    
   
}
