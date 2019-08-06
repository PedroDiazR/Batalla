package batalla2;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class Juego2 {
    
    
     //Estas son las direcciones para los iconos, no me dejo importarlo entre calses por eso lo hice muchas veces
    File fichero = new File("");    
    ImageIcon drake = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Drake.PNG");
    ImageIcon inicio = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Inicio.png");
    ImageIcon ogro = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Ogro.PNG");
    ImageIcon zeus = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Zeus.PNG");
    ImageIcon dado = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Dado.PNG");
    ImageIcon puño = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Puños.PNG");
    ImageIcon goodgame = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Goodgame.PNG");
    
    
    
    
    private Personaje2 o;
    private Personaje2 c;
    private Dado2 d10;
    
    
    
    public Juego2() {
    }
    
    
    public Juego2(Personaje2 c, Personaje2 o,Dado2 d10){
        this.c = c;
        this.o = o;
        this.d10 = d10;
    }
    
    
    public Personaje2 CrearPersonaje(){
        String[] ola = {"Zeus", "Ogro", "Drake"};
        int clase = JOptionPane.showOptionDialog(null, " Elija un personaje", "Pelea", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,inicio,ola,ola[0]);
        Dado2 d1 = new Dado2(10);
        String nombre =JOptionPane.showInputDialog(null, "Escriba el nombre que desea para el personaje ", "Nombre", JOptionPane.DEFAULT_OPTION);
        String n = nombre;
        if(clase==0){//NO uso un swich por que da error, creo que pasa por el break... 
                JOptionPane.showMessageDialog(null,"Bienvenido "+ n + " el Zeus!","Zeus", JOptionPane.INFORMATION_MESSAGE,zeus);
                int salud = 600;
                int ataque = 50;
                int defensa= 25;
                Caballero2 c1 = new Caballero2(d1, nombre, salud, ataque, defensa);
                return c1;
        }
        
        if (clase==1){
                JOptionPane.showMessageDialog(null,"Bienvenido "+ nombre + " el Ogro !","Ogro",JOptionPane.INFORMATION_MESSAGE,ogro);
                int salu = 1000;
                int ataqu = 30;
                int defens= 19;
                Orco2 o1 = new Orco2(d1, n, salu, ataqu, defens);
                return o1;
        }
        if(clase==2){
                JOptionPane.showMessageDialog(null,"Bienvenido "+ nombre + " el Drake!","Drake",JOptionPane.INFORMATION_MESSAGE,drake);
                
                int sal = 800;
                int ataq = 65;
                int defen= 5;
                Dragon2 d = new Dragon2(d1, n, sal,ataq,defen );
                return d;
        }
            
        return null;
        
    }
    
    
    

    @Override
    public String toString() {
        return "Juego{" + "c=" + c + ", o=" + o + ", d10=" + d10 + '}';
    }

    
    
    
    public void setC(Personaje2 c) {
        this.c = c;
    }

    public void setO(Personaje2 o) {
        this.o = o;
    }

    public void setD10(Dado2 d10) {
        this.d10 = d10;
    }

    public Personaje2 getC() {
        return c;
    }

    public Personaje2 getO() {
        return o;
    }

    public Dado2 getD10() {
        return d10;
    }
            
            
            
            
    public void jugar(Personaje2 c, Personaje2 o){        
        JOptionPane.showMessageDialog(null, "Bienvenidos a esta pelea mítica", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,puño);
        JOptionPane.showMessageDialog(null, "Pelean: " + c.getNombre() + " y " + o.getNombre() + ".", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,puño);
        JOptionPane.showMessageDialog(null, "Si el dado es mayor que 5\n pega:  " + c.getNombre() +" sino,\n pega: " + o.getNombre() + ".", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,puño);
        System.out.println("Esta será una pelea mítica!");
        System.out.println("Pelean " + c.getNombre() + " y " + o.getNombre() + ".");
        System.out.println("Si el dado es mayor que 5\n n pega Zeus sino el Ogro");
        
        
        Dado2 d10 = new Dado2(10);
        while (c.estaSaludable() && o.estaSaludable()) {
            int tirada = d10.tirarDado();
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("TURNO");
            System.out.println("Dado = " + tirada);
            if (tirada > 5) {
                JOptionPane.showMessageDialog(null, "El numero es = " + tirada + ".\n Pega "+ c.getNombre() +".", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,dado);
                c.atacar(o);
                c.subirLV();
                System.out.println("Salud restante de"+ o.getNombre()+"= " + o.getSalud());
            } else {
                JOptionPane.showMessageDialog(null, "El numero es = " + tirada + ".\n Pega "+ o.getNombre() +".", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,dado);
                o.atacar(c);
                o.subirLV();
                System.out.println("La salud restante de "+ o.getNombre()+" = " + o.getSalud());

            }
        }

        
        
        if(c.estaSaludable()){
            int t = c.getTipe();
            switch(t){
                case 0:
                   JOptionPane.showMessageDialog(null, c.getNombre() + " el Zeus ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame); 
                   System.out.println("El Zeus ha vencido!");
                   break;
                case 1:
                    JOptionPane.showMessageDialog(null, c.getNombre() + " el Ogro ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame);
                    System.out.println("El Ogro ha vencido!");
                    break;
                case 2:
                    System.out.println("El Drake ha vencido!");
                    JOptionPane.showMessageDialog(null, c.getNombre() + " el Drake ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame);
                    break;
            }
            
            
        }else{
            int t = o.getTipe();
            switch(t){
                case 0:
                   JOptionPane.showMessageDialog(null, o.getNombre() + " el Zeus ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame); 
                   System.out.println("Zeus ha vencido!");
                   break;
                case 1:
                    JOptionPane.showMessageDialog(null, o.getNombre() + " el Ogro ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame);
                    System.out.println("El Ogro ha ganado!");
                    break;
                case 2:
                    System.out.println("Drake ha ganado!");
                    JOptionPane.showMessageDialog(null, o.getNombre() + " el Drake ha vencido!","Victoria",JOptionPane.INFORMATION_MESSAGE,goodgame);
                    break;
            }
        }
        
    }

    void jugar2(Personaje2 p1, Personaje2 p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
