package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;


public class DblpSolr_Search {

	private JFrame frame;

	public DblpSolr_Search() {
		frame=new JFrame("Solr-Dblp Search");
		
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	

	public void showFrame(JScrollPane MidPart, JPanel TopPart, JPanel BottomPart) {

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(TopPart, BorderLayout.NORTH);
		panel.add(MidPart, BorderLayout.CENTER);
		panel.add(BottomPart, BorderLayout.SOUTH);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	public void showJDialog(JPanel DocView) {
		JDialog dialog = new JDialog(frame);
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setBounds(100, 100, 400, 400);
		dialog.add(DocView);
		dialog.pack();
		dialog.setVisible(true);
	}
}
