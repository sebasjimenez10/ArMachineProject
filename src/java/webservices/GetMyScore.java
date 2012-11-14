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
import Dao.DAOStudentTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/GetMyScore")
public class GetMyScore {

    @GET
    public String GetMyScore(@QueryParam("idStudent") String idStudent) {
        String rst;
        DAOStudentTest DAOst = new DAOStudentTest();
        rst = DAOst.GetMyScore(idStudent);

        return rst;
    }
}
