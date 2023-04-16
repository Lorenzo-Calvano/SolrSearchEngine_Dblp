package entities;

import java.util.ArrayList;

public class Copertina {
	
	private String ID;
	private String titolo;
	private ArrayList<String> autori;
	
	public Copertina(String ID, String titolo, ArrayList<String> autori) {
		this.ID=ID;
		this.titolo=titolo;
		this.autori=autori;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public ArrayList<String> getAutori() {
		return autori;
	}
	
	public void addAutore(String autore) {
		this.autori.add(autore);
	}
	
	public void setAutori(ArrayList<String> autori) {
		this.autori = autori;
	}
	
	public String getID() {
		return ID;
	}
	
	
}
