package connessione;


import java.util.ArrayList;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;

import ricerca.Ricerca;
import ricerca.RispostaQuery;


public class FornitoreRisposta implements RispostaQuery{
	
	private static FornitoreRisposta Instance;
	private GestoreQuery Gestore = new GestoreQuery();

	private FornitoreRisposta() {}
	
	public static FornitoreRisposta getInstance() {
		if (Instance == null)
			Instance= new FornitoreRisposta();
		return Instance;
	}
	
	
	public ArrayList<SolrDocument> getResponse(Ricerca ricerca) throws Exception {
		Gestore.setRicerca(ricerca);
		
		QueryResponse Qr = Gestore.mandaQuery();

		ArrayList <SolrDocument> response = new ArrayList <SolrDocument>(Qr.getResults());
		return response;
	}
	
}
