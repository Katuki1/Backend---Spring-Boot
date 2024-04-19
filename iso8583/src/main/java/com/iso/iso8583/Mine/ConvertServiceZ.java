package com.iso.iso8583.Mine;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.solab.iso8583.MessageFactory;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertServiceZ {

    public EntityResponse parseISO8583Message(byte[] isoMessage) {
        EntityResponse response = new EntityResponse<>();
        JSONObject result = new JSONObject();
        try {
            MessageFactory messageFactory = new MessageFactory();
            // Parse the ISO message
            IsoMessage message = messageFactory.parseMessage(isoMessage, 0);

            JSONObject bitmapFields = new JSONObject();
            JSONArray fieldArray = new JSONArray();

            // Iterate through fields 2 to 128 (assuming 128-bit bitmap)
            for (int i = 2; i <= 128; i++) {
                if (message.hasField(i)) {
                    IsoType fieldType = message.getField(i).getType();
                    Object fieldValue = message.getObjectValue(i);
                    JSONObject field = new JSONObject();
                    field.put("field", i);
                    field.put("type", fieldType.toString());
                    field.put("value", fieldValue);
                    fieldArray.put(field);
                }
            }

            bitmapFields.put("fields", fieldArray);
            result.put("bitmapFields", bitmapFields);
            response.setEntity(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public List<JSONObject> parseISO8583Message(byte[] isoMessage) {
        List<JSONObject> resultList = new ArrayList<>();
        try {
            // Instantiate a new MessageFactory
            MessageFactory messageFactory = new MessageFactory();

            // Split the concatenated ISO 8583 messages
            String[] messages = isoMessage.split("\\[\\[\\s*\"|\"\\s*\\]\\]");

            // Parse each ISO 8583 message separately
            for (String message : messages) {
                IsoMessage isoMsg = messageFactory.parseMessage(Hex.decodeHex(message));

                JSONObject result = new JSONObject();
                JSONObject bitmapFields = new JSONObject();
                JSONArray fieldArray = new JSONArray();

                // Iterate through fields 2 to 128 (assuming 128-bit bitmap)
                for (int i = 2; i <= 128; i++) {
                    if (isoMsg.hasField(i)) {
                        IsoType fieldType = isoMsg.getField(i).getType();
                        Object fieldValue = isoMsg.getObjectValue(i);
                        JSONObject field = new JSONObject();
                        field.put("field", i);
                        field.put("type", fieldType.toString());
                        field.put("value", fieldValue);
                        fieldArray.put(field);
                    }
                }

                bitmapFields.put("fields", fieldArray);
                result.put("bitmapFields", bitmapFields);
                resultList.add(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}
