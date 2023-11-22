package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes6.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.io.FileSystem
        public Source source(File file) throws FileNotFoundException {
            return Okio.PlaceComponentResult(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink sink(File file) throws FileNotFoundException {
            try {
                return Okio.MyBillsEntityDataFactory(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.MyBillsEntityDataFactory(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink appendingSink(File file) throws FileNotFoundException {
            try {
                return Okio.getAuthRequestContext(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.getAuthRequestContext(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("failed to delete ");
            sb.append(file);
            throw new IOException(sb.toString());
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("failed to rename ");
            sb.append(file);
            sb.append(" to ");
            sb.append(file2);
            throw new IOException(sb.toString());
        }

        @Override // okhttp3.internal.io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("not a readable directory: ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to delete ");
                    sb2.append(file2);
                    throw new IOException(sb2.toString());
                }
            }
        }
    };

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
