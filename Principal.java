package Operacoes;

import java.io.*;
import java.awt.*;
import Janela.*;

import org.json.simple.parser.ParseException;


public class Principal {
public static void main(String[] args){
	    PainelGeral frame = new PainelGeral();
		try {		
		frame.Mostrar();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}