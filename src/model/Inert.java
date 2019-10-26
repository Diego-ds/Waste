public class Inert extends Waste{
	//Atributos
	private String tip;
	//Constructor
public Inert(String id,String name,String origin,String color,int time,String prodRef,String tip){
	super(id,name,origin,color,time,prodRef);
	this.tip=tip;
}
public double calcularEfectoNocivo(){
	double res = 0;
	res= super.calcularEfectoNocivo();
	return res;

}
}