package com.gjk.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
 
    @Id
    protected String isbn;
    protected String title;
    protected String author;
    protected String description;
    
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}