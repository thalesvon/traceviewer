package Janela;


import java.io.IOException;

import javax.swing.JOptionPane;



public class ArquivoNovo  {

	
	public ArquivoNovo(String ipDesejado){


	String comando ="cmd /c tracert "+ipDesejado+">"+ipDesejado+".txt";
	try {
		Runtime.getRuntime().exec(comando);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}