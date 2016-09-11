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
public class IENPDUNumber extends InformationElement {
    
    private String npdu;
    
    public IENPDUNumber(String value) {
        npdu = value;
    }
    
    public String getNPDU() {
        return npdu;
    }
    
    public void setNPDU(String given) {
        npdu = given;
    }
    
    @Override
    public void setValue(String given) {
        npdu = given;
    }
    
    @Override
    public int getLength() {
        return 1;
    }
    
    @Override
    public String getValue() {
        return npdu;
    }
    
    @Override
    public String getType() {
        return "NPDU Number";
    }




    public byte[] getBitStream() {
        byte[] stream = new byte[1];
        
        stream[0] = (ByteBuffer.allocate(4).putInt(Integer.parseInt(npdu)).array())[3];
        return stream;
    }
    
}
