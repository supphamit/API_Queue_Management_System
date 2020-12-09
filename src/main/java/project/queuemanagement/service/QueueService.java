package project.queuemanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.queuemanagement.models.Queue;
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
	
	public double waitTime(String business_name, Integer id) {
		int ppl = 0;																	// people in line
		double ppm = 0.06666;															// people served per minute
		double mow = 0;																	// minutes of waiting
		List<Queue> list = queueRepository.findWatingQueueByBusiness(business_name);
		System.out.println("business_name");
		System.out.println(business_name);
		System.out.println("id");
		System.out.println(id);
		System.out.println(queueRepository.findWatingQueueByBusiness(business_name));
		for (Queue i : list) {															// นับqueue_no แล้ว+1 (Hardcode)
			if (i.getId() < id){
				  ppl += 1;
			};
		}
		mow = ppl/ppm;
		return mow;
		
	}
	
	public  Map<String, Object> findQueueStatusDetail(String business_name, Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("curent_Queue", findCurentQueue(business_name));
		result.put("wait_time", waitTime(business_name, id));
        return result;
    }
}

