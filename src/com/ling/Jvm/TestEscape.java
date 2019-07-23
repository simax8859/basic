package com.ling.Jvm;

/**
 * @ClassName TestEscape
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/7/18 15:23
 * @Version 1.0
 **/
public class TestEscape {
    public static Object obj ;

    public void variableEscape(){
        obj = new Object(); //发生逃逸
    }

    public Object methodEscape(){
        return new Object();  //方法逃逸
    }


    public static void alloc(){
        byte[] bytes = new byte[2];
        bytes[0] = 1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++ ){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
