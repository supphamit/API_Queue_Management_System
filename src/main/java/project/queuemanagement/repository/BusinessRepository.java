package project.queuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.queuemanagement.models.Business;
@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer>{

}
