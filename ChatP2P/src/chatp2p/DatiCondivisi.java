/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

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

    public DatiCondivisi()
    {
        DaInviare = new ArrayList<>();
        DaElaborare = new ArrayList<>();
        connesso = false;
    }
    
    public List<String> getDaElaborare() {
        return DaElaborare;
    }

    public List<String> getDaInviare() {
        return DaInviare;
    }

    public void AddDaInviare(String pacchetto)
    {
        DaInviare.add(pacchetto);
    }
    
    public void AddDaElaborare(String pacchetto)
    {
        DaInviare.add(pacchetto);
    }
    
    public boolean isConnesso() {
        return connesso;
    }

    public void setConnesso(boolean connesso) {
        this.connesso = connesso;
    }
}
