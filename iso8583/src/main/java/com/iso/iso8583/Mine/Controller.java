package com.iso.iso8583.Mine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("converter")
public class Controller {
    EntityResponse response = new EntityResponse<>();


    @Autowired
    private ConvertService convertService;
    @Autowired
    private ConvertServiceZ convertServiceZ;

    @GetMapping("/hex-binary")
    public EntityResponse<ConvertService> hexToBinaryController (String hexString){

        String binary = convertService.hexToBinary(hexString);
        response.setMessage("Success");
        response.setEntity(binary);
        response.setStatusCode(HttpStatus.OK.value());

        return response;
    }

    @GetMapping("/binary-hex")
    public EntityResponse<ConvertService> BinaryToHexController (String binaryString){

        String hex = convertService.binaryToHex(binaryString);
        response.setMessage("Success");
        response.setEntity(hex);
        response.setStatusCode(HttpStatus.OK.value());

        return response;
    }

    @GetMapping("/bitmap-binary")
    public EntityResponse<ConvertService> bitmapToBinaryController (String isoMessage){

        String binary = convertService.bitmapToBinary(isoMessage);
        response.setMessage("Success");
        response.setEntity(binary);
        response.setStatusCode(HttpStatus.OK.value());

        return response;
    }

    @PostMapping("/parseISO8583")
    public EntityResponse<ConvertServiceZ> parseISO8583(@RequestBody byte[] isoMessage) {
//        return convertServiceZ.parseISO8583Message(isoMessage);
        EntityResponse binary = convertServiceZ.parseISO8583Message(isoMessage);
        response.setMessage("Success");
        response.setEntity(binary);
        response.setStatusCode(HttpStatus.OK.value());

        return response;
    }

}
