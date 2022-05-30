
package membres_equip.Tecnic;


public class Entrenador extends Tecnic{
    
    private int anysExperiencia;
    private int numeroTrofeus;

    public int getAnysExperiencia() {
        return anysExperiencia;
    }

    public void setAnysExperiencia(int anysExperiencia) {
        this.anysExperiencia = anysExperiencia;
    }

    public int getNumeroTrofeus() {
        return numeroTrofeus;
    }

    public void setNumeroTrofeus(int numeroTrofeus) {
        this.numeroTrofeus = numeroTrofeus;
    }

    public Entrenador(int anysExperiencia, int numeroTrofeus) {
        this.anysExperiencia = anysExperiencia;
        this.numeroTrofeus = numeroTrofeus;
    }
    
    public int CalculSouVar(){
        return 0;
    }
    
    public void altaEntrenador(){
        
    }
}
