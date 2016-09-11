package Utilities;

import UI.PDPMaintenance;
import UI.SGSNUI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class ListeningThread extends Thread {
    private SGSNUI ui;
    private DefaultTableModel tableModel;
    protected DatagramSocket socket = null;
    private boolean listening;
    private boolean pdplistening = false;
    private PDPMaintenance PDPui;
    
    public ListeningThread (SGSNUI given, DatagramSocket givenSocket, boolean givenBoolean) throws SocketException {
        super();
        ui=given;
        socket = givenSocket;
        tableModel = ui.getTableModel();
        listening = givenBoolean;
        
    }
    
    public ListeningThread getThread() {
        return this;
    }
    
    public void setPDPui(PDPMaintenance givenui) {
        PDPui = givenui;
    }
    
    public void setListening(boolean given) {
        listening = given;
    }
    
    public void setPDPListening(boolean given) {
        pdplistening = given;
    }
    
    public void run() {
        while (listening) {
            try {
                byte[] buf = new byte[256];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                parse(packet);
                //tableModel.addRow(new Object[]{packet.getAddress(), packet.getSocketAddress(), packet.getData()});

		
            } catch (IOException e) {
                e.printStackTrace();
		socket.close();
            }
        }
        
    }
    
    public void sendPacket() {
        
    }
    
    
    // parse received packets
    private void parse(DatagramPacket packet) throws IOException {
        byte[] packetData = packet.getData();
        switch (packetData[1]) {
            case 1: tableModel.addRow(new Object[]{packet.getAddress(), "me", "Echo Request"});
                    if (pdplistening) PDPui.acceptEchoRequest(packetData, packet.getAddress());
                    break;
            case 2: tableModel.addRow(new Object[]{packet.getAddress(), "me", "Echo Response"});
                    break;
            case 16: tableModel.addRow(new Object[]{packet.getAddress(), "me", "Create PDP Context Request"});
                    if (pdplistening) PDPui.acceptPDPRequest(packetData, packet.getAddress());
                    break;
            case 17: tableModel.addRow(new Object[]{packet.getAddress(), "me", "Create PDP Context Response"});
                    break;
        }

    }
}
