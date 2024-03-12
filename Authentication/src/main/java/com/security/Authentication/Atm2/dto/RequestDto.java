package com.security.Authentication.Atm2.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class RequestDto {
    private Long id;
    private String entityId;
    private String vendorName;

    //    //this atm Terminal Id, to be added by FrontEnd Team
//    private String deviceId;
    private String atmAccount;
    private String branchName;
    private String profileName;
    private String location;
    private String coordinates;
    private String atmHost;
    private String tcpPort;
    private String terminalMasterKey;
    private String ipAddress;
    private String terminalPinKey;
    private String gateway;

    //Operation Flags
    @Column(length = 30, nullable = false)
    private String postedBy;
    @Column(nullable = false)
    private Character postedFlag = 'N';
    @Column(nullable = false)
    private Date postedTime;

    private String modifiedBy;
    private Character modifiedFlag = 'N';
    private Date modifiedTime;

    private String verifiedBy;
    private Character verifiedFlag = 'N';
    private Date verifiedTime;

    private String deletedBy;
    private Character deletedFlag = 'N';
    private Date deletedTime;

    private Date rejectAt;
    private Character rejectedFlag = 'N';
    private String rejectBy;

}
