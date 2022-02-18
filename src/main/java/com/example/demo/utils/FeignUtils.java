package com.example.demo.utils;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.FeignModel;

@FeignClient(value = "lambdaDemo", url = "https://jsonplaceholder.typicode.com")
public interface FeignUtils {

	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	List<FeignModel> getPosts();
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}", produces = "application/json")
	FeignModel getItem(@PathVariable("id") Long id);
}
