package com.iso.iso8583.Mine;


import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ConvertService {

    //Example
    //048C159D26AE37BF  // 0000 0100 1000 1100 0001 01011001110100100110101011100011011110111111
    //B23AE40128E09034  //1011001000111010111001000000000100101000111000001001000000110100

    public static String hexToBinary(String hexString) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (int i = 0; i < hexString.length(); i++) {
            char hexChar = hexString.charAt(i);
            String binaryDigit = Integer.toBinaryString(Integer.parseInt(String.valueOf(hexChar), 16));
            binaryStringBuilder.append(String.format("%4s", binaryDigit).replace(' ', '0'));
        }
        return binaryStringBuilder.toString();
    }


    public static String bitmapToBinary(String isoMessage) {
        // Extract the hexadecimal bitmap from the ISO message
        String hexBitmap = isoMessage.substring(4, 20); // Assuming bitmap is located at position 4 to 19

        // Convert the hexadecimal bitmap to binary
        String binaryBitmap = new BigInteger(hexBitmap, 16).toString(2);

        // Ensure that the binary bitmap has leading zeros if necessary
        int bitmapLength = hexBitmap.length() * 4;
        while (binaryBitmap.length() < bitmapLength) {
            binaryBitmap = "0" + binaryBitmap;
        }

        return binaryBitmap;
    }


    public static String binaryToHex(String binaryString) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 4) {
            String binaryDigitGroup = binaryString.substring(i, Math.min(i + 4, binaryString.length()));
            int decimalValue = Integer.parseInt(binaryDigitGroup, 2);
            String hexDigit = Integer.toHexString(decimalValue);
            hexStringBuilder.append(hexDigit);
        }
        return hexStringBuilder.toString().toUpperCase();
    }


    public ISOMsg iso8583Parser(String message){
        // Create an empty ISO message
        ISOMsg isoMsg = new ISOMsg();
        try{
            ISOPackager packager = new GenericPackager("/fields.json");

            // Set the packager
            isoMsg.setPackager(packager);

            // Load the ISO message from a byte array (replace byte array with your ISO message bytes)
            isoMsg.unpack(message.getBytes());


        }catch (ISOException e) {
        e.printStackTrace();
        }
        return isoMsg;
    }


    public void printISOMessage(ISOMsg isoMsg) throws ISOException {
        // Extract and process each field
        for (int i = 0; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                String fieldValue = isoMsg.getString(i);
                // Process the field value as needed
                System.out.println("Field " + i + ": " + fieldValue);
            }
        }
    }




}
