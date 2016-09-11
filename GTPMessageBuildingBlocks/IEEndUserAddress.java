package GTPMessageBuildingBlocks;

import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class IEEndUserAddress extends InformationElement {
    
    private String address;
    
    public IEEndUserAddress(String value) {
        address = value;
    }
    
    public String getEndUserAddress() {
        return address;
    }
    
    public void setEndUserAddress(String given) {
        address = given;
    }
    
    @Override
    public void setValue(String given) {
        address = given;
    }
    
    @Override
    public int getLength() {
        if (address.isEmpty() || address.equals("") || address.equals(" "))
            return 5;
        else 
            return 9;
    }
    
    @Override
    public String getType() {
        return "End User Address";
    }
    
    @Override
    public String getValue() {
        return address;
    }
    
    public byte[] getBitStream() {
        
        byte[] stream;
             
        // address not present
        if (address.isEmpty() || address.equals("") || address.equals(" ")) {
            stream = new byte[5];
            
            // length
            stream[1] = (ByteBuffer.allocate(4).putInt(2).array())[2];
            stream[2] = (ByteBuffer.allocate(4).putInt(2).array())[3];
        }
        
        // address is present
        else {
            stream = new byte[9];
            
            // length
            stream[1] = (ByteBuffer.allocate(4).putInt(6).array())[2];
            stream[2] = (ByteBuffer.allocate(4).putInt(6).array())[3];
        
            int p1 = 0, p2 = 0, p3 = 0;
            // find point positions in IP address
            for (int i=0; i<address.length();i++) {
                if (address.charAt(i) == '.') {
                    if (p1 == 0) p1 = i;
                    else if (p2 == 0) p2 = i;
                    else if (p3 == 0) p3 = i;
                
                }
            }
            
            // gsn address
            StringBuilder ip1 = new StringBuilder();
            for (int i=0; i<p1; i++) {
                ip1.append(address.charAt(i));
            }
        
            stream[5] = (byte) Integer.parseInt(ip1.toString());
        
        
            StringBuilder ip2 = new StringBuilder();
            for (int i=p1+1; i<p2; i++) {
                ip2.append(address.charAt(i));
            }

            stream[6] = (byte) Integer.parseInt(ip2.toString());
        
        
            StringBuilder ip3 = new StringBuilder();
            for (int i=p2+1; i<p3; i++) {
                ip3.append(address.charAt(i));
            }

            stream[7] = (byte) Integer.parseInt(ip3.toString());
        
        
            StringBuilder ip4 = new StringBuilder();
            for (int i=p3+1; i<address.length(); i++) {
                ip4.append(address.charAt(i));
            }

            stream[8] = (byte) Integer.parseInt(ip4.toString());
        }
        
        stream[0] = (byte) 128;
        
        stream[3] = (byte) 241;
        stream[4] = (byte) 33;


        return stream;
    }
}
