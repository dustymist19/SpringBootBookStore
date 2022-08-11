package com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples.model.Boook;

@Repository //Telling spring that this is the repository 
public class BoookRepositoryImpl implements BoookRepository {

	//RedisTemplate for implementation of redis
	private RedisTemplate<String,Boook> redisTemplate;
	
	
	private HashOperations hashOperations;
	
	public BoookRepositoryImpl(RedisTemplate<String, Boook> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		//using hash to operate on redis template
		hashOperations=redisTemplate.opsForHash();
	}

	@Override
	public void save(Boook boook) {
		//using index or key usually written in caps
		//Inside the Book we'll be having value id which will give us types of users
		hashOperations.put("BOOOK", boook.getId(), boook);
	}

	@Override
	//its not list of Boook as it is going to return a key value back
	public Map<String,Boook> findAll() {
		// findAll consists of operations called as entries
		//In entries we can find all type of objects or values
		//returns map of users
		return hashOperations.entries("BOOOK");
	}

	@Override
	public Boook findById(String id) {
	
		return (Boook)hashOperations.get("BOOOK", id);
	}

	@Override
	public void update(Boook boook) {
		//hashOperations.put("USER", user.getId(), user);
		save(boook);
		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("BOOOK", id);
		
	}

}
