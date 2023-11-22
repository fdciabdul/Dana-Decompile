package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class MultiInputStream extends InputStream {
    @CheckForNull

    /* renamed from: in  reason: collision with root package name */
    private InputStream f7437in;
    private Iterator<? extends ByteSource> it;

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.f7437in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f7437in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.f7437in = this.it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        InputStream inputStream = this.f7437in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f7437in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f7437in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        InputStream inputStream = this.f7437in;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f7437in.skip(j - 1) + 1;
    }
}
