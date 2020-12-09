package project.queuemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.queuemanagement.models.Queue;
import project.queuemanagement.service.QueueService;

@RestController
@RequestMapping("/api/queue")
public class QueueController {
	@Autowired
	QueueService queueService;
	
	
	@PostMapping(value = "/addQueue")
    public ResponseEntity<?> postQueue(@RequestBody Queue body) {
        queueService.addQueue(body);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
	
	@PostMapping(value = "/QueueByBusiness")
    public ResponseEntity<?> postQueue(@RequestBody String business_name) {
		List<Queue> result = queueService.findByBusinessName(business_name);
		System.out.println(business_name);
		System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
