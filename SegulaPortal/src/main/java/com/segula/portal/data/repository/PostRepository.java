package com.segula.portal.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.segula.portal.data.entity.Post;

@RepositoryRestResource(collectionResourceRel = "Post",path = "Post")
public interface  PostRepository extends JpaRepository<Post, Long> {


}
