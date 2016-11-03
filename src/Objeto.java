
public class Objeto implements Comparable<Objeto> {

    private int peso;
    private int beneficio;
    private int id;

    public Objeto(int id, int peso, int beneficio) {
        this.id = id;
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public Objeto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public int compareTo(Objeto objeto) {
        if (this.beneficio > objeto.getBeneficio()) {
            return -1;
        } else if (this.beneficio < objeto.getBeneficio()) {
            return 1;
        } else {
            if (this.peso < objeto.getPeso()) {
                return -1;
            } else if (this.peso > objeto.getPeso()) {
                return 1;
            } else {
                return 0;
            }

        }
    }

}
