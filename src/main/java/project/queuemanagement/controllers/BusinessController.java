//package project.queuemanagement.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import project.queuemanagement.models.Business;
//import service.BusinessService;
//
//@RestController
//public class BusinessController {
//	
//	@Autowired
//	BusinessService businessService;
//	@PostMapping(value = "/addBusiness")
//    public ResponseEntity<?> postBusiness(@RequestBody Business body) {
//        businessService.addBusiness(body);
//        return new ResponseEntity<>("OK", HttpStatus.OK);
//    }
//}
