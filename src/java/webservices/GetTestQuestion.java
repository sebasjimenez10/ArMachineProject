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

/**
 *
 * @author David
 */
@Stateless
@Path("/GetTestQuestion")
public class GetTestQuestion {
    
    @GET
    public String GetTestQuestion(@QueryParam("idTest")String idTest){
    
      String rst = null;
      DAOTestQuestion DAOtq = new DAOTestQuestion();
      rst = DAOtq.GetTestQuestion(idTest);
      return rst;
    }
    
}
