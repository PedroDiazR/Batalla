package batalla2;

import javax.swing.JOptionPane;

public class Dragon2 extends Personaje2 {
    
    public Dragon2(Dado2 d10, String nombre, int salud, int ataque, int defensa) {
	this.dado = d10;
	this.nombre = nombre;
	this.salud = salud;
	this.ataque = ataque;
	this.defensa = defensa;
	xp = 0;
        tipo = 2;
        xpMax = 10;
        lv=1;
    

    }

    @Override
    public String toString() {
        return nombre + " tiene " + xp + " puntos de experiencia.";
    }
    @Override
    public void atacar(Personaje2 p){
        int t = p.getTipe();
        int critico = dado.tirarDado();
        int daño;
        switch(t){
            case 0:
                System.out.println(nombre + " ataca!");
                if (critico > 8) {
                    System.out.println("Golpe Mortal!");
                    daño = ataque * 4; //Esto siempre mataba de un golpe asi que lo baje a por 4
                    JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                } else {
                    daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)/2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                }
                p.recibirDaño(daño);
                xp += 10 ;
                break;
            case 1:
                System.out.println(nombre + " ataca!");    
                if (critico > 8) {
                    System.out.println("Golpe Mortal!");
                    daño = ataque * 8; //Esto siempre mataba de un golpe asi que lo baje a por 4
                    JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                } else {
                    daño = (ataque * (int) Math.floor(Math.random() * 2) + 1)*2; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                }
                p.recibirDaño(daño);
                xp += 10 ;
                break;
            case 2:
                System.out.println(nombre + " ataca!");
                if (critico > 8) {
                    System.out.println("Golpe Mortal!");
                    daño = ataque * 3; //Esto siempre mataba de un golpe asi que lo baje a por 4
                    JOptionPane.showMessageDialog(null,"Fue un golpe MORTAL","Golpe Mortal", JOptionPane.INFORMATION_MESSAGE,golpe_mortal);
                } else {
                    daño = ataque * (int) Math.floor(Math.random() * 2) + 1; //Para que las peleas sean mas largas achiueel daño a norma o el doble
                }        
                p.recibirDaño(daño);
                xp += 10 ;
                break;
        }    
    
    }
    
}
