package project.queuemanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import project.queuemanagement.dto.QueueDto;
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
	
	public  Map<String, Object> findWatingQueueByBusiness(String business_name, String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> list = new HashMap<String, Object>();
		list.put(business_name, findAllQueueWait(business_name, username));
//		list.put("allQueueWait", findAllQueueWait(business_name, username));
		result.put("allQueue" , list);
        return result;
    }
	
	
	public double waitTime(String business_name, String username) {
		int ppl = 0;																	// people in line
		double ppm = 0.06666;															// people served per minute
		double mow = 0;																	// minutes of waiting
		List<Queue> list = queueRepository.findWatingQueueByBusiness(business_name);
		int id = queueRepository.findUserQueueDetailByUsername(username).get(0).getId();
//		System.out.println("business_name");
//		System.out.println(business_name);
//		System.out.println("id " + id);
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
	
	public  Map<String, Object> findListQueue(String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("listQueue", queueRepository.findUserQueueDetailByUsername(username));
		
        return result;
    }
	
	public void cancelQueue(String username, String business_name) {
		queueRepository.cancelQueue(username, business_name);
	}
	
	public void accpetQueue(String username, String business_name) {
		queueRepository.acceptQueue(username, business_name);
	}
	
	public  Map<String, Object> checkQueueWithLoginUsername(String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		ArrayList<QueueDto> list = new ArrayList<QueueDto>();
//		Map<String, Object> list = new HashMap<String, Object>();
		Map<Object, Integer> waitQueueList = new HashMap<Object, Integer>();
		List<Queue> listQueue = queueRepository.findUserQueueDetailByUsername(username);
		
//		QueueDto listQueueDto =  new QueueDto();
//		System.out.println("This is a listQueue" + listQueue);
		for (Queue i : listQueue) {
			QueueDto listQueueDto =  new QueueDto();
			System.out.println(i.getBusiness_name());
			waitQueueList.put(i, findAllQueueWait(i.getBusiness_name(), username));
			listQueueDto.setId(i.getId());
			listQueueDto.setUsername(i.getUsername());
			listQueueDto.setUser_email(i.getUser_email());
			listQueueDto.setUser_detail(i.getUser_detail());
			listQueueDto.setBook_time(i.getBook_time());
			listQueueDto.setUser_telephone(i.getUser_telephone());
			listQueueDto.setQueue_no(i.getQueue_no());
			listQueueDto.setQueue_type(i.getQueue_type());
			listQueueDto.setBusiness_detail_id(i.getBusiness_detail_id());
			listQueueDto.setStatus(i.getStatus());
			listQueueDto.setBusiness_name(i.getBusiness_name());
			listQueueDto.setWait_left(findAllQueueWait(i.getBusiness_name(), username));
			listQueueDto.setWait_time(waitTime(i.getBusiness_name(), username));
			listQueueDto.setCurrent_queue(findCurentQueue(i.getBusiness_name()));
			list.add(listQueueDto);
		}
//		list.put("listQueueDetail", listQueueDto);
		System.out.println("this is a list " + list.toString());
		result.put("listQueue", list);
		
        return result;
    }
	
	public  Map<String, Object> findCurrentQueueDetail(String business_name) {
		Map<String, Object> result = new HashMap<String, Object>();
		Integer currentQueueNo = queueRepository.findCurentQueue(business_name);
		result.put("currentQueueDetail",  queueRepository.findCurentQueueDetailByQueueNo(currentQueueNo));
        return result;
    }
}

