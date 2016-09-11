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
public class IETEIDCP extends InformationElement {
    private String teidcp;

    public IETEIDCP(String value) {
        teidcp = value;
    }
    
    public IETEIDCP(byte[] value) {
        teidcp = "";
        teidcp += new BigInteger(value).toString();
    }
    
    public String getTeidcp() {
        return teidcp;
    }
    
    public void setTeidcp(String given) {
        teidcp = given;
    }
    
    @Override
    public void setValue(String given) {
        teidcp = given;
    }
    
    @Override
    public int getLength() {
        return 5;
    }
    
    @Override
    public String getValue() {
        return teidcp;
    }
    
    @Override
    public String getType() {
        return "TEIDCP";
    }
    

    
    
    
    public byte[] getBitStream() {
        byte[] stream = new byte[5];
        stream[0] = 17;
        /*
        stream[1] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teidcp)).array()[0];
        stream[2] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teidcp)).array()[1];
        stream[3] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teidcp)).array()[2];
        stream[4] = ByteBuffer.allocate(4).putInt(Integer.parseInt(teidcp)).array()[3];
        */
        
        BigInteger b = new BigInteger(teidcp);
        byte[] q = b.toByteArray();
        //byte[] stream = new byte[2];
        if (q.length-4 >= 0)
            stream[1] = q[q.length-4];
        if (q.length-3 >= 0)
            stream[2] = q[q.length-3];
        if (q.length-2 >= 0)
            stream[3] = q[q.length-2];
        if (q.length-1 >= 0)
            stream[4] = q[q.length-1];
        
        /*
        stream[1] = (byte) 138;
        stream[2] = (byte) 11;
        stream[3] = (byte) 40;
        stream[4] = (byte) 198;
        */
        
        
        return stream;
    }    
    
}
