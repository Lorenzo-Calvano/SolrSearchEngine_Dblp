package gui;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Documento;
import entities.Incollection;
import entities.Inproceedings;

public class LinkLabelsCreator {
	
	public JPanel createLinks(Documento doc) {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel(HTMLPresenter.RappAut(doc)));
		p.add(Box.createVerticalStrut(20));
		
		ArrayList <String> links = doc.getURLs();
		for(int i=0; i<links.size(); i++) 
			p.add(new LinkLabel(links.get(i)));
		
		if(doc instanceof Inproceedings) {
			p.add(new JLabel("Conferenza: "+ ((Inproceedings) doc).getTitolo_libro()));
		}
		
		if(doc instanceof Incollection) {
			p.add(new JLabel("Libro: "+ ((Incollection) doc).getTitolo_libro()));
		}
		
		p.add(Box.createVerticalStrut(20));
		return p;
		
	}
}
