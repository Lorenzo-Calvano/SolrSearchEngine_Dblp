package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Responder;

public class TopPartCreator {
	
	Responder responder;
	
	public TopPartCreator(Responder responder) {
		this.responder=responder;
	}
	
	
	public JPanel createSearch() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(this.responder.getTextField());
		panel.add(this.responder.getCerca());
		panel.add(this.responder.getDOC());
		panel.add(this.responder.getWEB());
		
		/*JPanel check= new JPanel();
		check.add(new JLabel("ricerca per (default parole-chiave): "));
		check.add(this.responder.getAut());
		check.add(this.responder.getTit());
		check.add(this.responder.getKey());*/
		
		JPanel search = new JPanel(new BorderLayout());
		
		search.add(panel, BorderLayout.CENTER);
		//search.add(check, BorderLayout.SOUTH);
		
		return search;
	}
	
	public JPanel createTopBar(String nomeautore) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JLabel Autore = new JLabel(nomeautore);
		Autore.setFont(new Font(null, Font.BOLD, 25));
		
		panel.add(this.responder.getIndSit());
		panel.add(Box.createHorizontalStrut(45));
		panel.add(Autore);
		return panel;
	}
}
