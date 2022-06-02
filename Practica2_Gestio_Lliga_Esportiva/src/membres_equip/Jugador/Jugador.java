
package membres_equip.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import membres_equip.Empleat_Plantilla;

public class Jugador extends Empleat_Plantilla{
    private int dorsal=0;
    private boolean titular;

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public Jugador(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int dorsal, boolean titular) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable);
        this.dorsal = dorsal;
        this.titular = titular;
    }

    @Override
    public String toString() {
        return super.toString() + "\ndorsal = " + dorsal + "\ntitular = " + titular;
    }

    
    
    public Jugador() {
    }
    
    public int IncrementaDorsal(ArrayList<Empleat_Plantilla> empleats){
        if(!empleats.isEmpty()){
            for(Empleat_Plantilla ep1 : empleats){
                if(ep1.toString().contains("Porter") || ep1.toString().contains("Defensa") || ep1.toString().contains("Migcampista") || ep1.toString().contains("Davanter")){
                    dorsal++;
                }
            }
        }
        return ++dorsal;
    }
}
