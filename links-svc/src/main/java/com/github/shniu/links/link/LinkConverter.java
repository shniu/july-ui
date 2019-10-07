package com.github.shniu.links.link;

/**
 * @author shniu
 * @date 2019/09/30 11:41:59
 */
public interface LinkConverter {
    /**
     * 链接转换.
     *
     * @param url 待转换的url
     * @return 转换后的短链接
     */
    String convert(String url);
}
