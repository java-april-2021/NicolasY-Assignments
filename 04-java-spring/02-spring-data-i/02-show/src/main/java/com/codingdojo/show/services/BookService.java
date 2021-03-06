package com.codingdojo.show.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codingdojo.show.models.Book;
import com.codingdojo.show.repositories.BookRepository;
@Service
public class BookService {

	private BookRepository bRepository;
	
	public BookService(BookRepository bRepo) {
		this.bRepository = bRepo;
	}
	
	public List<Book> getAllBooks(){
		return this.bRepository.findAll();
	}
	
	//get one book
	
	public Book getOneBook(Long id) {
		return this.bRepository.findById(id).orElse(null);
	}
	
	//create a book
	public Book createBook(Book newBook) {
		return this.bRepository.save(newBook);
	}
	
	//delete
	public void deleteBook(Long id) {
		this.bRepository.deleteById(id);
	}
	
	
}
