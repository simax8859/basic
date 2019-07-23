package com.ling.Jvm;

/**
 * @ClassName HeapTest
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/7/18 15:00
 * @Version 1.0
 **/
public class HeapTest {

    private static final int byteSize = 1024*1024;
    public static void main(String[] args) {
        byte[] bytes = new byte[40 * byteSize];
    }
}
