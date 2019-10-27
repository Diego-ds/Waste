public class Product{
//Atributos
	private String id;
	private String name;
	private String desc;
	Waste residuos[];
//Constructor
public Product(String id,String name,String desc){
	this.id=id;
	this.name=name;
	this.desc=desc;
	residuos=new Waste[20];
}
//Getters
public String getId(){
	return id;
}
public String getName(){
	return name;
}

public String addWasteProd(Waste obj){
	boolean val =false;
	String msg = "";
	for (int i =0;i<residuos.length && !val ;i++ ) {
		if(residuos[i]==null){
			residuos[i]=obj;
			val = true;
			msg= "Waste added sucesfully to the product";
		}
	}
	return msg;

}

public String toString(){
	String msg ="";
	msg= "Name: "+name+"Id: "+id+"Description: "+desc+"\n";
	return msg;
}
public String displayWaste(){
	String msg="";
	boolean val = false;
	for (int i =0;i<residuos.length && !val ;i++ ) {
		if(residuos[i]!=null){
			if(residuos[i] instanceof BioDegradable){
				BioDegradable obj = (BioDegradable)residuos[i];
				msg+= obj.toString();
			}
			else if(residuos[i] instanceof Recycling){
				Recycling obj1 = (Recycling)residuos[i];
				msg+=obj1.toString();
			}
			else{
				Inert obj2 = (Inert)residuos[i];
				msg+=obj2.toString();
			}
		}
	}
	return msg;
}
}