package com.github.shniu.common.utils;

/**
 * 进制转换工具类
 */
public final class BinaryConversionUtil {

    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int scale62 = 62;

    /**
     * 10 进制转 62 进制
     *
     * @param num
     * @return
     */
    public static String toBase62(int num) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        while (num > scale62 - 1) {
            // 对 scale 进行求余，然后将余数追加至 sb 中，由于是从末位开始追加的，因此最后需要反转（reverse）字符串
            remainder = Long.valueOf(num % scale62).intValue();
            sb.append(chars.charAt(remainder));

            num = num / scale62;
        }

        sb.append(chars.charAt(Long.valueOf(num).intValue()));
        return sb.reverse().toString();
    }
}
