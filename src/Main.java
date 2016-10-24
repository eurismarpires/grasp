import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Objeto objeto1 = new Objeto(1, 4, 2);
		Objeto objeto2 = new Objeto(2, 5, 2);
		Objeto objeto3 = new Objeto(3, 7, 3);
		Objeto objeto4 = new Objeto(4, 9, 4);
		Objeto objeto5 = new Objeto(5, 6, 4);
		List<Objeto> objetos = new ArrayList<Objeto>();	
		objetos.add(objeto1);
		objetos.add(objeto2);
		objetos.add(objeto3);
		objetos.add(objeto4);
		objetos.add(objeto5);
		for(Objeto objeto:objetos){
			  System.out.println(objeto.getId() + "-" + objeto.getPeso()  + "-" + objeto.getBeneficio()); 
		}
		Collections.sort(objetos);
		System.out.println("ordenando..."); 
		for(Objeto objeto:objetos){
			  System.out.println(objeto.getId() + "-" + objeto.getPeso()  + "-" + objeto.getBeneficio()); 
		}		
	}

}
