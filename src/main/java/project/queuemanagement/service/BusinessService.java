package project.queuemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.queuemanagement.models.Business;
import project.queuemanagement.repository.BusinessRepository;

@Service
public class BusinessService {
	@Autowired
	private BusinessRepository businessRepository;
	
	
	public  Business addBusiness(Business business) {
        return businessRepository.save(business);
    }
	
//	public  List<Business> findQueueByUsername(String username) {
//        return businessRepository.findQueueByUsername(username);
//    }
}
