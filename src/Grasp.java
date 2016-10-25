
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grasp {

    public void grasp(Mochila mochila) {
        Solucao solucao = construcao(mochila);

        for (int i = 0; i < solucao.s.length; i++) {
            System.out.print(solucao.s[i] + " ");
        }
        System.out.println("");

    }

    public Solucao construcao(Mochila mochila) {
        Solucao solucaoRetorno = new Solucao();
        solucaoRetorno.s = new int[mochila.objetos.size()];
        for (int i = 0; i < mochila.objetos.size(); i++) {
            solucaoRetorno.s[i] = 0;
        }
        Collections.sort(mochila.objetos);

        while (mochila.objetos.size() > 0) {
            int iMax = mochila.objetos.size() - 1;

            Objeto tMinO = mochila.objetos.get(0);
            Objeto tMaxO = mochila.objetos.get(iMax);
            double alfa = 1;
            int tMin = tMinO.getId();
            int tMax = tMaxO.getId();
            double t = tMin + alfa * (tMax - tMin);
            Mochila mochilaAux = mochila;
            List<Objeto> LCR = new ArrayList<Objeto>();
            for (Objeto objeto : mochilaAux.objetos) {
                if ((int) t < objeto.getId()) {
                    LCR.add(objeto);
                }
            }
            Random geraRandom = new Random();
            // System.out.println("LCR.size()=" + LCR.size());
            if (LCR.size() > 0) {
                int random = geraRandom.nextInt(LCR.size());
                Objeto objeto = LCR.get(random);
                solucaoRetorno.s[objeto.getId() - 1] = 1;
                //  LCR.add(tMax);  
            }
            // System.out.println("TamanhoLCR=" + LCR.size() + "    t=" + t + "       iMin: " + mochila.objetos.get(0).getId() + "-iMax: " + mochila.objetos.get(iMax).getId()  + "-" + mochila.objetos.size());
            //mochila.objetos.remove(tMinO.getId());
            mochila.objetos.remove(iMax);

        }
        //System.out.println("--solução--");        
        //testeOrdenacao(mochila);
        return solucaoRetorno;
    }

    public void testeOrdenacao(Mochila mochila) {
        System.out.println("teste ordena��o");
        for (Objeto objeto : mochila.objetos) {
            System.out.println(objeto.getId() + "-" + objeto.getPeso() + "-" + objeto.getBeneficio());
        }
        Collections.sort(mochila.objetos);
        System.out.println("ordenando...");
        for (Objeto objeto : mochila.objetos) {
            System.out.println(objeto.getId() + "-" + objeto.getPeso() + "-" + objeto.getBeneficio());
        }
    }
}
