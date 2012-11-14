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

import Dao.DAOStudent;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/GetStudent")
public class GetStudent{

    @GET
    public String Registry(@QueryParam("idProfessor") String idProfessor) {
        String rst;

        DAOStudent DAOs = new DAOStudent();
        rst = DAOs.getStudents(idProfessor);
        return rst;
    }
}
