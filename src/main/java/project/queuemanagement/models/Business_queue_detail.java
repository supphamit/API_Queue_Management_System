package project.queuemanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="business_queue")
public class Business_queue_detail {
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Column(name = "business_id")
		private int business_id;
		
		@Column(name = "username")
		private String username;
		
		@Column(name = "user_detail")
		private String user_detail;
		
		@Column(name = "user_telephone")
		private int user_telephone;
		
		@Column(name = "user_email")
		private String user_email;
		
		@Column(name = "book_time")
		private String book_time;
		

		
		public Business_queue_detail() {
			
		}
		
		public Business_queue_detail(int id, int business_id, String username, String user_detail, 
				int user_telephone, String user_email, String book_time
				) {
			this.id = id;
			this.business_id = business_id;
			this.username = username;
			this.user_detail = user_detail;
			this.user_telephone = user_telephone;
			this.user_email = user_email;
			this.book_time = book_time;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getBusiness_id() {
			return business_id;
		}

		public void setBusiness_id(int business_id) {
			this.business_id = business_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUser_detail() {
			return user_detail;
		}

		public void setUser_detail(String user_detail) {
			this.user_detail = user_detail;
		}

		public int getUser_telephone() {
			return user_telephone;
		}

		public void setUser_telephone(int user_telephone) {
			this.user_telephone = user_telephone;
		}

		public String getUser_email() {
			return user_email;
		}

		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}

		public String getBook_time() {
			return book_time;
		}

		public void setBook_time(String book_time) {
			this.book_time = book_time;
		}
		
}
	
