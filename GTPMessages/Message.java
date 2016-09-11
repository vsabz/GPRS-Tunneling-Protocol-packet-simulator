package GTPMessages;

import GTPMessageBuildingBlocks.*;

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
public abstract class Message {
    
    public abstract String getFlags();
    
    public abstract String getLength();
    
    public abstract String getTeid();
    
    public abstract String getSequenceNumber();
    
    public abstract String getMessageType();
    
    public abstract void setFlags(String given);
    
    public abstract void setLength(String given);
    
    public abstract void setTeid(String given);
    
    public abstract void setSequenceNumber(String given);
    
    public abstract void setMessageType(String given);
    
    public abstract byte[] getBitStream();
    
    public abstract List<InformationElement> getIEList();
}
