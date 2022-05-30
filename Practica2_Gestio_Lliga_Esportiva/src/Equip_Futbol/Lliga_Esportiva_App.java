
package Equip_Futbol;

import java.text.ParseException;

public class Lliga_Esportiva_App{
    public static void main(String[] args) throws ParseException {
        
        Equip_Futbol equipf = new Equip_Futbol("FCBarcelona","U14927552","Av.Catalunya, 12",766544565,"FCB@gmail.com","FCB.com");
        
        equipf.GestioEquip();
    }
}