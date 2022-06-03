
package membres_equip;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import membres_equip.Jugador.Davanter;
import membres_equip.Jugador.Defensa;
import membres_equip.Jugador.Jugador;
import membres_equip.Jugador.Migcampista;
import membres_equip.Jugador.Porter;
import membres_equip.Tecnic.Entrenador;
import membres_equip.Tecnic.Preparador_fisic;
import membres_equip.Tecnic.Tecnic;

public class Empleat_Plantilla extends Membre_Equip implements Serializable{
    
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
        return "\ndni = " + getDni() + " \nnom = " + getNom() + " \ncognom = " + getCognom() + " \ndatanaixement = " + getDatanaixement() + " \ntelefon = " + getTelefon() + " \nemail = " + getEmail() + " \nnumeroEmpleat = " + numero_empleat + " \nnumeroSS = " + numeroSS + " \nsouBase = " + sou_base + " \nsouVariable = " + sou_variable;
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
        
        boolean enrere=false;
        
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
        
        System.out.println("\n****** Tria el tipus d'empleat ******");
        System.out.println("1. Tecnic");
        System.out.println("2. Jugador");
        
        String op = sc.next();
        char opcio = op.charAt(0);
        
        switch(opcio){
            case'1':
                System.out.println("\n****** Tria el tipus del Tecnic ******");
                System.out.println("1. Entrenador");
                System.out.println("2. Preparador fisic");
                
                op = sc.next();
                opcio = op.charAt(0);

                switch(opcio){
                    case'1':
                        
                        System.out.println("Ficar els anys d'experiencia del Entrenador: ");
                        int anys_experiencia = sc.nextInt();
                        
                        System.out.println("Ficar el numero trofeus del Entrenador: ");
                        int numero_trofeus = sc.nextInt();
                        
                        Entrenador en = new Entrenador();
                        
                        sou_variable=en.CalculSouVar(numero_trofeus);
                        
                        Entrenador en1 = new Entrenador(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,anys_experiencia,numero_trofeus);
                        
                        empleats.add(en1);
                        
                        break;
                        
                    case'2':
                        
                        System.out.println("Ficar els anys d'experiencia del Preparador fisic: ");
                        anys_experiencia = sc.nextInt();
                        
                        Preparador_fisic pf = new Preparador_fisic();
                        
                        sou_variable=pf.CalculSouVar(anys_experiencia);
                        
                        Preparador_fisic pf1 = new Preparador_fisic(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,anys_experiencia);
                        
                        empleats.add(pf1);
                        
                        break;
                        
                    default:
                        System.out.println("Opcio invalida");
                }
                break;
            case'2':
                System.out.println("\n****** Tria el tipus del Jugador ******");
                System.out.println("1. Porter");
                System.out.println("2. Defensa");
                System.out.println("3. Migcampista");
                System.out.println("4. Davanter");
                
                op = sc.next();
                opcio = op.charAt(0);
                
                System.out.println("Es titular(true/false): ");
                boolean titular = sc.nextBoolean();

                Jugador j = new Jugador();
                int dorsal = j.IncrementaDorsal(empleats);
                
                switch(opcio){
                    case'1':
                        
                        System.out.println("Ficar els Gols Aturats: ");
                        int gols_a = sc.nextInt();
                        
                        System.out.println("Ficar els Gols Rebuts: ");
                        int gols_r = sc.nextInt();
                        
                        Porter p = new Porter();
                        
                        sou_variable = p.CalculSouVar(gols_a);
                        
                        Porter p1 = new Porter(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,dorsal,titular,gols_a,gols_r);
                        
                        empleats.add(p1);
                        
                        break;
                        
                    case'2':
                        
                        System.out.println("Ficar els Atacs Aturats: ");
                        int atacsAturats = sc.nextInt();
                        
                        System.out.println("Ficar els Balons Recuperats: ");
                        int balonsRecuperats = sc.nextInt();
                        
                        Defensa def = new Defensa();
                        
                        sou_variable = def.CalculSouVar(atacsAturats, balonsRecuperats);
                        
                        Defensa def1 = new Defensa(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,dorsal,titular,atacsAturats,balonsRecuperats);
                        
                        empleats.add(def1);
                        
                        break;
                        
                    case'3':
                        
                        System.out.println("Ficar les Asistencies de Gols: ");
                        int asistGols = sc.nextInt();
                        
                        System.out.println("Ficar els Balons Recuperats: ");
                        int balonsRecuperats1 = sc.nextInt();
                        
                        Migcampista mc = new Migcampista();
                        
                        sou_variable = mc.CalculSouVar(asistGols, balonsRecuperats1);
                        
                        Migcampista mc1 = new Migcampista(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,dorsal,titular,asistGols,balonsRecuperats1);
                        
                        empleats.add(mc1);
                        
                        break;
                        
                    case'4':
                        
                        System.out.println("Ficar els Gols: ");
                        int gols = sc.nextInt();
                        
                        System.out.println("Ficar els Balons Recuperats: ");
                        int balonsRecuperats2 = sc.nextInt();
                        
                        Davanter dav = new Davanter();
                        
                        sou_variable = dav.CalculSouVar(gols, balonsRecuperats2);
                        
                        Davanter dav1 = new Davanter(dni,nom,cognom,datanaixement,telefon,email,num_emp,numeroSS,sou_base,sou_variable,dorsal,titular,gols,balonsRecuperats2);
                        
                        empleats.add(dav1);
                        
                        break;
                    default:
                        System.out.println("Opcio invalida");
                }
                break;
            
            default:
                System.out.println("Opcio invalida");
                
        }
    }
    
    public void ModEmpleat(ArrayList<Empleat_Plantilla> empleats){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Empleat que vols Modificar: ");
        String dni_mod = sc.next();
        
        for(Empleat_Plantilla ep1 : empleats){
            if(dni_mod.equals(ep1.getDni())){
                
                int pos = ep1.toString().indexOf("dorsal = "); // Canvio un objecte de la llista a string, grabo la posicio de dorsal
                char dorsal1 = ep1.toString().charAt(pos+9); // grabo el numero que es posara a 'dorsal = num'
                int dorsal = Character.getNumericValue(dorsal1); //converteixo el char a int
                
                DNI comp_dni = new DNI();
                String dni;

                do{
                    System.out.println("Posar el nou DNI del Empleat: ");
                    dni = sc.next();
                }while(!comp_dni.validarDni(dni));
                comp_dni.setDni(dni);
                setDni(dni);
                
                System.out.println("Posar el nou nom del Empleat: ");
                String nom = sc.next();
                
                System.out.println("Posar el nou cognom del Empleat: ");
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
                int numero_ss = sc.nextInt();
                
                System.out.println("Posar el Sou Base: ");
                int sou_base1 = sc.nextInt();
                
                int num_emp = ep1.getNumero_empleat();
                
                if(ep1.toString().contains("Entrenador")){
                    
                    System.out.println("Posar els anys d'experiencia: ");
                    int anys_experiencia = sc.nextInt();
                    
                    System.out.println("Posar el numero trofeus");
                    int numero_trofeus = sc.nextInt();
                    
                    Entrenador en = new Entrenador();
                        
                    sou_variable=en.CalculSouVar(numero_trofeus);
                    
                    Entrenador en1 = new Entrenador(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,anys_experiencia,numero_trofeus);
                    empleats.remove(ep1);
                    empleats.add(en1);
                    
                    return;
                    
                }else if(ep1.toString().contains("Preparador_fisic")){
                    
                    System.out.println("Posar els anys d'experiencia");
                    int anys_experiencia = sc.nextInt();
                    
                    Preparador_fisic pf = new Preparador_fisic();
                        
                    sou_variable=pf.CalculSouVar(anys_experiencia);
                    
                    Preparador_fisic pf1 = new Preparador_fisic(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,anys_experiencia);
                    empleats.remove(ep1);
                    empleats.add(pf1);
                    
                    return;
                    
                }else if(ep1.toString().contains("Porter")){
                    
                    System.out.println("Es titular(true/false): ");
                    boolean titular = sc.nextBoolean();
                    
                    System.out.println("Posar els gols Aturats: ");
                    int gols_aturats = sc.nextInt();
                    
                    System.out.println("Posar els gols Rebuts: ");
                    int gols_rebuts = sc.nextInt();
                    
                    Porter p = new Porter();
                        
                    sou_variable = p.CalculSouVar(gols_aturats);
                    
                    Porter po1 = new Porter(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,dorsal,titular,gols_aturats,gols_rebuts);
                    empleats.remove(ep1);
                    empleats.add(po1);
                    
                    return;
                    
                }else if(ep1.toString().contains("Defensa")){
                    
                    System.out.println("Es Titular(true/false): ");
                    boolean titular = sc.nextBoolean();
                    
                    System.out.println("Posar els Atacs Aturats: ");
                    int atacs_aturats = sc.nextInt();
                    
                    System.out.println("Posar els Balons Recuperats: ");
                    int balons_recuperats = sc.nextInt();
                    
                    Defensa def = new Defensa();
                        
                    sou_variable = def.CalculSouVar(atacs_aturats, balons_recuperats);
                    
                    Defensa def1 = new Defensa(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,dorsal,titular,atacs_aturats,balons_recuperats);
                    empleats.remove(ep1);
                    empleats.add(def1);
                    
                    return;
                    
                }else if(ep1.toString().contains("Migcampista")){
                    
                    System.out.println("Es Titular(true/false): ");
                    boolean titular = sc.nextBoolean();
                    
                    System.out.println("Posar els Asistencies de Gols: ");
                    int asist_gols = sc.nextInt();
                    
                    System.out.println("Posar els Balons Recuperats: ");
                    int balons_recuperats = sc.nextInt();
                    
                    Migcampista mc = new Migcampista();
                        
                    sou_variable = mc.CalculSouVar(asist_gols, balons_recuperats);
                    
                    Migcampista mc1 = new Migcampista(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,dorsal,titular,asist_gols,balons_recuperats);
                    empleats.remove(ep1);
                    empleats.add(mc1);
                    
                    return;
                    
                }else if(ep1.toString().contains("Davanter")){
                    
                    System.out.println("Es Titular(true/false): ");
                    boolean titular = sc.nextBoolean();
                    
                    System.out.println("Posar els Gols: ");
                    int gols = sc.nextInt();
                    
                    System.out.println("Posar els Balons Recuperats: ");
                    int balons_recuperats = sc.nextInt();
                    
                    Davanter dav = new Davanter();
                        
                    sou_variable = dav.CalculSouVar(gols, balons_recuperats);
                    
                    Davanter dav1 = new Davanter(dni,nom,cognom,datanaixement,telefon,email,num_emp,numero_ss,sou_base1,sou_variable,dorsal,titular,gols,balons_recuperats);
                    empleats.remove(ep1);
                    empleats.add(dav1);
                    
                    return;
                    
                }
            }   
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void BaixaEmpleat(ArrayList<Empleat_Plantilla> empleats){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Posar el DNI del Empleat que vols Borrar: ");
        String dni_esb = sc.next();
        
        for(Empleat_Plantilla ep1 : empleats){
            if(dni_esb.equals(ep1.getDni())){
                empleats.remove(ep1);
                return;
            }
        }
        System.out.println("\nEl soci amb aquest DNI no existeix\n");
    }
    
    public void VisualitzarPerRols(ArrayList<Empleat_Plantilla> empleats){
        Collections.sort(empleats, new Comparator<Empleat_Plantilla>(){
            @Override
            public int compare(Empleat_Plantilla ep1, Empleat_Plantilla ep2){
                return ep1.getClass().toString().compareTo(ep2.getClass().toString());
            }
        });
        Visualitzar(empleats);
    }
    
    public void VisualitzarPerSou(ArrayList<Empleat_Plantilla> empleats){
        Collections.sort(empleats, new Comparator<Empleat_Plantilla>(){
            @Override
            public int compare(Empleat_Plantilla ep1, Empleat_Plantilla ep2){
                return ep2.getSou_variable()-ep1.getSou_variable();
            }
        });
        Visualitzar(empleats);
    }
    
    public void Visualitzar(ArrayList<Empleat_Plantilla> empleats){
        for(Empleat_Plantilla ep1 : empleats){
            System.out.println(ep1);
        }
    }
}
