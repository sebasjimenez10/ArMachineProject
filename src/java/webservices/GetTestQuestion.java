/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import Dao.DAOTest;
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
    public String GetTestQuestion(@QueryParam("nameTest")String nameTest){
    
      String rst = null;
      DAOTestQuestion DAOtq = new DAOTestQuestion();
      DAOTest DAOt = new DAOTest();
      String idTest = DAOt.getIdtest(nameTest);
      rst = DAOtq.GetTestQuestion(idTest);
      return rst;
    }
    
}
