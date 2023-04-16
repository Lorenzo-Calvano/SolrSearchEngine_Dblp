package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UpdateConn {
	
	public void Upd() throws IOException, Exception {
		
		URL url = new URL("http://localhost:8983/solr/prova1/update?commit=true&tr=trasformazione.xsl");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("Content-Type", "text/xml");

		httpConn.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
		BufferedWriter w = new BufferedWriter(writer);
		FileToURL(w);
		writer.close();
		httpConn.getOutputStream().close();
		
		
		InputStream responseStream = httpConn.getResponseCode() / 100 == 2 ? httpConn.getInputStream() : httpConn.getErrorStream();
				
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
		
		
		
	}
	
	private void FileToURL(BufferedWriter writer) throws IOException {
		
		File f = new File("C:\\Users\\Lorenzo\\Downloads\\DBLPSplit\\Risultati\\dblp_3.xml");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String k=null;
		while((k=reader.readLine()) != null) {
			writer.write(k);
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
