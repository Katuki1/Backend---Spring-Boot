package com.iso.iso8583.Mine;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("convert")
public class Iso8583Converter {

    private MessageFactory<IsoMessage> messageFactory;

    public Iso8583Converter() {
        // Initialize message factory with desired configuration
        messageFactory = new MessageFactory<>();
        messageFactory.setCharacterEncoding("UTF-8");
        // Set field format for incoming messages
        messageFactory.setUseBinaryMessages(false); // Set to true if using binary format
        messageFactory.setAssignDate(true); // If you need to add DATE12 field
//        messageFactory.setStrictParse(false); // Adjust this based on your requirements
    }

//    @PostMapping("/json-to-iso")
    public String jsonToIso(@RequestBody AtmCard atmCard) {
        try {
            IsoMessage isoMessage = messageFactory.newMessage(0x200);
            isoMessage.setValue(2, atmCard.getCardNumber().toString(),IsoType.NUMERIC,16); // Card Number
            isoMessage.setValue(102, atmCard.getAccountName(), IsoType.ALPHA, 20); // Account Name
            isoMessage.setValue(54, String.format("%.2f", atmCard.getAmount()), IsoType.NUMERIC, 20); // Amount
            isoMessage.setValue(52, String.format("%04d", atmCard.getPin()), IsoType.NUMERIC, 8); // PIN

            // Convert ISO message to String
            return isoMessage.debugString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting ATM card details to ISO: " + e.getMessage();
        }
    }

//    @PostMapping("/iso-to-json")
    public Map<String, Object> isoToJson(@RequestBody String isoMessageString) {
        Map<String, Object> jsonResponse = new HashMap<>();
        try {
            // Parse ISO 8583 message
            IsoMessage isoMessage = messageFactory.parseMessage(isoMessageString.getBytes(), isoMessageString.length(), false);

            // Extract field values from ISO message
            for (int i = 2; i <= 128; i++) {
                IsoValue<?> isoValue = isoMessage.getField(i);
//                IsoMessage.FieldValue<?> fieldValue = isoMessage.getField(i);
                if (isoValue != null) {
                    jsonResponse.put("field" + i, isoValue.getValue());
                }
            }
        } catch (Exception e) {
            jsonResponse.put("error", "Error parsing ISO 8583 message: " + e.getMessage());
        }
        return jsonResponse;
    }

}

