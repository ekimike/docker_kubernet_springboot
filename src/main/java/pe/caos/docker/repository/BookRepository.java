package pe.caos.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.caos.docker.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
