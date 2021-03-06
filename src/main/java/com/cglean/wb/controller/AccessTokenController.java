package com.cglean.wb.controller;

import com.cglean.wb.service.AccessTokenService;
import com.cglean.wb.service.util.Token;
import com.cglean.wb.service.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sanrawat on 2/13/2017.
 */

@RequestMapping("/public")
@RestController
public class AccessTokenController {

    private AccessTokenService accessTokenService;

    @Autowired
    public AccessTokenController(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    @PostMapping("/token")
    public Token securedAuthenticationToken(@RequestBody User user) {

        Token token = accessTokenService.getAccessToken(user);
        return token;

    }
//    Test Method
//    @GetMapping("/")
//    public String securedAuthenticationToken() {
//        User user = new User("", "");
//        Token token = accessTokenService.getAccessToken(user);
//        System.out.println(token);
//
//        return token.getAccess_token();
//    }

}
