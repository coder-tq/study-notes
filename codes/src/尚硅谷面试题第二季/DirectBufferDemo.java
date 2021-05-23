package 尚硅谷面试题第二季;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @author coder_tq
 * @Date 2021/5/23 16:46
 */
public class DirectBufferDemo {
    public static void main(String[] args) {
        System.out.println(VM.maxDirectMemory() / 1024/1024);
        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
