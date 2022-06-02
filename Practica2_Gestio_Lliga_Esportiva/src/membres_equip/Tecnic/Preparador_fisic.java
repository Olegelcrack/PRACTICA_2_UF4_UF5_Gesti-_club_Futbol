
package membres_equip.Tecnic;

import java.time.LocalDate;

public class Preparador_fisic extends Tecnic{
    private int anysExperiencia;

    public int getAnysExperiencia() {
        return anysExperiencia;
    }

    public void setAnysExperiencia(int anysExperiencia) {
        this.anysExperiencia = anysExperiencia;
    }

    public Preparador_fisic(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int anysExperiencia) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable);
        this.anysExperiencia = anysExperiencia;
    }

    public Preparador_fisic() {
    }

    @Override
    public String toString() {
        return "Preparador_fisic:\n" + super.toString() + "\nanysExperiencia = " + anysExperiencia + "\n";
    }
    
    public int CalculSouVar(int anys_experiencia){
        sou_variable = anys_experiencia*25;
        return sou_variable;
    }
}
