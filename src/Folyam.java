
import java.io.*;

/**
 *  Készítő: Radovits Ádám
 *  Neptun: Z8EJQ5
 */
public class Folyam {
    // Fájl készítés
    public static void main(String[] args) {
        File f = new File("./src/adat.dat");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(new Szemely("Péter", 276873));
            oos.writeObject(new Szemely("Pál", 176873));
            oos.writeObject(new Szemely("Rozi", 224568));
        } 
        catch (NotSerializableException e) {
            System.out.println("Hiba! Nincs engedély!");
        }
        catch (IOException e) {
//            System.out.println(e.getMessage());
            
            e.printStackTrace(); // --> Szemelyt kellett "felokosítani" (implements Serializable)
            System.out.println("... 1");
        }
        finally {
            if (oos != null) {
                try {
                    oos.close();
                }
                catch (IOException e) {
                    System.out.println("... 2");
                }
            }
        }
    }
    
//    // Beolvasás fájlból
//    public static void main(String[] args) {
//        File f = new File("./src/adat.dat");
//        ObjectInputStream ois = null;
//        int ossz = 0, fo = 0;
//        try {
//            ois = new ObjectInputStream(new FileInputStream(f));
//            while (true) {          // mesterséges végtelen ciklus              
////                System.out.println(ois.readObject());
////                Szemely s = (Szemely)ois.readObject(); // --> kockázatos
//                Object o = ois.readObject();
//                if (o instanceof Szemely) {
//                    Szemely s = (Szemely)o;
//                    ossz += s.getFizetes();
//                    fo++;
//                }
//            }
////            ois.close();
//        }   
//        catch (EOFException e) { // végtelen ciklust ez a kivétel szakította meg
////            System.out.println("Vége.");
//            System.out.println("Átlagfizetés: " + (double)ossz/fo);
//        }
//        catch (IOException e) {
//            System.out.println("Hiba! Nem sikerült olvasni a fájlból.");
//        }
//        catch (ClassNotFoundException e) {
//            System.out.println("Hiba! Konverziós hiba...");
//        }
//        finally {
//            try {
//                if (ois != null)
//                    ois.close();
//            }
//            catch (IOException e) {
//                System.out.println("Hiba! Nem sikerült lezárni a fájlt.");
//            }
//        }
//    }
}
