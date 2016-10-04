
import java.io.Serializable;

/**
 *  Készítő: Radovits Ádám
 *  Neptun: Z8EJQ5
 */
public class Szemely implements Serializable {
    private String nev;
    private int fizetes;

    public Szemely(String nev, int fizetes) {
        this.nev = nev;
        this.fizetes = fizetes;
    }

    public String getNev() {
        return nev;
    }

    public int getFizetes() {
        return fizetes;
    }

    @Override
    public String toString() {
        return "Személy{ név: " + nev + ", fizetés: " + fizetes + " Ft}";
    }
    
}
