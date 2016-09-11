package GTPMessageBuildingBlocks;

import java.nio.ByteBuffer;
import UI.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsabziyev
 */
public class IERAI extends InformationElement {

    private String rai;
    private PacketDetails myParentForm;
    private int tableIndex;
    private RAI RATTypeUI;
    

    public IERAI(String value) {
        rai = value;
        RATTypeUI = new RAI();
        
        
        // derive mcc&mnc&lac&rac from string
        String mcc = "";
        String mnc = "";
        String lac = "";
        String rac = "";
        
        int startIndex = 0;
        //int endIndex = 0;
        int item = 1;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ';') {
                OUTER:
                for (int k = startIndex; k < i; k++) {
                    switch (item) {
                        case 1:
                            mcc += value.charAt(k);
                            break;
                        case 2:
                            mnc += value.charAt(k);
                            break;
                        case 3:
                            lac += value.charAt(k);
                            break;
                        case 4:
                            rac += value.charAt(k);
                            break;
                        default:
                            break OUTER;
                    }
                }
                startIndex = i+1;
                item++;
                
            }
        }
        
        // Update UI
        RATTypeUI.setMCC(mcc);
        RATTypeUI.setMNC(mnc);
        RATTypeUI.setLAC(lac);
        RATTypeUI.setRAC(rac);
    }
    
    public String getRAI() {
        return rai;
    }
    
    public void setRAI(String given) {
        rai = given;
    }
    
    @Override
    public void setValue(String given) {
        rai = given;
    }
    
    @Override
    public int getLength() {
        return 7;
    }
    
    @Override
    public String getValue() {
        return rai;
    }
    
    @Override
    public String getType() {
        return "RAI";
    }
    
    // update flags variables and PacketDetails form
    public void update(String given) {
        rai = given;
        myParentForm.updateElement(tableIndex);
    }
    
    public void setUIVisible(boolean given, int givenIndex) {
        RATTypeUI.setVisible(given);
        RATTypeUI.setObject(this);
        tableIndex = givenIndex;
    }
    
    public void setParentWindow(PacketDetails given) {
        myParentForm = given;
        
    }
    

    
    public byte[] getBitStream() {
        byte[] stream = new byte[7];
        stream[0] = 3;
        stream[1] = (byte)(Character.getNumericValue(rai.charAt(1)) * 16
                + Character.getNumericValue(rai.charAt(0)));
        stream[2] = (byte)(15 * 16
                + Character.getNumericValue(rai.charAt(2)));
        stream[3] = (byte)(Character.getNumericValue(rai.charAt(5)) * 16
                + Character.getNumericValue(rai.charAt(4)));
        
        StringBuilder lac = new StringBuilder();
        lac.append(rai.charAt(7));
        lac.append(rai.charAt(8));
        lac.append(rai.charAt(9));
        lac.append(rai.charAt(10));
        lac.append(rai.charAt(11));
        //int lac = (Integer.parseInt(rai.charAt(7)
        //        + rai.charAt(8) + rai.charAt(9) + rai.charAt(10) + rai.charAt(11)));
        
        //int lac = (Integer.parseInt(rai.
        stream[4] = ByteBuffer.allocate(4).putInt(Integer.parseInt(lac.toString())).array()[2];
        stream[5] = ByteBuffer.allocate(4).putInt(Integer.parseInt(lac.toString())).array()[3];
        
        StringBuilder rac = new StringBuilder();
        rac.append(rai.charAt(13));
        rac.append(rai.charAt(14));
        rac.append(rai.charAt(15));
        stream[6] = (byte)(Integer.parseInt(rac.toString()));
        return stream;
    }    
    
}
