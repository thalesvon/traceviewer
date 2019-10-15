package Operacoes;
public class Ip{//Não há necessidade de métodos do tipo set por que essa classe será carregada SEMPRE pelo gson que usa o objeto JSON recebido da api
public String statusCode;
public String countryName;
public String zipCode;
public String cityName;
public String regionName;
public String countryCode;
public String timeZone;
public String longitude;
public String latitude;
public String ipAddress;

public String getStatusCode(){
	return statusCode;
	
}
public String getCountryName(){
	return countryName;
}
public String getCountryCode(){
	return countryCode;
	
}
public String getCityName(){
	return cityName;
	
}
public String getRegionName(){
	return regionName;
}
public String getTimeZone(){
	return timeZone;
}
public String getLongitude(){
	return longitude;
}
public String getLatitude(){
	return latitude;
}
public String getIpAddress(){
	return ipAddress;
}

public String toString(){
	return getLatitude()+","+getLongitude()+"|";
	
}
public String formataCoordenadas(int posicao){
	if(posicao==0){
		return "&markers=color:red|label:F|"+this.toString();//o primeiro ip � o de destino.F de final ehehhe

	}
	else{
	
	return "&markers=color:red|label:"+(posicao-1)+"|"+this.toString();// a coordenada na posicao 1 � a 0,0 logo o de posicao 2 � o primeiro e assim sucessivamente
}
}}
