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

import Dao.DAOProfessor;
import Dao.DAOQuestion;
import Dao.DAOTag;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/GetProfessor")
public class GetProfessor {

    @GET
    public String Registry() {
        String rst;

        DAOProfessor DAOp = new DAOProfessor();

        rst = DAOp.getProfessors();
        System.out.println("RESULTADO REGISTRY = " + rst);

        return rst;
    }
}
