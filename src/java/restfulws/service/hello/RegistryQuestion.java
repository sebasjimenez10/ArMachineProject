/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restfulws.service.hello;

import Dao.DAOProfessor;
import Dao.DAOQuestion;
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
@Path("/RegistryQuestion")
public class RegistryQuestion {

    @GET
    public String Registry(@QueryParam("Sentence") String sentence, @QueryParam("OpcionA") String opcionA , @QueryParam("OpcionB") String opcionB , @QueryParam("OpcionC") String opcionC , @QueryParam("OpcionD") String opcionD , @QueryParam("Correct") String correct , @QueryParam("IdProfessor") String idProfessor , @QueryParam("TagName") String tagName) {
        //invoke el DAO
         String rst;

        DAOQuestion DAOq = new DAOQuestion();

        rst = DAOq.registryQuestion(sentence, opcionA, opcionB, opcionC, opcionD, correct, idProfessor, tagName);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
