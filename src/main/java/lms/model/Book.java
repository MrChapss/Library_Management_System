package lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String author;
	@Column
	private boolean isAvailable;
	
	// setter
	public void setBookId(int id) {this.id=id;}
	public void setTitle(String title) {this.title=title;}
	public void setAuthor(String author) {this.author=author;}
	public void setIsAvailable(boolean isAvailable) {this.isAvailable=isAvailable;}
	// getter
	public int getBookId() {return id;}
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public boolean getIsAvailable() {return isAvailable;}
}
