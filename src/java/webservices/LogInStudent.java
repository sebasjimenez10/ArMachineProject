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

import Dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/StudentLogIn")
public class LogInStudent {

    @GET
    public String LogInStudent(@QueryParam("Student") String usr, @QueryParam("Password") String passw) {
        DAOStudent DAOs = new DAOStudent();
        String rst = DAOs.LogInStudent(usr, passw);
        if (rst == null) {
            return "Invalid Student";
        }
        return rst;
    }
}