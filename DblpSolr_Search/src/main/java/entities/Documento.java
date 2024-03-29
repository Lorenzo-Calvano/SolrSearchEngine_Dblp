package entities;

import java.util.ArrayList;


public abstract class Documento {

	private Copertina copertina;
	private int anno; 
	private Proprietā proprietā;
	private ArrayList<String> URLs;


	public Documento(Copertina copertina, Proprietā proprietā, int anno, ArrayList<String> uRLs) {
		super();
		this.anno = anno;
		this.setURLs(uRLs);
		this.proprietā=proprietā;
		this.copertina = copertina;
	}


	public int getAnno() {
		return anno;
	}

	public String getAnnoString() {
		return ((Integer) this.anno).toString();
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Copertina getCopertina() {
		return copertina;
	}

	public void setCopertina(Copertina copertina) {
		this.copertina = copertina;
	}

	public ArrayList<String> getURLs() {
		return URLs;
	}

	public void setURLs(ArrayList<String> uRLs) {
		for(int i=0; i<uRLs.size(); i++) {
			if(!uRLs.get(i).startsWith("http")){
				String u = "https://dblp.uni-trier.de/" + uRLs.get(i);
				uRLs.set(i, u);
			}
		}
		URLs = uRLs;
		
	}

	public void addURL(String URL) {
		this.URLs.add(URL);
	}

	public Proprietā getProprietā() {
		return proprietā;
	}

	public void setProprietā(Proprietā proprietā) {
		this.proprietā = proprietā;
	}
	

}
