//package com.iso.iso8583.Mine;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.solab.iso8583.IsoMessage;
//import com.solab.iso8583.IsoType;
//import com.solab.iso8583.IsoValue;
//import com.solab.iso8583.MessageFactory;
//
//import java.io.UnsupportedEncodingException;
//import java.text.ParseException;
//
//
//public class IsoToJsonConverter {
//
//    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
//        // Sample ISO message
//        String isoMessageBytes = "0110B23AE4012AE080340000000004000020002000000000003500072420053701236416050000" +
//                "24072507245411084000210A10420003141F0447708010100....D03081014327534F0F2F0F6F0" +
//                "F0F2F1F8F0F1F7F0F0C2F2F1F2F0F6F0F0F0F14040404040E3C5E7C1C3D640E2C5D9E5C9C3C540" +
//                "F8F8F740E2C1D5C4D6E2D2E84040404040404040404040E2E8D2C5E2E5C9D3D3C5404040D4C4E4" +
//                "E20840000EF2F44040404040404040404040400007F4F0F0" +
//                "40F0F0F0001B5E00000000000000218017E2E6E3C8D4C2C3C2E2E6E3C8D4C2C3C2100000000003" +
//                "023339E3C5E7C1C3D640E2C5D9E5C9C3C540";
//
//        // Create an ISO message factory
//        MessageFactory messageFactory = new MessageFactory();
//        messageFactory.setCharacterEncoding("UTF-8");
//
//        // Register the ISO message fields with the factory
//        messageFactory.setUseBinaryMessages(false); // Set to true if the ISO message is binary
//        messageFactory.addField(3, IsoType.NUMERIC, 6); // Example field 3 (processing code)
//        // Register other ISO fields as needed...
//
//        // Parse the ISO message
//        IsoMessage isoMessage = messageFactory.parseMessage(isoMessageBytes, 0);
//
//        // Convert ISO message to JSON
//        String json = convertIsoToJson(isoMessage);
//
//        // Print the JSON representation of the ISO message
//        System.out.println(json);
//    }
//
//    private static String convertIsoToJson(IsoMessage isoMessage) {
//        // Create a Gson instance
//        Gson gson = new Gson();
//
//        // Create a JSON object to hold ISO message fields
//        JsonObject jsonObject = new JsonObject();
//
//        // Iterate over each ISO field and add it to the JSON object
//        for (int field : isoMessage.getFieldNumbers()) {
//            IsoValue<?> isoValue = isoMessage.getField(field);
//            jsonObject.addProperty("field_" + field, isoValue.toString());
//        }
//
//        // Convert the JSON object to a string
//        return gson.toJson(jsonObject);
//    }
//}
//
