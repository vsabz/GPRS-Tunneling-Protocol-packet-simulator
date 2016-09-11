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
public class IEUserLocationInfo extends InformationElement {
    private String locInfo;
    
    public IEUserLocationInfo(String value) {
        locInfo = value;
    }
    
    public String getUserLocationInfo() {
        return locInfo;
    }
    
    public void setUserLocationInfo(String given) {
        locInfo = given;
    }
    
    @Override
    public void setValue(String given) {
        locInfo = given;
    }
    
    @Override
    public int getLength() {
        return 11;
    }
    
    @Override
    public String getType() {
        return "User Location Info";
    }
    
    @Override
    public String getValue() {
        return locInfo;
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[11];
        stream[0] = (byte) 152;
        stream[1] = (ByteBuffer.allocate(4).putInt(8).array())[2];
        stream[2] = (ByteBuffer.allocate(4).putInt(8).array())[3];
        stream[3] = 1;
        stream[4] = 4;
        stream[5] = (byte) 240;
        stream[6] = 32;
        stream[7] = 6;
        stream[8] = 6;
        stream[9] = (ByteBuffer.allocate(4).putInt(54615).array())[2];
        stream[10] = (ByteBuffer.allocate(4).putInt(54615).array())[3];
        
        
        return stream;
    }    
}
