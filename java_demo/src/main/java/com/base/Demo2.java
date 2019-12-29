package com.base;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by Brian in 19:16 2018/11/26
 */
public class Demo2 {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(Demo2.class);

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/file_dir";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteOutputStream byteOs = new ByteOutputStream();
        try {
            FileChannel fileChannel = FileChannel.open(Paths.get(path, "testin.txt"), StandardOpenOption.READ);
            int size = 0;
            size = fileChannel.read(buffer);
            System.out.println("size == "+size);
            while((size = fileChannel.read(buffer)) > -1){

                buffer.flip();
                System.out.println("size == "+size);
                System.out.println("position == "+buffer.position());
                System.out.println("limit == "+buffer.position());
                System.out.println("capacity == "+buffer.position());

                byteOs.write(buffer.array(), 0, size);
                buffer.clear();
            }

//            System.out.println(byteOs.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        /*while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println("str == " + str.getBytes().length);
        }*/
        test2();

    }

    public static void test2(){
        long start = System.currentTimeMillis();

        for (int i = 0; i < 30000; i++) {
            System.out.println(Thread.currentThread().getName() +" = "+i);
        }

        long end = System.currentTimeMillis();

        System.out.println("test2 --> " +(end -start));
    }


}
