
package membres_equip.Jugador;

import java.time.LocalDate;

public class Davanter extends Jugador{
    
    private int gols;
    private int balonsRecuperats;

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public Davanter(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int dorsal, boolean titular, int gols, int balonsRecuperats) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable, dorsal, titular);
        this.gols = gols;
        this.balonsRecuperats = balonsRecuperats;
    }

    public Davanter() {
    }

    @Override
    public String toString() {
        return "Davanter:\n" + super.toString() + "\ngols = " + gols + "\nbalonsRecuperats = " + balonsRecuperats + "\n";
    }
    
    public int CalculSouVar(int gols, int bal_rec){
        sou_variable = (gols*30)+(bal_rec*2);
        return sou_variable;
    }
}
