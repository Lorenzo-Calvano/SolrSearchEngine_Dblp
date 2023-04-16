package ricerca;

import java.util.ArrayList;
import entities.PaginaAutore;

public class RicercaAutore extends Ricerca{
	

	public RicercaAutore(Campo campo) {
		super();
		this.campo=campo;
	}


	public ArrayList<PaginaAutore> mostraRisultati() {
		try {
			return Parser.creaPagineAutore(Risposta.getResponse(this));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String getCampoString() {
		{
			String query= null;
			query = this.campo.getSezione() + ":" + this.campo.getValore() + " && type:www";
			return query;
		}
	}
	
	
}
