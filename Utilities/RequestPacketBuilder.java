package Utilities;

import GTPMessageBuildingBlocks.InformationElement;
import GTPMessages.*;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */

public class RequestPacketBuilder {
    
    private String flags;
    private String length;
    private String teid;
    private String sequenceNumber;
    private String messageType;
    
    private Message packet;
    
    public RequestPacketBuilder(String packetType) {
        
        if (packetType.equals("Echo Request")) {
            packet = new MessageEchoRequest();
            
        }
        
        else if (packetType.equals("Create PDP Context Request")) {
            packet = new MessageCreatePDPRequest();
        }
        
        else if (packetType.equals("PDU Notification Request")) {
            packet = new MessagePDUNotificationRequest();
        }
        
        else if (packetType.equals("Custom")) {
            packet = new MessageCustom();
        }
        
        
    }
    
    public String getFlags(){
        return packet.getFlags();
    }
    
    public String getLength() {
        return packet.getLength();
    }
    
    public String getTeid() {
        return packet.getTeid();
    }
    
    public String getSequenceNumber() {
        return packet.getSequenceNumber();
    }
    
    public String getMessageType() {
        return packet.getMessageType();
    }
    
    public byte[] getBitStream() {
        return packet.getBitStream();
    }
    
    public void setFlags(String given){
        packet.setFlags(given);
    }
    
    public void setLength(String given){
        packet.setLength(given);
    }
        
    public void setMessageType(String given){
        packet.setMessageType(given);
    }
    
    public void setTeid(String given){
        packet.setTeid(given);
    }

    public void setSequenceNumber(String given){
        packet.setSequenceNumber(given);
    }
    
    public List<InformationElement> getIEList() {
        return packet.getIEList();
    }


           
}
