package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UI.shared.dto.Userdto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
@Service
public class UserserviceImpl implements UserService {
	@Autowired
	com.example.demo.UserRepo UserRepo;
	@Override
	public Userdto createUser(Userdto user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		UserEntity storeduserdetails = UserRepo.save(userEntity);
		Userdto returnValue = new Userdto();
		BeanUtils.copyProperties(storeduserdetails, returnValue);

		return returnValue; 
	}
	@Override
	public Userdto getUserbyName(String name) {
		Userdto returnValue = new Userdto();
		UserEntity userEntity = UserRepo.findByFirstname(name);

		BeanUtils.copyProperties(userEntity, returnValue);


		return returnValue; 
	}
	public Userdto getallUserbyName(String name) {
		Userdto returnValue = new Userdto();
		UserEntity userEntity = UserRepo.findAllByFirstname(name);

		BeanUtils.copyProperties(userEntity, returnValue);


		return returnValue; 
	}
	@Override
	public Userdto updateUser(String id, Userdto user) {
		Userdto returnValue = new Userdto();
		UserEntity userEntity = UserRepo.findAllByFirstname(id);
		
		userEntity.setAddclass(user.getAddclass()); // updated the Class
		userEntity.setAddgrade(user.getAddgrade()); // updated the Grade
		UserEntity updateddata =UserRepo.save(userEntity);
		BeanUtils.copyProperties(updateddata, returnValue);
		return returnValue;
	}
	@Override
	public void deleteUser(String name) {
		UserEntity userEntity = UserRepo.findAllByFirstname(name);
		UserRepo.delete(userEntity);
	}

}
