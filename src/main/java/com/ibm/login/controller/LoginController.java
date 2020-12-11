package com.ibm.login.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.login.dto.UserDataDTO;
import com.ibm.login.service.UserService;

@RestController //Enabling REST functionality. With this, we can now expose our own endpoints
public class LoginController {
	@Autowired
	UserService userService;

	@GetMapping("/productDetails")
	public String getProductDetails(Principal principal) {

		final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;

		final Authentication authentication = oAuth2Authentication.getUserAuthentication();

		String tokenValue = ((OAuth2AuthenticationDetails) oAuth2Authentication.getDetails()).getTokenValue();
		String sessionId = ((OAuth2AuthenticationDetails) oAuth2Authentication.getDetails()).getSessionId();
		String serviceId = ((OAuth2Request) oAuth2Authentication.getOAuth2Request()).getClientId();

		HashMap<String, Object> details = (HashMap<String, Object>) authentication.getDetails();

		List identities = new ArrayList();
		identities.addAll((ArrayList)details.get("identities"));

		HashMap<String, Object> identity = (HashMap<String, Object>) identities.get(0);

		UserDataDTO user = new UserDataDTO();
		user.setUserAccountId(identity.get("id").toString());
		user.setUserAuthToken(tokenValue);
		user.setTransactionToken(sessionId);
		user.setServiceToken("serviceId_" + serviceId);
		userService.createUserData(user);

		return user.getUserAccountId();
	}

	@RequestMapping("/user")
    public Principal user(Principal principal) {
        //Principal holds the logged in user information.
        // Spring automatically populates this principal object after login.
    	
        return principal;
    }
 
    @RequestMapping("/userInfo")
    public String userInfo(Principal principal){
        final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        final Authentication authentication = oAuth2Authentication.getUserAuthentication();
        //Manually getting the details from the authentication, and returning them as String.
        return authentication.getDetails().toString();
    }
}
