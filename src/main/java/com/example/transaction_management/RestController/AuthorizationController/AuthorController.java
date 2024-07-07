package com.example.transaction_management.RestController.AuthorizationController;

import com.example.transaction_management.dto.Login.LoginRequest;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.apache.kafka.common.security.auth.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @PostMapping("/login")
    public String login(@Valid @NonNull @RequestBody LoginRequest loginRequest)
    {
        LoginRequest rq = new LoginRequest("", "");
        if(loginRequest.getUsername().equals("kiet") &&
        loginRequest.getPassword().equals("1234"))
        {
            return "Login Success";
        }


        return "Login Failed";
    }
}
