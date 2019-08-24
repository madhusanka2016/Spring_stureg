/**
 * 
 */
package com.example.demo.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.UserRepo;
import com.example.demo.UI.shared.dto.Userdto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	UserRepo userrepo;
	@Override
	public Userdto createUser(Userdto user) {
		UserEntity userentity = new UserEntity();
		BeanUtils.copyProperties(user, userentity);
		UserEntity storeduserdetails = userrepo.save(userentity);
		Userdto returnValue = new Userdto();
		BeanUtils.copyProperties(storeduserdetails, returnValue);

		return returnValue;
	}

}
