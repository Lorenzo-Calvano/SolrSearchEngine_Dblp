package gui;

import java.util.ArrayList;

import entities.Documento;
import entities.PaginaAutore;

public class HTMLPresenter {
	
	public static String ResAut(PaginaAutore doc) {
		String html= new String("");
		html += "<html> <body> <h1>";
		html+= doc.getNome().split("0")[0];
		html+= "</h1>  <p>";
		html+= doc.getNote();
		html+= "</p> </body> </html>";
		
		return html;
	}
	
	public static String ResDoc(Documento doc) {
		String html= new String("");
		html += "<html> <body> <h1>";
		html+= doc.getCopertina().getTitolo();
		html+= "</h1>  <p>";
		
		String h = HTMLPresenter.RappAut(doc);
		html+= h.substring(h.indexOf(">")+1, h.lastIndexOf("<"));
		
		html+= "</p> </body> </html>";
		
		return html;
	}
	
	public static String RappAut(Documento doc) {
		ArrayList <String> autori = doc.getCopertina().getAutori();
		String html = new String("<html> ");
		
		if(autori.isEmpty()) {
			html+=" </html>";
			return html;
		}
		
		for (String aut: autori) {
			html+=aut.split("0")[0];
			html+=", ";
		}
		
		html = html.substring(0, html.lastIndexOf(","));
		html+=" </html>";
		return html;
	}
	
	public static String RappTit(Documento doc) {
		String html = new String("<html> ");
		html+=" <body> <h1> ";
		html+=doc.getCopertina().getTitolo();
		html+=" </h1> </body>";
		html+="</html>";
		return html;
	}
}
