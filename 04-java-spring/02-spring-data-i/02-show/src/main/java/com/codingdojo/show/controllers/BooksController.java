package com.codingdojo.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.show.models.Book;
import com.codingdojo.show.services.BookService;

@Controller
public class BooksController {
	
	@Autowired
	private BookService bService;
	
	//show all books in a table
	@GetMapping("/books")
		public String index(Model model) {
			List<Book> books = bService.getAllBooks();
			model.addAttribute("books", books);
			return "/books/index.jsp";
		}
	//finds a single book
	@GetMapping("/books/{index}")
	public String findBookByIndex(Model viewModel, @PathVariable("index") Long index) {
		Book book = bService.getOneBook(index);
		viewModel.addAttribute("book", book);
		return "/books/showBook.jsp";
	}
	//deletebook
	@DeleteMapping("/books/delete/{index}")
	public String deleteBookByindex(Model viewModel, @PathVariable("index") Long index){
		bService.deleteBook(index);
		return "redirect:/books";
	}
	
	
	//creates a book
	@ PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result){
		if (result.hasErrors()){
			return "/books/new.jsp";
		}else {
			bService.createBook(book);
			return "redirect:/books";
		}
	}
	
	
	
}
