package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.MyBooksModel;
import com.example.demo.service.MyBooksService;

@RestController
@RequestMapping("/")
public class MyBooksController {
	
	@Autowired
	private MyBooksService service;
	
	 @RequestMapping("/GetMyBooks")
	 public List<MyBooksModel> index() {
		List<MyBooksModel> result = service.getAll();
	 	return result;
	 }
}
