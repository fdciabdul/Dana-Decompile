package com.alibaba.ariver.resource.parser.tar;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class TarInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private TarEntry f6233a;
    private long b;
    private long c;
    private boolean d;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public TarInputStream(InputStream inputStream) {
        super(inputStream);
        this.d = false;
        this.b = 0L;
        this.c = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            throw new IOException("mark/reset not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read != -1 ? bArr[0] & 255 : read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        TarEntry tarEntry = this.f6233a;
        if (tarEntry != null) {
            if (this.b == tarEntry.getSize()) {
                return -1;
            }
            if (this.f6233a.getSize() - this.b < i2) {
                i2 = (int) (this.f6233a.getSize() - this.b);
            }
        }
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            if (this.f6233a != null) {
                this.b += read;
            }
            this.c += read;
        }
        return read;
    }

    public TarEntry getNextEntry() throws IOException {
        closeCurrentEntry();
        byte[] buf = IOUtils.getBuf(512);
        byte[] buf2 = IOUtils.getBuf(512);
        boolean z = false;
        int i = 0;
        while (i < 512) {
            int read = read(buf2, 0, 512 - i);
            if (read < 0) {
                break;
            }
            System.arraycopy(buf2, 0, buf, i, read);
            i += read;
        }
        int length = buf.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (buf[i2] != 0) {
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            this.f6233a = new TarEntry(buf);
        }
        IOUtils.returnBuf(buf);
        IOUtils.returnBuf(buf2);
        return this.f6233a;
    }

    public long getCurrentOffset() {
        return this.c;
    }

    protected void closeCurrentEntry() throws IOException {
        TarEntry tarEntry = this.f6233a;
        if (tarEntry != null) {
            if (tarEntry.getSize() > this.b) {
                long j = 0;
                while (j < this.f6233a.getSize() - this.b) {
                    long skip = skip((this.f6233a.getSize() - this.b) - j);
                    if (skip == 0 && this.f6233a.getSize() - this.b > 0) {
                        throw new IOException("Possible tar file corruption");
                    }
                    j += skip;
                }
            }
            this.f6233a = null;
            this.b = 0L;
            skipPad();
        }
    }

    protected void skipPad() throws IOException {
        int i;
        long j = this.c;
        long j2 = 0;
        if (j <= 0 || (i = (int) (j % 512)) <= 0) {
            return;
        }
        while (true) {
            long j3 = 512 - i;
            if (j2 >= j3) {
                return;
            }
            j2 += skip(j3 - j2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.d) {
            long skip = super.skip(j);
            this.c += skip;
            return skip;
        } else if (j <= 0) {
            return 0L;
        } else {
            byte[] buf = IOUtils.getBuf(2048);
            long j2 = j;
            while (j2 > 0) {
                int read = read(buf, 0, (int) (j2 < 2048 ? j2 : 2048L));
                if (read < 0) {
                    break;
                }
                j2 -= read;
            }
            IOUtils.returnBuf(buf);
            return j - j2;
        }
    }

    public boolean isDefaultSkip() {
        return this.d;
    }

    public void setDefaultSkip(boolean z) {
        this.d = z;
    }
}
