package batalla2;

public class Batalla2 {

    public static void main(String[] args) {
        
        Juego2 gj = new Juego2();
        
        Personaje2 p1 = gj.CrearPersonaje();
        Personaje2 p2 = gj.CrearPersonaje();
        gj.jugar(p1,p2);
    }
    
}
