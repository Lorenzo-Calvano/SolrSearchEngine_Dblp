package ricerca;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.common.SolrDocument;

public class Helper {

	protected String title;
	protected String key;
	protected String pages;
	protected String volume;
	protected ArrayList <String> URLs;
	protected String pub;
	protected String scuola;
	protected String isbn;
	protected int anno;
	protected ArrayList <String> autori;
	protected String mese;
	protected String giorn;
	protected String editor;
	protected String titlib;
	protected String rif;
	protected String type;
	protected String note;
	
	public Helper(SolrDocument item) {
		type = (String) item.getFirstValue("type");
		title = (String) item.getFirstValue("title");
		key = (String) item.getFirstValue("key");
		pages = (String) item.getFirstValue("pages");
		volume = (String) item.getFirstValue("volume");
		pub = (String) item.getFirstValue("publisher");
		scuola = (String) item.getFirstValue("school");
		isbn = (String) item.getFirstValue("isbn");
		anno = this.getYear(item);
		autori = this.getAuthorsArray(item);
		mese = (String) item.getFirstValue("month");
		giorn = (String) item.getFirstValue("journal");
		editor = (String) item.getFirstValue("editor");
	    titlib = (String) item.getFirstValue("booktitle");
		rif = (String) item.getFirstValue("crossref");
		URLs = this.getURLArray(item);
	}
	
	public Helper(String autore, SolrDocument item) {
		this.type= (String) item.getFirstValue("type");
		this.editor=autore;
		this.URLs= this.getURLArray(item);
		this.note= (String) item.getFirstValue("note");
		
	}
	
	
	private int getYear(SolrDocument doc) {
		Integer anno = (Integer) doc.getFirstValue("year");
		if (anno== null)
			return 0;
		int ret = anno;
		return ret;
	}
	
	private ArrayList<String> getAuthorsArray(SolrDocument item) {
		Collection<Object> fieldValues = item.getFieldValues("author");
		return RetList(fieldValues);

	}
	
	private ArrayList <String> getURLArray(SolrDocument item) {
		Collection<Object> fieldValues = item.getFieldValues("ee");
		
		if(fieldValues == null)
			fieldValues = item.getFieldValues("url");
		
		else if (item.getFieldValues("url")!=null)
			fieldValues.addAll(item.getFieldValues("url"));
			
		return RetList(fieldValues);
	}
	
	private ArrayList <String> RetList(Collection<Object> fieldValues){
		ArrayList <String> List = new ArrayList <String>();
		
		if(fieldValues == null)
			return List;
		
		for (Object elem: fieldValues) {
			List.add((String) elem);
		}
		
		return List;
	}
}
