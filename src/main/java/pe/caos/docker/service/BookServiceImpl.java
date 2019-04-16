package pe.caos.docker.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import lombok.extern.log4j.Log4j2;
import pe.caos.docker.domain.Book;
import pe.caos.docker.exception.BookAlreadyExistsExceptionString;
import pe.caos.docker.repository.BookRepository;

@Log4j2
@Service
@Validated
public class BookServiceImpl implements BookService 
{

	private final BookRepository repository;
	
	@Autowired
	BookServiceImpl(final BookRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Book saveBook(@NotNull @Valid Book book) {
		log.debug("Creating book");
		Optional<Book> existing = repository.findById(book.getId());
		if (existing != null) {
			throw new BookAlreadyExistsExceptionString.format("There already exists a book with id=%s", book.getId())); 
		}
		return repository.save(book);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> getList() {
		log.debug("retrieving the list o users");
		return repository.findAll();
	}

	@Override
	public Book getBook(Long bookId) {
		log.debug("Getting specific book");
		return repository.getOne(bookId);
	}

	@Override
	@Transactional
	public void deleteBook(Long bookId) {
		log.debug("deleting a book");
		repository.deleteById(bookId);
	}

}
