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

import Dao.DAOTag;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryTag")
public class RegistryTag {

    @GET
    public String Registry(@QueryParam("tagName") String tagName, @QueryParam("professorName") String professorName) {
        String rst;

        DAOTag DAOt = new DAOTag();

        rst = DAOt.registryTag(tagName, professorName);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
