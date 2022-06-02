
package Equip_Futbol;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import membres_equip.Empleat_Plantilla;
import membres_equip.Socis;

public class Equip_Futbol {
    
    private String nom;
    private String cif;
    private String adreça;
    private int telefon;
    private String email;
    private String www;

    public Equip_Futbol() {
    }
    
    public Equip_Futbol(String nom, String cif, String adreça, int telefon, String email, String www) {
        this.nom = nom;
        this.cif = cif;
        this.adreça = adreça;
        this.telefon = telefon;
        this.email = email;
        this.www = www;
    }

    @Override
    public String toString() {
        return "Equip_Futbol{" + "nom=" + nom + ", cif=" + cif + ", adre\u00e7a=" + adreça + ", telefon=" + telefon + ", email=" + email + ", www=" + www + '}';
    }

    
    
    Socis soci = new Socis();
    Empleat_Plantilla ep = new Empleat_Plantilla();
    
    ArrayList<Socis> socis = new ArrayList<>();
    ArrayList<Empleat_Plantilla> empleats = new ArrayList<>();

    public ArrayList<Socis> getSocis() {
        return socis;
    }
    
    private boolean sortir=false;
    private boolean enrere=false;
    private boolean enrere1=false;
    private boolean enrere2=false;
    
    public void GestioEquip() throws ParseException{
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("\n************* Menu Club *************");
            
            System.out.println("1. Consultar Dades del Equip");
            System.out.println("2. Gestionar Socis");
            System.out.println("3. Gestionar Plantilla");
            System.out.println("4. Visualitzar Dades Economiques");
            System.out.println("5. Sortir");
            
            String op = sc.next();
            char opcio = op.charAt(0);
            
            System.out.println("\nOpció: " + opcio + "\n");
            
            switch(opcio){
                case '1':
                    ConsultaDades();
                    break;
                case'2':
                    do{
                        System.out.println("1. Alta Soci");
                        System.out.println("2. Modificacio Soci");
                        System.out.println("3. Baixa Soci");
                        System.out.println("4. Visualitzar per Criteris");
                        System.out.println("5. Enrere");
                        
                        op = sc.next();
                        opcio = op.charAt(0);
                        
                        System.out.println("\nOpció: " + opcio + "\n");
                        
                        switch(opcio){
                            case '1':
                                soci.IncrementaSoci(socis);
                                break;
                            case '2':
                                soci.ModSocis(socis);
                                break;
                            case '3':
                                soci.BaixaSocis(socis);
                                break;
                            case '4':
                                do{
                                    enrere=false;
                                    enrere2=false;
                                    System.out.println("a. Visualitzar per Cognom i Nom");
                                    System.out.println("b. Visualitzar per Localitat");
                                    System.out.println("c. Visualitzar per Quota");
                                    System.out.println("s. Enrere");
                                    
                                    op = sc.next();
                                    opcio = op.charAt(0);
                                    
                                    System.out.println("\nOpció: " + opcio + "\n");
                                    
                                    switch(opcio){
                                        case 'a':
                                            soci.VisualitzarPerNom(socis);
                                            break;
                                        case 'b':
                                            soci.VisualitzarPerLoc(socis);
                                            break;
                                        case 'c':
                                            soci.VisualitzarPerQuota(socis);
                                            break;
                                        case 's':
                                            enrere2=true;
                                            break;
                                        default:
                                            System.out.println("Opcio invalida");
                                    }
                                }while(!enrere2);
                                break;
                            case '5':
                                enrere=true;
                                break;
                            default:
                                System.out.println("Opcio invalida");
                        }
                    }while(!enrere);
                    break;
                case'3':
                    do{
                        System.out.println("1. Alta Plantilla");
                        System.out.println("2. Mod Plantilla");
                        System.out.println("3. Baixa Plantilla");
                        System.out.println("4. Visualitzar per Criteris");
                        System.out.println("5. Enrere");
                        
                        op = sc.next();
                        opcio = op.charAt(0);
                        
                        System.out.println("\nOpció: " + opcio + "\n");
                        
                        switch(opcio){
                            case'1':
                                ep.IncrementaEmpleat(empleats);
                                break;
                            case'2':
                                ep.ModEmpleat(empleats);
                                break;
                            case'3':
                                ep.BaixaEmpleat(empleats);
                                break;
                            case'4':
                                do{
                                    enrere1=false;
                                    enrere2=false;
                                    
                                    System.out.println("a. Visualitzar per Rols");
                                    System.out.println("b. Visualitzar per Sou Variable");
                                    System.out.println("s. Enrere");
                                    
                                    op = sc.next();
                                    opcio = op.charAt(0);
                                    
                                    System.out.println("\nOpció: " + opcio + "\n");
                                    
                                    switch(opcio){
                                        case'a':
                                            ep.VisualitzarPerRols(empleats);
                                            break;
                                        case'b':
                                            ep.VisualitzarPerSou(empleats);
                                            break;
                                        case's':
                                            enrere2=true;
                                            break;
                                    }
                                }while(!enrere2);
                                break;
                            case'5':
                                enrere1=true;
                                break;
                            default:
                                System.out.println("Opcio invalida");
                        }
                    }while(!enrere1);
                    break;
                case'4':
                    VisualitzarDadesEco();
                    break;
                case'5':
                    sortir=true;
                    break;
                default:
                    System.out.println("Opcio invalida");
            }
        }while(!sortir);
    }
    
    public void ConsultaDades(){
        System.out.println(this.nom +" "+ this.cif +" "+ this.adreça +" "+ this.telefon +" "+ this.email +" "+ this.www);
    }
    
    public void VisualitzarDadesEco(){
        int balanç = calculaDadesEco();
        System.out.println("El balanç del club es: " + balanç);
    }
    
    public int calculaDadesEco(){
        int total_quota=0;
        for(Socis s1: socis){
            total_quota+=s1.getQuotaAnual();
        }
        
        int total_sou_inc=0;
        for(Empleat_Plantilla ep1 : empleats){
            total_sou_inc+=ep1.getSou_variable();
        }
        int balanç=total_quota-total_sou_inc;
        return balanç;
    }
}
