
import java.util.List;

public class Mochila implements Cloneable {

    private int capacidade;
    List<Objeto> objetos;
    private int pesoCalculado;
    private int beneficioCalculado;

    public Mochila() {
    }

    public Mochila(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public Mochila(List<Objeto> objetos,int capacidade) {        
        this.objetos = objetos;
        this.capacidade = capacidade;
    }

    public Mochila(List<Objeto> objetos, int capacidade, int pesoCalculado, int beneficioCalculado) {
        this.capacidade = capacidade;
        this.objetos = objetos;
        this.pesoCalculado = pesoCalculado;
        this.beneficioCalculado = beneficioCalculado;
    }

    
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public int getPesoCalculado() {
        return pesoCalculado;
    }

    public void setPesoCalculado(int pesoCalculado) {
        this.pesoCalculado = pesoCalculado;
    }

    public int getBeneficioCalculado() {
        return beneficioCalculado;
    }

    public void setBeneficioCalculado(int beneficioCalculado) {
        this.beneficioCalculado = beneficioCalculado;
    }

}
