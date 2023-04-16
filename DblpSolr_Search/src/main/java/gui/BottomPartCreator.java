package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;

import controller.Responder;

public class BottomPartCreator {
		private Responder responder;
		
		public BottomPartCreator(Responder responder) {
			this.responder=responder;
		}
		
		public JPanel Navigazione() {
			JPanel panel = new JPanel(new GridLayout(1,2));
			panel.add(this.responder.getIndietro());
			panel.add(this.responder.getAvanti());
			return panel;
		}
}
