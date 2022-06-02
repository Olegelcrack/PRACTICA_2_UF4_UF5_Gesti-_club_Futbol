
package membres_equip.Tecnic;

import java.time.LocalDate;


public class Entrenador extends Tecnic{
    
    private int anys_experiencia;
    private int numero_trofeus;

    public int getAnysExperiencia() {
        return anys_experiencia;
    }

    public void setAnysExperiencia(int anysExperiencia) {
        this.anys_experiencia = anysExperiencia;
    }

    public int getNumeroTrofeus() {
        return numero_trofeus;
    }

    public void setNumeroTrofeus(int numeroTrofeus) {
        this.numero_trofeus = numeroTrofeus;
    }

    public Entrenador(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable, int anys_experiencia, int numero_trofeus) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable);
        this.anys_experiencia = anys_experiencia;
        this.numero_trofeus = numero_trofeus;
    }

    public Entrenador() {
    }
    
    @Override
    public String toString() {
        return "Entrenador:\n" + super.toString() + "\nanysExperiencia = " + anys_experiencia + " \nnumeroTrofeus = " + numero_trofeus + "\n";
    }
    
    public int CalculSouVar(int num_trof){
        sou_variable = num_trof*50;
        return sou_variable;
    }
}
