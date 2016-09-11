package Utilities;

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
public class BitStream {
    
    
    
    public static byte[] makeBitStream(
            IEFlags flags, IEMessageType messageType, IELength length,
            IETEID teid, IESequenceNumber sequenceNumber, IEIMSI imsi,
            IEAPN apn, IERAI rai, IENSAPI nsapi, IEGSNAddress gsn1,
            IEGSNAddress gsn2, IETEID1 teid1, IETEIDCP teidcp, IEQoS qos,
            IEMSISDN msisdn, IERecovery recovery, IESelectionMode selection,
            IEEndUserAddress EndUserAddress, IEProtocolConfigurationOptions protconfig,
            IERATType ratType, IEUserLocationInfo locInfo, IEMSTimeZone timeZone,
            IEIMEISV imeisv) {
        byte[] bitStream = new byte[125 + qos.getLength() + msisdn.getLength() + imeisv.getLength()];
        bitStream[0] = flags.getBitStream()[3];
        bitStream[1] = messageType.getBitStream()[3];
        bitStream[2] = length.getBitStream()[0];
        bitStream[3] = length.getBitStream()[1];
        bitStream[4] = teid.getBitStream()[0];
        bitStream[5] = teid.getBitStream()[1];
        bitStream[6] = teid.getBitStream()[2];
        bitStream[7] = teid.getBitStream()[3];
        bitStream[8] = sequenceNumber.getBitStream()[0];
        bitStream[9] = sequenceNumber.getBitStream()[1];
        bitStream[10] = (byte) 255;
        bitStream[11] = 0;
        
        // imsi
        bitStream[12] = imsi.getBitStream()[0];
        bitStream[13] = imsi.getBitStream()[1];
        bitStream[14] = imsi.getBitStream()[2];
        bitStream[15] = imsi.getBitStream()[3];
        bitStream[16] = imsi.getBitStream()[4];
        bitStream[17] = imsi.getBitStream()[5];
        bitStream[18] = imsi.getBitStream()[6];
        bitStream[19] = imsi.getBitStream()[7];      
        bitStream[20] = imsi.getBitStream()[8];
        
        // RAI
        bitStream[21] = rai.getBitStream()[0];
        bitStream[22] = rai.getBitStream()[1];
        bitStream[23] = rai.getBitStream()[2];
        bitStream[24] = rai.getBitStream()[3];
        bitStream[25] = rai.getBitStream()[4];
        bitStream[26] = rai.getBitStream()[5];
        bitStream[27] = rai.getBitStream()[6];
        
        // Recovery
        bitStream[28] = recovery.getBitStream()[0];
        bitStream[29] = recovery.getBitStream()[1];
        
        // Selection
        bitStream[30] = selection.getBitStream()[0];
        bitStream[31] = selection.getBitStream()[1];
        
        // TEID1
        bitStream[32] = teid1.getBitStream()[0];
        bitStream[33] = teid1.getBitStream()[1];
        bitStream[34] = teid1.getBitStream()[2];
        bitStream[35] = teid1.getBitStream()[3];
        bitStream[36] = teid1.getBitStream()[4];
        
        // TEID CP
        bitStream[37] = teidcp.getBitStream()[0];
        bitStream[38] = teidcp.getBitStream()[1];
        bitStream[39] = teidcp.getBitStream()[2];
        bitStream[40] = teidcp.getBitStream()[3];
        bitStream[41] = teidcp.getBitStream()[4];
        
        // NSAPI
        bitStream[42] = nsapi.getBitStream()[0];
        bitStream[43] = nsapi.getBitStream()[1];
        
        // EndUserAddress
        bitStream[44] = EndUserAddress.getBitStream()[0];
        bitStream[45] = EndUserAddress.getBitStream()[1];
        bitStream[46] = EndUserAddress.getBitStream()[2];
        bitStream[47] = EndUserAddress.getBitStream()[3];
        bitStream[48] = EndUserAddress.getBitStream()[4];
        
        // apn
        bitStream[49] = apn.getBitStream()[0];
        bitStream[50] = apn.getBitStream()[1];
        bitStream[51] = apn.getBitStream()[2];
        bitStream[52] = apn.getBitStream()[3];
        bitStream[53] = apn.getBitStream()[4];
        bitStream[54] = apn.getBitStream()[5];
        bitStream[55] = apn.getBitStream()[6];
        
        // Protocol Configuration Options
        bitStream[56] = protconfig.getBitStream()[0];
        bitStream[57] = protconfig.getBitStream()[1];
        bitStream[58] = protconfig.getBitStream()[2];
        bitStream[59] = protconfig.getBitStream()[3];
        bitStream[60] = protconfig.getBitStream()[4];
        bitStream[61] = protconfig.getBitStream()[5];
        bitStream[62] = protconfig.getBitStream()[6];
        bitStream[63] = protconfig.getBitStream()[7];
        bitStream[64] = protconfig.getBitStream()[8];
        bitStream[65] = protconfig.getBitStream()[9];
        bitStream[66] = protconfig.getBitStream()[10];
        bitStream[67] = protconfig.getBitStream()[11];
        bitStream[68] = protconfig.getBitStream()[12];
        bitStream[69] = protconfig.getBitStream()[13];
        bitStream[70] = protconfig.getBitStream()[14];
        bitStream[71] = protconfig.getBitStream()[15];
        bitStream[72] = protconfig.getBitStream()[16];
        bitStream[73] = protconfig.getBitStream()[17];
        bitStream[74] = protconfig.getBitStream()[18];
        bitStream[75] = protconfig.getBitStream()[19];
        bitStream[76] = protconfig.getBitStream()[20];
        bitStream[77] = protconfig.getBitStream()[21];
        bitStream[78] = protconfig.getBitStream()[22];
        bitStream[79] = protconfig.getBitStream()[23];
        bitStream[80] = protconfig.getBitStream()[24];
        bitStream[81] = protconfig.getBitStream()[25];
        bitStream[82] = protconfig.getBitStream()[26];
        bitStream[83] = protconfig.getBitStream()[27];
        bitStream[84] = protconfig.getBitStream()[28];
        bitStream[85] = protconfig.getBitStream()[29];
        bitStream[86] = protconfig.getBitStream()[30];
        bitStream[87] = protconfig.getBitStream()[31];
        bitStream[88] = protconfig.getBitStream()[32];
        bitStream[89] = protconfig.getBitStream()[33];
        bitStream[90] = protconfig.getBitStream()[34];
        
        
        //gsn1
        bitStream[91] = gsn1.getBitStream()[0];
        bitStream[92] = gsn1.getBitStream()[1];
        bitStream[93] = gsn1.getBitStream()[2];
        bitStream[94] = gsn1.getBitStream()[3];
        bitStream[95] = gsn1.getBitStream()[4];
        bitStream[96] = gsn1.getBitStream()[5];
        bitStream[97] = gsn1.getBitStream()[6];
        
        //gsn2
        bitStream[98] = gsn2.getBitStream()[0];
        bitStream[99] = gsn2.getBitStream()[1];
        bitStream[100] = gsn2.getBitStream()[2];
        bitStream[101] = gsn2.getBitStream()[3];
        bitStream[102] = gsn2.getBitStream()[4];
        bitStream[103] = gsn2.getBitStream()[5];
        bitStream[104] = gsn2.getBitStream()[6];
        
        // msisdn
        int start = 105;
        int index = -1;
        for (int i=start; i<start+msisdn.getLength(); i++) {
            index++;
            bitStream[i] = 
                    msisdn.getBitStream()[index];
            
        }
        
        // qos
        start = 105 + msisdn.getLength();
        index = -1;
        for (int i=start; i<start+qos.getLength(); i++) {
            index++;
            bitStream[i] = 
                    qos.getBitStream()[index];
            
        }
        
        // RAT Type
        start = 105 + msisdn.getLength() + qos.getLength();
        bitStream[start] = ratType.getBitStream()[0];
        bitStream[start+1] = ratType.getBitStream()[1];
        bitStream[start+2] = ratType.getBitStream()[2];
        bitStream[start+3] = ratType.getBitStream()[3];
        
        // User Location Info
        bitStream[start+4] = locInfo.getBitStream()[0];
        bitStream[start+5] = locInfo.getBitStream()[1];
        bitStream[start+6] = locInfo.getBitStream()[2];
        bitStream[start+7] = locInfo.getBitStream()[3];
        bitStream[start+8] = locInfo.getBitStream()[4];
        bitStream[start+9] = locInfo.getBitStream()[5];
        bitStream[start+10] = locInfo.getBitStream()[6];
        bitStream[start+11] = locInfo.getBitStream()[7];
        bitStream[start+12] = locInfo.getBitStream()[8];
        bitStream[start+13] = locInfo.getBitStream()[9];
        bitStream[start+14] = locInfo.getBitStream()[10];
        
        // MS Time Zone
        bitStream[start+15] = timeZone.getBitStream()[0];
        bitStream[start+16] = timeZone.getBitStream()[1];
        bitStream[start+17] = timeZone.getBitStream()[2];
        bitStream[start+18] = timeZone.getBitStream()[3];
        bitStream[start+19] = timeZone.getBitStream()[4];
        
        start = start + 20;
        
        // IMEISV
        
        index = -1;
        for (int i=start; i<start+imeisv.getLength(); i++) {
            index++;
            bitStream[i] = 
                    imeisv.getBitStream()[index];
            
        }
        
        return bitStream;       
    }
    
    public static byte[] makeBitStream(
            IEFlags flags, byte messageType, IELength length, 
            IETEID teid, IESequenceNumber sequenceNumber) {
        byte[] bitStream = new byte[12];
        bitStream[0] = flags.getBitStream()[3];
        bitStream[1] = messageType;
        bitStream[2] = length.getBitStream()[0];
        bitStream[3] = length.getBitStream()[1];
        bitStream[4] = teid.getBitStream()[0];
        bitStream[5] = teid.getBitStream()[1];
        bitStream[6] = teid.getBitStream()[2];
        bitStream[7] = teid.getBitStream()[3];
        bitStream[8] = sequenceNumber.getBitStream()[0];
        bitStream[9] = sequenceNumber.getBitStream()[1];
        bitStream[10] = 0;
        bitStream[11] = 0;
        return bitStream;
    }
    
    
    
    
    public static byte[] makeBitStream(List<InformationElement> IE) {
        
        int byteLength = 0;
        int packetLength = 0;
        
        for (InformationElement e : IE) {
            // calculate byte length
            byteLength += e.getLength();
            
            // calculate packet length
            // no flags, message type, length, teid
            if (!e.getType().equals("Flags") && 
                    !e.getType().equals("Message Type") &&
                    !e.getType().equals("Length") &&
                    !e.getType().equals("TEID")) {
                packetLength += e.getLength();
            }
           
        }
        
        
        
        byte[] bitStream = new byte[byteLength];
        int streamIndex = 0;
        
        for (InformationElement e : IE) {
            // set packet length
            if (e.getType().equals("Length")) {
                IELength b = (IELength) e;
                b.setLength(new Integer(packetLength).toString());
            }
                
            for (int i=0; i<e.getLength(); i++) {
                bitStream[streamIndex] = e.getBitStream()[i];
                streamIndex++;
                
                // to be removed
                /* if (streamIndex == 10) {
                    bitStream[10] = (byte) 255;
                    bitStream[11] = 0;
                    streamIndex = 12; 
                } */
            }
        }
        
        
        /*
        for (GTPMessageBuildingBlocks.InformationElement e : IE) {
            
            
            // flags
            if (e.getMessageType().equals("Flags")) {
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
            }
            
            // message type
            if (e.getMessageType().equals("Message Type")) {
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
            }
            
            // length
            if (e.getMessageType().equals("Length")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
            }
            
            // TEID
            if (e.getMessageType().equals("TEID")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                
            }
            
            // Sequence Number
            if (e.getMessageType().equals("Sequence Number")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
            }
        



        
        
            // imsi
            if (e.getMessageType().equals("IMSI")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[7];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[8];
                streamIndex++;
            }

        
            // RAI
            if (e.getMessageType().equals("RAI")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
            }
        
            // Recovery
            if (e.getMessageType().equals("Recovery")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
            }

        
            // Selection
            if (e.getMessageType().equals("Selection")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
            }
        
        
            // TEID1
            if (e.getMessageType().equals("TEID1")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
            }
        
        
            // TEID CP
            if (e.getMessageType().equals("TEIDCP")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
            }
        
        
            // NSAPI
            if (e.getMessageType().equals("NSAPI")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
            }
        
        
            // EndUserAddress
            if (e.getMessageType().equals("End User Address")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
            }
        
        
            // apn
            if (e.getMessageType().equals("APN")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
            }
        
        
            // Protocol Configuration Options
            if (e.getMessageType().equals("Protocol Config")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[7];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[8];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[9];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[10];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[11];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[12];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[13];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[14];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[15];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[16];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[17];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[18];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[19];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[20];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[21];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[22];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[23];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[24];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[25];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[26];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[27];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[28];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[29];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[30];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[31];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[32];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[33];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[34];
                streamIndex++;
            }
        
            //gsn1
            if (e.getMessageType().equals("GSN")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
            }
        /*
        //gsn2
        bitStream[98] = gsn2.getBitStream()[0];
        bitStream[99] = gsn2.getBitStream()[1];
        bitStream[100] = gsn2.getBitStream()[2];
        bitStream[101] = gsn2.getBitStream()[3];
        bitStream[102] = gsn2.getBitStream()[4];
        bitStream[103] = gsn2.getBitStream()[5];
        bitStream[104] = gsn2.getBitStream()[6];
        
        
            // msisdn
            if (e.getMessageType().equals("MSISDN")) {
                int start = streamIndex;
                int index = -1;
                for (int i=start; i<start+e.getLength(); i++) {
                    index++;
                    bitStream[i] = 
                            e.getBitStream()[index];
                    streamIndex++;
            
                }
            }
        
            // qos
            if (e.getMessageType().equals("QoS")) {
                int start = streamIndex;
                int index = -1;
                for (int i=start; i<start+e.getLength(); i++) {
                    index++;
                    bitStream[i] = 
                        e.getBitStream()[index];
                    streamIndex++;
            
                }
            }
        
            // RAT Type
            if (e.getMessageType().equals("QoS")) {
                //start = 105 + msisdn.getLength() + qos.getLength();
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
            }
        
            // User Location Info
            if (e.getMessageType().equals("User Location Info")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[5];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[6];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[7];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[8];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[9];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[10];
                streamIndex++;
            }
        
            // MS Time Zone
            if (e.getMessageType().equals("User Location Info")) {
                bitStream[streamIndex] = e.getBitStream()[0];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[1];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[2];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[3];
                streamIndex++;
                bitStream[streamIndex] = e.getBitStream()[4];
                streamIndex++;
            }
        
        //start = start + 20;
        
            // IMEISV
            if (e.getMessageType().equals("IMEISV")) {
                int index = -1;
                for (int i=streamIndex; i<streamIndex+e.getLength(); i++) {
                    index++;
                    bitStream[i] = 
                            e.getBitStream()[index];
            
                }
            }
            
        } */
        
        
        return bitStream;       
    }
    
}
