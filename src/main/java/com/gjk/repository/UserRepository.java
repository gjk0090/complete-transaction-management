package com.gjk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gjk.domain.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String>{
	
	public UserInfo findUserInfoByUsername(@Param("username") String usermane);
}
