package com.example.demo.UI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UI.req.model.UserdetailsReqModel;
import com.example.demo.UI.resp.model.DeleteResp;
import com.example.demo.UI.resp.model.UserdetailsRespModel;
import com.example.demo.UI.resp.model.UserdetailsSearchModel;
import com.example.demo.UI.shared.dto.Userdto;
import com.example.demo.service.UserService;

@RestController //BindRequests
@RequestMapping("students") //Handle requests - http://localhost:8080/users
public class usercontroller {
	@Autowired
	UserService userservice;
	
	@GetMapping(path="/{name}") //bind the get request
	public UserdetailsSearchModel getuser(@PathVariable String name)
	{
		UserdetailsSearchModel returnValue = new UserdetailsSearchModel();
		Userdto userDto = userservice.getUserbyName(name);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}
	
	@PostMapping //post
	public UserdetailsRespModel createUser(@RequestBody UserdetailsReqModel userDetails) {
		UserdetailsRespModel returnValue = new UserdetailsRespModel();
		Userdto userDto = new Userdto();
		BeanUtils.copyProperties(userDetails, userDto);
		Userdto createdUser = userservice.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "Update User Called";
	}
	
	@DeleteMapping(path="/{id}")
	public DeleteResp deleteUser() {
		DeleteResp returnValue = new DeleteResp();
		return returnValue;
	}

}
