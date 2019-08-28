package com.benjamin.community.dto;

import lombok.Data;

@Data
public class AccessTokenDto {
    private String client_id	;       // GitHub应用程序的客户端ID。
    private String client_secret;	    //GitHub应用程序的客户端密码。
    private String code;                //您收到的代码作为对第1步的回复。
    private String redirect_uri;        //应用程序中的URL，用于在授权后发送用户。
    private String state;
}
