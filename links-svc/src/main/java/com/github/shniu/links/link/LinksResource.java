package com.github.shniu.links.link;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author shniu
 * @date 2019/09/24 19:53:19
 */
@RestController
@RequestMapping("/links/v1")
public class LinksResource {

    @GetMapping(value = "/short/{originUrl}")
    public String getShortUrl(@PathVariable @Valid @NotBlank final String originUrl) {
        return String.format("Your url is %s", originUrl);
    }
}
