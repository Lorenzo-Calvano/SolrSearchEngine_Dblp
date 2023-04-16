package entities;

import java.util.ArrayList;

public class Articolo extends Documento{

	private String mese;
	private String giornale;


	public Articolo(String mese, String giornale, Copertina copertina, Proprietà proprietà, int anno,  
			 ArrayList<String> uRLs) {
		super(copertina, proprietà, anno, uRLs);
		this.mese=mese;
		this.giornale=giornale;
	}


	public String getMese() {
		return mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public String getGiornale() {
		return giornale;
	}

	public void setGiornale(String giornale) {
		this.giornale = giornale;
	}


}
