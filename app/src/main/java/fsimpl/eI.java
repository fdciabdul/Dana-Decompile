package fsimpl;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class eI {
    private static String a() {
        return UUID.randomUUID().toString();
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void a(File file, File file2) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (file2 == null) {
                throw new IOException(String.format("Directory already exists as a file: %s", file.getPath()));
            }
            file.renameTo(new File(file2, a()));
            if (file.exists()) {
                throw new IOException(String.format("Directory already exists as a file: %s", file.getPath()));
            }
        }
        file.mkdirs();
        if (!file.exists()) {
            throw new IOException(String.format("Unable to create dir: %s", file.getPath()));
        }
        if (!file.isDirectory()) {
            throw new IOException(String.format("Created directory, but now it's a file?: %s", file.getPath()));
        }
    }

    public static void b(File file, File file2) {
        file.renameTo(new File(file2, a()));
        if (file.exists()) {
            throw new IOException(String.format("Directory or file still exists after trashing: %s", file.getPath()));
        }
    }
}
