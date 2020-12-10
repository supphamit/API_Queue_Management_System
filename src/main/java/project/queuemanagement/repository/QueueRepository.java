package project.queuemanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query("SELECT r FROM Queue r WHERE r.status = 'waiting' AND r.username = :username")
	public List<Queue> findUserQueueDetailByUsername(@Param("username") String username);
	
	@Query("SELECT r FROM Queue r WHERE r.status = 'waiting' AND r.username = ?1 AND r.business_name = ?2" )
	public List<Queue> existsByUsername(String username, String business_name);
	
	@Modifying
	@Transactional
	@Query("UPDATE Queue SET status = 'cancel'  WHERE username = ?1 AND business_name = ?2" )
	public void cancelQueue(@Param("username") String username, @Param("business_name") String business_name);
	
	@Modifying
	@Transactional
	@Query("UPDATE Queue SET status = 'inprocess'  WHERE username = ?1 AND business_name = ?2" )
	public void acceptQueue(@Param("username") String username, @Param("business_name") String business_name);
}
