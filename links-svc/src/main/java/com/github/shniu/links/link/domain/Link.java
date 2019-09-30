package com.github.shniu.links.link.domain;

import com.github.shniu.links.link.LinkConverter;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shniu
 * @date 2019/09/30 11:31:47
 */
@Data
@Accessors(chain = true)
public class Link {
    // 原始链接
    private String originUrl;
    private String shortUrl;

    private LinkConverter linkConverter;

    /**
     * 转换成短链接.
     *
     * @return 短链接
     */
    public String toShort() {
        if (!validOriginUrl()) {
            throw new RuntimeException("");
        }

        // 根据转换算法获取到短网址
        shortUrl = linkConverter.convert();

        // 根据短网址来查询是否有冲突
        //   关系数据库中存储，加唯一索引查询
        //   优化性能：使用布隆过滤器先行判断，然后再做数据库查询插入
        return shortUrl;
    }

    private boolean validOriginUrl() {
        //  && originUrl.startsWith("http")
        return !Strings.isNullOrEmpty(originUrl);
    }
}
