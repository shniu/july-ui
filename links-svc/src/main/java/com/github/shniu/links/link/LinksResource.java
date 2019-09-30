package com.github.shniu.links.link;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Links transfer uri")
public class LinksResource {
    private LinkService linkService;

    public LinksResource(final LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping(value = "/short/{originUrl}")
    @ApiOperation(value = "短链接生成接口", notes = "对外提供短链接生成功能，传入长链接返回短链接")
    public String getShortUrl(@PathVariable @Valid @NotBlank final String originUrl) {
        String shortUrl = linkService.toShort(originUrl);
        return String.format("Your url is %s, and short url is %s", originUrl, shortUrl);
    }
}
