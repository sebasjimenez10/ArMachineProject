/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Dao.DAOTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David
 */
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
