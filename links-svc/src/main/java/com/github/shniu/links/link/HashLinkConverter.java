package com.github.shniu.links.link;

import org.springframework.stereotype.Component;

/**
 * @author shniu
 * @date 2019/09/30 12:44:57
 */
@Component
public class HashLinkConverter implements LinkConverter {
    @Override
    public String convert() {
        // 使用Murmur哈希算法生成hash值
        // 将hash值转成base 62的字符串
        // 返回短链接
        return null;
    }
}
