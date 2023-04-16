package entities;

import java.util.ArrayList;
import java.util.List;

public class PaginaAutore {

	private String nome;
	private ArrayList<Documento> pubblicazioni;
	private String note;

	public PaginaAutore(String nome, ArrayList<Documento> pubblicazioni, String note) {
		this.nome=nome;
		this.pubblicazioni=pubblicazioni;
		this.note = note;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Documento> getPubblicazioni(int posizione) {
		if(pubblicazioni.size()>posizione)
			return pubblicazioni.subList(posizione, posizione + Math.min(10, pubblicazioni.size()-posizione));
		else
			return null;
	}

	public void AggiungiPubblicazioni(ArrayList <Documento> pubblicazione, int posizione) {
		if(this.pubblicazioni!= null && this.pubblicazioni.size()<=posizione)
			this.pubblicazioni.addAll(pubblicazione);
		else if (this.pubblicazioni == null)
			this.pubblicazioni=pubblicazione;
	}
	
	public int numDoc() {
		return this.pubblicazioni.size();
	}
	
	public String getNote() {
		if(this.note == null)
			return "";
		return this.note;
	}
}
