package model;

public class BioDegradable extends Waste implements Usable{
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
public String getName(){
	return super.getName();
}
public String getOrigin(){
	return super.getOrigin();
}
public String getColor(){
	return super.getColor();
}
public String getId(){
	return super.getId();
}
@Override
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
//Convert the waste to a String
public String toString(){
	String msg = "";
	msg = "-------------------------------------\n"+getName() + "\nId: "+getId()+"\nOrigin: "+getOrigin()+"\nColor: "+getColor()+"\n"+getTime()+" days to decompose"+"\nAble to compose?: "+this.compost+"\n";
	return msg;
}
//Interface method implemented
public boolean aprovechable(){
	boolean val = false;
	if(getTime()<365 && compost==true){
		val = true;
	}
	return val;
}
}