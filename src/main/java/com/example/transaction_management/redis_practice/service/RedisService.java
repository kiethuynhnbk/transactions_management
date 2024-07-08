package com.example.transaction_management.redis_practice.service;

public interface RedisService {

    public boolean setKeyValue(String key, Object value, Long TTL);

    public Object getValueByKey(String key);
}
