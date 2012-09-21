/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package webservices;

import dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Erika Gomez
 * @author Sebastian Jimenez
 * @author David Sttivend
 * @author Ernesto Quintero
 */
@Stateless
@Path("/StudentLogIn")
public class LogInStudent {

    @GET
    public String LogInStudent(@QueryParam("Student") String usr, @QueryParam("Password") String passw) {
        DAOStudent DAOp = new DAOStudent();
        String rst = DAOp.LogInStudent(usr, passw);
        if (rst == null) {
            return "Invalid Student";
        }
        return rst;
    }
}