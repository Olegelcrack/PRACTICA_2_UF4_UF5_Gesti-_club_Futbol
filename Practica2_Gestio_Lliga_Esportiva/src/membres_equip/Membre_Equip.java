
package membres_equip;

import Equip_Futbol.Equip_Futbol;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Membre_Equip implements Serializable{
    
    private String dni;
    private String nom;
    private String cognom;
    private LocalDate datanaixement;
    private int telefon;
    private String email;
    
    
    public Membre_Equip(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.datanaixement = datanaixement;
        this.telefon = telefon;
        this.email = email;
    }
    
    public Membre_Equip(){
        
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public LocalDate getDatanaixement() {
        return datanaixement;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setDatanaixement(LocalDate datanaixement) {
        this.datanaixement = datanaixement;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Membre_Equip{" + "dni=" + dni + ", nom=" + nom + ", cognom=" + cognom + ", datanaixement=" + datanaixement + ", telefon=" + telefon + ", email=" + email + '}';
    }


}
