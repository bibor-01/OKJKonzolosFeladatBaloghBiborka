package modell;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Raktar implements Iterable<Elelmiszer>, Serializable{

    private ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        elelmiszerek = new ArrayList<>();
    }

    public List<Elelmiszer> rendezNevSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.nevRendez());
        return Collections.unmodifiableList(elelmiszerek);
    }

    public List<Elelmiszer> rendezGyartoSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.nevRendez());
        return Collections.unmodifiableList(elelmiszerek);
    }

    @Override
    public Iterator<Elelmiszer> iterator() {
        return Collections.unmodifiableList(elelmiszerek).iterator();
    }
}
