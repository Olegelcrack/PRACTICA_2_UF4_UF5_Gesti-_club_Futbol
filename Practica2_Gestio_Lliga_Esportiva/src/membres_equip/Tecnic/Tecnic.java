
package membres_equip.Tecnic;

import java.util.Scanner;
import membres_equip.Empleat_Plantilla;

public class Tecnic extends Empleat_Plantilla{

    public int getSou_variable() {
        return sou_variable;
    }

    public void setSou_variable(int sou_variable) {
        this.sou_variable = sou_variable;
    }
    
    public void gestioTecnic(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("****** Tria el tipus del Tecnic ******");
        System.out.println("1. Entrenador");
        System.out.println("2. Preparador fisic");
        
        String op = sc.next();
        char opcio = op.charAt(0);
        
        switch(opcio){
            case'1':
                Entrenador e = new Entrenador();
                e.altaEntrenador();
                break;
            case'2':
                Preparador_fisic pf = new Preparador_fisic();
                pf.altaPreparadorFisic();
                break;
        }
    }
}
