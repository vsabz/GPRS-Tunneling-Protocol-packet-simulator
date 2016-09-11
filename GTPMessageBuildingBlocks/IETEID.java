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
public class IETEID extends InformationElement {
    
    private String teid;

    public IETEID(String value) {
        teid = value;
    }
    
    public String getTeid() {
        return teid;
    }
    
    public void setTeid(String given) {
        teid = given;
    }
    
    @Override
    public void setValue(String given) {
        teid = given;
    }
    
    @Override
    public String getType() {
        return "TEID";
    }
    
    @Override
    public String getValue() {
        return teid;
    }
    
    @Override
    public int getLength() {
        return 4;
    }

    public byte[] getBitStream() {
        byte[] stream = new byte[4];
        //stream = new BigInteger(teid.trim()).toByteArray();
        //stream = teid.trim().getBytes();
        //teid = "23";
        //System.out.println(new BigInteger(teid.trim()).toByteArray());
        System.out.println(Integer.parseInt(teid));
        stream = ByteBuffer.allocate(4).putInt(Integer.parseInt(teid)).array();
        return stream;
    }
    
}