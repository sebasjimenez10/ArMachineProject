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

import Dao.DAOProfessor;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/ProfessorLogIn")
public class LogInProfessor {

    @GET
    public String testDb(@QueryParam("Professor") String usr, @QueryParam("Password") String passw) {
        DAOProfessor DAOp = new DAOProfessor();
        String rst = DAOp.LogInProfessor(usr, passw);
        if (rst == null) {
            return "Invalid Professor";
        }
        return rst;
    }
}