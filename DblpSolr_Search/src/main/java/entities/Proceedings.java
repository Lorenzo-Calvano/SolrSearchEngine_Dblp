package entities;

import java.util.ArrayList;

public class Proceedings extends Documento{

	private String ISBN;
	private String editore;
	private String titolo_libro;
	private String publisher;

	
	public Proceedings(String ISBN, String editore, String titolo_libro, String publisher, Copertina copertina, Proprietà proprietà, int anno,  
			 ArrayList<String> uRLs) {
		super(copertina, proprietà, anno, uRLs);
		this.publisher=publisher;
		this.titolo_libro=titolo_libro;
		this.editore=editore;
		this.ISBN=ISBN;
	}

	
	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getTitolo_libro() {
		return titolo_libro;
	}

	public void setTitolo_libro(String titolo_libro) {
		this.titolo_libro = titolo_libro;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getISBN() {
		return ISBN;
	}

}
