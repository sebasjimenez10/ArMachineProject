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

import Dao.DAOTestQuestion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryTestQuestion")
public class RegistryTestQuestion {

    @GET
    public String Registry(@QueryParam("questionSentence") String sentence, @QueryParam("testName") String testName) {
        
        String rst;
        DAOTestQuestion DAOtq = new DAOTestQuestion();
        rst = DAOtq.registryTestQuestion(testName, sentence);
        System.out.println("Resultado = " + rst);

        return rst;
    }
}
