package com.nioBase;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Brian in 2:16 2018/11/25
 */
public class TestChannel {


    /* private static final String relativePath = System.getProperty("user.dir");
     private static final String filePath = relativePath + "/file_dir";
    private static final String relativePath = "E:\\download\\browser\\office2016";
    private static final String filePath = "/cn_office_professional_plus_2016_x86_x64_dvd_6969182.iso";
    private static final String dstPath = "/demo/demo.iso"; */

    private static final String relativePath = "E:\\download\\browser\\office2016";
    private static final String filePath = "/cn_office_professional_plus_2016_x86_x64_dvd_6969182.iso";
    private static final String dstPath = "/demo/demo.iso";
    @Test
    public void test4() throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        // 获取编码器
        CharsetEncoder ce = charset.newEncoder();

        // 获取解码器
        CharsetDecoder cd = charset.newDecoder();

        CharBuffer cbf = CharBuffer.allocate(1024);
        cbf.put("解码器编码器练习");
        cbf.flip();

        ByteBuffer bBuf = ce.encode(cbf);

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        bBuf.flip();

        cd.decode(bBuf);



    }

    // 字符集
    @Test
    public void test3() {
        Map<String, Charset> map= Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry:set){
             System.out.println(entry.getKey()+" = "+ entry.getValue());
        }
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        try {
            FileChannel inChannel = FileChannel.open(Paths.get(relativePath, filePath), StandardOpenOption.READ);
//            FileChannel outChannel = FileChannel.open(Paths.get(relativePath, dstPath), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);

            // 内存映射文件
            MappedByteBuffer inMapBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, Integer.MAX_VALUE);
            MappedByteBuffer inMapBuf2 = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size()- Integer.MAX_VALUE);

//            MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作

            System.out.println("afe  == " + inMapBuf.limit() / Integer.MAX_VALUE);
            System.exit(1);
           /* byte[] dst = new byte[Integer.MAX_VALUE];
            inMapBuf.get(dst);
            outMapBuf.put(dst);*/

            inChannel.close();
//            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        long start = System.currentTimeMillis();
        try {
            fis = new FileInputStream(relativePath + filePath);
            fos = new FileOutputStream(relativePath + dstPath);

//        获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) > -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
