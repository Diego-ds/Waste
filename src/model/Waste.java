package model;
public class Waste{

//Atributos
	private String id;
	private String name;
	private String origin;
	private String color;
	private int time;
	Product prod;
//Constructor
public Waste(String id,String name,String origin,String color,int time,Product prod){
	this.id=id;
	this.name=name;
	this.origin=origin;
	this.color=color;
	this.time=time;
	this.prod=prod;
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
public String getTime(){
	return time;
}

}