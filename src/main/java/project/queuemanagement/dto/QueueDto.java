package project.queuemanagement.dto;

public class QueueDto {
	private Integer id;
	private String username;
	private String user_email;
	private String user_detail;
	private String book_time;
	private String user_telephone;
	private Integer queue_no;
	private String queue_type;
	private Integer business_detail_id;
	private String status;
	private String business_name;
	private Integer wait_left;
	private Double wait_time;
	private Integer current_queue;
	
	public QueueDto(){
		
	}
	
	public QueueDto(Integer id, String username, String user_email, String user_detail, String book_time,
			String user_telephone, Integer queue_no, String queue_type, Integer business_detail_id, String status,
			String business_name, Integer wait_left, Double wait_time, Integer current_queue) {
		super();
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
		this.wait_left = wait_left;
		this.wait_time = wait_time;
		this.current_queue = current_queue;
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

	public Integer getWait_left() {
		return wait_left;
	}

	public void setWait_left(Integer wait_left) {
		this.wait_left = wait_left;
	}

	public Double getWait_time() {
		return wait_time;
	}

	public void setWait_time(Double wait_time) {
		this.wait_time = wait_time;
	}

	public Integer getCurrent_queue() {
		return current_queue;
	}

	public void setCurrent_queue(Integer current_queue) {
		this.current_queue = current_queue;
	}

	@Override
	public String toString() {
		return "QueueDto [id=" + id + ", username=" + username + ", user_email=" + user_email + ", user_detail="
				+ user_detail + ", book_time=" + book_time + ", user_telephone=" + user_telephone + ", queue_no="
				+ queue_no + ", queue_type=" + queue_type + ", business_detail_id=" + business_detail_id + ", status="
				+ status + ", business_name=" + business_name + ", wait_left=" + wait_left + ", wait_time=" + wait_time
				+ ", current_queue=" + current_queue + "]";
	}
	
}
