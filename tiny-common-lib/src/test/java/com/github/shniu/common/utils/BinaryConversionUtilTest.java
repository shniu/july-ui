package com.github.shniu.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryConversionUtilTest {

    @Test
    public void testConversionUtil() {
        String base62Val = BinaryConversionUtil.toBase62(19029212);
        System.out.println(base62Val);
    }
}
