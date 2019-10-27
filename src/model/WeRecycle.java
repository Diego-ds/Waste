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

public String addProduct(String id,String name,String desc){
	Product obj = new Product(id,name,desc);
	boolean val = false;
	String msg = "";
	if(buscarProducto(id)==null){
		for (int i =0;i<pro.length && !val ;i++ ) {
			if(pro[i]==null){
				pro[i]=obj;
				msg="Product added sucessfully";
				val=true;
			}
		}
	}
	else{
		msg="Error: The product is already registered.";
	}
	return msg;
}

public String showNociveEffect(String n){
	boolean val = false;
	String msg = "";
	for (int i = 0;i<res.length && !val ;i++ ) {
		if(buscarWaste(n)!=null){
			if(buscarWaste(n) instanceof BioDegradable){
				BioDegradable obj = (BioDegradable) buscarWaste(n);
				String noc = String.valueOf(obj.calcularEfectoNocivo());
				msg= "The nocive effect of the waste "+obj.getName()+" identified as "+obj.getId()+ " is "+noc+"\n";
				val = true;
			}
			else if(buscarWaste(n) instanceof Recycling){
				Recycling obj = (Recycling) buscarWaste(n);
				String noc = String.valueOf(obj.calcularEfectoNocivo());
				msg= "The nocive effect of the waste "+obj.getName()+" identified as "+obj.getId()+ " is "+noc+"\n";
				val = true;
			}
			else{
				Inert obj = (Inert) buscarWaste(n);
				String noc = String.valueOf(obj.calcularEfectoNocivo());
				msg= "The nocive effect of the waste "+obj.getName()+" identified as "+obj.getId()+ " is "+noc+"\n";
				val = true;
			}
		}
		else{
			msg= "Error: Waste cannot be found. Please try again";
			val=true;
		}
	}
	return msg;
}

public String isUsable(String n){
	String msg = "";
	boolean val;
	if(buscarWaste(n)!=null){
		if(buscarWaste(n) instanceof BioDegradable){
			BioDegradable obj = (BioDegradable)buscarWaste(n);
		 	val=obj.aprovechable();
		 	msg= obj.getName()+" identified as "+obj.getId()+" is usable? "+ val;
		}
		else if(buscarWaste(n) instanceof Recycling){
			Recycling obj = (Recycling)buscarWaste(n);
		 	val=obj.aprovechable();
		 	msg= obj.getName()+" identified as "+obj.getId()+" is usable? "+ val;
		}
		else{
			msg ="Error: the waste isn't biodegradable or recyclable";
		}
	}
	else{
		msg="Error: Cannot found waste. Please try again";
	}
	return msg;
}

public Product buscarProducto(String id){
	boolean val=false;
	Product obj =null;
	for (int i =0;i<pro.length && !val ;i++ ) {
		if(pro[i]!=null){
			if(pro[i].getId().equalsIgnoreCase(id)){
				obj=pro[i];
				val=true;
			}
		}
		else{
			val=true;
		}
	}
	return obj;

}

public Waste buscarWaste(String name){
	boolean val =false;
	Waste obj = null;
	for (int i =0;i<res.length && !val ;i++ ) {
		if(res[i]!=null){
			if(res[i].getName().equalsIgnoreCase(name)){
				obj=res[i];
				val=true;
			}
		}
		else{
			val = true;
		}
	}
	return obj;
}

public String searchWaste(String n){
	boolean val = true;
	String msg = "";
	if(buscarWaste(n)!=null){
		msg = buscarWaste(n).toString();
	}
    else if(buscarProducto(n)!=null){
    	msg = buscarProducto(n).displayWaste();
    }
    else{
    	msg ="Error: Waste not found. Please try again";
    }
    return msg;


}
public String showProd(){
	String msg = "You have not registered products yet. Type something to continue\n";
	boolean val = false;
	for (int i =0;i<pro.length && !val ;i++ ) {
		if(pro[i]!=null){
			msg= "";
			msg+=pro[i].toString();
		}
		else{
			val=true;
		}
	}
	return msg;
}

public String showWaste(){
	String msg = "\nBiodegradable: \n";
	String msg2= "\nRecyclable: \n";
	String msg3= "\nInert: \n";
	boolean val = false;
	for (int i =0;i<res.length && !val ;i++ ) {
		if(res[i]!=null){
			if(res[i] instanceof BioDegradable){
				BioDegradable obj = (BioDegradable) res[i];
				msg+= obj.toString();
			}
			else if(res[i] instanceof Recycling){
				Recycling obj1 = (Recycling) res[i];
				msg2+=obj1.toString();
			}
			else{
				Inert obj2 = (Inert) res[i];
				msg3+=obj2.toString();
			}
		}
		else{
			val =true;
		}
		
	}

	return msg+msg2+msg3;

}


}