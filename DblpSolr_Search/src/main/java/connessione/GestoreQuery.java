package connessione;

import java.util.HashMap;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import ricerca.Ricerca;

public class GestoreQuery {

	private HttpSolrClient SolrClient;
	private Ricerca ricerca;


	public GestoreQuery() {
	}


	public QueryResponse mandaQuery() throws Exception {
		SolrClient = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		return SolrClient.query("DBLP", CreaQuery());
	}


	private SolrParams CreaQuery() {
		HashMap <String, String> par = new HashMap <String, String>();
		par.put("q", ricerca.getCampoString());
		par.put("start", ricerca.getCampo().getPosizioneString());
		
		SolrParams params = new MapSolrParams(par);
		return params;
	}


	public void setRicerca(Ricerca ricerca) {
		this.ricerca = ricerca;
	}

}
