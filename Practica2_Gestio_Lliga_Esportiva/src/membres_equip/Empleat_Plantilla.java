
package membres_equip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import membres_equip.Jugador.Jugador;
import membres_equip.Tecnic.Tecnic;

public class Empleat_Plantilla extends Membre_Equip{
    
    private int numero_empleat=0;
    private int numeroSS;
    private int sou_base;
    protected int sou_variable;

    public int getNumero_empleat() {
        return numero_empleat;
    }

    public void setNumero_empleat(int numero_empleat) {
        this.numero_empleat = numero_empleat;
    }

    public int getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(int numeroSS) {
        this.numeroSS = numeroSS;
    }

    public int getSou_base() {
        return sou_base;
    }

    public void setSou_base(int sou_base) {
        this.sou_base = sou_base;
    }

    public int getSou_variable() {
        return sou_variable;
    }

    public void setSou_variable(int sou_variable) {
        this.sou_variable = sou_variable;
    }

    public Empleat_Plantilla(String dni, String nom, String cognom, LocalDate datanaixement, int telefon, String email, int numero_empleat, int numeroSS, int sou_base, int sou_variable) {
        super(dni, nom, cognom, datanaixement, telefon, email);
        this.numero_empleat = numero_empleat;
        this.numeroSS = numeroSS;
        this.sou_base = sou_base;
        this.sou_variable = sou_variable;
    }

    public Empleat_Plantilla() {
    }

    @Override
    public String toString() {
        return "Empleat_Plantilla{" + "dni=" + getDni() + ", nom=" + getNom() + ", cognom=" + getCognom() + ", datanaixement=" + getDatanaixement() + ", telefon=" + getTelefon() + ", email=" + getEmail() + ", numeroEmpleat=" + numero_empleat + ", numeroSS=" + numeroSS + ", souBase=" + sou_base + ", souVariable=" + sou_variable + '}';
    }
    
    public void IncrementaEmpleat(ArrayList<Empleat_Plantilla> empleats){
        if(!empleats.isEmpty()){
            for(int i=0; i<=empleats.size(); i++){
                numero_empleat=i;
            }
        }
        AltaEmpleat(++numero_empleat, empleats);
    }
    
    public void AltaEmpleat(int num_emp ,ArrayList<Empleat_Plantilla> empleats){
        Scanner sc = new Scanner(System.in);
        
        DNI comp_dni = new DNI();
        String dni;
        
        do{
            System.out.println("Posar el DNI del nou Empleat: ");
            dni = sc.next();
        }while(!comp_dni.validarDni(dni));
        comp_dni.setDni(dni);
        setDni(dni);
        
        System.out.println("Posar el nom del nou Empleat: ");
        String nom = sc.next();
        
        System.out.println("Posar el cognom del nou Empleat: ");
        String cognom = sc.next();
        
        LocalDate datanaixement=null;
        boolean data_correct=false;
        do{
            try{
                data_correct=true;
                System.out.println("Posar la data naixement del Empleat: (aaaa-mm-dd)");
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
            System.out.println("Posar el numero telefon del Empleat: ");
            telefon = sc.nextInt();
        }while(!comp_tel.validaTelefon(telefon));
        comp_tel.setTelefon(telefon);
        setTelefon(telefon);
        
        Email comp_email = new Email();
        String email;
        
        do{
            System.out.println("Posar el correu del Empleat: ");
            email = sc.next();
        }while(!comp_email.validaEmail(email));
        comp_email.setEmail(email);
        setEmail(email);
        
        System.out.println("Posar el numero de Seguretat Social: ");
        numeroSS = sc.nextInt();
        
        System.out.println("Posar el sou base del Empleat: ");
        sou_base = sc.nextInt();
        
        Empleat_Plantilla ep = new Empleat_Plantilla(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,1);
        
        empleats.add(ep);
        
        System.out.println("****** Tria el tipus d'empleat ******");
        System.out.println("1. Tecnic");
        System.out.println("2. Jugador");
        
        String op = sc.next();
        char opcio = op.charAt(0);
        
        switch(opcio){
            case'1':
                Tecnic t = new Tecnic();
                t.gestioTecnic();
                break;
            case'2':
                Jugador j = new Jugador();
                j.gestioJugador();
                break;
        }
    }
    
    public void ModEmpleat(ArrayList<Empleat_Plantilla> empleats){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Empleat que vols Modificar: ");
        String dni_mod = sc.next();
        
        for(Empleat_Plantilla ep1 : empleats){
            if(dni_mod.equals(ep1.getDni())){
                
                System.out.println("Posar el nou DNI del Empleat: ");
                String dni = sc.next();
                
                System.out.println("Posar el nou nom del Empleat: ");
                String nom = sc.next();
                
                System.out.println("Posar el nou cognom del Empleat: ");
                String cognom = sc.next();
                
                System.out.println("Posar la data naixement del Empleat: ");
                String data = sc.next();
                LocalDate datanaixement = LocalDate.parse(data);
                
                System.out.println("Posar el numero telefon del Empleat");
                int telefon = sc.nextInt();
                
                System.out.println("Posar el correu del Empleat: ");
                String email = sc.next();

                System.out.println("Posar el numero de Seguretat Social: ");
                int numero_ss = sc.nextInt();
                
                System.out.println("Posar el Sou Base: ");
                int sou_base = sc.nextInt();
                
                ep1.setDni(dni);
                ep1.setNom(nom);
                ep1.setCognom(cognom);
                ep1.setDatanaixement(datanaixement);
                ep1.setTelefon(telefon);
                ep1.setEmail(email);
                ep1.setNumeroSS(numero_ss);
                ep1.setSou_base(sou_base);
                
                return;
            }   
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void BaixaEmpleat(ArrayList<Empleat_Plantilla> empleats){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Soci que vols Borrar: ");
        String dni_esb = sc.next();
        
        for(Empleat_Plantilla ep1 : empleats){
            if(dni_esb.equals(ep1.getDni())){
                empleats.remove(ep1);
                return;
            }
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void VisualitzarPerCriteris(ArrayList<Empleat_Plantilla> empleats){
        for(Empleat_Plantilla ep1 : empleats){
            System.out.println(ep1);
        }
    }
}
