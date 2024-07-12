package com.example.transaction_management.redis_practice.RedisController;

import com.example.transaction_management.redis_practice.dto.KeyValueRequest;
import com.example.transaction_management.redis_practice.dto.UserInfor;
import com.example.transaction_management.redis_practice.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private RedisService redisService;

    public RedisController(RedisService redisService)
    {
        this.redisService = redisService;
    }

    @PostMapping("/setKeyValue")
    public boolean setKeyValue(@RequestBody KeyValueRequest request)
    {
        return redisService.setKeyValue(request.getKey(), request.getValue(),
                request.getTTL());
    }

    @PostMapping("/setKeyValue/{key}")
    public boolean setKeyValueAsObject(@PathVariable String key, @RequestBody UserInfor userInfor)
    {
        return redisService.setKeyValue(key, userInfor,
                null);
        //return true;
    }

    @GetMapping("/getValue/{key}")
    public Object getKey(@PathVariable String key)
    {
        return redisService.getValueByKey(key);
    }
}
