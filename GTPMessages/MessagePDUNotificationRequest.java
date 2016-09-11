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
public class MessagePDUNotificationRequest extends Message {
    
    
    private IEFlags flags;
    private IELength length;
    private IETEID teid;
    private IESequenceNumber sequenceNumber;
    private IEMessageType messageType;
    private IEIMSI imsi;
    private IEAPN apn;
    private IEGSNAddress gsn1;
    private IETEIDCP teidcp;
    private IEEndUserAddress EndUserAddress;
    private IENPDUNumber npdu;
    private IENextExtensionHeader nextext;
    
    private List<InformationElement> IE;
    
    public MessagePDUNotificationRequest() {
        IE = new ArrayList <InformationElement>();
        
        flags = new IEFlags("1;1;0;0;1;0;");
        IE.add(flags);
        
        messageType = new IEMessageType("27");
        IE.add(messageType);

        length = new IELength("0");
        IE.add(length);
        
        teid = new IETEID("0");
        IE.add(teid);
        
        sequenceNumber = new IESequenceNumber("45000");
        IE.add(sequenceNumber);
        
        npdu = new IENPDUNumber("255");
        IE.add(npdu);
        
        nextext = new IENextExtensionHeader("0");
        IE.add(nextext);
        
        imsi = new IEIMSI("400041036278834");
        IE.add(imsi);
        
        teidcp = new IETEIDCP("2315987142");
        IE.add(teidcp);
        
        EndUserAddress = new IEEndUserAddress("");
        IE.add(EndUserAddress);
        
        apn = new IEAPN("NAR");
        IE.add(apn);
        
        gsn1 = new IEGSNAddress("10.10.10.2");
        IE.add(gsn1);
        
        
        Integer lng = 0;
        for (InformationElement e : IE) {
            if (!e.getType().equals("Flags") && 
                    !e.getType().equals("GTPMessages.Message Type") &&
                    !e.getType().equals("Length") &&
                    !e.getType().equals("TEID")) {
                lng += e.getLength();
            }
            
        }
        
        length.setLength(lng.toString());
        
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
        messageType.setMessageType(given);
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
        return messageType.getMessageType();
    }
    
    @Override
    public byte[] getBitStream() {

        /*return Utilities.BitStream.makeBitStream(flags, messageType, length, teid, sequenceNumber, imsi, apn, rai,
                nsapi, gsn1, gsn2, teid1, teidcp, qos, msisdn, recovery,selection, EndUserAddress, 
                protconfig, ratType, locInfo, timeZone, imeisv); */
        return BitStream.makeBitStream(IE);
    }
    
    public List<InformationElement> getIEList() {
        return IE;
    }
}
