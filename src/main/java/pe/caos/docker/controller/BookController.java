package pe.caos.docker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import pe.caos.docker.domain.Book;
import pe.caos.docker.service.BookService;

@Log4j2
@RestController
public class BookController {

	private final BookService bookService;
	
	@Autowired
	BookController(final BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(value = "/books", consumes = {"application/json"})
	public Book saveBook(@RequestBody @Valid final Book book) {
		log.debug("save controller");
		return bookService.saveBook(book);
	}
	
}
