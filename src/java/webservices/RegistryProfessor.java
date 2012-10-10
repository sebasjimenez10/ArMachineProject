/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Dao.DAOProfessor;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Menes
 */
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
