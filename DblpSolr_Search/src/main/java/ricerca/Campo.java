package ricerca;

public class Campo {
	private String valore;
	private String sezione;
	private int posizione;
	
	public Campo(String sezione, String valore) {
		this.valore=valore;
		this.sezione=sezione;
		this.posizione = 0;
	}

	public String getPosizioneString() {
		Integer pos = (Integer)posizione;
		return pos.toString();
	}
	
	public int getPosizioneInt() {
		return this.posizione;
	}
	
	public void setPosizione(int posizione) {
		this.posizione=posizione;
	}
	
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	
}
