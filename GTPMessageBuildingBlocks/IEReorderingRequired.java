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
public class IEReorderingRequired extends InformationElement {
    private String rr;
    
    public IEReorderingRequired (String value) {
        rr = value;
    }
    
    public String getReordering() {
        return rr;
    }
    
    public void setReordering(String given) {
        rr = given;
    }
    
    @Override
    public void setValue(String given) {
        rr = given;
    }
    
    @Override
    public String getType() {
        return "Reordering Required";
    }
    
    @Override
    public String getValue() {
        return rr;
    }
    
    
    @Override
    public int getLength() {
        return 2;
    }


    public byte[] getBitStream() {
        
        
        byte[] stream = new byte[2];
        
        stream[0] = 8;
        if (rr.equals("False") || rr.equals("false") || rr.equals("0"))
            stream[1] = (byte) 254;
        else
            stream[1] = (byte) 255;
        return stream;
    }
}
