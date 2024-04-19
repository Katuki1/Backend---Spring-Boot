package com.iso.iso8583.Atm.client.function;


import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class BalanceIso {
    private ISOMsg isoMsg;
    private InputStream inputStream;
    private GenericPackager packager;
    private byte[] result = new byte[0];

//    public String buildIsoMessage(String accNumber){
    public String buildIsoMessage(String accNumber, String pin, String server, int port){
        try {
            // Load package from resources directory.
            inputStream = getClass().getResourceAsStream("/fields.xml");
            packager = new GenericPackager(inputStream);

            isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI("0200");
            isoMsg.set (1,"0000000000000000");
//            isoMsg.setValue (accNumber);
            isoMsg.set (2,accNumber);
            isoMsg.set(3, "300000");
            isoMsg.set(4, "000000000000");
            isoMsg.set(7, new SimpleDateFormat ("MMddHHmmss").format(new Date ()));
            isoMsg.set(11, "000000");
            isoMsg.set (12, new SimpleDateFormat ("hhmmss").format(new Date ()));
            isoMsg.set (13, new SimpleDateFormat ("MMdd").format(new Date ()));
            isoMsg.set (15, new SimpleDateFormat ("MMdd").format(new Date ()));
            isoMsg.set(18,"0000");
            isoMsg.set(32,"00000000000");
            isoMsg.set(33,"00000000000");
            isoMsg.set (37,"000000000000");
            isoMsg.set (41, "00000000");
            isoMsg.set(43,"0000000000000000000000000000000000000000");
            isoMsg.set (49,"000");
            isoMsg.set (62, server+port);
            isoMsg.set (102,"0");
            isoMsg.set (52, pin);
            result= isoMsg.pack();
        } catch (ISOException e) {
            System.out.println ("Error: "+e.getMessage ());
        }
        return new String(result);
    }

    public String buildResponseMessage(String accNumber, String statusCode, int balance){
        try {
            // Load package from resources directory.
            inputStream = getClass().getResourceAsStream("/fields.xml");
            packager = new GenericPackager(inputStream);

            isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI("0210");
            isoMsg.set (1,"0000000000000000");
            isoMsg.set (2,accNumber);
            isoMsg.set(3, "309999");
            isoMsg.set(4, "000000000000");
            isoMsg.set(7, new SimpleDateFormat ("MMddHHmmss").format(new Date ()));
            isoMsg.set(11, "000000");
            isoMsg.set (12, new SimpleDateFormat ("hhmmss").format(new Date ()));
            isoMsg.set (13, new SimpleDateFormat ("MMdd").format(new Date ()));
            isoMsg.set (15, new SimpleDateFormat ("MMdd").format(new Date ()));
            isoMsg.set(18,"0000");
            isoMsg.set(32,"00000000000");
            isoMsg.set(33,"00000000000");
            isoMsg.set (37,"000000000000");
            isoMsg.set (39, statusCode);
            isoMsg.set (41, "00000000");
            isoMsg.set (42,"000000000000000");
            isoMsg.set(43,"0000000000000000000000000000000000000000");
            isoMsg.set (49,"000");
            isoMsg.set (54, balance+"");
            isoMsg.set(56, "0");
            isoMsg.set (62, "0");
            isoMsg.set (102,"0");

            DecodeIso decodeIso = new DecodeIso ();
            decodeIso.printISOMessage(isoMsg);
            result= isoMsg.pack();
            log.info ("ISO Message from Server: "+ new String(result));

        } catch (ISOException e) {
            log.info("Error: "+e.getMessage ());
        }
        return new String(result);
    }


}
