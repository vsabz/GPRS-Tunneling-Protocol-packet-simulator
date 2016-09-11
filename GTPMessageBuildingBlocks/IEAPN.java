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
public class IEAPN extends InformationElement {

    private String apn;

    public IEAPN(String value) {
        apn = value;
    }
    
    public String getAPN() {
        return apn;
    }
    
    public void setAPN(String given) {
        apn = given;
    }
    
    @Override
    public void setValue(String given) {
        apn = given;
    }
    
    @Override
    public int getLength() {
        return apn.length() + 4;
    }
    
    @Override
    public String getType() {
        return "APN";
    }
    
    @Override
    public String getValue() {
        return apn;
    }
    
    
    
    public byte[] getBitStream() {
        byte[] stream = new byte[apn.length() + 4];
        // type
        stream[0] = (byte)131;
        
        // length
        stream[1] = ByteBuffer.allocate(4).putInt(apn.length()+1).array()[2];
        stream[2] = ByteBuffer.allocate(4).putInt(apn.length()+1).array()[3];
        
        // apn
        stream[3] = (byte) apn.length();
        System.arraycopy(apn.getBytes(), 0, stream, 4, apn.length());

        return stream;
    }   
        
}
