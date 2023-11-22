package com.alibaba.griver.lottie.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource, com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer buffer() {
        return this.buffer;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final Buffer getBuffer() {
        return this.buffer;
    }

    @Override // com.alibaba.griver.lottie.okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else {
                if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
                    return -1L;
                }
                return this.buffer.read(buffer, Math.min(j, this.buffer.size));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean request(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.buffer.size < j) {
            if (this.source.read(this.buffer, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final ByteString readByteString(long j) throws IOException {
        require(j);
        return this.buffer.readByteString(j);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = this.buffer.selectPrefix(options, true);
            if (selectPrefix == -1) {
                return -1;
            }
            if (selectPrefix != -2) {
                this.buffer.skip(options.byteStrings[selectPrefix].size());
                return selectPrefix;
            }
        } while (this.source.read(this.buffer, 8192L) != -1);
        return -1;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.buffer.readByteArray(j);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.buffer.size > 0) {
                Buffer buffer = this.buffer;
                int read = buffer.read(bArr, i, (int) buffer.size);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw e;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) Math.min(j, this.buffer.size));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.buffer.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.buffer);
            throw e;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j = 0;
            while (this.source.read(this.buffer, 8192L) != -1) {
                long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j += completeSegmentByteCount;
                    sink.write(this.buffer, completeSegmentByteCount);
                }
            }
            if (this.buffer.size() > 0) {
                long size = j + this.buffer.size();
                Buffer buffer = this.buffer;
                sink.write(buffer, buffer.size());
                return size;
            }
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8(long j) throws IOException {
        require(j);
        return this.buffer.readUtf8(j);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.buffer.readString(j, charset);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            if (this.buffer.size != 0) {
                return readUtf8(this.buffer.size);
            }
            return null;
        }
        return this.buffer.readUtf8Line(indexOf);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("limit < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        if (j2 < LongCompanionObject.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
            return this.buffer.readUtf8Line(j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\n not found: limit=");
        sb2.append(Math.min(this.buffer.size(), j));
        sb2.append(" content=");
        sb2.append(buffer.readByteString().hex());
        sb2.append(Typography.ellipsis);
        throw new EOFException(sb2.toString());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b = this.buffer.getByte(0L);
        if ((b & 224) == 192) {
            require(2L);
        } else if ((b & 240) == 224) {
            require(3L);
        } else if ((b & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readDecimalLong() throws IOException {
        byte b;
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            b = this.buffer.getByte(i);
            if ((b < 48 || b > 57) && !(i == 0 && b == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b)));
        }
        return this.buffer.readDecimalLong();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r1 == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L49
            com.alibaba.griver.lottie.okio.Buffer r3 = r6.buffer
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L2f
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L2f
        L27:
            r4 = 65
            if (r3 < r4) goto L31
            r4 = 70
            if (r3 > r4) goto L31
        L2f:
            r1 = r2
            goto L7
        L31:
            if (r1 == 0) goto L34
            goto L49
        L34:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r1[r0] = r2
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L49:
            com.alibaba.griver.lottie.okio.Buffer r0 = r6.buffer
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void skip(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.buffer.size());
            this.buffer.skip(min);
            j -= min;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b) throws IOException {
        return indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b, long j) throws IOException {
        return indexOf(b, j, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b, long j, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long indexOf = this.buffer.indexOf(b, j, j2);
            if (indexOf == -1) {
                long j3 = this.buffer.size;
                if (j3 >= j2 || this.source.read(this.buffer, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - byteString.size()) + 1);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOfElement(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final InputStream inputStream() {
        return new InputStream() { // from class: com.alibaba.griver.lottie.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, i, i2);
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(RealBufferedSource.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // com.alibaba.griver.lottie.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.alibaba.griver.lottie.okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.source);
        sb.append(")");
        return sb.toString();
    }
}
