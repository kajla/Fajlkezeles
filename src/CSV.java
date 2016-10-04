
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *  Készítő: Radovits Ádám
 *  Neptun: Z8EJQ5
 */
public class CSV {
    public static void main(String[] args) {
        File f = new File("./adat.csv");    // aktuális mappa
    /*    
        System.out.println(f.exists());     // létezik-e a fájl?
        System.out.println(f.isDirectory());    // mappa-e?
        System.out.println(f.isFile());         // fájl-e?
        System.out.println(f.getAbsolutePath());    // hol van?
        System.out.println(f.length());     // mekkora a fájl bájtban?
     */    
        ArrayList<Szemely> szemelyLista = new ArrayList();
        BufferedReader br = null;    // beolvasás
        try {
            br = new BufferedReader(new FileReader(f));     // fájl megnyitása
//            System.out.println(br.readLine());
            
            br.readLine();
            String sor = "";
//            int ossz = 0, db = 0;
            while ((sor = br.readLine()) != null) {     // amíg nincs vége a fájlnak
//                System.out.println(sor);    // br.readLine() nem jó.
                String[] daraboltSor = sor.split(";");     // ;-nél darabolunk
                String nev = daraboltSor[0];
                int fizetes = Integer.parseInt(daraboltSor[1]);
                szemelyLista.add(new Szemely(nev, fizetes));
                
//                ossz += fizetes;
//                db++;
            }
//            System.out.println("Átlagfizetés: " + (double)ossz/db);
        } 
        catch (NumberFormatException e) {   // ha a beolvasott szám valóban nem szám
            System.out.println("Hiba! ...");
        }
        catch (FileNotFoundException e) {
            System.out.println("Hiba! Nincs meg a fájl!");
        }
        catch (IOException e) {     // ha bármi más hiba lenne
            System.out.println("Hiba! Nem sikerült olvasni a fájlból.");
        }
        finally {
            try {
                if (br != null)
                    br.close();     // bezárás, ha sikerült megnyitni
            }
            catch (IOException e) {
                System.out.println("Hiba! Nem sikerült lezárni a fájlt!");
            }
        }
        
        // feldolgozás
        Collections.sort(szemelyLista, new Comparator<Szemely>() {

            @Override
            public int compare(Szemely o1, Szemely o2) {
                return o1.getNev().compareTo(o2.getNev());
            }
        });
        for (Szemely szemely : szemelyLista) {
            System.out.println(szemely.getNev());
        }
        
        // átlagfizetés
        int ossz = 0, fo = 0;
        for (Szemely szemely : szemelyLista) {
            ossz += szemely.getFizetes();
            fo++;
        }
        System.out.println("Átlagfizetés: " + (double)ossz/fo);
    }
}
