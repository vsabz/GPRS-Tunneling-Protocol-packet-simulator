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
public class IEGSNAddress extends InformationElement {

    private String gsn;

    public IEGSNAddress(String value) {
        gsn = value;
    }
    
    public String getGSN() {
        return gsn;
    }
    
    public void setGSN(String given) {
        gsn = given;
    }
    
    @Override
    public void setValue(String given) {
        gsn = given;
    }
    
    @Override
    public int getLength() {
        return 7;
    }
    
    @Override
    public String getType() {
        return "GSN Address";
    }
    
    @Override
    public String getValue() {
        return gsn;
    }

    
    public byte[] getBitStream() {
        
        // TODO
        // flexibility
        int p1 = 0, p2 = 0, p3 = 0;
        // find point positions in IP address
        for (int i=0; i<gsn.length();i++) {
            if (gsn.charAt(i) == '.') {
                if (p1 == 0) p1 = i;
                else if (p2 == 0) p2 = i;
                else if (p3 == 0) p3 = i;
                
            }
        }
        
        byte[] stream = new byte[7];
        // type
        stream[0] = (byte)133;
        
        // length
        stream[1] = ByteBuffer.allocate(4).putInt(4).array()[2];
        stream[2] = ByteBuffer.allocate(4).putInt(4).array()[3];
        
        // gsn address
        StringBuilder ip1 = new StringBuilder();
        for (int i=0; i<p1; i++) {
            ip1.append(gsn.charAt(i));
        }
        
        stream[3] = (byte) Integer.parseInt(ip1.toString());
        
        
        StringBuilder ip2 = new StringBuilder();
        for (int i=p1+1; i<p2; i++) {
            ip2.append(gsn.charAt(i));
        }
        
        //StringBuilder ip2 = new StringBuilder();
        //ip2.append(gsn.charAt(3));
        //ip2.append(gsn.charAt(4));
        stream[4] = (byte) Integer.parseInt(ip2.toString());
        
        
        StringBuilder ip3 = new StringBuilder();
        for (int i=p2+1; i<p3; i++) {
            ip3.append(gsn.charAt(i));
        }
        //StringBuilder ip3 = new StringBuilder();
        //ip3.append(gsn.charAt(6));
        //ip3.append(gsn.charAt(7));
        stream[5] = (byte) Integer.parseInt(ip3.toString());
        
        
        StringBuilder ip4 = new StringBuilder();
        for (int i=p3+1; i<gsn.length(); i++) {
            ip4.append(gsn.charAt(i));
        }
        //StringBuilder ip4 = new StringBuilder();
        //ip4.append(gsn.charAt(9));
        //ip4.append(gsn.charAt(10));
        stream[6] = (byte) Integer.parseInt(ip4.toString());
        //System.arraycopy(gsn.getBytes(), 0, stream, 3, gsn.length());

        return stream;
    }
         
}
