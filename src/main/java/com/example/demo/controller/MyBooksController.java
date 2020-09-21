package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 
	 //http://localhost:8080/InsMyBooks?Title=測試&Price=50
	 @RequestMapping(value="/InsMyBooks",method = RequestMethod.GET)
	 public void InsMyBooks(HttpServletResponse response,@RequestParam(value = "Title",required = true) String Title,@RequestParam(value = "Price",required = true) Double Price)throws IOException{
		 service.InsertMyBooks(Title, Price);	
		 response.sendRedirect("/GetMyBooks");
	 }
	 
	//http://localhost:8080/UpdMyBooks?Id=5&Title=測試修改2&Price=88
	 @RequestMapping(value="/UpdMyBooks",method = RequestMethod.GET)
	public void UpdMyBooks(HttpServletResponse response,@RequestParam(value = "Id",required = true) Integer Id,@RequestParam(value = "Title") String Title,@RequestParam(value = "Price") Double Price)throws IOException{
		 service.UpdateMyBooks(Title, Price,Id);	
		 response.sendRedirect("/GetMyBooks");
	}
	 
	//http://localhost:8080/DelMyBooks?Id=5
	@RequestMapping(value="/DelMyBooks",method = RequestMethod.GET)
	public void DelMyBooks(HttpServletResponse response,@RequestParam(value = "Id",required = true) Integer Id)throws IOException{
		service.DeleteMyBooks(Id);	
		response.sendRedirect("/GetMyBooks");
	}
}
