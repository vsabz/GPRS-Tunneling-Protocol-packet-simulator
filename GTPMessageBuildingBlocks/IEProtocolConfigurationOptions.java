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
public class IEProtocolConfigurationOptions extends InformationElement {
    
    private String address;
    
    public IEProtocolConfigurationOptions() {
        //address = value;
    }
    
    public IEProtocolConfigurationOptions(String value) {
        address = value;
    }
    
    @Override
    public void setValue(String given) {
        address = given;
    }
    /*
    public String getEndUserAddress() {
        return address;
    }
    
    public void setEndUserAddress(String given) {
        address = given;
    }
    */
    
    @Override
    public int getLength() {
        return 27;
    }
    
    @Override
    public String getType() {
        return "Protocol Configuration Options";
    }
    
    @Override
    public String getValue() {
        return "";
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[27];
        stream[0] = (byte) 132;
        stream[1] = (ByteBuffer.allocate(4).putInt(24).array())[2];
        stream[2] = (ByteBuffer.allocate(4).putInt(24).array())[3];
        stream[3] = (byte) 128;
        
        //stream[4] = (ByteBuffer.allocate(4).putInt(49187).array())[2];
        //stream[5] = (ByteBuffer.allocate(4).putInt(49187).array())[3];
        //stream[6] = (byte) 6;
        //stream[7] = (byte) 1;
        //stream[8] = (byte) 0;
        //stream[9] = (byte) 0;
        //stream[10] = (byte) 6;
        //stream[11] = (byte) 0;
        //stream[12] = (byte) 0;
        
        stream[4] = (ByteBuffer.allocate(4).putInt(32801).array())[2];
        stream[5] = (ByteBuffer.allocate(4).putInt(32801).array())[3];
        stream[6] = (byte) 16;
        stream[7] = (byte) 3; // 
        stream[8] = (byte) 0;
        stream[9] = (byte) 0;
        stream[10] = (byte) 16;
        stream[11] = (byte) 129;
        stream[12] = (byte) 6;
        stream[13] = (byte) 10; // ip1
        stream[14] = (byte) 75;
        stream[15] = (byte) 250;
        stream[16] = (byte) 100;
        stream[17] = (byte) 131;
        stream[18] = (byte) 6;
        stream[19] = (byte) 10;  // ip2
        stream[20] = (byte) 75;
        stream[21] = (byte) 250;
        stream[22] = (byte) 110;
        
        stream[23] = (ByteBuffer.allocate(4).putInt(5).array())[2];
        stream[24] = (ByteBuffer.allocate(4).putInt(5).array())[3];
        stream[25] = (byte) 1;
        stream[26] = (byte) 2;
        return stream;
    }
    
}
