package com.segula.portal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segula.portal.data.entity.Post;
import com.segula.portal.data.repository.PostRepository;
import com.segula.portal.dto.PostDto;

@Service
@Transactional
public class PostService {

	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> listAll() {
        return postRepository.findAll();
    }
     
    public Post save(PostDto post) {
    	Post p = new Post();
    	p.setClient(post.getClient());
    	p.setDeadline(post.getDeadline());
    	p.setDescription(post.getDescription());
    	p.setEmail(post.getEmail());
    	p.setStartDate(post.getStartDate());
    	p.setEndDate(post.getEndDate());
    	p.setHours(post.getHours());
    	p.setLocation(post.getLocation());
    	p.setName(post.getName());
    	p.setPhone_number(post.getPhone_number());
    	p.setPortal(post.getPortal());
    	p.setPosition(post.getPosition());
    	p.setSlogan(post.getSlogan());
    	p.setUrl(post.getUrl());
    	
    	return postRepository.save(p);
    }
    
    public Post update(Long id,PostDto post) {
    	
    	
    	Post p = get(id);
    	
    	p.setClient(post.getClient());
    	p.setDeadline(post.getDeadline());
    	p.setDescription(post.getDescription());
    	p.setEmail(post.getEmail());
    	p.setStartDate(post.getStartDate());
    	p.setEndDate(post.getEndDate());
    	p.setHours(post.getHours());
    	p.setLocation(post.getLocation());
    	p.setName(post.getName());
    	p.setPhone_number(post.getPhone_number());
    	p.setPortal(post.getPortal());
    	p.setPosition(post.getPosition());
    	p.setSlogan(post.getSlogan());
    	p.setUrl(post.getUrl());
    	
    	return postRepository.save(p);
    }
    public Post get(long id) {
        return postRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	postRepository.deleteById(id);
    }
}
