package com.example.transaction_management.redis_practice.service;

import com.example.transaction_management.redis_practice.dto.Tag;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private Tag findTagByName(String name) {
        // Database query simulation
        return new Tag(name, 0.25);
    }

    private Integer getNumber(Integer number) {
        // Database query simulation
        return number;
    }

    @Cacheable(value = "tags", key = "#name")
    public Tag getTagByName(String name) {
        //return findTagByName(name);
        try {
            throw new RuntimeException("not found");
            //return new Tag(name, 0.25);
        }
        catch(RuntimeException ex)
        {
            ex.printStackTrace();
            return null;
        }
        //return null;
    }

    @CacheEvict(value= "tags", key="#name")
    public boolean updateTags(String name)
    {
        //update something in database
        return true;
    }

    @CachePut(value = "tags", key = "#tag.getName()")
    public Tag updateTag(Tag tag) {
        // Update the user in the database
        return tag;
    }


    @Cacheable(value = "numbers", key = "#num")
    public Integer getTagByNumber(Integer num) {
        return getNumber(num);
    }
}
