package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MyBooksModel;

@Repository
public interface MyBooksRepository extends CrudRepository<MyBooksModel,Long> {
	@Query(nativeQuery=true,value="SELECT * FROM [MyTestDB].[dbo].[MyBooks]")
	List<MyBooksModel> getAll();
	
	@Query(nativeQuery=true,value="SELECT * FROM [MyTestDB].[dbo].[MyBooks] where Id= :Id")
	MyBooksModel getById(@Param("Id") Integer Id);
	
	@Modifying
	@Query(nativeQuery=true,value="INSERT INTO [MyTestDB].[dbo].[MyBooks] SELECT Title= :Title,Price= :Price")
	@Transactional
	void InsertMyBooks(@Param("Title") String Title,@Param("Price") Double Price);
	
	@Modifying
	@Query(nativeQuery=true,value="DELETE FROM [MyTestDB].[dbo].[MyBooks] WHERE Id= :Id")
	@Transactional
	void DeleteMyBooks(@Param("Id") Integer Id);
	
	@Modifying
	@Query(nativeQuery=true,value="UPDATE [MyTestDB].[dbo].[MyBooks] SET Title= :Title,Price= :Price WHERE Id= :Id")
	@Transactional
	void UpdateMyBooks(@Param("Id") Integer Id,@Param("Title") String Title,@Param("Price") Double Price);

}
