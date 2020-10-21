package project.queuemanagement.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	
//	@GetMapping(value = "/account")
//	public List<Account> getAccount(@RequestBody String loginForm){
//		System.out.println(loginForm.toString());
//		System.out.println(accountService.getAllAccount());
//		return  accountService.getAllAccount();
//	}
	
	@PostMapping(value = "/account")
	 public ResponseEntity<String> listAllMasterCampaign(@RequestBody String acc) {
	  System.out.println(acc);
	  System.out.println("eiei");
	  return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	

}
