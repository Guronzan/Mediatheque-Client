package fr.guronzan.mediatheque.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {

    public static byte[] getArray(final File inputFile) throws IOException {
        if (inputFile != null) {
            final byte[] bFile = new byte[(int) inputFile.length()];
            try (FileInputStream fileInputStream = new FileInputStream(
                    inputFile)) {
                fileInputStream.read(bFile);
            }
            return bFile;
        }
        return null;
    }
}
