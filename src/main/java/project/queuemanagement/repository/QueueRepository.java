package project.queuemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.queuemanagement.models.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Integer>{
	
	@Query("SELECT r FROM Queue r WHERE r.business_name = :business_name")
	public List<Queue> findQueueByBusinessName(@Param("business_name") String business_name);
	

}
