//package com.iso.iso8583.Atm.controller;
//
//import com.iso.iso8583.Atm.client.function.DecodeIso;
//import com.iso.iso8583.Atm.model.Account;
//import com.iso.iso8583.Atm.service.BalanceService;
//import com.solab.iso8583.IsoMessage;
//import com.solab.iso8583.MessageFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.jpos.iso.ISOBasePackager;
//import org.jpos.iso.ISOException;
//import org.jpos.iso.ISOMsg;
//import org.jpos.iso.packager.GenericPackager;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.InputStream;
//
//@RestController
//@RequestMapping("atm")
//@Slf4j
//public class BalanceController {
//    private DecodeIso decodeIso = new DecodeIso();
//    private BalanceService balanceService;
//    private ISOMsg isoMsg;
//    private String result = "";
//    private MessageFactory<IsoMessage> messageFactory;
//    private final ISOBasePackager packager;
//
//
//    @PostMapping(value = "/balance")
//    public String checkBalance(@RequestBody String message) {
//        log.info("Message from client: " + message);
//        result = balanceService.findByAccNumber(message);
//        log.info("Message to client: " + result);
//        return result;
//    }
//    public BalanceController(BalanceService balanceService) throws ISOException {
//        this.balanceService = balanceService;
//        // Load the ISO 8583 message packager from the XML file
//        InputStream is = getClass().getResourceAsStream("/fields.xml");
//        packager = new GenericPackager(is);
//    }
//
////    @PostMapping("/balance-to-json")
////    public Map<String, Object> isoToJson(@RequestBody String isoMessageString) {
////        Map<String, Object> jsonResponse = new HashMap<>();
////        try {
////            // Parse ISO 8583 message
////            ISOMsg isoMessage = new ISOMsg();
////            isoMessage.setPackager(packager);
////            isoMessage.unpack(ISOUtil.hex2byte(isoMessageString));
////
////            // Extract specific field values from ISO message
////            String accountNumber = isoMessage.getString(2);
////            String pinNumber = isoMessage.getString(52);
////            String serverAndPort = isoMessage.getString(62);
////
////            // Split serverAndPort into server and port
////            String server = serverAndPort.substring(0, 5);
////            int port = Integer.parseInt(serverAndPort.substring(5));
////
////            // Populate JSON response
////            jsonResponse.put("accountNumber", accountNumber);
////            jsonResponse.put("pinNumber", pinNumber);
////            jsonResponse.put("server", server);
////            jsonResponse.put("port", port);
////        } catch (Exception e) {
////            jsonResponse.put("error", "Error parsing ISO 8583 message: " + e.getMessage());
////        }
////        return jsonResponse;
////    }
//
//
//    @PostMapping("/balance-to-iso")
//    public String jsonToIso(@RequestBody Account account) {
//        result = balanceService.jsonToIso(account);
//        return result;
//    }
//
//    @PostMapping("/balance-to-json")
//    public String isoToJson(@RequestBody String message) {
//        result = balanceService.isoToJson(message);
//        return result;
//    }
//
//}
