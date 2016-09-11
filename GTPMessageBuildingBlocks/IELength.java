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
public class IELength extends InformationElement {
    
    private String length;
    
    public IELength(String value) {
        length = value;
    }
    
    public String getLngth() {
        return length;
    }
    
    @Override
    public int getLength() {
        return 2;
    }
    
    @Override
    public String getType() {
        return "Length";
    }
    
    public void setLength(String given) {
        length = given;
    }
    
    @Override
    public void setValue(String given) {
        length = given;
    }
    
    @Override
    public String getValue() {
        return length;
    }
    
    public byte[] getBitStream() {
        byte[] stream = new byte[2];
        stream[0] = (ByteBuffer.allocate(4).putInt(Integer.parseInt(length)).array())[2];
        stream[1] = (ByteBuffer.allocate(4).putInt(Integer.parseInt(length)).array())[3];
        return stream;
    }
    
}
