package co.usa.ciclo3.ciclo3.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        //return principal.getAttributes(); //<=NO SE RECOMIENDA! EXPONE DATOS PRIVADOS
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
