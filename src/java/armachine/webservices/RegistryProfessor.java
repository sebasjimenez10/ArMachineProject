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
package armachine.webservices;


import armachine.dao.DAOProfessor;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryProfessor")
public class RegistryProfessor {

    @GET
    public String Registry(@QueryParam("ProfessorName") String name, @QueryParam("ProfessorUser") String user, @QueryParam("ProfessorLastName") String lastName, @QueryParam("ProfessorEmail") String email, @QueryParam("ProfessorPassword") String password) {
        DAOProfessor DAOp = new DAOProfessor();

        String rst = DAOp.registryProfessor(name, user, lastName, email, password);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
