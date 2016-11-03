                        
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grasp {

    public Solucao grasp(Mochila mochila, int maxIteracoes, double alfa) {
        Solucao melhorSolucao = new Solucao();
        melhorSolucao.s = new int[mochila.objetos.size()];
        
        
        Solucao solucaoRetorno = new Solucao();
        solucaoRetorno.s = new int[mochila.objetos.size()];        
        
        
        
        int fMelhor = 0;
        for (int it = 0; it< maxIteracoes; it++) {
            List<Objeto> objetosConstrucao = new ArrayList<Objeto>();
            for (Objeto o : mochila.objetos) {
                objetosConstrucao.add(o);
            }
            List<Objeto> objetosLocal = new ArrayList<Objeto>();
            for (Objeto o : mochila.objetos) {
                objetosLocal.add(o);
            }
            Mochila mochilaConstrucao = new Mochila(objetosConstrucao, mochila.getCapacidade(), mochila.getPesoCalculado(), mochila.getBeneficioCalculado());
            Mochila mochilaLocal = new Mochila(objetosLocal, mochila.getCapacidade(), mochila.getPesoCalculado(), mochila.getBeneficioCalculado());

            //------------------------------------BUSCA CONSTRUÇÃO-----------------------------------------------
            Solucao solucao = construcao(mochilaConstrucao, alfa); 
            //------------------------------------BUSCA LOCAL-----------------------------------------------
            Solucao solucaoBuscaLocal = buscaLocal(mochilaLocal, solucao);

           // System.out.println("solucao construção");
            imprimirSolucao(mochila, solucao);
            imprimirSolucao(mochila, solucaoBuscaLocal);
            System.out.println("");
            int fConstrucao = calculaBeneficios(mochilaLocal, solucao);
            int fLocal = calculaBeneficios(mochilaLocal, solucaoBuscaLocal);
            int fs = 0;
            if (fLocal > fConstrucao) {
                fs = fLocal;
                System.arraycopy(solucaoBuscaLocal.s, 0, melhorSolucao.s, 0, solucaoBuscaLocal.s.length);
            } else {
                fs = fConstrucao;
                System.arraycopy(solucao.s, 0, melhorSolucao.s, 0, solucao.s.length);
            }
            if (fs > fMelhor){
              fMelhor = fs;
              System.arraycopy(melhorSolucao.s, 0, solucaoRetorno.s, 0, melhorSolucao.s.length);              
            }
            System.out.println("iteracao " + it + " fMelhor=" + fMelhor);
        }
        //System.out.println("melhor............................................................" + fMelhor);
        return solucaoRetorno;

    }

  
    public Solucao construcao(Mochila mochila, double alfa) {

        Solucao solucaoRetorno = new Solucao();
        solucaoRetorno.s = new int[mochila.objetos.size()];
        for (int i = 0; i < mochila.objetos.size(); i++) {
            solucaoRetorno.s[i] = 0;
        }
        //implementei o método da interface Comparable para ordenar por benefício/decrescente e por peso/crescente.
        Collections.sort(mochila.objetos);
        int pesoTotalDaMochila = 0;
        mochila.setPesoCalculado(0);
        mochila.setBeneficioCalculado(0);
        while (mochila.objetos.size() > 0) {
            int iMax = mochila.objetos.size() - 1;

            Objeto tMinO = mochila.objetos.get(0);
            Objeto tMaxO = mochila.objetos.get(iMax);
            int tMin = tMinO.getId();
            int tMax = tMaxO.getId();
            double t = tMin + alfa * (tMax - tMin);
            Mochila mochilaAux = mochila;
            List<Objeto> LCR = new ArrayList<Objeto>();
            for (Objeto objeto : mochilaAux.objetos) {
                if ((int) t <= objeto.getId()) {
                    LCR.add(objeto);
                }
            }
            Random geraRandom = new Random();
            int random = geraRandom.nextInt(LCR.size());
            Objeto objeto = LCR.get(random);
            pesoTotalDaMochila = pesoTotalDaMochila + objeto.getPeso();
            if (pesoTotalDaMochila <= mochila.getCapacidade()) {
                solucaoRetorno.s[objeto.getId() - 1] = 1;
                mochila.setPesoCalculado(mochila.getPesoCalculado() + objeto.getPeso());
                mochila.setBeneficioCalculado(mochila.getBeneficioCalculado() + objeto.getBeneficio());
            }
            mochila.objetos.remove(objeto);
        }
        return solucaoRetorno;
    }

    public Solucao buscaLocal(Mochila mochila, Solucao solucao) {

        List<Solucao> vizinhos = new ArrayList<>();
        int[] s = new int[solucao.s.length];
        System.arraycopy(solucao.s, 0, s, 0, solucao.s.length);
        for (int i = 0; i < solucao.s.length; i++) {
            int[] sAux = new int[solucao.s.length];
            System.arraycopy(s, 0, sAux, 0, s.length);
            if (sAux[i] == 0) {
                sAux[i] = 1;
            } else {
                sAux[i] = 0;
            }
            Solucao solucaoAux = new Solucao();
            solucaoAux.s = new int[solucao.s.length];
            System.arraycopy(sAux, 0, solucaoAux.s, 0, s.length);
            vizinhos.add(solucaoAux);
        }

        //System.out.println("vou gerar os vizinhos");

        int maiorBeneficio = 0;
        Solucao melhorSolucao = new Solucao();
        melhorSolucao.s = new int[s.length];
        for (Solucao sol : vizinhos) {
            int somaBeneficios = 0;
            int somaPesos = 0;
            int alfa = 0;
            Objeto objetoAux = new Objeto();
            // mochila.getObjetos().get(j)
            for (int j = 0; j < sol.s.length; j++) {
              //  System.out.print(sol.s[j]);
                List<Objeto> objs = new ArrayList<>();
                objs = mochila.getObjetos();

                objetoAux = mochila.getObjetos().get(j);
                int beneficio = objetoAux.getBeneficio();
                int peso = objetoAux.getPeso();
                somaBeneficios = somaBeneficios + beneficio * sol.s[j];
                somaPesos = somaPesos + peso * sol.s[j];
                alfa = alfa + beneficio;
            }
          //  System.out.print("-" + somaBeneficios + "-" + somaPesos);
          //  System.out.print(" alfa-" + alfa);
            int max = somaPesos - mochila.getCapacidade();
            if (max <= 0) {
                max = 0;
            }
            int f = somaBeneficios - alfa * (max);
            if (f > maiorBeneficio) {
                maiorBeneficio = f;
                System.arraycopy(sol.s, 0, melhorSolucao.s, 0, sol.s.length);
            }
           // System.out.print(" c-" + mochila.getCapacidade());
           // System.out.println(" f:" + f);
        }
        //System.out.println(" maiorBeneficio:" + maiorBeneficio);
        return melhorSolucao;
    }
  public int calculaBeneficios(Mochila mochila, Solucao sol) {
        int totalBeneficios = 0;
        for (int i = 0; i < sol.s.length; i++) {
            totalBeneficios = totalBeneficios + sol.s[i] * mochila.objetos.get(i).getBeneficio();
        }
        return totalBeneficios;
    }

    public void imprimirSolucao(Mochila mochila, Solucao solucao) {
        int totalBeneficios = 0;
        for (int i = 0; i < solucao.s.length; i++) {
            totalBeneficios = totalBeneficios + mochila.getObjetos().get(i).getBeneficio() * solucao.s[i];
            System.out.print(solucao.s[i] + " ");
        }
        System.out.println("Total Beneficios: " + totalBeneficios);
        
    }

}
