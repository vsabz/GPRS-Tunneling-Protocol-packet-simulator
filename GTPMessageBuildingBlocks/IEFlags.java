package GTPMessageBuildingBlocks;

import UI.Flags;
import UI.PacketDetails;

import java.nio.ByteBuffer;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class IEFlags extends InformationElement {
    private String flags;
    private Flags flagsUI;
    private PacketDetails myParentForm;
    private int tableIndex;
    
    public IEFlags(String value) {
        // 1;1;0;0;1;0;
        flags = value;
        flagsUI = new Flags();
        
        //stream = (ByteBuffer.allocate(4).putInt(Integer.parseInt(flags)).array())[3];
        //flags = "1;1;0;0;1;0;";
        flagsUI.setGTPVersion(flags.charAt(0));
        flagsUI.setProtocolType(flags.charAt(2));
        flagsUI.setReserved(flags.charAt(4));
        flagsUI.setExtHeader(flags.charAt(6));
        flagsUI.setSequenceNumber(flags.charAt(8));
        flagsUI.setNPDUNumber(flags.charAt(10));
        
    }
    
    public void setUIVisible(boolean given, int givenIndex) {
        flagsUI.setVisible(given);
        flagsUI.setObject(this);
        tableIndex = givenIndex;
    }
    
    public String getFlags() {
        return flags;
    }
    
    public void setFlags(String given) {
        flags = given;
    }
    
    @Override
    public int getLength() {
        return 1;
    }
    
    @Override
    public void setValue(String given) {
        flags = given;
    }
    
    @Override
    public String getType() {
        return "Flags";
    }
    
    @Override
    public String getValue() {
        return flags;
    }
    
    public void setParentWindow(PacketDetails given) {
        myParentForm = given;
        
    }
    
    
    // update flags variables and PacketDetails form
    public void update(String given) {
        flags = given;
        myParentForm.updateElement(tableIndex);
    }
    
    
    
    @Override
    public byte[] getBitStream() {
        int flagStream = Character.getNumericValue(flags.charAt(10)) + Character.getNumericValue(flags.charAt(8)) * 2 + 
                Character.getNumericValue(flags.charAt(6)) * 4 + Character.getNumericValue(flags.charAt(4)) * 8 + 
                Character.getNumericValue(flags.charAt(2)) * 16 + Character.getNumericValue(flags.charAt(0)) * 32;
        byte[] stream = new byte[1];
        stream[0] = (ByteBuffer.allocate(4).putInt(flagStream).array())[3];
        return stream;
    }    
}
