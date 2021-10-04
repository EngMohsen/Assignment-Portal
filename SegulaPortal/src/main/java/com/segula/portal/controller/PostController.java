package com.segula.portal.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.segula.portal.data.entity.Post;
import com.segula.portal.dto.PostDto;
import com.segula.portal.service.PostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PostController {
	
	  	@Autowired
	    private PostService postService;
	  	
	  	@PostMapping(path = "/post", consumes = { "application/json" })
		public ResponseEntity<PostDto> saveAdvertisment(@RequestBody PostDto adver) {
	  		Post savedAdver = postService.save(adver);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAdver.getId()).toUri();
			adver.setLinks(new String[] {uri.toString()});
			log.info("The URL after modification with advertisment Id : {}",uri.toString());
			return new ResponseEntity<PostDto>(adver, HttpStatus.OK);
		}
	  	
		@PutMapping(path = "/post/{id}", consumes = { "application/json" })
		public ResponseEntity<Post> updatedAdvertisment(@PathVariable long id , @RequestBody PostDto adver) {
			Post updatedAdver = postService.update(id,adver);
			return new ResponseEntity<Post>(updatedAdver, HttpStatus.OK);
		}
	  	
	  	@GetMapping("/posts")
	  	public List<Post> list() {
	  	    return postService.listAll();
	  	}
	  	
	  	@GetMapping("/post/{id}")
	  	public ResponseEntity<Post> get(@PathVariable long id) {
	  	    try {
	  	    	Post adver = postService.get(id);
	  	        return new ResponseEntity<Post>(adver, HttpStatus.OK);
	  	    } catch (NoSuchElementException e) {
	  	        return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	  	    }      
	  	}
	  	
	  	@DeleteMapping(path = "/post/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletePost(@PathVariable Long id) {
			try {
				postService.delete(id);
			} catch (ResourceNotFoundException e) {
				log.error("Person not found for id {} , error {}", id, e);
			}
		}

}
