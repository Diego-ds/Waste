public class Inert extends Waste{
	//Atributos
	private String tip;
	//Constructor
public Inert(String id,String name,String origin,String color,int time,Product prod,String tip){
	super(id,name,origin,color,time,prod);
	this.tip=tip;
}
}