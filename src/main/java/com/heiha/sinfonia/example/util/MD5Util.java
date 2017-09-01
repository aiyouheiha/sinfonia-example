package com.heiha.sinfonia.example.util;

import com.heiha.sinfonia.example.enums.Algorithm;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/9/1 13:57<br>
 * <b>Author:</b> heiha<br>
 *
 * MD5 is a type of Message Digest, to represent the origin content. <br>
 * MD5 consists of 128 bits. Normally, 128 separate into 32 parts, every part has 4 bits. <br>
 * These 4 bits were represented by one hex number (2^4 = 16). <br>
 * Then, the 32 length string is the digest after MD5 encryption..
 */
public class MD5Util {
    public static String digest(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance(Algorithm.MD5.name());
        return new BigInteger(1, md5.digest(input.getBytes())).toString(16);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(Algorithm.MD5.name());
        System.out.println(MD5Util.digest("123").length());
    }
}
