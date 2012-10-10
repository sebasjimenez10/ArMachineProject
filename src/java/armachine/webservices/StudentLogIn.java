/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package armachine.webservices;

import armachine.dao.DAOStudent;
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
public class StudentLogIn {

    @GET
    public String StudentLogIn(@QueryParam("Student") String usr, @QueryParam("Password") String passw) {
        DAOStudent DAOStudent = new DAOStudent();
        String rst = DAOStudent.LogInStudent(usr, passw);
        if (rst == null) {
            return "Invalid Student";
        }
        return rst;
    }
}