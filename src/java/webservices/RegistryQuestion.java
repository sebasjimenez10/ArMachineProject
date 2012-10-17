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


import armachine.dao.DAOQuestion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryQuestion")
public class RegistryQuestion {

    @GET
    public String Registry(@QueryParam("Sentence") String sentence, @QueryParam("OpcionA") String opcionA, @QueryParam("OpcionB") String opcionB, @QueryParam("OpcionC") String opcionC, @QueryParam("OpcionD") String opcionD, @QueryParam("Correct") String correct, @QueryParam("IdProfessor") String idProfessor, @QueryParam("TagName") String tagName) {
        String rst;
        DAOQuestion DAOq = new DAOQuestion();

        rst = DAOq.registryQuestion(sentence, opcionA, opcionB, opcionC, opcionD, correct, idProfessor, tagName);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
