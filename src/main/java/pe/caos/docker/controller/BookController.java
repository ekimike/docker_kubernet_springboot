package pe.caos.docker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import pe.caos.docker.domain.Book;
import pe.caos.docker.exception.BookAlreadyExistsException;
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
	
	@ApiOperation(value = "Retrieve a list of books", responseContainer = "List")
	@GetMapping(value = "/books", produces = {"aplication/json"})
	public List<Book> listBooks() {
		log.debug("listBooks");
		return bookService.getList();
	}
	
	@GetMapping(value = "/books/{id}", produces = {"application/json"})
	public Book singleBook(@PathVariable Long id) {
		log.debug("singleBook");
		return bookService.getBook(id);
	}
	
	@DeleteMapping(value = "/books/{id}")
	public void deleteBook(@PathVariable Long id) {
		log.debug("deleteBook");
		bookService.deleteBook(id);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleUserAlreadyExistsException(BookAlreadyExistsException e) {
		return e.getMessage();
	}
	
}
