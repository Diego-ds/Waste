package model;
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
/**
* This method adds a waste <br>
* <b>post: </b> The waste has been added.<br>
* @param id Id of the waste. id != null &amp;&amp; id != "".
* @param name Name of the waste. name != null &amp;&amp; name != "".
* @param origin Origin of the waste. origin != null &amp;&amp; origin != "".
* @param color Color of the waste. color != null &amp;&amp; color != "".
* @param time Time to decompose. time != null &amp;&amp; time != "".
* @param prodRef The id of the product which produce the waste. prodRef != null &amp;&amp; prodRef != "".
* @param type Type of the waste. type != null &amp;&amp; type != "".
* @param desc Description of the waste. desc != null &amp;&amp; desc != "".
* @return msg Indicating that the waste was created. msg != null &amp;&amp; msg != "".
*/
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
/**
* This method adds a waste <br>
* <b>post: </b> The waste has been added.<br>
* @param id Id of the waste. id != null &amp;&amp; id != "".
* @param name Name of the waste. name != null &amp;&amp; name != "".
* @param origin Origin of the waste. origin != null &amp;&amp; origin != "".
* @param color Color of the waste. color != null &amp;&amp; color != "".
* @param time Time to decompose. time != null &amp;&amp; time != "".
* @param prodRef The id of the product which produce the waste. prodRef != null &amp;&amp; prodRef != "".
* @param tip Tip to manage this waste. tip != null &amp;&amp; tip != "".
* @return msg Indicating that the waste was created. msg != null &amp;&amp; msg != "".
*/

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
/**
* This method adds a waste <br>
* <b>post: </b> The waste has been added.<br>
* @param id Id of the waste. id != null &amp;&amp; id != "".
* @param name Name of the waste. name != null &amp;&amp; name != "".
* @param origin Origin of the waste. origin != null &amp;&amp; origin != "".
* @param color Color of the waste. color != null &amp;&amp; color != "".
* @param time Time to decompose. time != null &amp;&amp; time != "".
* @param prodRef The id of the product which produce the waste. prodRef != null &amp;&amp; prodRef != "".
* @param compost indicate if the waste is compostable. compost != null &amp;&amp; compost != "".
* @return msg Indicating that the waste was created. msg != null &amp;&amp; msg != "".
*/
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
/**
* This method adds a product <br>
* <b>post: </b> The product has been added.<br>
* @param id Id of the product. id != null &amp;&amp; id != "".
* @param name Name of the product. name != null &amp;&amp; name != "".
* @param desc Description of the product. desc != null &amp;&amp; desc != "".
* @return msg Indicating that the product was created. msg != null &amp;&amp; msg != "".
*/
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
/**
* This method show the nocive effect of a waste<br>
* <b>post: </b> The nocive effect has been displayed<br>
* @param n Name of the waste to look for. n != null &amp;&amp; n != "".
* @return msg Indicating the nocive of the waste. msg != null &amp;&amp; msg != "".
*/
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
			else if(buscarWaste(n) instanceof Inert){
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
/**
* This method calculate the nocive effect of a waste<br>
* <b>post: </b> The nocive effect has been calculated<br>
* @param n Name of the waste to look for. n != null &amp;&amp; n != "".
* @return noc The nocive effect of the waste. noc != null &amp;&amp; noc != "".
*/
public double calculateNociveEffect(String n){
	boolean val = false;
	String msg = "";
	double noc=0;
	for (int i = 0;i<res.length && !val ;i++ ) {
		if(buscarWaste(n)!=null){
			if(buscarWaste(n) instanceof BioDegradable){
				BioDegradable obj = (BioDegradable) buscarWaste(n);
				noc = obj.calcularEfectoNocivo();
				val = true;
			}
			else if(buscarWaste(n) instanceof Recycling){
				Recycling obj = (Recycling) buscarWaste(n);
				noc = obj.calcularEfectoNocivo();
				val = true;
			}
			else{
				Inert obj = (Inert) buscarWaste(n);
				noc = obj.calcularEfectoNocivo();
				val = true;
			}
		}

	}
	return noc;
}

/**
* This method determine if a biodegradable or recyclabe waste its usable<br>
* <b>post: </b> The waste has been cataloged<br>
* @param n Name of the waste to look for. n != null &amp;&amp; n != "".
* @return msg Indicating if the waste its usable or not. msg != null &amp;&amp; msg != "".
*/

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
/**
* This method order the waste of a product by its nocive from more to lower<br>
* <b>post: </b> The waste has been listed<br>
* @param n Id of the product to look for. n != null &amp;&amp; n != "".
* @return msg The wasted ordered in a chain text. msg != null &amp;&amp; msg != "".
*/
public String orderWaste(String n){
	String msg = "";
	boolean val = false;
    int cont = 0;
    Waste obj[]= new Waste[20];
    Waste aux;

    while(cont<pro.length && !val){
    	if(pro[cont]!=null){
    		if(pro[cont].getId().equalsIgnoreCase(n)){
    			obj=pro[cont].getWaste();

    			for (int i=0;i<obj.length && !val  ;i++ ) {
    				if(obj[i]!=null){
    					for (int j =0;j<obj.length;i++ ) {
    						if(calculateNociveEffect(obj[j].getName())>calculateNociveEffect(obj[j+1].getName())){
    							aux=obj[j+1];
    							obj[j+1]=obj[j];
    							obj[j]=aux;
    						}
    					}
    				}
    				else{
    					val=true;
    				}   			
    			}
    		}
    	}
    	else{
    		val=true;
    	}
    	cont++;
    }
	
	val = false;	
	for (int t=0;t<obj.length && !val ;t++ ) {
		if(obj[t]!=null){
			msg+=obj[t].toString();
		}
		else{
			val=true;
		}
	}
	return msg;
	
}
/**
* This method search a product by id <br>
* <b>post: </b> The product has been searched<br>
* @param id Id of the product to look for. id != null &amp;&amp; id != "".
* @return obj The product founded.
*/
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
/**
* This method search a waste by name <br>
* <b>post: </b> The waste has been searched<br>
* @param name Name of the waste to look for. name != null &amp;&amp; name != "".
* @return obj The waste founded.
*/
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

/**
* This method search a waste by name or product identifier <br>
* <b>post: </b> The waste has been searched<br>
* @param n Name or the product identifier of the waste to look for. n != null &amp;&amp; n != "".
* @return msg The waste converted to string. msg != null &amp;&amp; msg != "".
*/
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
/**
* This method show all the registered products <br>
* <b>post: </b> The products has been displayed<br>
* @return msg The products converted to string. msg != null &amp;&amp; msg != "".
*/
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
/**
* This method show all the registered waste <br>
* <b>post: </b> The waste has been displayed<br>
* @return msg The waste converted to string. msg != null &amp;&amp; msg != "".
*/
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