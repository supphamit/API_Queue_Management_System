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
	
	@Query("SELECT MIN(r.queue_no) FROM Queue r WHERE r.status = 'waiting' AND r.business_name = :business_name")
	public Integer findCurentQueue(@Param("business_name") String business_name);	

	@Query("SELECT r FROM Queue r WHERE r.id = :id")
	public List<Queue> findQueueStatus(@Param("id") Integer id);
	
	@Query("SELECT r FROM Queue r WHERE r.status = 'waiting' AND r.business_name = :business_name")
	public List<Queue> findWatingQueueByBusiness(@Param("business_name") String business_name);	
}
