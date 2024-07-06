package com.example.transaction_management.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/{username}")
    public String helloWithUsername(@PathVariable String username)
    {
        return "hello " + username;
    }

    @GetMapping("/multiply/{num1}/{num2}")
    public Integer multiplyTwoNumber(@PathVariable Integer num1, @PathVariable Integer num2)
    {
        return num1 * num2;
    }
}
