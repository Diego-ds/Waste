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
}