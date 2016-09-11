package GTPMessageBuildingBlocks;

import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class IECause extends InformationElement {
    
    private String cause;
    
    public IECause (String value) {
        cause = value;
    }
    
    public String getCause() {
        return cause;
    }
    
    public void setCause(String given) {
        cause = given;
    }
    
    @Override
    public void setValue(String given) {
        cause = given;
    }
    
    @Override
    public String getType() {
        return "Cause";
    }
    
    @Override
    public String getValue() {
        return cause;
    }
    
    
    @Override
    public int getLength() {
        return 2;
    }


    public byte[] getBitStream() {
        
        BigInteger b = new BigInteger(cause);
        byte[] q = b.toByteArray();
        byte[] stream = new byte[2];
        
        stream[0] = 1;
        stream[1] = (byte) Integer.parseInt(cause);

        return stream;
    }
    
}
