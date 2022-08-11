package com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples;

import java.util.Map;

import com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples.model.Boook;

//interface specifies the behavior of a class by providing 
//an abstract type
public interface BoookRepository {
	
	void save(Boook boook);
	Map<String,Boook> findAll();
	Boook findById(String id);
	void update(Boook boook);
	void delete(String id);

}
