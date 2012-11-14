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
import Dao.DAOStudentAnswer;
import Dao.DAOStudentTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/DoTest")
public class DoTest {

    @GET
    public String DoTest(@QueryParam("datos") String js) {
        String rst;
        DAOStudentAnswer DAOsa = new DAOStudentAnswer();
        rst = DAOsa.DoTest(js); 

        return rst;
    }
}
