/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.io.IOException;
import java.lang.System.Logger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;

/**
 *
 * @author Miky
 */
public class ThreadServer extends Thread {
    private DatiCondivisi daticondivisi;
    private DatagramSocket Server;
    private DatagramPacket packet;
    private byte[] Bytedata;
    private boolean stop;

    public ThreadServer(DatiCondivisi dati) throws SocketException, UnknownHostException {
        daticondivisi = dati;
        Server = new DatagramSocket(777);
        Bytedata = new byte[1024];
        packet = new DatagramPacket(Bytedata, Bytedata.length);
        stop = false;
    }
    
    @Override
    public void run() {
        while(true)
        {
           String messaggioRicevuto = "";
            try {
                Server.receive(packet);
                byte[] dataReceived = packet.getData();
                messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                daticondivisi.AddDaElaborare(messaggioRicevuto); //passo il pacchetto da elaborare
            }catch (IOException ex) {
                java.util.logging.Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
}
