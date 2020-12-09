package project.queuemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.queuemanagement.models.Business;

@Repository

public interface BusinessRepository extends JpaRepository<Business, Integer>{
	
//	@Query("select Business FROM Business INNER JOIN Queue ON Business.business_name = Queue.business_name WHERE Queue.username = :username")
//	public List<Business> findQueueByUsername(@Param("username") String username);
//	
}