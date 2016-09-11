package GTPMessageBuildingBlocks;

import java.math.BigInteger;
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
public class IETEID1 extends InformationElement {

    private String teid1;

    public IETEID1(String value) {
        teid1 = value;
    }
    
    public IETEID1 (byte[] value) {
        teid1 = "";
        teid1 += new BigInteger(value).toString();
    }
    
    public String getTeid1() {
        return teid1;
    }
    
    public void setTeid1(String given) {
        teid1 = given;
    }
    
    @Override
    public void setValue(String given) {
        teid1 = given;
    }
    
    @Override
    public String getType() {
        return "TEID1";
    }
    
    @Override
    public int getLength() {
        return 5;
    }
    
    @Override
    public String getValue() {
        return teid1;
    }

    
    public byte[] getBitStream() {
        byte[] stream = new byte[5];
        stream[0] = 16;
        stream[1] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teid1)).array()[0];
        stream[2] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teid1)).array()[1];
        stream[3] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teid1)).array()[2];
        stream[4] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teid1)).array()[3];
        return stream;
    }    
}
