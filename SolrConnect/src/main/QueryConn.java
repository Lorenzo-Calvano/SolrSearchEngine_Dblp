package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QueryConn {
	
	public void Quer() throws IOException {
		URL SolrQuery = new URL("http://localhost:8983/solr/prova1/select?q=*%3A*");
		HttpURLConnection Con1 = (HttpURLConnection) SolrQuery.openConnection();
		InputStream a =  (InputStream) Con1.getContent();
		BufferedReader ab = new BufferedReader(new InputStreamReader(a));
		String s = null;
		while((s=ab.readLine())!= null) {
			System.out.println(s);
		}
		ab.close();
	}
}
