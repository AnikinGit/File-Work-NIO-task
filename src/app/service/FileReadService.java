package app.service;

import app.utils.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {
    public static String readBuffer(String path) throws IOException {

        Path path1 = Paths.get(Constants.BASE_PATH_REL + path + ".txt");

        FileChannel channel = FileChannel.open(path1);

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        channel.read(byteBuffer);

        byte[] byteArray = byteBuffer.array();

        channel.close();

        return new String(byteArray).trim();
    }
}
