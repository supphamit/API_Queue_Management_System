//package project.queuemanagement.accounts;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="queues")
//public class Queue {
//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "sortNo")
//	private int sortNo;
//	
//	@Column(name = "name")
//	private String name;
//	
//	@Column(name = "surname")
//	private String surname;
//	
//	@Column(name = "email")
//	private String email;
//	
//	@Column(name = "telephone")
//	private int telephone;
//	
//	@Column(name = "activeFlag")
//	private Boolean activeFlag;
//	
//	public Queue() {
//		
//	}
//	
//	public Queue(int id, int sortNo, String name, String surname, String email, int telephone, Boolean activeFlag) {
//		this.id = id;
//		this.sortNo = sortNo;
//		this.name = name;
//		this.surname = surname;
//		this.email = email;
//		this.telephone = telephone;
//		this.activeFlag = activeFlag;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getSortNo() {
//		return sortNo;
//	}
//
//	public void setSortNo(int sortNo) {
//		this.sortNo = sortNo;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getSurname() {
//		return surname;
//	}
//
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public int getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(int telephone) {
//		this.telephone = telephone;
//	}
//
//	public Boolean getActiveFlag() {
//		return activeFlag;
//	}
//
//	public void setActiveFlag(Boolean activeFlag) {
//		this.activeFlag = activeFlag;
//	}
//
//	
//}