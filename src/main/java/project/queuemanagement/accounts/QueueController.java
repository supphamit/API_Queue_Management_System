package project.queuemanagement.accounts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.queuemanagement.accounts.AccountService;

@RestController

public class QueueController {
	
	@Autowired
	QueueService queueService;
	
	
	@PostMapping(value = "/queue")
	 public ResponseEntity<String> listAllMasterCampaign(@RequestBody String acc) {
	  System.out.println(acc);
	  System.out.println("eiei");
	  return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@PostMapping(value = "/addqueue")
    public ResponseEntity<?> postQueue(@RequestBody Queue body) {
        queueService.addQueue(body);
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
	
    @GetMapping(value = "/getqueue")
    public List<Queue> getQueues() {
        return queueService.viewQueues();
    }
    
    @GetMapping(value = "/count") // ดูคิวที่เท่าไร
    public int getNum() {
        return queueService.countQueues();
    }
    @PostMapping(value = "/view")          // เหลืออีกกี่คิว
    public int viewQueue(@RequestBody String name) {
    	System.out.print(name);
        return queueService.noQueue(name);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putQueue( int id,  @RequestBody Queue body) {
        Optional<Queue> queue = queueService.updateQueue(id, body);
        if(!queue.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    
    @PostMapping(value = "/check") // เข้าดูคิวของuser
    public Boolean checkName(@RequestBody String name) {
    	return queueService.checkName(name);
    }
    
    @PostMapping(value = "/accept") // กดรับคิว
    public String acceptQueue(@RequestBody int id) throws Exception {
		return queueService.acceptQueue(id);
    	
    }
    
    @PostMapping(value = "/denine") // ยกเลิกคิว
    public String denineQueue(@RequestBody int id) throws Exception {
		return queueService.denineQueue(id);
    	
    }
    
    @PostMapping(value = "/detailById")
	public List<Queue> detailById(int id){
    	
		return queueService.viewById(id);
    	
    }
    
    @GetMapping(value = "/getByFlag")
    public List<Queue> getByFlag(@RequestBody Boolean activeFlag) throws Exception{
    	
		return queueService.getByFlag(activeFlag);
    	
    }
    
    @PostMapping(value = "/QueueByName")
	public List<Queue> findIdByname(@RequestBody String name){
    	System.out.print(name);
		return queueService.checkNoQueueByName(name);
    	
    }
    }

