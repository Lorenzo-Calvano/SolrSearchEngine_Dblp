package gui;

import java.util.ArrayList;

import javax.swing.JButton;

import controller.Responder;


public class ButtonsCreator {
	
	private Responder responder;
	
	public ButtonsCreator(Responder responder) {
		this.responder=responder;
	}
	
	public ArrayList <JButton> inizializeBottons(int lenght){
		ArrayList <JButton> bottoni = new ArrayList <JButton>();
		for(int i=0; i<lenght; i++) {
			JButton visualizza = new JButton("visualizza");
			bottoni.add(visualizza);
		}
		
		this.responder.addVisDoc(bottoni);
		return bottoni;
	}
}
