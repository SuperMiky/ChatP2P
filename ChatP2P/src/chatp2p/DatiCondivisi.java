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

    Grafica g = new Grafica();
    private List<String> DaInviare = new ArrayList<>();
    private List<String> DaRicevere = new ArrayList<>();
    private boolean connesso = false; //per vedere se c'è già un peer connesso

    public DatiCondivisi() {}

    public List<String> getDaInviare() {
        return DaInviare;
    }

    public void AddDaInviare(String pacchetto)
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
