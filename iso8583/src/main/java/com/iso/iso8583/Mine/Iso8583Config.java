package com.iso.iso8583.Mine;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Iso8583Config {

//    @Bean
//    public MessageFactory<IsoMessage> messageFactory() {
//        // Initialize message factory with desired configuration
//        MessageFactory<IsoMessage> messageFactory = new MessageFactory<>();
//        messageFactory.setCharacterEncoding("UTF-8");
//        // Set field format for incoming messages
//        messageFactory.setUseBinaryMessages(false); // Set to true if using binary format
//        messageFactory.setAssignDate(true); // If you need to add DATE12 field
//        messageFactory.setAssignDate(true); // If you need to add TIME10 field
//        messageFactory.setStrictParse(false); // Adjust this based on your requirements
//
//        // Define field format for specific fields
//        messageFactory.addField(3, IsoType.NUMERIC, 6); // Field 3 - 6 digits numeric
//        // Add more fields as needed
//
//        return messageFactory;
//    }
}

