package project.queuemanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="queues")
public class Queue {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "user_email")
	private String user_email;
	
	@Column(name = "user_detail")
	private String user_detail;
	
	@Column(name = "book_time")
	private String book_time;
	
	@Column(name = "user_telephone")
	private String user_telephone;
	
	@Column(name = "queue_no")
	private Integer queue_no;
	
	@Column(name = "queue_type")
	private String queue_type;
	
	@Column(name = "business_detail_id")
	private Integer business_detail_id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "business_name")
	private String business_name;
	
	public Queue() {
		
	}
	
	public Queue(Integer id, String username, String user_email, String user_detail, String book_time, String user_telephone
			, Integer queue_no, String queue_type, int business_detail_id, String status, String business_name) {
		this.id = id;
		this.username = username;
		this.user_email = user_email;
		this.user_detail = user_detail;
		this.book_time = book_time;
		this.user_telephone = user_telephone;
		this.queue_no = queue_no;
		this.queue_type = queue_type;
		this.business_detail_id = business_detail_id;
		this.status = status;
		this.business_name = business_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_detail() {
		return user_detail;
	}

	public void setUser_detail(String user_detail) {
		this.user_detail = user_detail;
	}

	public String getBook_time() {
		return book_time;
	}

	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}

	public String getUser_telephone() {
		return user_telephone;
	}

	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}

	public Integer getQueue_no() {
		return queue_no;
	}

	public void setQueue_no(Integer queue_no) {
		this.queue_no = queue_no;
	}

	public String getQueue_type() {
		return queue_type;
	}

	public void setQueue_type(String queue_type) {
		this.queue_type = queue_type;
	}

	public Integer getBusiness_detail_id() {
		return business_detail_id;
	}

	public void setBusiness_detail_id(Integer business_detail_id) {
		this.business_detail_id = business_detail_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	@Override
	public String toString() {
		return "Queue [id=" + id + ", username=" + username + ", user_email=" + user_email + ", user_detail="
				+ user_detail + ", book_time=" + book_time + ", user_telephone=" + user_telephone + ", queue_no="
				+ queue_no + ", queue_type=" + queue_type + ", business_detail_id=" + business_detail_id + ", status="
				+ status + ", business_name=" + business_name + "]";
	}

	

}
