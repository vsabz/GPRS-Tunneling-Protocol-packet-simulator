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
public class IESequenceNumber extends InformationElement {
    
    private String sequenceNumber;
    
    public IESequenceNumber(String value) {
        sequenceNumber = value;
    }
    
    public String getSequenceNumber() {
        return sequenceNumber;
    }
    
    public void setSequenceNumber(String given) {
        sequenceNumber = given;
    }
    
    @Override
    public void setValue(String given) {
        sequenceNumber = given;
    }
    
    @Override
    public String getType() {
        return "Sequence Number";
    }
    
    @Override
    public String getValue() {
        return sequenceNumber;
    }
    
    
    @Override
    public int getLength() {
        return 2;
    }


    public byte[] getBitStream() {
        
        BigInteger b = new BigInteger(sequenceNumber);
        byte[] q = b.toByteArray();
        byte[] stream = new byte[2];
        
        if (q.length-2 >= 0)
            stream[0] = q[q.length-2];
        if (q.length-1 >= 0)
            stream[1] = q[q.length-1];

        return stream;
    }
}
