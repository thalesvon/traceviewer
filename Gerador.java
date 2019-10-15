package Operacoes;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.*;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
//dudugay

public class Gerador {
private String[] ips;

private Ip[]ipcoordenadas;


public Gerador(File tracert) throws IOException{//Construtor que já exige o arquivo do traceroute para poder separar as ips
	byte[]array;
	FileInputStream fis= new FileInputStream(tracert);
	int tamanho = (int)tracert.length();
	array= new byte[tamanho];
	fis.read(array);
	String lido = new String(array);
	ips = StringUtils.substringsBetween(lido, "[", "]");// método da biblioteca apache.commons.lang, o primeiro argumento é a a string que deseja ser separada e os outros dois são os limitantes!
}
public void geocodificaIp () throws IOException, ParseException{//metódo que converte os endereços ips recebidos em coordenadas e cria objetos do tipo Ip
	JSONObject jsonObjeto;
	JSONParser parser = new JSONParser();
	Gson gson= new Gson();
	Ip[] ip= new Ip[ips.length];
	//String coordenadas= "|";
	for(int i=0;i<=ips.length-1;i++){
	URL url=new URL("http://api.ipinfodb.com/v3/ip-city/?key=3dce9b9cdcca574ce3026f1a3ec95275b706de39f31ad62b6103a409e1f710f5&ip="+ips[i]+"&format=json");//chamada da api da ipinfodb a key é distribuida gratuitamente no site da api
		Reader br= new InputStreamReader(url.openStream());
	jsonObjeto=(JSONObject) parser.parse(br);//pega o objeto do site
		//System.out.println(jsonObjeto);
		String r=jsonObjeto.toJSONString();//transforma em string só para poder usar o gson
		//System.out.println(r);
		//Ips[] ip= new Ips[ips.length];
		ip[i]= gson.fromJson(r, Ip.class);//transforma o objeto recebido em outro da classe ip com o gson
	}
	ipcoordenadas= ip;

}
public Ip getIp(int posicao){//método de acesso aos objetos do tipo Ip(encapsulamento)
	return ipcoordenadas[posicao];
}
public URL gerarMapa () throws MalformedURLException{//Metodo que gera a URL que contem o mapa usando a api do google
	String mapa="http://maps.googleapis.com/maps/api/staticmap?size=600x600";// parte da url que especifica as caracteristicas do mapa, nesse caso apenas o size
	for(int i=2;i<=this.ipcoordenadas.length-1;i++){// -1 por que o ultimo ip é igual ao primeiro(posicao 0) que é o de destino.
		mapa=mapa.concat(this.ipcoordenadas[i].formataCoordenadas(i));
	}
	mapa= mapa+"&format=jpg";//especificação do formato que o mapa será gerado.
	URL linkmapa= new URL(mapa);
	return linkmapa;
	}
}