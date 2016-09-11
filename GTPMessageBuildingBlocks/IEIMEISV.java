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
public class IEIMEISV extends InformationElement {

    private String imeisv;
    
    public IEIMEISV (String value) {
        imeisv = value;
    }
    
    public String getIMEISV() {
        return imeisv;
    }
    
    public void setIMEISV(String given) {
        imeisv = given;
    }
    
    @Override
    public void setValue(String given) {
        imeisv = given;
    }
    
    public int getLength() {
        return (imeisv.length()+1)/2+3;
    }
    
    @Override
    public String getType() {
        return "IMEISV";
    }
    
    @Override
    public String getValue() {
        return imeisv;
    }
 
    
    public byte[] getBitStream() {
        byte[] stream = new byte[(imeisv.length()+1)/2+3];
        
        stream[0] = (byte)154;
        stream[1] = ByteBuffer.allocate(4).putInt(8).array()[2];
        stream[2] = ByteBuffer.allocate(4).putInt(8).array()[3];
        
        
        int start = 3;
        for (int i = 1; i<=(imeisv.length()); i+=2) {
            stream[start] = (byte) (Character.getNumericValue(imeisv.charAt(i)) * 16
                    + Character.getNumericValue(imeisv.charAt(i-1)));
            start++;
            
        }
        
        return stream;
    }
    
}
