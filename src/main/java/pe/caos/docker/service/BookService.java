package pe.caos.docker.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import pe.caos.docker.domain.Book;

public interface BookService {

	Book saveBook(@NotNull @Valid final Book book);
	List<Book> getList();
	Book getBook(Long bookId);
	void deleteBook(final Long bookId);
	
}
