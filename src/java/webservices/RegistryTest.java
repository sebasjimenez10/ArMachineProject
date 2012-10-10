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

import Dao.DAOTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryTest")
public class RegistryTest {

    @GET
    public String Registry(@QueryParam("IdProfessor") String idProfessor, @QueryParam("TestName") String testName, @QueryParam("TestDescription") String testDescription, @QueryParam("TestDate") String testDate) {
        String rst;
        DAOTest DAOt = new DAOTest();
        rst = DAOt.registryTest(idProfessor, testName, testDescription, testDate);
        System.out.println("Resultado = " + rst);

        return rst;
    }
}
