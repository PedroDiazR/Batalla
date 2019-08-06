package batalla2;

public class Dado2 {
    
    private int cantidadDeLados;

    public Dado2(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }
    public int tirarDado() {
        return (int) Math.floor(Math.random() * cantidadDeLados) + 1;
    }

    public int getCantidadDeLados() {
        return cantidadDeLados;
    }

    public void setCantidadDeLados(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }

    @Override
    public String toString() {
        return "Dado{" + "cantidadDeLados=" + cantidadDeLados + '}';
    }
    
}
