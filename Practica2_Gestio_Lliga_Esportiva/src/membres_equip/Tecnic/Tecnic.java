
package membres_equip.Tecnic;

import java.time.LocalDate;
import java.util.Scanner;
import membres_equip.Empleat_Plantilla;

public class Tecnic extends Empleat_Plantilla{

    public int getSou_variable() {
        return sou_variable;
    }

    public void setSou_variable(int sou_variable) {
        this.sou_variable = sou_variable;
    }

    public Tecnic(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable) {
        super(dni, nom, cognom, datanaixement, telefon, email, numero_empleat, numeroSS, sou_base, sou_variable);
    }

    public Tecnic() {
    }
}
