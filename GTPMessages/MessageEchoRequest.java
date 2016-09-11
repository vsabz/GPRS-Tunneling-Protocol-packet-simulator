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


public class MessageEchoRequest extends Message {
    
    //private byte flags;
    //private byte[] length;
    private IEFlags flags;
    private IELength length;
    private IETEID teid;
    private IESequenceNumber sequenceNumber;
    private IEMessageType messageType;
    private List<InformationElement> IE;
    private IENPDUNumber npdu;
    private IENextExtensionHeader nextext;
    
    public MessageEchoRequest() {
        //flags = 50;
        //length = ByteBuffer.allocate(4).putInt(4).array();
        IE = new ArrayList <InformationElement>();
        
        flags = new IEFlags("1;1;0;0;1;0;");
        IE.add(flags);
        
        messageType = new IEMessageType("1");
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
        //messageType = (ByteBuffer.allocate(4).putInt(Integer.parseInt(given)).array())[3];
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
        return messageType.getValue();
    }
    
    @Override
    public List<InformationElement> getIEList() {
        return IE;
    }
    
    @Override
    public byte[] getBitStream() {
        
        //byte[] flag1 = ByteBuffer.allocate(4).putInt(flags).array();
        //ByteBuffer.allocate(1).put(flags)
        //byte[] messageType1 = ByteBuffer.allocate(4).putInt(messageType).array();
        //byte[] bitStream = new byte[flag1.length + messageType1.length];
        
        //System.arraycopy(flags, 0, bitStream, 0, flags.length);
        //System.arraycopy(messageType1, 0, bitStream, flag1.length, messageType1.length);
        /*
        byte[] bitStream = new byte[10];
        bitStream[0] = flags.getBitStream();
        bitStream[1] = messageType;
        bitStream[2] = length.getBitStream()[0];
        bitStream[3] = length.getBitStream()[1];
        bitStream[4] = teid.getBitStream()[0];
        bitStream[5] = teid.getBitStream()[1];
        bitStream[6] = teid.getBitStream()[2];
        bitStream[7] = teid.getBitStream()[3];
        bitStream[8] = sequenceNumber.getBitStream()[0];
        bitStream[9] = sequenceNumber.getBitStream()[1]; 
        return bitStream; */
        return BitStream.makeBitStream(IE);
    }
}
