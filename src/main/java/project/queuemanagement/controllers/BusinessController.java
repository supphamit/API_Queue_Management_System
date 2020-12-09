package project.queuemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.queuemanagement.models.Business;
import project.queuemanagement.models.Queue;
import project.queuemanagement.service.BusinessService;


@RestController
@CrossOrigin
@RequestMapping("/api/business")
public class BusinessController {
	
	@Autowired
	BusinessService businessService;
	@PostMapping(value = "/addBusiness")
    public ResponseEntity<?> postBusiness(@RequestBody Business body) {
        businessService.addBusiness(body);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
	
	
//	@PostMapping(value = "/QueueByBusiness")
//    public ResponseEntity<?> postQueue(@RequestBody String username) {
//		List<Business> result = businessService.findQueueByUsername(username);
//		System.out.println(username);
//		System.out.println(result);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

}
