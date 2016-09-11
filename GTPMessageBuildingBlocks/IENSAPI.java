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
public class IENSAPI extends InformationElement {

    private String nsapi;

    public IENSAPI(String value) {
        nsapi = value;
    }
    
    public String getNsapi() {
        return nsapi;
    }
    
    public void setNsapi(String given) {
        nsapi = given;
    }
    
    @Override
    public void setValue(String given) {
        nsapi = given;
    }
    
    @Override
    public int getLength() {
        return 2;
    }
    
    @Override
    public String getType() {
        return "NSAPI";
    }
    
    @Override
    public String getValue() {
        return nsapi;
    }
    
    public byte[] getBitStream() {
        byte[] stream = new byte[2];
        stream[0] = 20;
        stream[1] = ByteBuffer.allocate(4).putInt(Integer.parseInt(nsapi)).array()[3];

        return stream;
    }
    
}
