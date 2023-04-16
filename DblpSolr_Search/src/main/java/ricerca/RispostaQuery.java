package ricerca;

import java.util.ArrayList;
import org.apache.solr.common.SolrDocument;

public interface RispostaQuery {
	
	public ArrayList<SolrDocument> getResponse(Ricerca ricerca) throws Exception;
	
}
