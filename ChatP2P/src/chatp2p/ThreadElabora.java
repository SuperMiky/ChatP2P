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
    
    public ThreadElabora(DatiCondivisi dati)
    {
        this.dati = dati;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            if(dati.GetSizeDaElaborare() > 0) //se c'è qualcosa nella lista
            {
                String pacchetto = dati.GetDaElaborare(); //mi salvo il pacchetto
                String[] campi = pacchetto.split(";");
                System.out.println("elabora: "+pacchetto);
                switch (campi[0]) 
                {
                    case "c": //caso in cui arriva una richiesta di connessione
                        dati.g.MessConnessione(campi[1]); //chiamo il metodo della grafica per accettare o rifiutare la connessione
                        break;
                    case "y": //caso in cui il destinatario ha accettato la richiesta
                        if(campi.length>1)
                            dati.g.OkConn(campi[1]); //chiamo il metodo della grafica per visualizzare l'accettazione
                        break;
                    case "n": //caso in cui il destinatario ha rifiutato la richiesta
                        dati.g.NoConn(); //chiamo il metodo della grafica per visualizzare il rifiuto
                        break;
                    case "m":
                        dati.g.AddMessaggio(campi[1]);
                }
            }
        }
    }
}
