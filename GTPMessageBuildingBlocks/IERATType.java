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
public class IERATType extends InformationElement {
    private String type;
    
    
    
    public IERATType(String value) {
        type = value;
        
        
    }
    
    public String getRATType() {
        return type;
    }
    
    public void setRATType(String given) {
        type = given;
    }
    
    @Override
    public void setValue(String given) {
        type = given;
    }
    
    @Override
    public int getLength() {
        return 4;
    }
    
    
    
    
    
    
    @Override
    public String getType() {
        return "RAT Type";
    }
    
    @Override
    public String getValue() {
        return type;
    }

    
    public byte[] getBitStream() {
        byte[] stream = new byte[4];
        stream[0] = (byte) 151;
        stream[1] = (ByteBuffer.allocate(4).putInt(1).array())[2];
        stream[2] = (ByteBuffer.allocate(4).putInt(1).array())[3];
        stream[3] = (byte) Integer.parseInt(type);
        
        return stream;
    }
}    

