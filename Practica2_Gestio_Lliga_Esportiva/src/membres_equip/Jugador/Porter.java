
package membres_equip.Jugador;

import java.time.LocalDate;

public class Porter extends Jugador{
    
    private int golsAturats;
    private int golsRebuts;

    public int getGolsAturats() {
        return golsAturats;
    }

    public void setGolsAturats(int golsAturats) {
        this.golsAturats = golsAturats;
    }

    public int getGolsRebuts() {
        return golsRebuts;
    }

    public void setGolsRebuts(int golsRebuts) {
        this.golsRebuts = golsRebuts;
    }

    public Porter(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int dorsal, boolean titular, int golsAturats, int golsRebuts) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable, dorsal, titular);
        this.golsAturats = golsAturats;
        this.golsRebuts = golsRebuts;
    }

    public Porter() {
    }

    @Override
    public String toString() {
        return "Porter:\n" + super.toString() + "\ngolsAturats = " + golsAturats + "\ngolsRebuts = " + golsRebuts + "\n";
    }
    
    public int CalculSouVar(int gols_atur){
        sou_variable = gols_atur*5;
        return sou_variable;
    }
}
