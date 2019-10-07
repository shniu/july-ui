package com.github.shniu.links.link;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashLinkConverterTest {

    @Test
    void test_hashConvert() {
        LinkConverter linkConverter = new HashLinkConverter();
        String shortUrl = linkConverter.convert("https://time.geekbang.org/column/article/80850");
        System.out.println("Origin url is https://time.geekbang.org/column/article/80850, \nShort url is " + shortUrl);
    }
}
