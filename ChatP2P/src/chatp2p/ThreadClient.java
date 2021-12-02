/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Miky
 */
public class ThreadClient extends Thread {

    private DatiCondivisi dati;
    private DatagramSocket socket;
    private InetAddress address;
    public ThreadClient(DatiCondivisi dati) throws UnknownHostException {
        this.dati = dati;
        address=InetAddress.getByName("192.168.1.2");
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(ThreadClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void InviaPacchetto(String riga) throws UnknownHostException {
        byte[] buffer = riga.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 12345);
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
            if(dati.GetSizeDaInviare() > 0) //se nella lista c'è qualcosa
            {
                String pacchetto = dati.GetDaInviare(); //mi salvo il pacchetto
                System.out.println("client "+pacchetto);
                try {
                    InviaPacchetto(pacchetto); //invio il pacchetto
                } catch (UnknownHostException ex) {
                    java.util.logging.Logger.getLogger(ThreadClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }
}
