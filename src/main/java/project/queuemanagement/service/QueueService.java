package project.queuemanagement.service;

import java.util.List;

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
}

