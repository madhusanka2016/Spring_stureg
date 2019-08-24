package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;
@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
	UserEntity findByFirstname(String id);
}
