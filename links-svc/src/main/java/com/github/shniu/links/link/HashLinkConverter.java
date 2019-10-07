package com.github.shniu.links.link;

import com.github.shniu.common.utils.BinaryConversionUtil;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

/**
 * @author shniu
 * @date 2019/09/30 12:44:57
 */
@Component
public class HashLinkConverter implements LinkConverter {

    /**
     * 这里 Hash 的实现使用的是 MurmurHash3, 实现有很多，可参考.
     * - Guava: https://github.com/google/guava/wiki/HashingExplained
     * - https://github.com/yonik/java_util/blob/master/src/util/hash/MurmurHash3.java
     * - Murmur hash 算法: http://blog.leanote.com/post/medusar/Murmur%E5%93%88%E5%B8%8C%E7%AE%97%E6%B3%95
     *
     * @param url 待转换的url
     * @return 转换后的字符串
     */
    @Override
    public String convert(final String url) {
        // 使用Murmur哈希算法生成hash值
        //noinspection UnstableApiUsage
        HashFunction hf = Hashing.murmur3_32();
        int hashVal = hf.newHasher().putString(url, Charsets.UTF_8).hash().asInt();

        // 将hash值转成base 62的字符串
        // 返回短链接
        return BinaryConversionUtil.toBase62(hashVal);
    }
}
