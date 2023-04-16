package entities;

import java.util.ArrayList;

public class MastersThesis extends Documento{

	private String scuola;
	private String ISBN;


	public MastersThesis(String scuola, String ISBN, Copertina copertina, Proprietà proprietà, int anno,  
			 ArrayList<String> uRLs) {
		super(copertina, proprietà, anno, uRLs);
		this.scuola=scuola;
		this.ISBN=ISBN;
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
