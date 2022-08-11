package com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples;

import org.apache.tomcat.jni.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples.model.Boook;

@SpringBootApplication
public class Redis5SpringbootBooksStorecrudopExamplesApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}//created by us and plugged into the redisTemplate
	
	@Bean
	RedisTemplate<String,Boook> redisTemplate(){
		RedisTemplate<String,Boook> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Redis5SpringbootBooksStorecrudopExamplesApplication.class, args);
	}

}
