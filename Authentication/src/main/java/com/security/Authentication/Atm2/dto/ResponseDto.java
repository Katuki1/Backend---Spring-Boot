package com.security.Authentication.Atm2.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String atmAccount;
    private String branchName;
    private String profileName;
    private String terminalId;
    private String location;
    private String coordinates;
}




