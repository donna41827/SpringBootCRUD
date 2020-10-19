package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.MyBooksModel;
import com.example.demo.service.MyBooksService;

@Controller
@RequestMapping("/")
public class MyBooksPageController {
	
	@Autowired
	private MyBooksService service;
	
	@RequestMapping("/MyBooksPage")
	public String List(Model model,@RequestParam(value = "Title", required=false) String Title) 
	{
		List<MyBooksModel> result;
		if(Title == null) 
		{
			result = service.getAll();
		}
		else 
		{
			result = service.getByTitle(Title);
		}
		model.addAttribute("MyBooks",result);
		return "MyBooks/MyBooks";
	}
	
//	@RequestMapping(value="/MyBooksPage",method = RequestMethod.GET)
//	public String SelectList(Model model,@RequestParam(value = "Title") String Title) 
//	{
//		List<MyBooksModel> result = service.getByTitle(Title);
//		model.addAttribute("MyBooks",result);
//		return "MyBooks/MyBooks";
//	}
	
	@RequestMapping("/MyBooksPageAdd")
	public String Add(Model model) 
	{
		model.addAttribute("MyBooks",new MyBooksModel());
		return "MyBooks/MyBooksAdd";
	}
	
	@PostMapping("/MyBooksPageAdd")
    public String Insert(HttpServletResponse response,MyBooksModel MyBooks, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "MyBooks/MyBooksAdd";
        }
        service.InsertMyBooksModel(MyBooks);

        return "redirect:/MyBooksPage";
    }
	@RequestMapping(value="/MyBooksPageDel",method = RequestMethod.GET)
	public String Delete(@RequestParam(value = "Id",required = true) Integer Id) {
		service.DeleteMyBooks(Id);
	    return "redirect:/MyBooksPage";
	}
	@RequestMapping(value="/MyBooksPageUpd",method = RequestMethod.GET)
	public String Edit(@RequestParam(value = "Id",required = true) Integer Id,Model model) {
		MyBooksModel result = service.getById(Id);
		model.addAttribute("MyBooks",result);
		return "MyBooks/MyBooksUpd";
	}
	@PostMapping("/MyBooksPageUpd")
	public String Update(MyBooksModel MyBooks) 
	{
		service.InsertMyBooksModel(MyBooks);
		return "redirect:/MyBooksPage";
	}
}
