package com.example.demo.service;

import com.example.demo.UI.shared.dto.Userdto;

public interface UserService {
	
	Userdto createUser (Userdto user);
	
	Userdto getUserbyName(String name);

	Userdto getallUserbyName(String name);

	Userdto updateUser(String id, Userdto user);

	void deleteUser(String name);
	
}
