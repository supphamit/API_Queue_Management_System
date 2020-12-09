package project.queuemanagement.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.queuemanagement.models.Queue;
import project.queuemanagement.payload.response.MessageResponse;
import project.queuemanagement.service.QueueService;

@RestController
@CrossOrigin
@RequestMapping("/api/queue")
public class QueueController {
	@Autowired
	QueueService queueService;
	
	
	@PostMapping(value = "/addQueue")
    public ResponseEntity<?> postQueue(@RequestBody Queue body) {
        queueService.addQueue(body);
        return ResponseEntity.ok(new MessageResponse("successfully"));
    }
	
	@PostMapping(value = "/queueByBusiness")
    public ResponseEntity<?> postQueue(@RequestBody String business_name) {
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
	
	@PostMapping(value = "/queueStatus")
    public ResponseEntity<?> queueSatus(@RequestBody Integer id) {
		List<Queue> result = queueService.findQueueStatus(id);
		System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@GetMapping(value = "/queueStatusDetail")
    public ResponseEntity<?> queueSatusDetail(@RequestParam("business_name") String business_name, @RequestParam("id") Integer id) {
		Map<String, Object> result = queueService.findQueueStatusDetail(business_name, id);
		System.out.println(result);
		
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
