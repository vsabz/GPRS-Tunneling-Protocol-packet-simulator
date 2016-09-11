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
public class IENextExtensionHeader extends InformationElement {
    
    private String nextext;
    
    public IENextExtensionHeader(String value) {
        nextext = value;
    }
    
    public String getNPDU() {
        return nextext;
    }
    
    public void setNPDU(String given) {
        nextext = given;
    }
    
    @Override
    public void setValue(String given) {
        nextext = given;
    }
    
    
    @Override
    public int getLength() {
        return 1;
    }
    
    @Override
    public String getValue() {
        return nextext;
    }
    
    @Override
    public String getType() {
        return "Next Extension Header";
    }
    

   
    public byte[] getBitStream() {
        byte[] stream = new byte[1];
        
        stream[0] = (ByteBuffer.allocate(4).putInt(Integer.parseInt(nextext)).array())[3];
        return stream;
    }
}
