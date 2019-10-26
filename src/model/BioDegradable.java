public class BioDegradable extends Waste{
	//Atributos
	private boolean compost;
	//Constructor
public BioDegradable(String id,String name,String origin,String color,int time,String prodRef,boolean compost){
	super(id,name,origin,color,time,prodRef);
	this.compost=compost;
}
//Getters
public int getTime(){
	return super.getTime();
}
public double calcularEfectoNocivo(){
	double res = 0;
if(compost){
	res=super.calcularEfectoNocivo()-this.getTime()*0.01;
}
else{
	res=super.calcularEfectoNocivo();
}

return res;

}
}