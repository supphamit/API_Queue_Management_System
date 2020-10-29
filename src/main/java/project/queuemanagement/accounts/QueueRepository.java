package project.queuemanagement.accounts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface QueueRepository extends JpaRepository<Queue, Integer>{

	@Query("SELECT r FROM Queue r WHERE r.id = :id")
	public Queue findOne(@Param("id") int id);
	
	@Query("SELECT r FROM Queue r WHERE r.id = :id")
	public List<Queue> findDetail(@Param("id") int id);
	
	@Query("SELECT r fROM Queue r WHERE r.activeFlag = :activeFlag")
	public List<Queue> findQueue(@Param("activeFlag") Boolean activeFlag);
	
	@Query("SELECT id fROM Queue r WHERE r.name = :name")
	public String findIdByName(@Param("name") String name);
}