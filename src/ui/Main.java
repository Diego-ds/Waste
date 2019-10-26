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

 
}

public void createWaste(){
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2= new Scanner(System.in);
	int option = 0;
	System.out.println("\nWhat type of waste do you want to add.\nEnter <1> for Biodegradable\n<2> for Recyclable\n<3> for Inert\n");
	option = teclado2.nextInt();
	switch(option){
		case 1:
		System.out.println("Enter the name of the waste\n");
		String name = teclado.nextLine();
		System.out.println("Enter the id of the waste\n");
		String id = teclado.nextLine();
		System.out.println("Enter the color of the waste\n");
		String color = teclado.nextLine();
		System.out.println("Enter the time that take the waste to decompose\n");
		int time = teclado2.nextInt();
		System.out.println("Is able to compost?\n<1> Yes\n<2> No\n");
		boolean compost = false;
		int opt = teclado2.nextInt();
		if(opt==1){
			compost=true;
		}
		System.out.println("Enter the id of the product that produce this waste\nHere a list of the registered products to help you out\n");
		//Crear metodo en controladora para displayar productos
		String prodRef = teclado.nextLine();

		String id,String name,String origin,String color,int time,String prodRef,boolean compost
	}
 
}
}