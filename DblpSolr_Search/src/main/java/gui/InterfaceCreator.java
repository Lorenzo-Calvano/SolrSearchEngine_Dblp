package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.CreatorePannelli;
import controller.Responder;
import entities.Documento;

public class InterfaceCreator implements CreatorePannelli{
	
	private DblpSolr_Search app;
	private TopPartCreator TopPart;
	private MiddlePartCreator MiddlePart;
	private BottomPartCreator BottomPart;
	private ButtonsCreator Buttons;
	private LinkLabelsCreator Labels;
	
	public InterfaceCreator(DblpSolr_Search app) {
		this.app=app;
	}
	
	
	
	public void CreaPannelloPrincipale(Responder responder) {
	
		this.TopPart = new TopPartCreator(responder);
		this.MiddlePart = new MiddlePartCreator();
		this.BottomPart = new BottomPartCreator(responder);
		this.Buttons = new ButtonsCreator(responder);
		this.Labels = new LinkLabelsCreator();
		
		JPanel search = this.TopPart.createSearch();
		JScrollPane scroll = new JScrollPane();
		JPanel bottom = new JPanel();
		
		app.showFrame(scroll, search,  bottom);
	}
	
	public void CreaPannelloRicerca(ArrayList <?> risultati) {	
		
		JPanel search =  TopPart.createSearch();
		JScrollPane scroll = MiddlePart.createScrollPane(CreatoreBox.Boxes(risultati, Buttons.inizializeBottons(risultati.size())));
		JPanel bottom = BottomPart.Navigazione();
		
		app.showFrame(scroll, search, bottom);
	}

	
	public void CreaPannelloSito(ArrayList<?> documenti, String nomeautore) {
		
		JPanel topbar =  TopPart.createTopBar(nomeautore);
		JScrollPane scroll = MiddlePart.createScrollPane(CreatoreBox.Boxes(documenti,  Buttons.inizializeBottons(documenti.size())));
		
		JPanel bottom = BottomPart.Navigazione();
		
		app.showFrame(scroll, topbar, bottom);
	}

	public void CreaPannelloDocumento(Documento doc) {
		
		JLabel titolo = new JLabel(HTMLPresenter.RappTit(doc));
		
		
		JPanel up = new JPanel();
		up.add(new JLabel(doc.getClass().getSimpleName()));
		up.add(Box.createHorizontalStrut(30));
		up.add(new JLabel(doc.getAnnoString()));
		
		JPanel down = this.Labels.createLinks(doc);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(up, BorderLayout.SOUTH);
		panel.add(titolo, BorderLayout.NORTH);
		panel.add(down, BorderLayout.CENTER);
		
		app.showJDialog(panel);
	}
	
}
