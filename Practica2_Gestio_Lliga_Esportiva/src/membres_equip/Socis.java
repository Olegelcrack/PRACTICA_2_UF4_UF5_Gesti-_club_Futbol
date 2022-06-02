
package membres_equip;

import Equip_Futbol.Equip_Futbol;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Socis extends Membre_Equip{
    
    private int numeroSoci=0;
    private int numeroLocalitat=500;
    private int quotaAnual;
        
    public Socis(String dni,  String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numeroSoci, int numeroLocalitat, int quotaAnual){
        super(dni, nom, cognom, datanaixement, telefon, email);
        this.numeroSoci = numeroSoci;
        this.numeroLocalitat = numeroLocalitat;
        this.quotaAnual = quotaAnual;
    }
    
    public Socis(){
        
    }

    @Override
    public String toString() {
        return "Socis{" + "dni=" + getDni() + ", nom=" + getNom() + ", cognom=" + getCognom() + ", datanaixement=" + getDatanaixement() + ", telefon=" + getTelefon() + ", email=" + getEmail() + ", numeroSoci=" + numeroSoci + ", numeroLocalitat=" + numeroLocalitat + ", quotaAnual=" + quotaAnual + '}';
    }

    
    
    public int getNumeroSoci() {
        return numeroSoci;
    }

    public int getNumeroLocalitat() {
        return numeroLocalitat;
    }

    public int getQuotaAnual() {
        return quotaAnual;
    }

    public void setNumeroSoci(int numeroSoci) {
        this.numeroSoci = numeroSoci;
    }

    public void setNumeroLocalitat(int numeroLocalitat) {
        this.numeroLocalitat = numeroLocalitat;
    }

    public void setQuotaAnual(int quotaAnual) {
        this.quotaAnual = quotaAnual;
    }
    
    public void IncrementaSoci(ArrayList<Socis> socis) throws ParseException{
        if(!socis.isEmpty()){
            for(int i=0; i<=socis.size(); i++){
                numeroSoci=i;
            }
        }
        NumeroLoc(++numeroSoci, socis);
    }
    
    public void NumeroLoc(int num_soci, ArrayList<Socis> socis) throws ParseException{
        int num_loc=num_soci+numeroLocalitat;
        AltaSocis(num_soci, num_loc, socis);
    }
    
    public void AltaSocis(int num_soci, int num_loc, ArrayList<Socis> socis) throws ParseException{
        Scanner sc = new Scanner(System.in);
        
        DNI comp_dni = new DNI();
        String dni;
        
        do{
            System.out.println("Posar el DNI del nou Soci: ");
            dni = sc.next();
        }while(!comp_dni.validarDni(dni));
        comp_dni.setDni(dni);
        setDni(dni);
        
        System.out.println("Posar el nom del nou Soci: ");
        String nom = sc.next();
        
        System.out.println("Posar el cognom del nou Soci: ");
        String cognom = sc.next();
        
        LocalDate datanaixement=null;
        boolean data_correct=false;
        do{
            try{
                data_correct=true;
                System.out.println("Posar la data naixement del Soci: (aaaa-mm-dd)");
                String data = sc.next();
                datanaixement = LocalDate.parse(data);
            }catch(Exception ex){
                data_correct=false;
                System.out.println("Data introduïda incorectament");
            }
        }while(!data_correct);
        
        Telefon comp_tel = new Telefon();
        int telefon;
        
        do{
            System.out.println("Posar el numero telefon del Soci: ");
            telefon = sc.nextInt();
        }while(!comp_tel.validaTelefon(telefon));
        comp_tel.setTelefon(telefon);
        setTelefon(telefon);
        
        Email comp_email = new Email();
        String email;
        
        do{
            System.out.println("Posar el correu del Soci: ");
            email = sc.next();
        }while(!comp_email.validaEmail(email));
        comp_email.setEmail(email);
        setEmail(email);
        
        System.out.println("Posar la quota anual: ");
        int quota_anual = sc.nextInt();
        
        Socis s = new Socis(dni,nom,cognom,datanaixement,telefon,email,num_soci,num_loc,quota_anual);
        
        socis.add(s);
    }
    
    public void ModSocis(ArrayList<Socis> socis){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Soci que vols Modificar: ");
        String dni_mod = sc.next();
        
        for(Socis s1:socis){
            if(dni_mod.equals(s1.getDni())){
                
                DNI comp_dni = new DNI();
                String dni;

                do{
                    System.out.println("Posar el nou DNI del Soci: ");
                    dni = sc.next();
                }while(!comp_dni.validarDni(dni));
                comp_dni.setDni(dni);
                setDni(dni);
                
                System.out.println("Posar el nou nom del Soci: ");
                String nom = sc.next();
                
                System.out.println("Posar el nou cognom del Soci: ");
                String cognom = sc.next();
                
                LocalDate datanaixement=null;
                boolean data_correct=false;
                do{
                    try{
                        data_correct=true;
                        System.out.println("Posar la data naixement del Soci: (aaaa-mm-dd)");
                        String data = sc.next();
                        datanaixement = LocalDate.parse(data);
                    }catch(Exception ex){
                        data_correct=false;
                        System.out.println("Data introduïda incorectament");
                    }
                }while(!data_correct);
                
                Telefon comp_tel = new Telefon();
                int telefon;

                do{
                    System.out.println("Posar el numero telefon del Soci: ");
                    telefon = sc.nextInt();
                }while(!comp_tel.validaTelefon(telefon));
                comp_tel.setTelefon(telefon);
                setTelefon(telefon);
                
                Email comp_email = new Email();
                String email;

                do{
                    System.out.println("Posar el correu del Soci: ");
                    email = sc.next();
                }while(!comp_email.validaEmail(email));
                comp_email.setEmail(email);
                setEmail(email);

                System.out.println("Posar la quota anual: ");
                int quota_anual = sc.nextInt();
                
                s1.setDni(dni);
                s1.setNom(nom);
                s1.setCognom(cognom);
                s1.setDatanaixement(datanaixement);
                s1.setTelefon(telefon);
                s1.setEmail(email);
                s1.setQuotaAnual(quota_anual);
                
                return;
            }   
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void BaixaSocis(ArrayList<Socis> socis){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Soci que vols Borrar: ");
        String dni_esb = sc.next();
        
        for(Socis s1:socis){
            if(dni_esb.equals(s1.getDni())){
                socis.remove(s1);
                return;
            }
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void VisualitzarPerNom(ArrayList<Socis> socis){
        Collections.sort(socis, new Comparator<Socis>(){
            @Override
            public int compare(Socis s1, Socis s2){
                if(!s1.getCognom().equals(s2.getCognom())){
                    return s1.getCognom().compareToIgnoreCase(s2.getCognom());
                }
                return s1.getNom().compareToIgnoreCase(s2.getNom());
            }
        });
        Visualitzar(socis);
    }
    
    public void VisualitzarPerLoc(ArrayList<Socis> socis){
        Collections.sort(socis, new Comparator<Socis>(){
            @Override
            public int compare(Socis s1, Socis s2){
                return s1.getNumeroLocalitat() - (s2.getNumeroLocalitat());
            }
        });
        Visualitzar(socis);
    }
    
    public void VisualitzarPerQuota(ArrayList<Socis> socis){
        Collections.sort(socis, new Comparator<Socis>(){
            @Override
            public int compare(Socis s1, Socis s2){
                return s1.getQuotaAnual()- (s2.getQuotaAnual());
            }
        });
        Visualitzar(socis);
    }
    
    public void Visualitzar(ArrayList<Socis> socis){
        for(Socis s1: socis){
            System.out.println(s1);
        }
    }
}
