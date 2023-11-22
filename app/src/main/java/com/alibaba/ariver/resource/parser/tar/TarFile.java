package com.alibaba.ariver.resource.parser.tar;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import id.dana.data.constant.BranchLinkConstant;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes6.dex */
public class TarFile implements Closeable {
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    public static final String TAG = "TarFile";

    /* renamed from: a  reason: collision with root package name */
    private final String f6232a;
    private File b;
    private RandomAccessFile c;
    private MappedByteBuffer d;
    private TarEntry e;
    private long f;
    private long g;

    public TarFile(String str) {
        this(new File(str), 1);
    }

    public TarFile(File file, int i) {
        String path = file.getPath();
        this.f6232a = path;
        if (i != 1 && i != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Bad mode: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if ((i & 4) != 0) {
            this.b = file;
            file.deleteOnExit();
        } else {
            this.b = null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, BranchLinkConstant.PayloadKey.REFERRAL);
            this.c = randomAccessFile;
            this.d = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, this.c.length());
        } catch (Throwable th) {
            try {
                RVLogger.e(TAG, th);
            } finally {
                IOUtils.freeMappedBuffer(this.d);
                IOUtils.closeQuietly(this.c);
            }
        }
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.c;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                IOUtils.freeMappedBuffer(this.d);
                this.c = null;
                randomAccessFile.close();
            }
            File file = this.b;
            if (file != null) {
                file.delete();
                this.b = null;
            }
        }
    }

    private void a() {
        if (this.c == null) {
            throw new IllegalStateException("Tar file closed");
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        a();
        TarEntry tarEntry = this.e;
        if (tarEntry != null) {
            if (this.f == tarEntry.getSize()) {
                return -1;
            }
            if (this.e.getSize() - this.f < i2) {
                i2 = (int) (this.e.getSize() - this.f);
            }
        }
        try {
            this.d.get(bArr, i, i2);
            i3 = i2;
        } catch (BufferUnderflowException e) {
            RVLogger.e(TAG, e);
            i3 = -1;
        }
        if (i3 != -1) {
            if (this.e != null) {
                this.f += i2;
            }
            this.g += i2;
            return i2;
        }
        throw new IOException();
    }

    public TarEntry getNextEntry() throws IOException {
        a();
        closeCurrentEntry();
        byte[] buf = IOUtils.getBuf(512);
        boolean z = false;
        try {
            this.d.get(buf, 0, 512);
        } catch (BufferUnderflowException e) {
            RVLogger.e(TAG, e);
        }
        int length = buf.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else if (buf[i] != 0) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            this.e = new TarEntry(buf);
        }
        IOUtils.returnBuf(buf);
        return this.e;
    }

    protected void closeCurrentEntry() throws IOException {
        TarEntry tarEntry = this.e;
        if (tarEntry == null) {
            return;
        }
        if (tarEntry.getSize() > this.f) {
            long j = 0;
            while (j < this.e.getSize() - this.f) {
                long skip = skip((this.e.getSize() - this.f) - j);
                if (skip == 0 && this.e.getSize() - this.f > 0) {
                    throw new IOException("Possible tar file corruption");
                }
                j += skip;
            }
        }
        this.e = null;
        this.f = 0L;
        skipPad();
    }

    protected void skipPad() throws IOException {
        int i;
        long j = this.g;
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

    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
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
