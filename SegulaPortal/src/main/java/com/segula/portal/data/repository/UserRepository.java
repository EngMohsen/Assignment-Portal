package com.segula.portal.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.segula.portal.data.entity.User;

@RepositoryRestResource(collectionResourceRel = "User",path = "User")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String userName);
	
}
