/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

/**
 *
 * @author Miky
 */
public class CSV {

    public CSV() {
    }
    
    static String Componi(String vett[])
    {
        String dati = "";
        for(int i = 0; i < vett.length - 1; i++)
        {
            dati += vett[i] + ";";
        }
        dati += vett[vett.length - 1]; //l'ultimo non deve avere la virgola      
        return dati;
    }
    
    static String[] Splitta(String dati)
    {
        String[] d = dati.split(";"); //splitto i dati
        return d;
    }
}
