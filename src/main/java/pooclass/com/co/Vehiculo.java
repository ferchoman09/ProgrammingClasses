package pooclass.com.co;

public class Vehiculo {
    private int gasolina;

    public Vehiculo(int gasolina) {
        this.gasolina = gasolina;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void andar(int distancia) {
        gasolina -= distancia;
    }

    public void tanquear(int gasolina) {
        this.gasolina += gasolina;
    }
}
