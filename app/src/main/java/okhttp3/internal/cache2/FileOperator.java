package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* loaded from: classes9.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public final void read(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.fileChannel.transferTo(j, j2, buffer);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public final void write(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.getAuthRequestContext) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}
