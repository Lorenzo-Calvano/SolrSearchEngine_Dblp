package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Responder implements ActionListener{

	private JTextField campoRicerca  = new JTextField();
	private JButton cerca = new JButton("Cerca");
	private JButton avanti = new JButton("Avanti");
	private JButton indietro = new JButton("Indietro");
	private JButton indSit = new JButton("Torna agli autori");
	private JRadioButton DOC = new JRadioButton("Documenti");
	private JRadioButton WEB = new JRadioButton("Pagine d'autore");
	private JRadioButton aut = new JRadioButton("autori");
	private JRadioButton tit = new JRadioButton("titolo");
	private JRadioButton key = new JRadioButton("parole-chiave");
	private ArrayList <JButton> visualDoc;

	private EventHandler Evento;


	public Responder(CreatorePannelli creat) {
		this.Evento= new EventHandler(creat, this);
		this.campoRicerca.setColumns(20);
		this.cerca.addActionListener(this);
		this.avanti.addActionListener(this);
		this.indietro.addActionListener(this);
		this.indSit.addActionListener(this);
		ButtonGroup scelta = new ButtonGroup();
		scelta.add(this.DOC);
		scelta.add(this.WEB);
		ButtonGroup ricerca = new ButtonGroup();
		ricerca.add(this.aut);
		ricerca.add(this.tit);
		ricerca.add(this.key);
	}


	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();

		if(event==cerca) {
			String testo = this.campoRicerca.getText();
			if(testo.isBlank())
				return;

			Evento.Ricerca(testo);
		}

		if (event == avanti)
			Evento.ProssimiRisultati();

		if (event == indietro)
			Evento.PrecedentiRisultati();

		if (visualDoc !=null && visualDoc.contains(event)){
			int posizione = visualDoc.indexOf(event);
			Evento.Visualizza(posizione);
		}

		if(event == indSit)
			Evento.TornaAiSiti();

	}


	public void test() {
		Evento.Inizio();
	}


	public void addVisDoc(ArrayList<JButton> bottoni) {
		this.visualDoc=bottoni;
		for (JButton bott: visualDoc) {
			bott.addActionListener(this);
		}
	}

	public JButton getCerca() {
		return this.cerca;
	}

	public JTextField getTextField() {
		return this.campoRicerca;
	}

	public JButton getAvanti() {
		return this.avanti;
	}

	public JButton getIndietro() {
		return this.indietro;
	}

	public JButton getIndSit() {
		return this.indSit;
	}

	public JRadioButton getDOC() {
		return this.DOC;
	}

	public JRadioButton getWEB() {
		return this.WEB;
	}

	public JRadioButton getTit() {
		return this.tit;
	}
	
	public JRadioButton getAut() {
		return this.aut;
	}
	
	public JRadioButton getKey() {
		return this.key;
	}

}