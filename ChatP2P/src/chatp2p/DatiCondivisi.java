/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miky
 */
public class DatiCondivisi {

    private List<String> DaInviare; //il client prende da qui i pacchetti da inviare
    private List<String> DaElaborare; //il server mette qui i pacchetti ricevuti da elaborare
    private boolean connesso; //per vedere se c'è già un peer connesso
    private Object sInvia,sElabora;
    Grafica g;
    public DatiCondivisi()
    {
        sElabora=new Object();
        sInvia=new Object();
        DaInviare = new ArrayList<>();
        DaElaborare = new ArrayList<>();
        connesso = false;
    }
    
    public void AddDaElaborare(String messaggio) {
        synchronized(sElabora)
        {DaElaborare.add(messaggio);}
    }

    public void AddDaInviare(String messaggio) {
        synchronized(sInvia)
        {DaInviare.add(messaggio);}
    }
    public String GetDaElaborare() {
        synchronized(sElabora)
        {String ris=DaElaborare.get(DaElaborare.size()-1);
        DaElaborare.remove(DaElaborare.size()-1);
        return ris;}
    }

    public String GetDaInviare() {
        synchronized(sInvia)
        {String ris=DaInviare.get(DaInviare.size()-1);
        DaInviare.remove(DaInviare.size()-1);
        return ris;}
    }
    
    public int GetSizeDaInviare() {
        synchronized(sInvia)
        {return DaInviare.size();}
    }
    public int GetSizeDaElaborare() {
        synchronized(sElabora)
        {return DaElaborare.size();}
    }
    
    public boolean isConnesso() {
        return connesso;
    }

    public void setConnesso(boolean connesso) {
        this.connesso = connesso;
    }
}
