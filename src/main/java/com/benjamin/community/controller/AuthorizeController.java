package com.benjamin.community.controller;

import com.benjamin.community.dto.AccessTokenDto;
import com.benjamin.community.dto.GitHubUserDto;
import com.benjamin.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("dabae88dd7602850ec69");
        accessTokenDto.setClient_secret("6e2e63068aa45e6f05430db8d7462d23b1161925");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost/callback");
        accessTokenDto.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUserDto user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName()+" "+user.getId());
        return "index";
    }

}
