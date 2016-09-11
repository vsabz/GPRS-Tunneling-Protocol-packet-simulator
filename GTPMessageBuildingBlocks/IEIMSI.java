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
public class IEIMSI extends InformationElement {
    
    
    private String imsi;
    
    public IEIMSI (String value) {
        imsi = value;
    }
    
    public IEIMSI (byte[] value) {
        imsi = "";
        
        // 1
        imsi += new Integer(value[1] & 15).toString();
        //imsi += new Integer(value[1] & 1 + ((value[1] >> 1) & 1) * 2 + ((value[1] >> 2) & 1) * 4 + ((value[1] >> 3) & 1) * 8).toString();

        // 2
        imsi += new Integer((value[1] >> 4) & 15).toString();
        //imsi += new Integer((value[1] >> 4) & 1 + ((value[1] >> 5) & 1) * 2 + ((value[1] >> 6) & 1) * 4 + ((value[7] >> 1) & 1) * 8).toString();
        
        // 3
        //imsi += new Integer(value[2] & 1 + (value[2] >> 1) & 1 * 2 + (value[2] >> 2) & 1 * 4 + (value[2] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[2] & 15).toString();
        
        // 4
        //imsi += new Integer((value[2] >> 4) & 1 + (value[2] >> 5) & 1 * 2 + (value[2] >> 6) & 1 * 4 + (value[2] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[2] >> 4) & 15).toString();
        
        // 5
        //imsi += new Integer(value[3] & 1 + (value[3] >> 1) & 1 * 2 + (value[3] >> 2) & 1 * 4 + (value[3] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[3] & 15).toString();
        
        // 6
        //imsi += new Integer((value[3] >> 4) & 1 + (value[3] >> 5) & 1 * 2 + (value[3] >> 6) & 1 * 4 + (value[3] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[3] >> 4) & 15).toString();
        
        // 7
        //imsi += new Integer(value[4] & 1 + (value[4] >> 1) & 1 * 2 + (value[4] >> 2) & 1 * 4 + (value[4] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[4] & 15).toString();
        
        // 8
        //imsi += new Integer((value[4] >> 4) & 1 + (value[4] >> 5) & 1 * 2 + (value[4] >> 6) & 1 * 4 + (value[4] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[4] >> 4) & 15).toString();
        
        // 9
        //imsi += new Integer(value[5] & 1 + (value[5] >> 1) & 1 * 2 + (value[5] >> 2) & 1 * 4 + (value[5] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[5] & 15).toString();
        
        // 10
        //imsi += new Integer((value[5] >> 4) & 1 + (value[5] >> 5) & 1 * 2 + (value[5] >> 6) & 1 * 4 + (value[5] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[5] >> 4) & 15).toString();
        
        // 11
        //imsi += new Integer(value[6] & 1 + (value[6] >> 1) & 1 * 2 + (value[6] >> 2) & 1 * 4 + (value[6] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[6] & 15).toString();
        
        // 12
        //imsi += new Integer((value[6] >> 4) & 1 + (value[6] >> 5) & 1 * 2 + (value[6] >> 6) & 1 * 4 + (value[6] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[6] >> 4) & 15).toString();
        
        // 13
        //imsi += new Integer(value[7] & 1 + (value[7] >> 1) & 1 * 2 + (value[7] >> 2) & 1 * 4 + (value[7] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[7] & 15).toString();
        
        // 14
        //imsi += new Integer((value[7] >> 4) & 1 + (value[7] >> 5) & 1 * 2 + (value[7] >> 6) & 1 * 4 + (value[7] >> 7) & 1 * 8).toString();
        imsi += new Integer((value[7] >> 4) & 15).toString();
        
        // 15
        //imsi += new Integer(value[8] & 1 + (value[8] >> 1) & 1 * 2 + (value[8] >> 2) & 1 * 4 + (value[8] >> 3) & 1 * 8).toString();
        imsi += new Integer(value[8] & 15).toString();
        
        // 16
        //imsi += new Integer((value[8] >> 4) & 1 + (value[8] >> 5) & 1 * 2 + (value[8] >> 6) & 1 * 4 + (value[8] >> 7) & 1 * 8).toString();
        if (new Integer((value[8] >> 4) & 15) != 15 ) imsi += new Integer((value[8] >> 4) & 15).toString();
    }
    
    public String getImsi() {
        return imsi;
    }
    
    public void setImsi(String given) {
        imsi = given;
    }
    
    @Override
    public void setValue(String given) {
        imsi = given;
    }
    
    @Override
    public int getLength() {
        return 9;
    }
    
    @Override
    public String getType() {
        return "IMSI";
    }
    
    @Override
    public String getValue() {
        return imsi;
    }
    
    
    public byte[] getBitStream() {
        byte[] stream = new byte[9];
        char[] tempimsi = imsi.toCharArray();
        stream[0] = 2;
        stream[1] = (byte) (Character.getNumericValue(imsi.charAt(0)) + 
                Character.getNumericValue(imsi.charAt(1))*16);
        stream[2] = (byte) (Character.getNumericValue(imsi.charAt(2)) + 
                Character.getNumericValue(imsi.charAt(3))*16);
        stream[3] = (byte) (Character.getNumericValue(imsi.charAt(4)) + 
                Character.getNumericValue(imsi.charAt(5))*16);
        stream[4] = (byte) (Character.getNumericValue(imsi.charAt(6)) + 
                Character.getNumericValue(imsi.charAt(7))*16);
        stream[5] = (byte) (Character.getNumericValue(imsi.charAt(8)) + 
                Character.getNumericValue(imsi.charAt(9))*16);
        stream[6] = (byte) (Character.getNumericValue(imsi.charAt(10)) + 
                Character.getNumericValue(imsi.charAt(11))*16);
        stream[7] = (byte) (Character.getNumericValue(imsi.charAt(12)) + 
                Character.getNumericValue(imsi.charAt(13))*16);
        stream[8] = (byte) (Character.getNumericValue(imsi.charAt(14)) + 
                15*16);
        return stream;
    }
}
