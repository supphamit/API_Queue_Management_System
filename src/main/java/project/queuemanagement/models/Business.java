package project.queuemanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="business")
public class Business {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "telephone")
	private int telephone;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "address")
	private String address;

	@Column(name = "open_time")
	private String open_time;
	
	@Column(name = "distance")
	private String distance;
	
	@Column(name = "advance")
	private String advance;

	
	public Business() {
		
	}
	
	public Business(int id, String name, String branch, String description, 
			int telephone, String contact, String address, String open_time, String distance, 
			String advance) {
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.description = description;
		this.telephone = telephone;
		this.contact = contact;
		this.address = address;
		this.open_time = open_time;
		this.distance = distance;
		this.advance = advance;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getAdvance() {
		return advance;
	}

	public void setAdvance(String advance) {
		this.advance = advance;
	}
	
}
