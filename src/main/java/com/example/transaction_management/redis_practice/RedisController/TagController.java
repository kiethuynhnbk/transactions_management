package com.example.transaction_management.redis_practice.RedisController;

import com.example.transaction_management.redis_practice.dto.Tag;
import com.example.transaction_management.redis_practice.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService)
    {
        this.tagService = tagService;
    }

    @GetMapping("/Name/{name}")
    public Tag getTagByName(@PathVariable String name)
    {
        return tagService.getTagByName(name);
    }

    @PutMapping
    public Tag updateTagByName(@RequestBody Tag tag)
    {
        return tagService.updateTag(tag);
    }

    @GetMapping("/{number}")
    public Integer getNumberByValue(@PathVariable Integer number)
    {
        return tagService.getTagByNumber(number);
    }
}
