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
public class IERecovery extends InformationElement {

    private String recovery;
    
    public IERecovery(String value) {
        recovery = value;
    }
    
    public String getRecovery() {
        return recovery;
    }
    
    public void setRecovery(String given) {
        recovery = given;
    }
    
    @Override
    public void setValue(String given) {
        recovery = given;
    }
    
    @Override
    public int getLength() {
        return 2;
    }
    
    @Override
    public String getType() {
        return "Recovery";
    }
    
    @Override
    public String getValue() {
        return recovery;
    }
    

    
    
    public byte[] getBitStream() {
        byte[] stream = new byte[2];
        stream[0] = 14;
        stream[1] = (byte)Integer.parseInt(recovery);
        return stream;
    }    
}
