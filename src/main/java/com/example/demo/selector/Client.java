package com.example.demo.selector;

import javassist.bytecode.stackmap.BasicBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1",8800));
            ByteBuffer  writeBuff = ByteBuffer.allocate(1024);
            ByteBuffer  readBuff = ByteBuffer.allocate(1024);
            writeBuff.put("Hello Words".getBytes());
            writeBuff.flip();
            while (true){
                writeBuff.rewind();
                channel.write(writeBuff);
                readBuff.clear();
                channel.read(readBuff);
                System.out.println("chient receive" +new String(readBuff.array()));
            }
        }catch (IOException e){

        }

    }
}
