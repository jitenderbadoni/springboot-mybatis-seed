package com.rest.project;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.RequestUser;
import com.rest.model.ResponseDTO;
import com.rest.model.User;
import com.rest.service.UserService;
import com.rest.project.ApplicationConstants;

@RestController
@RequestMapping("/")
@Api(value="onlinestore", description="Welcome controller")
public class WelcomeController {
	@Autowired
	public EmailServiceImpl emailService;
	
	@RequestMapping(value="/allUsers", method=RequestMethod.GET)
	public ResponseDTO getAllUsers() {
		ResponseDTO response = new ResponseDTO();
		UserService userService = new UserService();
		response.setReturn_object(userService.getAllUsers());
		response.setStatus(ApplicationConstants.TRUE);
		response.setMessage("");
		return response;
	}
	
	@RequestMapping(value="/getUserById", method=RequestMethod.POST)
	public ResponseDTO getUserById(@RequestParam int id){
		ResponseDTO response = new ResponseDTO();
		UserService userService = new UserService();
		response.setReturn_object(userService.getUserById(id));
		response.setStatus(ApplicationConstants.TRUE);
		response.setMessage("");
		return response;
	}
	@RequestMapping(value="/insertUser",
					method=RequestMethod.POST,
					consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE 
			)
	public ResponseDTO addUser(RequestUser user){
		ResponseDTO response = new ResponseDTO();
		User addUser = new User();
		addUser.setName(user.getName());
		addUser.setAge(user.getAge());
		UserService userService = new UserService();
		try{
			userService.insertUser(addUser);
			response.setStatus(ApplicationConstants.TRUE);
			response.setMessage("");
		}
		catch(Exception e){
			response.setMessage(e.getMessage());
			response.setStatus(ApplicationConstants.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/updateUser",
			method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE 
	)
	public ResponseDTO updateUser(User user){
		ResponseDTO response = new ResponseDTO();
		UserService userService = new UserService();
		try{
			userService.updateUser(user);
			response.setStatus(ApplicationConstants.TRUE);
			response.setMessage("");
		}
		catch(Exception e){
			response.setMessage(e.getMessage());
			response.setStatus(ApplicationConstants.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/deleteUser",
			method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE 
	)
	public ResponseDTO deleteUser(int id){
		ResponseDTO response = new ResponseDTO();
		try{
			UserService userService = new UserService();
			userService.deleteUser(id);
			response.setStatus(ApplicationConstants.TRUE);
			response.setMessage("");
		}
		catch(Exception e){
			response.setMessage(e.getMessage());
			response.setStatus(ApplicationConstants.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		emailService.sendSimpleMessage("jitenderbadoni@gmail.com", "Test", "Test"); 
		return "Welcome to Spring Application";
	}
}
