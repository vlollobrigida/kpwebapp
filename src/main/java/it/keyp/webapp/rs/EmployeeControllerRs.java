package it.keyp.webapp.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.keyp.webapp.domain.KeyEmployee;
import it.keyp.webapp.ejb.KeyEmployeeDAOLocal;
import it.keyp.webapp.interceptors.Logging;

@Path("employees")
@ApplicationScoped
@Logging
public class EmployeeControllerRs {
	@EJB
	KeyEmployeeDAOLocal keyEmployeeDAO;
	
	@GET
	@Produces("application/json")
	public KeyEmployee[] getEmployees() {
		List<KeyEmployee> listKeyEmp = keyEmployeeDAO.getAllEmpoyees();
		return listKeyEmp.toArray(new KeyEmployee[0]);
	}

}
