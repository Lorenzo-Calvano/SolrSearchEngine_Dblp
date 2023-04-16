package ricerca;

import java.util.ArrayList;

import org.apache.solr.common.SolrDocument;

import entities.Proprietà;
import entities.Copertina;
import entities.PaginaAutore;
import entities.Documento;
import entities.Articolo;
import entities.Incollection;
import entities.Inproceedings;
import entities.Libro;
import entities.MastersThesis;
import entities.PhDThesis;
import entities.Proceedings;


public class ParserRisposta {

	ArrayList <SolrDocument> RisultatoQuery;

	public ArrayList<Documento> creaDocumenti(ArrayList<SolrDocument> Docum) {
		ArrayList <Documento> result = new ArrayList<Documento>();

		for(SolrDocument item : Docum) {
			Helper help= new Helper(item);
			Copertina c = new Copertina(help.key, help.title, help.autori);
			Proprietà p = new Proprietà(help.pages, help.volume);

			switch (help.type) {
			case "phdthesis":
				result.add(new PhDThesis(help.pub, help.scuola, help.isbn, c, p, help.anno, help.URLs));
				break;
			case "mastersthesis":
				result.add(new MastersThesis(help.scuola, help.isbn, c, p, help.anno, help.URLs));
				break;
			case "article":
				result.add(new Articolo(help.mese, help.giorn, c, p, help.anno, help.URLs));
				break;
			case "proceedings":
				result.add(new Proceedings(help.isbn, help.editor, help.titlib, help.pub, c, p, help.anno, help.URLs));
				break;
			case "incollection":
				result.add(new Incollection(help.titlib, help.rif, c, p, help.anno, help.URLs));
				break;
			case "book":
				result.add(new Libro(help.isbn, help.scuola, help.titlib, help.pub, c, p, help.anno, help.URLs));
				break;
			case "inproceedings":
				result.add(new Inproceedings(help.titlib, help.rif, c, p, help.anno, help.URLs));
				break;
			}
		}
		return result;
	}


	public ArrayList<PaginaAutore> creaPagineAutore(ArrayList<SolrDocument> Docum){
		ArrayList <PaginaAutore> result = new ArrayList<PaginaAutore>();

		for(SolrDocument item : Docum) {
			Helper help= new Helper((String) item.getFirstValue("author"), item);
			result.add(new PaginaAutore(help.editor, null, help.note));
		}

		return result;
	}

}
