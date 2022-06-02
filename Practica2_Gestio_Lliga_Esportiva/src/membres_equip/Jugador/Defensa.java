
package membres_equip.Jugador;

import java.time.LocalDate;

public class Defensa extends Jugador{
    
    private int atacsAturats;
    private int balonsRecuperats;

    public int getAtacsAturats() {
        return atacsAturats;
    }

    public void setAtacsAturats(int atacsAturats) {
        this.atacsAturats = atacsAturats;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public Defensa(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int dorsal, boolean titular, int atacsAturats, int balonsRecuperats) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable, dorsal, titular);
        this.atacsAturats = atacsAturats;
        this.balonsRecuperats = balonsRecuperats;
    }

    public Defensa() {
    }

    @Override
    public String toString() {
        return "Defensa:\n" + super.toString() + "\natacsAturats = " + atacsAturats + "\nbalonsRecuperats = " + balonsRecuperats + "\n";
    }
    
    public int CalculSouVar(int atac_atur, int bal_rec){
        sou_variable = (atac_atur*4)+(bal_rec*2);
        return sou_variable;
    }
}
