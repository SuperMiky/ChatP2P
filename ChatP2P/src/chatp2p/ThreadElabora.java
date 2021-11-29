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
public class ThreadElabora extends Thread {
    
    DatiCondivisi dati;
    Grafica g;
    
    public ThreadElabora(DatiCondivisi dati)
    {
        this.dati = dati;
        g = new Grafica();
    }
    
    public void run()
    {
        while(true)
        {
            if(dati.getDaElaborare().size() > 0) //se c'è qualcosa nella lista
            {
                String pacchetto = dati.getDaElaborare().get(0); //mi salvo il pacchetto
                dati.getDaElaborare().remove(0); //rimuovo dalla lista il pacchetto 
                String[] campi = pacchetto.split(";");
                switch (campi[0]) 
                {
                    case "c": //caso in cui arriva una richiesta di connessione
                        g.MessConnessione(campi[1]); //chiamo il metodo della grafica per accettare o rifiutare la connessione
                        break;
                    case "y": //caso in cui il destinatario ha accettato la richiesta
                        g.OkConn(campi[1]); //chiamo il metodo della grafica per visualizzare l'accettazione
                        break;
                    case "n": //caso in cui il destinatario ha rifiutato la richiesta
                        g.NoConn(); //chiamo il metodo della grafica per visualizzare il rifiuto
                        break;
                }
            }
        }
    }
}
