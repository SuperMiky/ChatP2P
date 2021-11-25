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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miky
 */
public class Client {
    
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buffer;
    
    public Client() throws UnknownHostException {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        address = InetAddress.getByName("localhost");
    }
    
    public void InviaPacchetto(String riga)
    {
        buffer = riga.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address,777);
        try {
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] RiceviPacchetto()
    {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        return CSV.fromCsv(received);
    }
}
