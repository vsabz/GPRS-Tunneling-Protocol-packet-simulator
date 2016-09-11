package GTPMessages;

import java.util.ArrayList;
import java.util.List;
import GTPMessageBuildingBlocks.*;
import Utilities.BitStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class MessageCustom extends Message {

    private IEFlags flags;
    private IEMessageType messageType;
    private IELength length;
    private IETEID teid;
    private IESequenceNumber sequenceNumber;
    private List<InformationElement> IE;
    private IENPDUNumber npdu;
    private IENextExtensionHeader nextext;
    
    public MessageCustom() {

        IE = new ArrayList <InformationElement>();

        flags = new IEFlags("1;1;0;0;1;0;");
        IE.add(flags);
        
        messageType = new IEMessageType("8");
        IE.add(messageType);

        length = new IELength("4");
        IE.add(length);
        
        teid = new IETEID("0");
        IE.add(teid);
        
        sequenceNumber = new IESequenceNumber("1");
        IE.add(sequenceNumber);

        npdu = new IENPDUNumber("255");
        IE.add(npdu);
        
        nextext = new IENextExtensionHeader("0");
        IE.add(nextext);
        
        
        
    }
    
    @Override
    public void setFlags(String given){
        flags.setFlags(given);
    }
    
    @Override
    public void setLength(String given) {
        length.setLength(given);
    }
    
    @Override
    public void setTeid(String given) {
        teid.setTeid(given);
    }
    
    @Override
    public void setSequenceNumber(String given) {
        sequenceNumber.setSequenceNumber(given);
    }
    
    @Override
    public void setMessageType(String given) {
        
    }
    
    @Override
    public String getFlags(){
        return flags.getFlags();
    }
    
    @Override
    public String getLength() {
        return length.getLngth();
    }
    
    @Override
    public String getTeid() {
        return teid.getTeid();
    }
    
    @Override
    public String getSequenceNumber() {
        return sequenceNumber.getSequenceNumber();
    }
    
    @Override
    public String getMessageType() {
        return "Custom";
    }
    
    @Override
    public List<InformationElement> getIEList() {
        return IE;
    }
    
    @Override
    public byte[] getBitStream() {
        return BitStream.makeBitStream(IE);
    }
    
}
