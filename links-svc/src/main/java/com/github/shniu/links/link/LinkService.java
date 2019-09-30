package com.github.shniu.links.link;

import com.github.shniu.links.link.domain.Link;
import org.springframework.stereotype.Component;

/**
 * 链接相关操作的服务层.
 *
 * @author shniu
 * @date 2019/09/30 11:33:34
 */
@Component
public class LinkService {

    private LinkConverter linkConverter;

    public LinkService(final LinkConverter linkConverter) {
        this.linkConverter = linkConverter;
    }

    public String toShort(final String url) {
        Link link = new Link()
            .setOriginUrl(url)
            .setLinkConverter(linkConverter);

        return link.toShort();
    }
}
