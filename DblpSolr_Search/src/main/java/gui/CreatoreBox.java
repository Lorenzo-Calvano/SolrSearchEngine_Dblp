package gui;

import java.util.ArrayList;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JLabel;

import entities.Documento;
import entities.PaginaAutore;

public class CreatoreBox {

	public static ArrayList<Box> Boxes(ArrayList<?> oggetti, ArrayList<JButton> bottoni){
		ArrayList <Box> boxes = new ArrayList <Box>();
		if(oggetti == null)
			return boxes;

		for (int i=0; i<oggetti.size(); i++) {
			Box box = null;
			if(oggetti.get(i) instanceof Documento)
				box = CreatoreBox.Docum((Documento)oggetti.get(i), bottoni.get(i));
			else if (oggetti.get(i) instanceof PaginaAutore)
				box = CreatoreBox.PagAut((PaginaAutore) oggetti.get(i), bottoni.get(i));

			boxes.add(box);
		}
		
		return boxes;
	}

	private static Box Docum(Documento doc, JButton visualizza) {
		Box box = Box.createVerticalBox();

		JLabel titolo = new JLabel(HTMLPresenter.ResDoc(doc));
		
		box.add(titolo);
		box.add(Box.createVerticalStrut(15));
		box.add(visualizza);
		

		return box;
	}

	private static Box PagAut(PaginaAutore doc, JButton visualizza) {
		Box box = Box.createVerticalBox();

		JLabel nomeautore = new JLabel(HTMLPresenter.ResAut(doc));
		box.add(nomeautore);
		box.add(Box.createVerticalStrut(15));
		box.add(visualizza);
		return box;

	}

}
