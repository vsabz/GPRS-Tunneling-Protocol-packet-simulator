package GTPMessageBuildingBlocks;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class IESelectionMode extends InformationElement {

    private String selection;
    
    public IESelectionMode(String value) {
        selection = value;
    }
    
    public String getSelection() {
        return selection;
    }
    
    public void setSelection(String given) {
        selection = given;
    }
    
    @Override
    public void setValue(String given) {
        selection = given;
    }
    
    @Override
    public int getLength() {
        return 2;
    }
    
    @Override
    public String getValue() {
        return selection;
    }
    
    @Override
    public String getType() {
        return "Selection Mode";
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[2];
        stream[0] = 15;
        stream[1] = (byte)(252+Integer.parseInt(selection));
        return stream;
    }    
    
}
