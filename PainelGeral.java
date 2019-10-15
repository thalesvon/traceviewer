package Janela;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

import org.json.simple.parser.ParseException;

import Operacoes.Gerador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

//Thales Luis Von Sperling 13/0048755
public class PainelGeral extends JFrame implements WindowListener {
	JMenuBar menuBar;
	JMenu menuArquivo;
	JMenu menuAjuda;
	JPanel direita;
	JLabel baixo;
	JPanel cima;
	JPanel geral;
	JButton comeca;
	JPanel esquerda;
	JMenuItem menuSair;
	JMenuItem menuNovo;
	JMenuItem menuAbrir;
	JMenuItem menuSobre;
	JTextField texto;
	JTextField mostrandoips;
	JLabel digite;
	JLabel Start;
    File tracert;
    Gerador gerador;
    String ipDesejado;
	public PainelGeral(){
		super("Trace Viewer Software");
		addWindowListener(this);
	menuBar = new JMenuBar();
	menuArquivo = new JMenu("Arquivo");
	menuAjuda = new JMenu("Ajuda");
	menuNovo = new JMenuItem("Novo");
	menuAbrir = new JMenuItem("Abrir");
	menuSobre= new JMenuItem("Sobre");
	menuSair = new JMenuItem("Sair");
	comeca = new JButton();
	comeca.setSize(50, 10);
	mostrandoips = new JTextField();
	this.setJMenuBar(menuBar);	
	menuBar.add(menuArquivo); 
	menuBar.add(menuAjuda);
	menuArquivo.add(menuNovo);
	menuArquivo.add(menuAbrir);
	menuArquivo.add(menuSair);
	menuAjuda.add(menuSobre);
	mostrandoips.setSize(200, 200);
	geral = (JPanel) this.getContentPane();
	geral.setLayout(new BorderLayout());
	cima = new JPanel(new GridLayout());
	direita = new JPanel(new FlowLayout());
	esquerda = new JPanel(new FlowLayout());
	baixo = new JLabel("Trace Viewer Software v1.0");
	digite = new JLabel("Digite o dominio : ");
	Start = new JLabel("Start");
	texto = new JTextField("globoesporte.com");//mudar para escolha do usuario
	ipDesejado = texto.getText();
	comeca.add(Start);
	cima.add(digite);
	cima.add(texto);
	cima.add(comeca);
	geral.add(direita,BorderLayout.EAST);
	geral.add(baixo,BorderLayout.SOUTH);
	geral.add(cima,BorderLayout.NORTH);
	direita.add(mostrandoips);
	menuAbrir.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
			   LeitordeArq3c selecao = new LeitordeArq3c();
			   tracert=selecao.arquivoEscolhido;
			   try {
			 gerador =new Gerador(tracert);
			 gerador.geocodificaIp();
			 System.out.println(gerador.getIp(0).getLatitude());
			 
			} catch (IOException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//nao testei esse paranaue ainda
		   }});
   comeca.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
			   ArquivoNovo arquivonovo= new ArquivoNovo(ipDesejado);
			  // try {
				 //  gerador =new Gerador(new File(ipDesejado+".txt"));
				  // gerador.geocodificaIp();
				//	 System.out.println(gerador.getIp(1).getCityName());
			//} catch (IOException | ParseException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//}
			
			   ////nao testei esse paranaue ainda
		   }});}


  
	

	public void Mostrar() throws IOException , ParseException{
		
		PainelGeral frame = new PainelGeral();
		frame.setSize(600 , 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
	    //Gerador gerador =new Gerador(tracert);
	    //gerador.geocodificaIp();
		//gerador.getIp(1).getLatitude();
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
	System.exit(0);
		
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}