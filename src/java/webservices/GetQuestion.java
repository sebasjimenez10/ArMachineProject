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

import Dao.DAOQuestion;
import Dao.DAOTag;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/GetQuestion")
public class GetQuestion {

    @GET
    public String Registry(@QueryParam("idProfessor") String idProfessor) {
        String rst;

        DAOQuestion DAOt = new DAOQuestion();

        rst = DAOt.getQuestion(idProfessor);
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
