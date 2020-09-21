package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.MyBooksModel;
import com.example.demo.repository.MyBooksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MyBooksService {
	
	@Autowired
	MyBooksRepository rep;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	public MyBooksService(MyBooksRepository rep) {
		this.rep = rep;
	}
	
	public List<MyBooksModel> getAll() {
		List<MyBooksModel> data = rep.getAll();
		try {
			System.out.println(mapper.writeValueAsString(data));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
