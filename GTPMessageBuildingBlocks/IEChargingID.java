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
public class IEChargingID extends InformationElement {
    
    private String cid;

    public IEChargingID(String value) {
        cid = value;
    }
    
    public String getCID() {
        return cid;
    }
    
    public void setCID(String given) {
        cid = given;
    }
    
    @Override
    public void setValue(String given) {
        cid = given;
    }
    
    @Override
    public String getType() {
        return "Charging ID";
    }
    
    @Override
    public String getValue() {
        return cid;
    }
    
    @Override
    public int getLength() {
        return 5;
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[5];
        stream[0] = 127;
        stream[1] = ByteBuffer.allocate(4).putInt(Integer.parseInt(cid)).array()[0];
        stream[2] = ByteBuffer.allocate(4).putInt(Integer.parseInt(cid)).array()[1];
        stream[3] = ByteBuffer.allocate(4).putInt(Integer.parseInt(cid)).array()[2];
        stream[4] = ByteBuffer.allocate(4).putInt(Integer.parseInt(cid)).array()[3];
        return stream;
    }
}
