package Janela;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class LeitordeArq3c{

	File arquivoEscolhido;
		
	  public LeitordeArq3c(){  
	    JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        ".txt file", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(chooser);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("Você ecolheu o arquivo: " +
	            chooser.getSelectedFile().getName());
         arquivoEscolhido = chooser.getSelectedFile();
   
	   
	   
	   
	   
	}}}