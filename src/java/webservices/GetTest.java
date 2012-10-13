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
import Dao.DAOTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/GetTest")
public class GetTest {

    @GET
    public String Registry(@QueryParam("idProfessor") String idProfessor) {
        String rst;

        DAOTest DAOt = new DAOTest();

        rst = DAOt.getTestNames(idProfessor);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
