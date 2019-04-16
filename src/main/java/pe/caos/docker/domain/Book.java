package pe.caos.docker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@Entity
public class Book {

	@Id 
    @NotNull 
    @Column(name = "id", nullable = false, updatable = false) 
    private Long id; 
 
    @NotNull 
    @Size(max = 64) 
    @Column(name = "author", nullable = false) 
    private String author; 
 
    @NotNull 
    @Size(max = 64) 
    @Column(name = "title", nullable = false) 
    private String title; 
  
	
}
