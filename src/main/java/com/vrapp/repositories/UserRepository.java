package com.vrapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vrapp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	@Query("select u from User u where u.userName=:userName")
	public User findByUserName(@Param("userName")String userName);
	
	@Query("Delete from User u where u.userName=:userName")
	public User deleteUser(@Param("userName")String userName); 
}
