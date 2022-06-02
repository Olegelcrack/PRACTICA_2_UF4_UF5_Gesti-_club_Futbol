
package membres_equip.Jugador;

import java.time.LocalDate;

public class Migcampista extends Jugador{
    
    private int asistGols;
    private int balonsRecuperats;

    public int getAsistGols() {
        return asistGols;
    }

    public void setAsistGols(int asistGols) {
        this.asistGols = asistGols;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public Migcampista(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int dorsal, boolean titular, int asistGols, int balonsRecuperats) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable, dorsal, titular);
        this.asistGols = asistGols;
        this.balonsRecuperats = balonsRecuperats;
    }

    public Migcampista() {
    }

    @Override
    public String toString() {
        return "Migcampista:\n" + super.toString() + "\nasistGols = " + asistGols + "\nbalonsRecuperats = " + balonsRecuperats + "\n";
    }
    
    public int CalculSouVar(int as_gol, int bal_rec){
        sou_variable = (as_gol*20)+(bal_rec*2);
        return sou_variable;
    }
}
