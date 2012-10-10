/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Dao.DAOProfessor;
import Dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David
 */
@Stateless
@Path("/RegistryStudent")
public class RegistryStudent {

    @GET
    public String Registry(@QueryParam("StudentName") String name, @QueryParam("StudentUser") String user, @QueryParam("StudentLastName") String lastName, @QueryParam("StudentEmail") String email, @QueryParam("StudentPassword") String password, @QueryParam("StudentProfessor") String professor) {
        //invoke el DAO
        String rst;

        DAOStudent DAOs = new DAOStudent();

        rst = DAOs.registryStudent(name, user, lastName, email, password,professor);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
