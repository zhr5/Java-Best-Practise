package com.javaedge.io;


import org.springframework.util.DigestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileGenerteMd5 {

    public static void main(String args[]){
        try {
            System.out.println(fileGenerteMd5());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String fileGenerteMd5() throws FileNotFoundException {
        try {
            return DigestUtils.md5DigestAsHex(new FileInputStream("readme.md"));//使用spring生产MD5码
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
