public class Inert extends Waste{
	//Atributos
	private String tip;
	//Constructor
public Inert(String id,String name,String origin,String color,int time,String prodRef,String tip){
	super(id,name,origin,color,time,prodRef);
	this.tip=tip;
}
//Getters
public int getTime(){
	return super.getTime();
}
public String getName(){
	return super.getName();
}
public String getOrigin(){
	return super.getOrigin();
}
public String getColor(){
	return super.getOrigin();
}
public String getId(){
	return super.getId();
}
public double calcularEfectoNocivo(){
	double res = 0;
	res= super.calcularEfectoNocivo();
	return res;

}
public String toString(){
	String msg = "";
	msg = getName() + "\nId: "+getId()+"\nOrigin: "+getOrigin()+"\nColor: "+getColor()+"\n"+getTime()+" days to decompose"+"\nTip: "+this.tip+"\n";
	return msg;
}
}
