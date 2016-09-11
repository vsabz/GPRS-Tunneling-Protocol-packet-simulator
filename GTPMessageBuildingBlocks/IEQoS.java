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
public class IEQoS extends InformationElement {

    private String qos;

    public IEQoS(String value) {
        qos = value;
    }
    
    public String getQoS() {
        return qos;
    }
    
    public void setQoS(String given) {
        qos = given;
    }
    
    @Override
    public void setValue(String given) {
        qos = given;
    }
    
    public int getLength() {
        BigInteger b = new BigInteger(qos);
        byte[] q = b.toByteArray();
        
        return q.length+3;
    }
    
    @Override
    public String getType() {
        return "QoS";
    }
    
    @Override
    public String getValue() {
        return qos;
    }
    

    
    public byte[] getBitStream() {
        //byte[] q = qos.getBytes();
        
        BigInteger b = new BigInteger(qos);
        byte[] q = b.toByteArray();
        byte[] stream = new byte[q.length+3];
        
        stream[0] = (byte)135;
        stream[1] = ByteBuffer.allocate(4).putInt(q.length).array()[2];
        stream[2] = ByteBuffer.allocate(4).putInt(q.length).array()[3];
        
        System.arraycopy(q, 0, stream, 3, q.length);
        return stream;
    }
    
}
