public class BioDegradable extends Waste{
	//Atributos
	private boolean compost;
	//Constructor
public BioDegradable(String id,String name,String origin,String color,int time,Product prod,boolean compost){
	super(id,name,origin,color,time,prod);
	this.compost=compost;
}
}