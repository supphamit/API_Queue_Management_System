package project.queuemanagement.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.queuemanagement.models.Queue;
import project.queuemanagement.payload.response.MessageResponse;
import project.queuemanagement.repository.QueueRepository;
import project.queuemanagement.service.QueueService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/queue")
public class QueueController {
	@Autowired
	QueueService queueService;
	
	@Autowired
	private QueueRepository queueRepository;
	
	//done
	@PostMapping(value = "/addQueue")
    public ResponseEntity<?> postQueue(@RequestBody Queue body) {
		System.out.println(body.toString());
		System.out.println(queueRepository.existsByUsername(body.getUsername(), body.getBusiness_name()).size());
		if (queueRepository.existsByUsername(body.getUsername(), body.getBusiness_name()).size() > 0) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("ชื่อผู้ใช้งานซ้ำ กรุณาเปลี่ยนชื่อผู้ใช้และทำการต่อคิวใหม่อีกครั้ง "));
		}
        queueService.addQueue(body);
        return ResponseEntity.ok(new MessageResponse("ต่อคิวสำเร็จ"));
    }
	
	//done
	@GetMapping(value = "/queueByBusiness")
    public ResponseEntity<?> postQueue(@RequestParam("business_name") String business_name) {
		List<Queue> result = queueService.findByBusinessName(business_name);
		System.out.println(business_name);
		System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
//	@PostMapping(value = "/getCurentQueue")
//	public ResponseEntity<?> getCurentQueue(@RequestBody String business_name) {
//		Integer result = queueService.findCurentQueue(business_name);
//		System.out.println(result);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//}
	
	//ใช้ทำไรวะะะะะะะะะะะะ ??
	@PostMapping(value = "/queueStatus")
    public ResponseEntity<?> queueSatus(@RequestBody Integer id) {
		List<Queue> result = queueService.findQueueStatus(id);
		System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	//done
	@GetMapping(value = "/queueStatusDetail")
    public ResponseEntity<Map<String, Object>> queueSatusDetail(@RequestParam("business_name") String business_name, @RequestParam("username") String username) {
		Map<String, Object> result = queueService.findQueueStatusDetail(username, business_name);
		System.out.println("/queueStatusDetail" + result);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
	
	//done
	@GetMapping(value = "/listQueue")
    public ResponseEntity<?> queueSatus(@RequestParam("username") String username) {
		System.out.println(username);
		Map<String, Object> result = queueService.findListQueue(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	//done
	@GetMapping(value = "/findWatingQueueByBusiness")
    public ResponseEntity<?> findWatingQueueByBusiness(@RequestParam("business_name") String business_name, @RequestParam("username") String username) {
		System.out.println(business_name);
		Map<String, Object> result = queueService.findWatingQueueByBusiness(business_name, username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
//	@GetMapping(value = "/cancelQueue")
//    public ResponseEntity<?> cancelQueue(@RequestParam("username") String username, @RequestParam("business_name") String business_name) {
//		queueService.cancelQueue(username, business_name);
//		System.out.println(username);
//		System.out.println(business_name);
//		return ResponseEntity.ok(new MessageResponse("ยกเลิกคิวสำเร็จ"));
//    }
	
	//done ---------------------------------------------------------------------------- แก้อัพเดตตามนี้
	@PatchMapping(value = "/cancelQueue/{username}")
	public ResponseEntity<?> cancelQueueByUser(@PathVariable(value = "username") String username, @Valid @RequestBody Queue body){
		queueService.cancelQueue(username, body.getBusiness_name());
		System.out.println(username);
		System.out.println(body.getBusiness_name());
		return ResponseEntity.ok(new MessageResponse("ยกเลิกคิวสำเร็จ"));
	}
	
	//--------------------------- แก้ตาม ^^^^^^^^^^^^^^^^^^^^^^^^^^^
	@GetMapping(value = "/acceptQueue")
    public ResponseEntity<?> acceptQueue(@RequestParam("username") String username, @RequestParam("business_name") String business_name) {
		queueService.accpetQueue(username, business_name);
		System.out.println(username);
		System.out.println(business_name);
		return ResponseEntity.ok(new MessageResponse("เรียกคิวสำเร็จ"));
    }
	
	//done มั้ง
	@GetMapping(value = "/checkQueueWithLoginUsername")
	public ResponseEntity<?> checkQueueWithLoginUsername(@RequestParam("username") String username){
		Map<String, Object> result = queueService.checkQueueWithLoginUsername(username);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//done มั้ง
	@GetMapping(value = "/findCurrentQueueDetail")
	public ResponseEntity<?> findCurrentQueueDetail(@RequestParam("business_name") String business_name){
		Map<String, Object> result = queueService.findCurrentQueueDetail(business_name);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
