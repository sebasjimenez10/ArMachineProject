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
import Dao.DAOTest;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/RegistryStudentTest")
public class RegistryStudentTest {

    @GET
    public String RegistryStudentTest(@QueryParam("idStudent") String idStudent, @QueryParam("idTest") String idTest) {
        String rst;




        DAOStudentTest DAOst = new DAOStudentTest();
        rst = DAOst.RegistryStudentTest(idStudent, idTest);



        return rst;
    }
}