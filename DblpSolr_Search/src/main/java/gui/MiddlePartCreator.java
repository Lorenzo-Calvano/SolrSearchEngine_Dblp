package gui;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class MiddlePartCreator {
	
	
	public MiddlePartCreator() {

	}
	
	public JScrollPane createScrollPane(ArrayList<Box> items) {
		
		JScrollPane scrollPane = new JScrollPane();
		
		Box verticalBox = this.contentScrollPane(items);
		scrollPane.setViewportView(verticalBox);
		
		return scrollPane;
	}

	private Box contentScrollPane(ArrayList<Box> boxes) {
		Box vertical = Box.createVerticalBox();

		if (boxes == null || boxes.size() == 0) {
			Box box = Box.createHorizontalBox();
			box.add(new JLabel("nessun risultato"));
			vertical.add(box);
			return vertical;
		}

		for (Box box : boxes) {
			vertical.add(box);
			vertical.add(Box.createVerticalStrut(20));
		}
		
		return vertical;
	}
	
}
