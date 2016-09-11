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
public class IEMSTimeZone extends InformationElement {
    
    private String timeZone;
    
    public IEMSTimeZone(String value) {
        timeZone = value;
    }
    
    public String getUserLocationInfo() {
        return timeZone;
    }
    
    public void setUserLocationInfo(String given) {
        timeZone = given;
    }
    
    @Override
    public void setValue(String given) {
        timeZone = given;
    }
    
    @Override
    public int getLength() {
        return 5;
    }
    
    @Override
    public String getValue() {
        return timeZone;
    }
    
    @Override
    public String getType() {
        return "MS Time Zone";
    }



    public byte[] getBitStream() {
        byte[] stream = new byte[5];
        stream[0] = (byte) 153;
        stream[1] = (ByteBuffer.allocate(4).putInt(2).array())[2];
        stream[2] = (ByteBuffer.allocate(4).putInt(2).array())[3];
        stream[3] = 16;
        stream[4] = 0;
        
        return stream;
    }    
    
}
