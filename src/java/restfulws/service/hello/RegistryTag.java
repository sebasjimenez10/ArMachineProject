/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restfulws.service.hello;

import Dao.DAOProfessor;
import Dao.DAOStudent;
import Dao.DAOTag;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David
 */
@Stateless
@Path("/RegistryTag")
public class RegistryTag {

    @GET
    public String Registry(@QueryParam("TagName") String tagName, @QueryParam("ProfessorName") String professorName) {
        //invoke el DAO
         String rst;

        DAOTag DAOt = new DAOTag();

        rst = DAOt.registryTag(tagName,professorName);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
