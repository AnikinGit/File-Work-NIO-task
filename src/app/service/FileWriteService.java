package app.service;

import app.utils.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteService {

    public static String writeBuffer(String content, String path) {

        Path path1 = Paths.get(Constants.BASE_PATH_REL + path + ".txt");

        try {

            byte[] contentBytes = content.getBytes();

            ByteBuffer byteBuffer = ByteBuffer.wrap(contentBytes);

            FileChannel channel = FileChannel.open(path1, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            channel.write(byteBuffer);

            channel.close();
        } catch (IOException e) {
            return "Exception: " + e.getMessage();
        }
        return "The content has been written.";
    }
}
