import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grasp {

	public void grasp(Mochila mochila){
		construcao(mochila);
	}
	public void construcao(Mochila mochila){
		Solucao solucao = new Solucao();
		solucao.s = new int[mochila.objetos.size()];
	    for(int i = 0; i < mochila.objetos.size(); i++){
	    	solucao.s[i] = 0;	    	
	    }	

   
		
		testeOrdenacao(mochila);
	}
	public void testeOrdenacao(Mochila mochila){
		System.out.println("teste ordenação");	
		for(Objeto objeto:mochila.objetos){
			  System.out.println(objeto.getId() + "-" + objeto.getPeso()  + "-" + objeto.getBeneficio()); 
		}
		Collections.sort(mochila.objetos);
		System.out.println("ordenando..."); 
		for(Objeto objeto:mochila.objetos){
			  System.out.println(objeto.getId() + "-" + objeto.getPeso()  + "-" + objeto.getBeneficio()); 
		}			
	}
}
