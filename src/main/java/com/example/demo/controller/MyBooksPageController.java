package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.MyBooksModel;
import com.example.demo.service.MyBooksService;

@Controller
@RequestMapping("/")
public class MyBooksPageController {
	
	@Autowired
	private MyBooksService service;
	
	@RequestMapping("/MyBooksPage")
	public String List(Model model) 
	{
		List<MyBooksModel> result = service.getAll();
		model.addAttribute("MyBooks",result);
		return "MyBooks/MyBooks";
	}
}
