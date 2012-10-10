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

import armachine.dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryStudent")
public class RegistryStudent {

    @GET
    public String Registry(@QueryParam("StudentName") String name, @QueryParam("StudentUser") String user, @QueryParam("StudentLastName") String lastName, @QueryParam("StudentEmail") String email, @QueryParam("StudentPassword") String password, @QueryParam("StudentProfessor") String professor) {
        String rst;

        DAOStudent DAOs = new DAOStudent();

        rst = DAOs.registryStudent(name, user, lastName, email, password,professor);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}