public class Recycling extends Waste{
//Atributos
	public static final String PAPER = "Paper";
	public static final String PAPERBOARD = "Paperboard";
	public static final String PLASTIC = "Plastic";
	public static final String GLASS  = "Glass";
	private String type;
	private String desc;
	//Constructor
public Recycling(String id,String name,String origin,String color,int time,String prodRef,String type,String desc){
	super(id,name,origin,color,time,prodRef);
	this.type=type;
	this.desc=desc;
}
public double calcularEfectoNocivo(){

}
}