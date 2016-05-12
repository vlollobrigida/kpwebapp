/**
 * 
 */
package it.keyp.webapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({ @NamedQuery(name = "KeyCustomer.findAll", query = "SELECT e FROM KeyCustomer e"), })
public class KeyCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String city;

	@Temporal(TemporalType.DATE)
	private Date insertionDate;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="EMPLOYEES_CUSTOMERS", joinColumns=@JoinColumn(name="CUSTOMERS_ID"),
	inverseJoinColumns=@JoinColumn(name="EMPLOYEES_ID"))
	private List<KeyEmployee> kpEmployees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public List<KeyEmployee> getKpEmployees() {
		return kpEmployees;
	}

	public void setKpEmployees(List<KeyEmployee> kpEmployees) {
		this.kpEmployees = kpEmployees;
	}

}
