package com.bumptech.glide.util;

import id.dana.data.constant.BranchLinkConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> getAuthRequestContext = new AtomicReference<>();

    private ByteBufferUtil() {
    }

    public static ByteBuffer PlaceComponentResult(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length == 0) {
                    throw new IOException("File unsuitable for memory mapping");
                }
                randomAccessFile = new RandomAccessFile(file, BranchLinkConstant.PayloadKey.REFERRAL);
                try {
                    fileChannel = randomAccessFile.getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
                try {
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return load;
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th4 = th;
                    fileChannel2 = fileChannel;
                    th = th4;
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    public static void MyBillsEntityDataFactory(ByteBuffer byteBuffer, File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = channel;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static InputStream PlaceComponentResult(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static ByteBuffer PlaceComponentResult(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = getAuthRequestContext.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                getAuthRequestContext.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SafeArray {
        final byte[] BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final int getAuthRequestContext;

        SafeArray(byte[] bArr, int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory = bArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = i2;
        }
    }

    /* loaded from: classes3.dex */
    static class ByteBufferStream extends InputStream {
        private int PlaceComponentResult = -1;
        private final ByteBuffer getAuthRequestContext;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(ByteBuffer byteBuffer) {
            this.getAuthRequestContext = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.getAuthRequestContext.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.getAuthRequestContext.hasRemaining()) {
                return this.getAuthRequestContext.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            synchronized (this) {
                this.PlaceComponentResult = this.getAuthRequestContext.position();
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.getAuthRequestContext.hasRemaining()) {
                int min = Math.min(i2, available());
                this.getAuthRequestContext.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            synchronized (this) {
                int i = this.PlaceComponentResult;
                if (i == -1) {
                    throw new IOException("Cannot reset to unset mark position");
                }
                this.getAuthRequestContext.position(i);
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (this.getAuthRequestContext.hasRemaining()) {
                long min = Math.min(j, available());
                this.getAuthRequestContext.position((int) (r0.position() + min));
                return min;
            }
            return -1L;
        }
    }

    public static byte[] MyBillsEntityDataFactory(ByteBuffer byteBuffer) {
        SafeArray safeArray = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (safeArray != null && safeArray.KClassImpl$Data$declaredNonStaticMembers$2 == 0 && safeArray.getAuthRequestContext == safeArray.BuiltInFictitiousFunctionClassFactory.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }
}
