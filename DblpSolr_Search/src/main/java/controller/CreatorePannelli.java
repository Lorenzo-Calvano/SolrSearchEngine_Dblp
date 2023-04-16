package controller;

import java.util.ArrayList;

import entities.Documento;

public interface CreatorePannelli {
	
	public void CreaPannelloPrincipale(Responder responder);
	
	public void CreaPannelloRicerca(ArrayList <?> risultati);
	
	public void CreaPannelloDocumento(Documento doc);
	
	public void CreaPannelloSito(ArrayList<?> documenti, String nomeautore);
	
}
