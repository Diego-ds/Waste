public class BioDegradable extends Waste{
	//Atributos
	private boolean compost;
	//Constructor
public BioDegradable(String id,String name,String origin,String color,int time,String prodRef,boolean compost){
	super(id,name,origin,color,time,prodRef);
	this.compost=compost;
}
}