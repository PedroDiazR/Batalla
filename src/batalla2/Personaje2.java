package batalla2;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Personaje2 {
    
    
    //Estas son las direcciones para los iconos, no me dejo importarlo entre calses por eso lo hice muchas veces
    File fichero = new File("");    
    ImageIcon drake = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Drake.PNG");
    ImageIcon inicio = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Inicio.png");
    ImageIcon ogro = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Ogro.PNG");
    ImageIcon zeus = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Zeus.png");
    ImageIcon puño = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Puños.PNG");
    ImageIcon drakexp = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Drakexp.png");
    ImageIcon ogroxp = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Ogroxp.png");
    ImageIcon zeusxp = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Zeusxp.png");
    ImageIcon golpe_mortal = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/GolpeMortal.png");
    ImageIcon armadura = new ImageIcon(fichero.getAbsolutePath()+"/src/resources/Armadura.png");
    //
    
   
    
    protected Dado2 dado;
    protected String nombre;
    protected int salud;
    protected int ataque;   
    protected int defensa;
    protected int xp;
    protected int tipo;
    protected int xpMax;
    protected int lv;
    
    
    
    public Personaje2(Dado2 dado, String nombre, int salud, int ataque, int defensa, int xp, int tipe, int xpMax, int lv) {
        this.dado = dado;
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.xp = xp;
        this.tipo = tipe;
        this.xpMax = xpMax;
        this.lv = lv;
    }

    public Personaje2() {
    }
    
    
    
    


    public Dado2 getDado() {
        return dado;
    }
    public void setDado(Dado2 dado) {
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getTipe() {
        return tipo;
    }
    public void setTipe(int tipe) {
        this.tipo = tipe;
    }

    public int getXpMax() {
        return xpMax;
    }

    public void setXpMax(int xpMax) {
        this.xpMax = xpMax;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }
      
        
        
    public boolean estaSaludable() { 
        return salud > 0;
    }    
	
    public void recibirDaño(int daño) {
        int golpe;
            System.out.println("daño= " + daño);
            System.out.println("defensa= "+defensa);
        if (defensa < daño){
            golpe = daño - defensa; //Agregar if por si el daño es menor a la defensa xd
            System.out.println(nombre + " recibe " + golpe + " de daño.");
            salud = salud - golpe;
            JOptionPane.showMessageDialog(null, "El daño es = " + daño + ".\n la salud restante de  "+ nombre +" es "+salud, "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,puño);

        }else{
            System.out.println(nombre + "No recibe daño, su defensa es mucha.");
            JOptionPane.showMessageDialog(null, nombre + " No recibe daño, su defensa es mucha.", "Pelea" + "", JOptionPane.INFORMATION_MESSAGE,armadura);

        }

    }

    public void subirLV(){
        System.out.println(nombre + " tiene " + xp);
        if (xp == xpMax){
            lv +=1;
            xpMax = xpMax*2;
            xp = 0;
            int mejora = 0;
            System.out.println(nombre +" ha subido de nivel");
            String[] ola = {"Ataque", "Vida", "Defensa"};
            
            switch(tipo){
                case 0:
                    mejora = JOptionPane.showOptionDialog(null,"      "+nombre +  " Elije una habilidad para mejorar", "Pelea", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,zeusxp,ola,ola[0]);
                    break;
                case 1:
                    mejora = JOptionPane.showOptionDialog(null,"      "+nombre +  " Eije una habilidad para mejorar", "Pelea", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,ogroxp,ola,ola[0]);
                    break;
                case 2:
                    mejora = JOptionPane.showOptionDialog(null,"      "+nombre +  " Elije una hablidad para mejorar", "Pelea", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,drakexp,ola,ola[0]);
                    break;
            }
            switch(mejora){
                case 0:
                    ataque += 20;
                    break;
                case 1:
                    salud += 100;
                    break;
                case 2:
                    defensa += 20;
                    break;
            }
            
            
            
            }
            
        }
    
    
    
    
        public void atacar(Personaje2 p) {
            int t = p.getTipe();
            int critico = dado.tirarDado();
            int daño = 0;            
            switch(tipo){  //Aca estamos hablando del tipo de quien ataca, y segun el tipo de quien ataca es el daño
                case 0:
                    switch(t){
                        case 0:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                System.out.println("Golpe Mortal!");
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                daño = ataque * 4; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = ataque * (int) Math.floor(Math.random() * 2) + 1; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                        case 1:
                            System.out.println(nombre + " ataca!");
                            if (critico > 8) {
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                System.out.println("Golpe Mortal!");
                                daño = ataque * 4; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)/2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);

                            xp += 10 ;
                            break;
                        case 2:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                System.out.println("Golpe Mortal!");
                                daño = ataque * 8; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)*2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                    }
                    break;
                case 1:
                    switch(t){
                        case 0:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                System.out.println("Golpe Mortal!");
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                daño = ataque * 8; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)*2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                        case 1:
                            System.out.println(nombre + " ataca!");
                            if (critico > 8) {
                                System.out.println("Golpe Mortal!");
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                daño = ataque * 4; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = ataque * (int) Math.floor(Math.random() * 2) + 1; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                        case 2:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                System.out.println("Golpe Mortal!");
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                daño = ataque * 3; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)/2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                    }
                    break;
                case 2:
                    switch(t){
                        case 0:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                System.out.println("Golpe Mortal!");
                                daño = ataque * 4; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)/2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                        case 1:
                            System.out.println(nombre + " ataca!");
                            if (critico > 8) {
                                JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                System.out.println("Golpe Mortal!");
                                daño = ataque * 8; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)*2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;
                        case 2:
                            System.out.println(nombre + " ataca!");

                            if (critico > 8) {
                                JOptionPane.showMessageDialog(null,"Fue un golpe Mortal","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                                System.out.println("Golpe Mortal!");
                                daño = ataque * 3; //Esto siempre mataba de un golpe asi que lo baje a por 4
                            } else {
                                daño = ataque * (int) Math.floor(Math.random() * 2) + 1; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                            }
                            p.recibirDaño(daño);
                            xp += 10 ;
                            break;

                    }
                    break;
                }

        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
