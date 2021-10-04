package com.segula.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.segula.portal.data.entity.Post;
import com.segula.portal.data.repository.PostRepository;
import com.segula.portal.dto.PostDto;
import com.segula.portal.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTests {
	
	
	@Autowired
	private PostService postService;

	@MockBean
	private PostRepository postRepository;
	
	@Test
	public void savePosts() {
		PostDto pDto = new PostDto(1L,"http:google.com","mohsen","volvo cars","software engineer",
				"fullstack developer", "gothenburg", "veronma", "stefan", "stefan@gmail.com", "07000000", 
				new Date(), new Date(), new Date(), "400", null);
		Post p = new Post(1L,"http:google.com","mohsen","volvo cars","software engineer",
				"fullstack developer", "gothenburg", "veronma", "stefan", "stefan@gmail.com", "07000000", 
				new Date(), new Date(), new Date(), "400", null);
		when(postRepository.save(p)).thenReturn(p);
		assertEquals(p, postService.save(pDto));
	}
	
	@Test
	public void getPosts() {
	Post p = new Post(1L,"http:google.com","mohsen","volvo cars","software engineer",
				"fullstack developer", "gothenburg", "veronma", "stefan", "stefan@gmail.com", "07000000", 
				new Date(), new Date(), new Date(), "400", null);
		List<Post> posts = new ArrayList<>();
		posts.add(p);
		when(postRepository.findAll()).thenReturn(posts);
		assertEquals(1, postService.listAll().size());
	}
}
