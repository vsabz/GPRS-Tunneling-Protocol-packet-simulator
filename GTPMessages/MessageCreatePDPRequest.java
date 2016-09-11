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
public class MessageCreatePDPRequest extends Message{
    
    private IEFlags flags;
    private IELength length;
    private IETEID teid;
    private IESequenceNumber sequenceNumber;
    private IEMessageType messageType;
    private IEIMSI imsi;
    private IEAPN apn;
    private IERAI rai;
    private IENSAPI nsapi;
    private IEGSNAddress gsn1;
    private IEGSNAddress gsn2;
    private IETEID1 teid1;
    private IETEIDCP teidcp;
    private IEQoS qos;
    private IEMSISDN msisdn;
    private IERecovery recovery;
    private IESelectionMode selection;
    private IEEndUserAddress EndUserAddress;
    private IEProtocolConfigurationOptions protconfig;
    private IERATType ratType;
    private IEUserLocationInfo locInfo;
    private IEMSTimeZone timeZone;
    private IEIMEISV imeisv;
    private IENPDUNumber npdu;
    private IENextExtensionHeader nextext;
    
    private List<InformationElement> IE;
    
    public MessageCreatePDPRequest() {
        IE = new ArrayList <InformationElement>();
        
        flags = new IEFlags("1;1;0;0;1;0;");
        IE.add(flags);
        
        messageType = new IEMessageType("16");
        IE.add(messageType);
        
        //int a;

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
        
        rai = new IERAI("400;04;21988;222;");
        IE.add(rai);
        
        recovery = new IERecovery("48");
        IE.add(recovery);
        
        selection = new IESelectionMode("0");
        IE.add(selection);
        
        teid1 = new IETEID1("199481");
        IE.add(teid1);
        
        teidcp = new IETEIDCP("2315987142");
        IE.add(teidcp);
        
        nsapi = new IENSAPI("5");
        IE.add(nsapi);
        
        EndUserAddress = new IEEndUserAddress("");
        IE.add(EndUserAddress);
        
        apn = new IEAPN("NAR");
        IE.add(apn);
        
        protconfig = new IEProtocolConfigurationOptions();
        IE.add(protconfig);
        
        gsn1 = new IEGSNAddress("10.10.10.2");
        IE.add(gsn1);
        
        gsn2 = new IEGSNAddress("10.10.10.2");
        IE.add(gsn2);
        
        msisdn = new IEMSISDN("994702011893");
        IE.add(msisdn);
        
        qos = new IEQoS("323241843419854800869261311");
        IE.add(qos);
        
        ratType = new IERATType("1");
        IE.add(ratType);
        
        locInfo = new IEUserLocationInfo("");
        IE.add(locInfo);
        
        timeZone = new IEMSTimeZone("");
        IE.add(timeZone);
        
        imeisv = new IEIMEISV("3520550661022616");
        IE.add(imeisv);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
