  package controller;

import java.util.ArrayList;

import entities.Documento;
import entities.PaginaAutore;
import ricerca.Campo;
import ricerca.Ricerca;
import ricerca.RicercaAutore;
import ricerca.RicercaDocumenti;


public class EventHandler {

	private CreatorePannelli creat;
	private Responder responder;
	private Ricerca rice;
	private Ricerca riceRis;
	private ArrayList <Documento> testi;
	private ArrayList <PaginaAutore> autori;
	private String nomeaut;


	public EventHandler(CreatorePannelli creat, Responder responder) {
		this.responder=responder;
		this.creat=creat;
	}

	public void Inizio() {
		creat.CreaPannelloPrincipale(this.responder);
	}

	public void Ricerca(String testo) {
		if(this.responder.getDOC().isSelected()) {
			rice = new RicercaDocumenti(this.createCampo(testo));
			testi=(ArrayList <Documento>) rice.mostraRisultati();
			creat.CreaPannelloRicerca(testi);
		}
		else if(this.responder.getWEB().isSelected()) {
			rice = new RicercaAutore(new Campo("author", testo));
			autori=(ArrayList <PaginaAutore>) rice.mostraRisultati();
			creat.CreaPannelloRicerca(autori);
		}
	}

	public void ProssimiRisultati() {
		if(rice instanceof RicercaDocumenti && this.rice.getCampo().getPosizioneInt()+10>testi.size())
			return;
		if (rice instanceof RicercaAutore && this.rice.getCampo().getPosizioneInt()+10>autori.size())
			return;

		if(riceRis==null)
			creat.CreaPannelloRicerca(this.prossimo());
		else
			creat.CreaPannelloSito(this.prossimo(), nomeaut.split("0")[0]);

	}

	public void PrecedentiRisultati() {
		if (this.rice.getCampo().getPosizioneInt()==0)
			return;

		if(riceRis==null)
			creat.CreaPannelloRicerca(this.precedente());
		else
			creat.CreaPannelloSito(this.precedente(), nomeaut.split("0")[0]);
	}

	public void Visualizza(int posizione) {
		posizione+=this.rice.getCampo().getPosizioneInt();
		if (rice instanceof RicercaDocumenti)
			this.CreaDocumento(posizione);
		else
			this.CreaSito(posizione);
	}

	public void TornaAiSiti() {
		rice=riceRis;
		riceRis=null;
		creat.CreaPannelloRicerca((ArrayList<PaginaAutore>) this.rice.mostraRisultati());
	}



	private void CreaSito(int posizione) {
		riceRis=rice;
		this.nomeaut = autori.get(posizione).getNome();
		rice=new RicercaDocumenti(new Campo("author", "\""+ nomeaut + "\""));
		testi = (ArrayList<Documento>) this.rice.mostraRisultati();
		creat.CreaPannelloSito(testi, nomeaut.split("0")[0]);
	}

	private void CreaDocumento(int posizione) {
		creat.CreaPannelloDocumento(testi.get(posizione));
	}

	private ArrayList<?> prossimo(){
		this.rice.nextPos();
		int pos = this.rice.getCampo().getPosizioneInt();

		if(rice instanceof RicercaDocumenti) {
			ArrayList <Documento> show = new ArrayList <Documento>();
			if(pos==testi.size()) {
				show.addAll((ArrayList<Documento>) this.rice.mostraRisultati());
				testi.addAll(show);
			}
			else
				show.addAll(testi.subList(pos, pos + Math.min(10, testi.size()-pos)));
			return show;
		}
		else {
			ArrayList <PaginaAutore> show = new ArrayList <PaginaAutore>();
			if(pos==autori.size()) {
				show.addAll((ArrayList<PaginaAutore>) this.rice.mostraRisultati());
				autori.addAll(show);
			}
			else
				show.addAll(autori.subList(pos, pos + Math.min(10, autori.size()-pos)));
			return show;
		}	
	}

	private ArrayList<?> precedente(){
		this.rice.prevPos();
		int pos = this.rice.getCampo().getPosizioneInt();
		ArrayList <?> show = null;
		if(rice instanceof RicercaDocumenti) 
			show = new ArrayList <Documento>(testi.subList(pos, pos + Math.min(10, testi.size()-pos)));
		else 
			show = new ArrayList <PaginaAutore>(autori.subList(pos, pos + Math.min(10, autori.size()-pos)));

		return show;
	}
	
	private Campo createCampo(String testo) {
		Campo fields = null;
		
		if(this.responder.getAut().isSelected())
			fields= new Campo("author", "\""+ testo + "\"");
		else if (this.responder.getTit().isSelected())
			fields= new Campo("title", "\""+ testo + "\"");
		else
			fields= new Campo("_text_", testo );
		
		return fields;
	}
}
