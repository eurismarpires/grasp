
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {        
        Objeto objeto1 = new Objeto(1, 8, 15);
        Objeto objeto2 = new Objeto(2, 7, 10);
        Objeto objeto3 = new Objeto(3, 10, 16);
        Objeto objeto4 = new Objeto(4, 10, 12);
        Objeto objeto5 = new Objeto(5, 6, 10);
        Objeto objeto6 = new Objeto(6, 7, 14);
        Objeto objeto7 = new Objeto(7, 5, 8);
        Objeto objeto8 = new Objeto(8, 10, 13);
        Objeto objeto9 = new Objeto(9, 6, 10);
        Objeto objeto10 = new Objeto(10, 6, 10);
        Objeto objeto11 = new Objeto(11, 10, 16);
        Objeto objeto12 = new Objeto(12, 5, 12);
        Objeto objeto13 = new Objeto(13, 9, 12);
        Objeto objeto14 = new Objeto(14, 8, 12);
        Objeto objeto15 = new Objeto(15, 9, 11);
        Objeto objeto16 = new Objeto(16, 11, 15);
        Objeto objeto17 = new Objeto(17, 7, 10);
        Objeto objeto18 = new Objeto(18, 10, 16);
        Objeto objeto19 = new Objeto(19, 15, 11);
        Objeto objeto20 = new Objeto(20, 6, 10);
        Objeto objeto21 = new Objeto(21, 7, 14);
        Objeto objeto22 = new Objeto(22, 5, 8);
        Objeto objeto23 = new Objeto(23, 10, 13);
        Objeto objeto24 = new Objeto(24, 6, 11);
        Objeto objeto25 = new Objeto(25, 4, 10);
        Objeto objeto26 = new Objeto(26, 10, 14);
        Objeto objeto27 = new Objeto(27, 15, 10);
        Objeto objeto28 = new Objeto(28, 19, 12);
        Objeto objeto29 = new Objeto(29, 8, 12);
        Objeto objeto30 = new Objeto(30, 9, 11);

        List<Objeto> objetos = new ArrayList<>();
        objetos.add(objeto1);
        objetos.add(objeto2);
        objetos.add(objeto3);
        objetos.add(objeto4);
        objetos.add(objeto5);
        objetos.add(objeto6);
        objetos.add(objeto7);
        objetos.add(objeto8);
        objetos.add(objeto9);
        objetos.add(objeto10);
        objetos.add(objeto11);
        objetos.add(objeto12);
        objetos.add(objeto13);
        objetos.add(objeto14);
        objetos.add(objeto15);
        objetos.add(objeto16);
        objetos.add(objeto17);
        objetos.add(objeto18);
        objetos.add(objeto19);
        objetos.add(objeto20);
        objetos.add(objeto21);
        objetos.add(objeto22);
        objetos.add(objeto23);
        objetos.add(objeto24);
        objetos.add(objeto25);
        objetos.add(objeto26);
        objetos.add(objeto27);
        objetos.add(objeto28);
        objetos.add(objeto29);
        objetos.add(objeto30);

        Mochila mochila = new Mochila();
        mochila.setObjetos(objetos);
        //mochila.setCapacidade(79);
        mochila.setCapacidade(150);
        Grasp g = new Grasp();

        int iteracoes = 100000;
        double alfa = 0.8;
        Solucao solucao = g.grasp(mochila, iteracoes, alfa);
        System.out.println("Melhor Solução------------");
        g.imprimirSolucao(mochila, solucao);

    }
}
