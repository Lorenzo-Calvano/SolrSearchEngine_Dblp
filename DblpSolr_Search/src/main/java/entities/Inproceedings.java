package entities;

import java.util.ArrayList;

public class Inproceedings extends Documento{

	private String titolo_libro;
	private String crossref;

	public Inproceedings(String titolo_libro, String crossref, Copertina copertina, ProprietÓ proprietÓ, int anno,  
			 ArrayList<String> uRLs) {
		super(copertina, proprietÓ, anno, uRLs);
		this.titolo_libro=titolo_libro;
		this.crossref=crossref;
	}

	public String getTitolo_libro() {
		return titolo_libro;
	}

	public void setTitolo_libro(String titolo_libro) {
		this.titolo_libro = titolo_libro;
	}

	public String getCrossref() {
		return crossref;
	}

	public void setCrossref(String crossref) {
		this.crossref = crossref;
	}



}
