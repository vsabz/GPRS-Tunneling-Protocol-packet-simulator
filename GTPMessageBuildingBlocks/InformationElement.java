package GTPMessageBuildingBlocks;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public abstract class InformationElement {
    
    public abstract byte[] getBitStream();
    
    public abstract int getLength();
    
    public abstract String getType();
    
    public abstract String getValue();
    
    public abstract void setValue(String given);
    
    // public abstract void setUIVisible(boolean given);
    
}
