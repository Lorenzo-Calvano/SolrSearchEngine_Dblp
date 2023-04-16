package entities;

import java.util.ArrayList;

public class Libro extends Documento{

	private String ISBN;
	private String scuola;
	private String titolo_libro;
	private String publisher;


	public Libro(String ISBN, String scuola, String titolo_libro, String publisher, Copertina copertina, 
			Proprietà proprietà, int anno, ArrayList<String> uRLs) {
		super(copertina, proprietà, anno, uRLs);
		this.publisher=publisher;
		this.titolo_libro=titolo_libro;
		this.scuola=scuola;
		this.ISBN=ISBN;
	}
	
	
	public String getScuola() {
		return scuola;
	}

	public void setScuola(String scuola) {
		this.scuola = scuola;
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
