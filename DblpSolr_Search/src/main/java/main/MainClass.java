package main;


import controller.Responder;

import gui.DblpSolr_Search;
import gui.InterfaceCreator;


public class MainClass {

	public static void main(String[] args) throws Exception {
		
		Responder resp = new Responder(new InterfaceCreator(new DblpSolr_Search()));
		resp.test();
		
	}

}
