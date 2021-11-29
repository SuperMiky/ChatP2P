/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.awt.Component;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author Miky
 */
public class ThreadClient extends Thread {

    Grafica g = new Grafica();
    private DatiCondivisi dati;
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buffer;

    public ThreadClient(DatiCondivisi dati) throws UnknownHostException {
        this.dati = dati;
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("192.168.1.10");
        } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(ThreadClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public ThreadClient() {}

    public void InviaPacchetto(String riga) throws UnknownHostException {
        buffer = riga.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 666);
        try {
            socket.send(packet);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ThreadClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) 
        {
            while(true)
            {
                if(dati.getDaInviare().size() > 0) //se nella lista c'è qualcosa
                {
                    String pacchetto = dati.getDaInviare().get(0); //mi salvo il pacchetto
                    dati.getDaInviare().remove(0); //rimuovo dalla lista il pacchetto
                    try {
                        InviaPacchetto(pacchetto); //invio il pacchetto
                    } catch (UnknownHostException ex) {
                        java.util.logging.Logger.getLogger(ThreadClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
