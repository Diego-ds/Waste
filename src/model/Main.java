import java.util.*;
public class Main{
	WeRecycle objRec;
public Main(){
	objRec=new WeRecycle("RECICLAMOS");
}

public static void main(String args[]){

	Main obj = new Main();
	boolean val = true;
	int option=0; 
	obj.createWaste();
}

public void createWaste(){
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2= new Scanner(System.in);
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
		String color = teclado.nextLine();
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
		objRec.addWaste(id,name,origin,color,time,prodRef,compost);
		if(objRec.buscarProducto(prodRef)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef).addWasteProd(objRec.buscarWaste(name)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans = teclado2.nextInt();
			if(ans==1){
				createProduct();
			}

		}
		break;
		case 2:
		System.out.println("Enter the name of the waste\n");
		String name1 = teclado.nextLine();
		System.out.println("Enter the identification of the waste\n");
		String id1 = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color1 = teclado.nextLine();
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
		objRec.addWaste(id1,name1,origin1,color1,time1,prodRef1,type,desc);
		if(objRec.buscarProducto(prodRef1)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef1).addWasteProd(objRec.buscarWaste(name1)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans1 = teclado2.nextInt();
			if(ans1==1){
				createProduct();
			}
		}
		break;
		case 3:
		System.out.println("Enter the name of the waste\n");
		String name2 = teclado.nextLine();
		System.out.println("Enter the identification of the waste\n");
		String id2 = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color2 = teclado.nextLine();
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
		System.out.println("Enter the identification of the product that produce this waste\nHere a list of the registered products to help you out\n");
		//Crear metodo en controladora para displayar productos
		System.out.println(objRec.showProd());
		String prodRef2 = teclado.nextLine();
		objRec.addWaste(id2,name2,origin2,color2,time2,prodRef2,tip);
		if(objRec.buscarProducto(prodRef2)!=null){
			System.out.println("Buscando.....\n");
			System.out.println(objRec.buscarProducto(prodRef2).addWasteProd(objRec.buscarWaste(name2)));
		}
		else{
			System.out.println("The product doesnt exist do you want to create it?\n<1> Yes\n<2> No\n");
			int ans2 = teclado2.nextInt();
			if(ans2==1){
				createProduct();
			}
		}
		break;
		default:
		System.out.println("Error: Wrong option\n");
	}
}

public void createProduct(){
	Scanner teclado = new Scanner(System.in);
	System.out.println("Enter the name of the product\n");
	String name = teclado.nextLine();
	System.out.println("Enter the identification of the product\n");
	String id = teclado.nextLine();
	System.out.println("Enter the description of the product\n");
	String desc = teclado.nextLine();
	System.out.println(objRec.addProduct(id,name,desc));
}


}