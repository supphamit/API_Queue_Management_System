package project.queuemanagement.accounts;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class QueueService {
	@Autowired
	private QueueRepository queueRepository;
	
	public List<Queue> getAllAccount() {
		// TODO Auto-generated method stub
		return queueRepository.findAll();
	}
	
	public Queue addQueue(Queue queue) {
        return queueRepository.save(queue);
    }
	
	public List<Queue> viewQueues() {
        return (List<Queue>) queueRepository.findAll();
    }
	
	public List<Queue> viewById(int id){
		List<Queue> detail = queueRepository.findDetail(id);
		return detail;
		
	}
	
	public Optional<Queue> updateQueue(int id, Queue queue) {
        Optional<Queue> customerOptional = queueRepository.findById(id);
        if(!customerOptional.isPresent()) {
            return customerOptional;
        }
        queue.setId(id);
        return Optional.of(queueRepository.save(queue));
    }
	
	public int countQueues() {
		int count = 0;
		List<Queue> list = queueRepository.findAll();
		for (Queue i : list) {
			if (i.getTelephone() == 0) {
			  count += 1;
			}
		}
		return count;
		
	}
	
	public int noQueue(String name) {
		int notest = 0;
		int count = 0;
		// String nameCheck;
		List<Queue> list = queueRepository.findAll();
		for (Queue i : list) {
			if (i.getName().equals(name)) {
				// nameCheck = name;
				count = i.getId();
			}
		}
		for (Queue j : list) {
			if (j.getId() < count && j.getActiveFlag().equals(true)) {
				notest += 1;
			}

		}
		
	
		
		return notest;
		
	}
	
	public Boolean checkName(String name) {
		List<Queue> list = queueRepository.findAll();
		for (Queue i : list) {
			System.out.print("getname = ");
			System.out.println(i.getName());
			System.out.print("name = ");
			System.out.println(name);
			if(i.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public String acceptQueue(int id) throws Exception {
		String result;
		Queue detail = queueRepository.findOne(id);
//		System.out.println(data.getName);
			
		try {
			detail.setActiveFlag(true);
			queueRepository.save(detail);
			
			result = "Success!";
		} catch (Exception e) {
			
			e.printStackTrace();
			result = "Fail!";
		}
		
		return result;
	}
	
	public String denineQueue(int id) throws Exception {
		String result;
		Queue detail = queueRepository.findOne(id);
//		System.out.println(data.getName);
			
		try {
			detail.setActiveFlag(false);
			queueRepository.save(detail);
			
			result = "Success!";
		} catch (Exception e) {
			
			e.printStackTrace();
			result = "Fail!";
		}
		
		return result;
	}
	
	public List<Queue> getByFlag(Boolean activeFlag) {
		// TODO Auto-generated method stub
		return queueRepository.findQueue(activeFlag);
	}
	
	
	public List<Queue> checkNoQueueByName(String name) {
		return queueRepository.findIdByName(name);
		
	}
}
