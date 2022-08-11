package com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples.model.Boook;

@RestController
@RequestMapping("/rest/boook")

public class BoookResource {

	private BoookRepository boookRepository;

	public BoookResource(BoookRepository boookRepository) {
		super();
		this.boookRepository = boookRepository;
	}
	
	//Rest end points with which we can add data
	//add and select covered
	//GET will invoke findById with the extracted id value
	@GetMapping("/add/{id}/{bname}/{bauthor}/{price}")
	//return type Boook to show which Boook got added
	public Boook add(@PathVariable("id") final String id,
			@PathVariable("bname") final String bname,
			@PathVariable("bauthor") final String bauthor,
			@PathVariable("price") final int price) {
		//creating a new Boook
		boookRepository.save(new Boook(id,bname,bauthor,price));
		//To return them back to the boook
		return boookRepository.findById(id);
		
	}
	
	//GET will invoke findById with the extracted id value
	@GetMapping("/update/{id}/{bname}/{bauthor}/{price}")
	//we use the @PathVariable annotation to extract the templated part of the URI, represented by the variable {id}.
	public Boook update(@PathVariable("id") final String id,
			@PathVariable("bname") final String bname,
			@PathVariable("bauthor") final String bauthor,
			@PathVariable("price") final int price) {
		boookRepository.update(new Boook(id,bname,bauthor,price));
		//To return them back to the boook
		return boookRepository.findById(id);
		
	}
	
	//GET will invoke findAll
	@GetMapping("/all")
	public Map<String,Boook> all() {
		return boookRepository.findAll();
	}
	
	//GET will invoke delete with the extracted id value
	@GetMapping("/delete/{id}")
	public Map<String,Boook> delete(@PathVariable("id") final String id) {
		boookRepository.delete(id);
		//To return them back to the boook
		return all();
		
	}
}
