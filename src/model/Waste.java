package model;
public abstract class Waste{

//Atributos
	private String id;
	private String name;
	private String origin;
	private String color;
	private int time;
	private String prodRef;
	public static final String INDUSTRIAL ="Industrial";
	public static final String DOMICILIARIO ="Domiciliary";
	public static final String MUNICIPAL ="Municipal";
	public static final String CONSTRUCCION ="Construction";
	public static final String HOSPITALARIO ="Hospitalary";
//Constructor
public Waste(String id,String name,String origin,String color,int time,String prodRef){
	this.id=id;
	this.name=name;
	this.origin=origin;
	this.color=color;
	this.time=time;
	this.prodRef=prodRef;
}
//Getters
public String getId(){
	return id;
}
public String getName(){
	return name;
}
public String getOrigin(){
	return origin;
}
public String getColor(){
	return color;
}
public int getTime(){
	return time;
}

public double calcularEfectoNocivo(){
	double res = 0;
	if(origin.equalsIgnoreCase(Waste.INDUSTRIAL)){
		res = time*0.10;
	}
	else if(origin.equalsIgnoreCase(Waste.DOMICILIARIO)){
		res=time*0.05;
	}
	else if(origin.equalsIgnoreCase(Waste.CONSTRUCCION)){
		res=time*0.08;
	}
	else if(origin.equalsIgnoreCase(Waste.MUNICIPAL)){
		res=time*0.12;
	}
	else {
		res=time*0.15;
	}
	
	return res;
}

}