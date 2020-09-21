package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MyBooksModel;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooksModel,Long> {
	@Query(nativeQuery=true,value="SELECT * FROM [MyTestDB].[dbo].[MyBooks]")
	List<MyBooksModel> getAll();
}
