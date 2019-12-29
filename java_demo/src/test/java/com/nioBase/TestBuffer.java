package com.nioBase;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by Brian in 5:07 2018/11/24
 */
public class TestBuffer {
    private static final Log4JLogger logger = (Log4JLogger) LogFactory.getLog(TestBuffer.class);

    @Test
    public void test2(){
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 存入数据
        buf.put(str.getBytes());

        // 切换成读模式
        buf.flip();

        byte[] bt = new byte[buf.limit()];

        // 只读2个
        buf.get(bt, 0, 2);
        logger.info(new String(bt, 0, 2));

        // 标记mark()
        buf.mark();

        buf.get(bt, 0, 2);
        logger.info(new String(bt, 0, 2));
        logger.info(buf.position());
        buf.reset();
        logger.info(buf.position());

        // 判断缓冲区是否有可操作的数据
        if(buf.hasRemaining()){
            logger.info(buf.remaining());
        }

    }

    @Test
    public void test1(){
        String str = "abcde";
        // 1. allocate()分配缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);
        logger.info(" ---------------");
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        // 2. 利用put() 存放数据
        buf.put(str.getBytes());
        logger.info(" ------put()-------");
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        // 3. 切换读取模式
        buf.flip();
        logger.info(" ------flip()-------");
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        // 4. 利用get() 读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        logger.info(" ------get()-------");
        logger.info(new String(dst, 0, dst.length));
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        // 5. rewind() 重复读数据
        buf.rewind();
        logger.info(" ------rewind()-------");
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        // 6. clear() 清空缓冲区, 但是缓冲区数据还在， 数据处于被遗忘状态
        buf.clear();
        logger.info(" ------clear()-------");
        logger.info("position == "+buf.position());
        logger.info("limit == "+buf.limit());
        logger.info("capacity == "+buf.capacity());

        buf.get(dst, 0, 5);
        logger.info("clear() 之后 == "+new String(dst, 0, 5));
    }
}
