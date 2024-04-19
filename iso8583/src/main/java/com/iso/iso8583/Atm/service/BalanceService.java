//package com.iso.iso8583.Atm.service;
//
//
//import com.iso.iso8583.Atm.client.function.BalanceIso;
//import com.iso.iso8583.Atm.client.function.DecodeIso;
//import com.iso.iso8583.Atm.model.Account;
//import com.iso.iso8583.Atm.repository.AccountRepository;
//import com.solab.iso8583.IsoMessage;
//import com.solab.iso8583.MessageFactory;
//import org.jpos.iso.ISOMsg;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.DataOutputStream;
//import java.net.Socket;
//
//@Service
//public class BalanceService {
//    private static final Logger logger = LoggerFactory.getLogger(BalanceService.class);
//    private AccountRepository accountRepository;
//    private Socket socket;
//    private DecodeIso decodeIso = new DecodeIso ();
//    private BalanceIso balanceIso = new BalanceIso ();
//    private final MessageFactory<IsoMessage> messageFactory;
//
//    @Autowired
//    public BalanceService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//        messageFactory = new MessageFactory<>();
//        // Configure message factory to parse ISO messages
//        messageFactory.setCharacterEncoding("UTF-8");
//        messageFactory.setUseBinaryMessages(false); // Use ASCII messages
////        messageFactory.setFieldParseInfo(2, new GenericParseInfo(IsoType.NUMERIC, 19));
////        messageFactory.setFieldParseInfo(52, new GenericParseInfo(IsoType.NUMERIC, 16));
////        messageFactory.setFieldParseInfo(62, new GenericParseInfo(IsoType.LLLVAR, 999));
//        // Example of setting field packagers for fields 2, 52, and 62
////        messageFactory.setFieldPackager(2, new IFA_NUMERIC(19, "Field 2"));
////        messageFactory.setFieldPackager(52, new IFA_NUMERIC(16, "Field 52"));
////        messageFactory.setFieldPackager(62, new IFA_LLLCHAR(999, "Field 62"));
//    }
//
//
//    public String jsonToIso(Account account) {
//        String account2 = account.getAccNumber();
//        String pin = account.getAccPin();
//        String server = account.getServer();
//        int port = account.getPort();
//
//        String result = balanceIso.buildIsoMessage(account2, pin, server, port);
//        return result;
//    }
//
////    public String isoToJson(String message){
////        ISOMsg isoMsg1 = decodeIso.parseISOMessage (message);
////        String account2 = isoMsg1.getString(2);
////        String pin = isoMsg1.getString(52);
////        String server = isoMsg1.getString(62).substring(0,9);
////        int port = Integer.parseInt(isoMsg1.getString(62).substring(9));
////
////        return account2;
////    }
//
//    public String isoToJson(String message) {
//        ISOMsg isoMsg = decodeIso.parseISOMessage(message);
//        String account2 = isoMsg.getString(2);
//        String pin = isoMsg.getString(52);
//        String server = isoMsg.getString(62).substring(0, 9);
//        int port = Integer.parseInt(isoMsg.getString(62).substring(9));
//
//        // Construct JSON object with extracted fields
//        JSONObject json = new JSONObject();
//        json.put("accountNumber", account2);
//        json.put("pin", pin);
//        json.put("server", server);
//        json.put("port", port);
//
//        return json.toString();
//    }
//
//
//    public String findByAccNumber(String msg) {
//        System.out.println ();
//        ISOMsg isoMsg = decodeIso.parseISOMessage (msg);
//        String accountNumber = isoMsg.getString (2);
//        String pinNumber = isoMsg.getString (52);
//        String server = isoMsg.getString (62).substring (0,9);
//        int port = Integer.parseInt (isoMsg.getString (62).substring (9));
//
//        BalanceIso balanceIso = new BalanceIso ();
//        Account account = accountRepository.findByAccNumber (accountNumber);
//        logger.info ("Fetch data from database by account number");
//        String message="";
//        if(account != null){
//            logger.info ("Data fetched successfully");
//            if(accountNumber.equalsIgnoreCase (account.getAccNumber ()) && Integer.parseInt (pinNumber) == Integer.parseInt (account.getAccPin ())){
//                message = balanceIso.buildResponseMessage (accountNumber, "00", account.getAccBalance ());
//            }else{
//                logger.warn ("Fail to Authenticate");
//                message = balanceIso.buildResponseMessage (accountNumber,"05",0);
//            }
//        }else {
//            logger.warn ("Empty data");
//            message = balanceIso.buildResponseMessage (accountNumber,"05",0);
//        }
//
//        try{
//            socket=new Socket (server,port);
//            if(socket.isConnected()){
//                logger.info ("Client connected to {} on port {}",socket.getInetAddress(), socket.getPort());
//            }else{
//                logger.warn ("Failed connect to client");
//            }
//            DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
//            dout.writeUTF(message);
//            dout.flush();
//            dout.close ();
//            socket.close ();
//        }catch (Exception e){
//            logger.error ("Error : {} in method {}",e.getMessage (), e.getStackTrace ());
//        }
//        return message;
//    }
//}
//
