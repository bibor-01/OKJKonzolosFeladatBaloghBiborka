package modell;

import java.io.File;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private File receptAjanlas;

    public Konzerv(String nev, String gyarto) throws HibasDatumException {
        this(new File("nincs"), nev, gyarto);
    }

    public Konzerv(LocalDate datum, String nev, String gyarto) throws HibasDatumException {
        this(new File("nincs"), datum, nev, gyarto);
    }

    public Konzerv(String leiras, File receptAjanlas, String nev, String gyarto) throws HibasDatumException {
        this(LocalDate.now(), leiras, receptAjanlas, nev, gyarto);
    }

    public Konzerv(String leiras, File receptAjanlas, LocalDate datum, String nev, String gyarto) throws HibasDatumException {
        super(datum, nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = receptAjanlas;
    }
   public void receptMitat(){
        if(receptAjanlas.exists()){
            System.out.println("");
        }
    }
    @Override
    public String toString() {
        return "Konzerv{" + "leiras=" + leiras + ", receptAjanlas=" + receptAjanlas + '}';
    }
    
    

}
