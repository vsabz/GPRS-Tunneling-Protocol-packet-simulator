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
public class IEMessageType extends InformationElement {

    private String msgType;
    
    public IEMessageType(String value) {
        msgType = value;
    }
    
    public String getMessageType() {
        return msgType;
    }
    
    public void setMessageType(String given) {
        msgType = given;
    }
    
    @Override
    public void setValue(String given) {
        msgType = given;
    }
    
    @Override
    public int getLength() {
        return 1;
    }
    
    @Override
    public String getType() {
        return "Message Type";
    }
    
    @Override
    public String getValue() {
        return msgType;
    }
    

    
    @Override
    public byte[] getBitStream() {
        byte[] stream = new byte[1];
        stream[0] = ByteBuffer.allocate(4).putInt(Integer.parseInt(msgType)).array()[3];
        return stream;
    }        
}
