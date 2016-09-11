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
public class IEMSISDN extends InformationElement {
    
    private String msisdn;
    
    public IEMSISDN (String value) {
        msisdn = value;
    }
    
    public String getMSISDN() {
        return msisdn;
    }
    
    public void setMSISDN(String given) {
        msisdn = given;
    }
    
    @Override
    public void setValue(String given) {
        msisdn = given;
    }
    
    public int getLength() {
        return (msisdn.length()+1)/2+4;
    }
    
    @Override
    public String getValue() {
        return msisdn;
    }
    
    @Override
    public String getType() {
        return "MSISDN";
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[(msisdn.length()+1)/2+4];
        
        stream[0] = (byte)134;
        stream[1] = ByteBuffer.allocate(4).putInt((msisdn.length()+1)/2+1).array()[2];
        stream[2] = ByteBuffer.allocate(4).putInt((msisdn.length()+1)/2+1).array()[3];
        stream[3] = (byte) 145;
        
        int start = 4;
        for (int i = 1; i<(msisdn.length()+1); i+=2) {
            stream[start] = (byte) (Character.getNumericValue(msisdn.charAt(i)) * 16
                    + Character.getNumericValue(msisdn.charAt(i-1)));
            start++;
            
        }
        
        return stream;
    }
}
