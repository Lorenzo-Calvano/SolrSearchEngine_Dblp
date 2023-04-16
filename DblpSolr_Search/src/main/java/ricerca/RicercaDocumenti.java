package ricerca;

import java.util.ArrayList;
import entities.Documento;

public class RicercaDocumenti extends Ricerca{


	public RicercaDocumenti(Campo campo) {
		super();
		this.campo=campo;
	}


	public ArrayList<Documento> mostraRisultati() {
		try {
			return Parser.creaDocumenti(Risposta.getResponse(this));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String getCampoString() {
		String query= null;
		query = this.campo.getSezione() + ":" + this.campo.getValore() + " && -type:www";
		return query;

	}

}
