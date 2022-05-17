package modell;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;
import javafx.print.Collation;

class nevComparator implements Comparator<Elelmiszer> {

    @Override
    public int compare(Elelmiszer egyik, Elelmiszer masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getNev(), masik.getNev());
    }
}

class gyartoComparator implements Comparator<Elelmiszer> {

    @Override
    public int compare(Elelmiszer egyik, Elelmiszer masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getGyarto(), masik.getGyarto());
    }

}

public abstract class Elelmiszer {

    private LocalDate datum;
    private String nev, gyarto;

    public Elelmiszer(String nev, String gyarto) throws HibasDatumException {
        this(LocalDate.now(), nev, gyarto);
    }

    public Elelmiszer(LocalDate datum, String nev, String gyarto) throws HibasDatumException {
        if (datum.isAfter(LocalDate.now())) {
            throw new HibasDatumException("Lejárt élelmiszer");
        }
        this.datum = datum;
        this.nev = nev;
        this.gyarto = gyarto;
    }

    public static nevComparator nevRendez() {
        return new nevComparator();
    }

    public static gyartoComparator gyartoRendez() {
        return new gyartoComparator();
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    @Override
    public String toString() {
        return "Elelmiszer{" + "datum=" + datum + ", nev=" + nev + ", gyarto=" + gyarto + '}';
    }

}
