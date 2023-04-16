package entities;

import java.util.ArrayList;

public class PhDThesis extends Documento{

	private String publisher;
	private String scuola;
	private String ISBN;


	public PhDThesis(String publisher, String scuola, String ISBN, Copertina copertina, Proprietà proprietà, int anno,  
			 ArrayList<String> uRLs) {
		super(copertina, proprietà, anno, uRLs);
		this.publisher=publisher;
		this.scuola=scuola;
		this.ISBN=ISBN;
	}


	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getScuola() {
		return scuola;
	}

	public void setScuola(String scuola) {
		this.scuola = scuola;
	}

	public String getISBN() {
		return ISBN;
	}


}
