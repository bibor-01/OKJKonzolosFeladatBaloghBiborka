
package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modell.Elelmiszer;
import modell.Raktar;


public class Program {

    
    public static void main(String[] args) {
        Raktar raktar = new Raktar();
         //kiírás:
        try {
            FileOutputStream fileOut = new FileOutputStream("raktar.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(raktar);
            out.close();
            fileOut.close();
            System.out.printf("sikeres kiírás!");
        } catch (IOException i) {
            i.printStackTrace();
        }
        raktar = null;

        //Visszaolvasás
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            raktar = (Raktar) objBe.readObject();
            objBe.close();
            System.out.println("Visszaállítás:");
            for (Elelmiszer elelmiszer : raktar) {
                System.out.println(elelmiszer);
            }
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Sikertelen beolvasás!");
            c.printStackTrace();
            return;
        } 
    }
    
}
