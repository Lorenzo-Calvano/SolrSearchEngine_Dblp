package ricerca;

import java.util.ArrayList;
import connessione.FornitoreRisposta;

public abstract class Ricerca {

	protected RispostaQuery Risposta;
	protected ParserRisposta Parser;
	protected Campo campo;
	
	public Ricerca() {
		this.Parser= new ParserRisposta();
		this.Risposta=FornitoreRisposta.getInstance();
	}
	
	
	public abstract ArrayList<?> mostraRisultati();

	
	public void setCampo(Campo campo) {
		this.campo=campo;
	}
	
	public Campo getCampo() {
		return this.campo;
	}
	
	public void nextPos() {
		int pos = this.campo.getPosizioneInt() + 10;
		this.campo.setPosizione(pos);
	}
	
	public void prevPos() {
		int pos = this.campo.getPosizioneInt();
		if(pos>=10) 
			this.campo.setPosizione(pos-10);
	}
	
	public abstract String getCampoString();
}
