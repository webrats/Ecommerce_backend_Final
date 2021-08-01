package com.mvc.reg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mvc.reg.model.PostDao;
import com.mvc.reg.repository.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	PostRepository postRepository ; 
	
	
	@GetMapping("/post")
	public List<PostDao> getAllPost(@RequestHeader (name="Authorization") String token){
		System.out.println(token);
		return  postRepository.findAll() ; 
	}
	
	
	@PostMapping("/post")
	public ResponseEntity<PostDao> savePost(@RequestBody PostDao post ){
		try {
			System.out.println("savePost controller ");
			if(post.getDescription() != null || post.getTitle()!= null) {
				
				return new ResponseEntity<PostDao>(postRepository.save(post),HttpStatus.OK);
			}else {
				return new ResponseEntity<PostDao>(post,HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<PostDao>(post,HttpStatus.BAD_REQUEST); 
		}
	}
	@PostMapping("post/{id}")
	public ResponseEntity<?> updatePostById(@PathVariable long id ,@RequestBody PostDao post ) {
		try {
			System.out.println("updatePostBy id  controller ");
			if(postRepository.existsById(id)==true && post!= null) {
				 postRepository.save(post);
				 
				return new ResponseEntity<String>("{\"message\":\"Success\"}",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("{\"message\":\"Fail\"}",HttpStatus.BAD_REQUEST);
			}
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Wrong post id :"+id);
		}
		
	}
	
	@DeleteMapping("post/{id}")
	public ResponseEntity<?> deletePost(@PathVariable long id ){
		try {
			System.out.println("delete post controller ");
			postRepository.deleteById(id);
		return new ResponseEntity<String>("{\"message\":\"Success\"}",HttpStatus.OK) ;
		}
		catch(Exception e) {
			return new ResponseEntity<String>("{\"message\":\"Fail\"}" ,HttpStatus.BAD_REQUEST) ;
		}
		
	}
	
}
