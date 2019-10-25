public class WeRecycle{
//Atributos
	private String name;
	Waste res[];
	Product pro[];

//Constructor
public WeRecycle(String name){
	this.name=name;
	res = new Waste[50];
	pro = new Product[50];
}

public String addWaste(String id,String name,String origin,String color,int time,String prodRef,String type,String desc){
	Recycling rec = new Recycling(id,name,origin,color,time,prodRef,type,desc);
	boolean val =false;
	String msg ="";
	for (int i =0;i<res.length && !val ;i++ ) {
		if(res[i]==null){
			res[i]=rec;
			val=true;
			msg="Waste added sucessfully";
		}
	}
	return msg;

}

public String addWaste(String id,String name,String origin,String color,int time,String prodRef,String tip){
	Inert rec = new Inert(id,name,origin,color,time,prodRef,tip);
	boolean val =false;
	String msg ="";
	for (int i =0;i<res.length && !val ;i++ ) {
		if(res[i]==null){
			res[i]=rec;
			val=true;
			msg="Waste added sucessfully";
		}
	}
	return msg;

}
public String addWaste(String id,String name,String origin,String color,int time,String prodRef,boolean compost){
	BioDegradable rec = new BioDegradable(id,name,origin,color,time,prodRef,compost);
	boolean val =false;
	String msg ="";
	for (int i =0;i<res.length && !val ;i++ ) {
		if(res[i]==null){
			res[i]=rec;
			val=true;
			msg="Waste added sucessfully";
		}
	}
	return msg;

}

public Product buscarProducto(String id){
	boolean val=false;
	Product obj =null;
	for (int i =0;i<pro.length && !val ;i++ ) {
		if(pro[i].getId().equalsIgnoreCase(id)){
			obj=pro[i];
			val=true;
		}
	}
	return obj;

}


}