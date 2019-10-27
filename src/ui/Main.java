package ui;
import model.*;
import java.util.*;
public class Main{
	WeRecycle objRec;
public Main(){
	objRec=new WeRecycle("RECICLAMOS");
}

public static void main(String args[]){
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2 = new Scanner(System.in);
	Main obj = new Main();
	boolean val = true;
	int option=0; 
	System.out.println("Welcome to RECICLAMOS\n");
	while(val==true){
		obj.showMenu();
		option = teclado.nextInt();
		switch(option){
			case 1:
			obj.createWaste();
			break;
			case 2:
			obj.createProductAddWaste();
			break;
			case 3:
			obj.showWaste();
			break;
			case 4:
			obj.showProd();
			break;
			case 5:
			System.out.println("\nEnter the name of the waste or the product identifier\n");
			String n = teclado2.nextLine();
			obj.searchWaste(n);
			break;
			case 6:
			System.out.println("Enter the name of the waste to calculate its nocive effect\n");
			String p = teclado2.nextLine();
			obj.showNociveEffect(p);
			break;
			case 7:
			System.out.println("Enter the name of the waste to show if its usable\n");
            String k = teclado2.nextLine();
            obj.isUsable(k);
            break;
            case 8:
            System.out.println("Enter the identifier of the product to display the waste");
            String t = teclado2.nextLine();
            obj.orderWaste(t);
            break;
            case 9:
            System.out.println("Thank you");
            val=false;
            break;
            default:
            System.out.println("Error: Wrong option");


		}
	}
	
}
/**
* This method show the menu of options <br>
* <b>post: </b> The menu has been showed.<br>
*/
public void showMenu(){
	System.out.println("Enter the option\n");
	System.out.println("<1> to add a waste\n");
	System.out.println("<2> to add a product\n");
	System.out.println("<3> to show the registered waste\n");
	System.out.println("<4> to show the registered products\n");
	System.out.println("<5> to search a waste by his name or product identifier\n");
	System.out.println("<6> to calculate the nocive effect of a waste\n");
	System.out.println("<7> to display if a Biodegradable or Recyclable waste is usable or not\n");
	System.out.println("<8> to list the waste by its nocive effect from lower to more\n");
	System.out.println("<9> to Exit\n");


}
public void orderWaste(String t){
	System.out.println(objRec.orderWaste(t));
}
public void isUsable(String n){
	System.out.println(objRec.isUsable(n));
}
public void showNociveEffect(String n){
	System.out.println(objRec.showNociveEffect(n));
}
public void searchWaste(String n){
	System.out.println(objRec.searchWaste(n));
}

public void showProd(){
	System.out.println(objRec.showProd());
}
public void showWaste(){
	System.out.println(objRec.showWaste()); 
}
/**
* This method recollect the information to create a waste <br>
* <b>post: </b> The information has been recollected.<br>
*/
public void createWaste(){
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2 = new Scanner(System.in);
	Scanner teclado3 = new Scanner(System.in);
	int option = 0;
	System.out.println("\nWhat type of waste do you want to add.\n<1> for Biodegradable\n<2> for Recyclable\n<3> for Inert\n");
	option = teclado2.nextInt();
	switch(option){
		case 1:
		System.out.println("Enter the name of the waste\n");
		String name = teclado.nextLine();
		System.out.println("Enter the identification of the waste\n");
		String id = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color = teclado3.nextLine();
		System.out.println("Select the origin of the waste.\n<1> Industrial\n<2> Domiciliary\n<3> Municipal\n<4> Construction\n<5> Hospitalary\n");
		int help = teclado2.nextInt();
		String origin = "";
		if(help==1){
			origin = Waste.INDUSTRIAL;
		}
		else if(help==2){
			origin= Waste.DOMICILIARIO;
		}
		else if(help==3){
			origin= Waste.MUNICIPAL;
		}
		else if(help==4){
			origin= Waste.CONSTRUCCION;
		}
		else{
			origin=Waste.HOSPITALARIO;
		}
		System.out.println("Enter the time(Days) that take the waste to decompose\n");
		int time = teclado2.nextInt();
		System.out.println("Is able to compost?\n<1> Yes\n<2> No\n");
		boolean compost = false;
		int opt = teclado2.nextInt();
		if(opt==1){
			compost=true;
		}
		System.out.println("Enter the identification of the product that produce this waste\nHere a list of the registered products to help you out\n");
		//Crear metodo en controladora para displayar productos
		System.out.println(objRec.showProd());
		String prodRef = teclado.nextLine();
		System.out.println(objRec.addWaste(id,name,origin,color,time,prodRef,compost));  
		if(objRec.buscarProducto(prodRef)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef).addWasteProd(objRec.buscarWaste(name)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans = teclado2.nextInt();
			if(ans==1){
				System.out.println(objRec.buscarProducto(createProduct()).addWasteProd(objRec.buscarWaste(name))); 
			}

		}
		break;
		case 2:
		System.out.println("Enter the name of the waste\n");
		String name1 = teclado.nextLine();
		System.out.println("Enter the identification of the waste\n");
		String id1 = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color1 = teclado3.nextLine();
		System.out.println("Select the origin of the waste.\n<1> Industrial\n<2> Domiciliary\n<3> Municipal\n<4> Construction\n<5> Hospitalary\n");
		int help1 = teclado2.nextInt();
		String origin1 = "";
		if(help1==1){
			origin1 = Waste.INDUSTRIAL;
		}
		else if(help1==2){
			origin1= Waste.DOMICILIARIO;
		}
		else if(help1==3){
			origin1= Waste.MUNICIPAL;
		}
		else if(help1==4){
			origin1= Waste.CONSTRUCCION;
		}
		else{
			origin1=Waste.HOSPITALARIO;
		}
		System.out.println("Enter the time(Days) that take the waste to decompose\n");
		int time1 = teclado2.nextInt();
		System.out.println("Select the type of recyclable waste\n<1> Paper\n<2> Paperboard\n<3> Plastic\n<4> Glass\n");
		help1=teclado2.nextInt();
		String type = "";
		if(help1==1){
			type = Recycling.PAPER;
		}
		else if(help1==2){
			type = Recycling.PAPERBOARD;
		}
		else if(help1==3){
			type = Recycling.PLASTIC;
		}
		else{
			type = Recycling.GLASS;
		}
		System.out.println("Type an advice about the managament of this waste\n");
		String desc = teclado.nextLine();
		System.out.println("Enter the identification of the product that produce this waste\nHere a list of the registered products to help you out\n");
		//Crear metodo en controladora para displayar productos
		System.out.println(objRec.showProd());
		String prodRef1 = teclado.nextLine();
		System.out.println(objRec.addWaste(id1,name1,origin1,color1,time1,prodRef1,type,desc));  
		if(objRec.buscarProducto(prodRef1)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef1).addWasteProd(objRec.buscarWaste(name1)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans1 = teclado2.nextInt();
			if(ans1==1){
				System.out.println(objRec.buscarProducto(createProduct()).addWasteProd(objRec.buscarWaste(name1))); 
			}
		}
		break;
		case 3:
		System.out.println("Enter the name of the waste\n");
		String name2 = teclado.nextLine();
		System.out.println("Enter the identification of the waste\n");
		String id2 = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color2 = teclado3.nextLine();
		System.out.println("Select the origin of the waste.\n<1> Industrial\n<2> Domiciliary\n<3> Municipal\n<4> Construction\n<5> Hospitalary\n");
		int help2 = teclado2.nextInt();
		String origin2 = "";
		if(help2==1){
			origin2 = Waste.INDUSTRIAL;
		}
		else if(help2==2){
			origin2= Waste.DOMICILIARIO;
		}
		else if(help2==3){
			origin2= Waste.MUNICIPAL;
		}
		else if(help2==4){
			origin2= Waste.CONSTRUCCION;
		}
		else{
			origin2=Waste.HOSPITALARIO;
		}
		System.out.println("Enter the time(Days) that take the waste to decompose\n");
		int time2 = teclado2.nextInt();
		System.out.println("Enter a tip to reduce the use of this waste\n");
		String tip = teclado.nextLine();
		System.out.println("Enter the identification of the product that produce this waste\nHere a list of the registered products to help you out\nNote: If you want to create a new product enter a new identifier\n");
		System.out.println(objRec.showProd());
		String prodRef2 = teclado.nextLine();
		System.out.println(objRec.addWaste(id2,name2,origin2,color2,time2,prodRef2,tip));   
		if(objRec.buscarProducto(prodRef2)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef2).addWasteProd(objRec.buscarWaste(name2)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans2 = teclado2.nextInt();
			if(ans2==1){
				System.out.println(objRec.buscarProducto(createProduct()).addWasteProd(objRec.buscarWaste(name2))); 

			}
		}
		break;
		default:
		System.out.println("Error: Wrong option\n");
	}
}
/**
* This method recollect the information to create a product<br>
* <b>post: </b> The information has been recollected.<br>
* @return id The id of the product. id != null &amp;&amp; id != "".
*/
public String createProduct(){
	Scanner teclado = new Scanner(System.in);
	System.out.println("Enter the name of the product\n");
	String name = teclado.nextLine();
	System.out.println("Enter the identification of the product\n");
	String id = teclado.nextLine();
	System.out.println("Enter the description of the product\n");
	String desc = teclado.nextLine();
	System.out.println(objRec.addProduct(id,name,desc));
	return id;
}
/**
* This method recollect the information to create a product <br>
* <b>post: </b> The information has been recollected.<br>
*/
public void createProductAddWaste(){
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2 = new Scanner(System.in);
	System.out.println("Enter the name of the product\n");
	String name = teclado.nextLine();
	System.out.println("Enter the identification of the product\n");
	String id = teclado.nextLine();
	System.out.println("Enter the description of the product\n");
	String desc = teclado.nextLine();
	System.out.println(objRec.addProduct(id,name,desc));
	System.out.println("You want to add waste to this product?\n<1> Yes\n<2> No\n");
	int help = teclado2.nextInt();
	if(help==1){
		int option = 0;
		String namewas = "";
		while(help==1){
		System.out.println("Here is a list of the waste to help you out\n");
		System.out.println(objRec.showWaste()); 
		System.out.println("You can add a waste just typing the name of the waste\n");
		System.out.println("Note: If you have not registered waste yet or you want to create a new one. Enter <3>\n");
		namewas=teclado.nextLine();
		int aux = Integer.parseInt(namewas);
		if(aux==3){
			createWaste();
		}
		else{
			System.out.println(objRec.buscarProducto(id).addWasteProd(objRec.buscarWaste(namewas)));
			System.out.println("You want to add another waste?\n<1> Yes\n<2> No\n");
			option= teclado2.nextInt();
			if(option==2){
				help=2;
			}
		}
		
		} 
	}
	
}




}