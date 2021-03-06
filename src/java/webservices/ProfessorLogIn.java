/*
 * Universidad EAFIT
 * Ing. de Sistemas
 * 
 * Proyecto Integrador 2
 * 
 * Name: Ar-Machine Project
 */
package webservices;

import Dao.DAOProfessor;
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
@Path("/ProfessorLogIn")
public class ProfessorLogIn {

    @GET
    public String ProfessorLogIn(@QueryParam("Professor") String usr, @QueryParam("Password") String passw) {
        DAOProfessor DAOProfessor = new DAOProfessor();
        String rst = DAOProfessor.LogInProfessor(usr, passw);
        if (rst == null) {
            return "Invalid Professor";
        }
        return rst;
    }
}