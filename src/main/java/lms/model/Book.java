package lms.model;

import jakarta.persistence.Entity;

@Entity
public class Book {
	private String name;
	private int referenceId;
	
	public void setBookName(String name) {this.name=name;}
	public String getBookName() {return name;}
	
	public void setBookId(int id) {this.referenceId=id;}
	public int getBookId() {return referenceId;}
}
