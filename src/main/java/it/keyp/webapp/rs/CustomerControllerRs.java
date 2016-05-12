/**
 * 
 */
package it.keyp.webapp.rs;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import it.keyp.webapp.domain.KeyCustomer;
import it.keyp.webapp.ejb.KeyCustomerDAOLocal;
import it.keyp.webapp.ejb.KeyEmployeeDAOLocal;
import it.keyp.webapp.interceptors.Logging;

@Path("customers")
@ApplicationScoped
@Logging
public class CustomerControllerRs {


	@EJB
	KeyCustomerDAOLocal keyCustomerDAO;
	@EJB
	KeyEmployeeDAOLocal keyEmployeeDAO;

	@GET
	@Produces("application/json")
	public KeyCustomer[] getCustomers() {
		List<KeyCustomer> listKeyCust = keyCustomerDAO.getAllCustomers();
		return listKeyCust.toArray(new KeyCustomer[0]);
	}

	@GET
	@Path("add/{name}/{city}")
	@Produces("application/json")
	public KeyCustomer insert(@PathParam("name") String name,
			@PathParam("city") String city){
		KeyCustomer keyCustomer = new KeyCustomer();
		keyCustomer.setCity(city);
		keyCustomer.setName(name);
		keyCustomer.setInsertionDate(new Date());
		return keyCustomerDAO.addCustomers(keyCustomer);
	}

}
