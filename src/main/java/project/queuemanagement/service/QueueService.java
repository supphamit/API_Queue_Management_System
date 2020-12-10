package project.queuemanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import project.queuemanagement.models.Queue;
import project.queuemanagement.payload.response.MessageResponse;
import project.queuemanagement.repository.QueueRepository;
@Service
public class QueueService {
	@Autowired
	private QueueRepository queueRepository;
	
	
	public  Queue addQueue(Queue queue) {
		int count = 0;
		List<Queue> list = queueRepository.findAll(); 	
		for (Queue i : list) {								// นับqueue_no แล้ว+1 (Hardcode)
			  count = i.getQueue_no();
			
		}
		queue.setQueue_no(count+1);
        return queueRepository.save(queue);
    }
	
	public  List<Queue> findByBusinessName(String business_name) {
        return queueRepository.findQueueByBusinessName(business_name);
    }
	
	public  Integer findCurentQueue(String business_name) {
        return queueRepository.findCurentQueue(business_name);
    }
    
	public  List<Queue> findQueueStatus(Integer id) {
        return queueRepository.findQueueStatus(id);
    }
	
	public  Integer findAllQueueWait(String business_name, String username) {
		List<Queue> list = queueRepository.findWatingQueueByBusiness(business_name);
		int id = queueRepository.findUserQueueDetailByUsername(username).get(0).getId();
		int allQueue = 0;
		for (Queue i : list) {															// นับqueue_no แล้ว+1 (Hardcode)
			if (i.getId() < id){
				  allQueue += 1;
			};
    }
		return allQueue;
	}
	public double waitTime(String business_name, String username) {
		int ppl = 0;																	// people in line
		double ppm = 0.06666;															// people served per minute
		double mow = 0;																	// minutes of waiting
		List<Queue> list = queueRepository.findWatingQueueByBusiness(business_name);
		int id = queueRepository.findUserQueueDetailByUsername(username).get(0).getId();
		System.out.println("business_name");
		System.out.println(business_name);
		System.out.println("id " + id);
		System.out.println(queueRepository.findWatingQueueByBusiness(business_name));
		for (Queue i : list) {															// นับqueue_no แล้ว+1 (Hardcode)
			if (i.getId() < id){
				  ppl += 1;
			};
		}
		mow = ppl/ppm;
		return Math.round(mow);
		
	}
	
	public  Map<String, Object> findQueueStatusDetail(String username, String business_name) {
		Map<String, Object> list = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		list.put("userQueueDetail", queueRepository.findUserQueueDetailByUsername(username));
		list.put("curent_Queue", findCurentQueue(business_name));
		list.put("wait_time", waitTime(business_name, username));
		list.put("allQueueWait", findAllQueueWait(business_name, username));
		result.put("QueueDetail" , list);
        return result;
    }
	
	public  List<Queue> findListQueue(String username) {
        return queueRepository.findUserQueueDetailByUsername(username);
    }
	
	public void cancelQueue(String username, String business_name) {
		queueRepository.cancelQueue(username, business_name);
	}
	
	public void accpetQueue(String username, String business_name) {
		queueRepository.acceptQueue(username, business_name);
	}
}

