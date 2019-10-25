public abstract class Waste{

//Atributos
	private String id;
	private String name;
	private String origin;
	private String color;
	private int time;
	private String prodRef;
	public static final String INDUSTRIAL ="Industrial";
	public static final String DOMICILIARIO ="Domiciliario";
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


}