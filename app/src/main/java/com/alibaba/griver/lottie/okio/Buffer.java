package com.alibaba.griver.lottie.okio;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.google.common.base.Ascii;
import id.dana.data.here.HereOauthManager;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    Segment head;
    long size;

    @Override // com.alibaba.griver.lottie.okio.BufferedSource, com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer buffer() {
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final BufferedSink emit() {
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer emitCompleteSegments() {
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink, com.alibaba.griver.lottie.okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final long size() {
        return this.size;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final OutputStream outputStream() {
        return new OutputStream() { // from class: com.alibaba.griver.lottie.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(Buffer.this);
                sb.append(".outputStream()");
                return sb.toString();
            }
        };
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean exhausted() {
        return this.size == 0;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean request(long j) {
        return this.size >= j;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final InputStream inputStream() {
        return new InputStream() { // from class: com.alibaba.griver.lottie.okio.Buffer.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(Buffer.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (j >= segment.limit - segment.pos) {
            j -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.limit - r8, j2);
            outputStream.write(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.size += j2;
        Segment segment = this.head;
        while (j >= segment.limit - segment.pos) {
            j -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos = (int) (sharedCopy.pos + j);
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer.head = sharedCopy;
            } else {
                segment2.prev.push(sharedCopy);
            }
            j2 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            int min = (int) Math.min(j, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = min;
            this.size -= j2;
            j -= j2;
            if (segment.pos == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        readFrom(inputStream, j, false);
        return this;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j : j - (segment.limit - segment.pos);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size--;
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    public final byte getByte(long j) {
        Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j > j) {
            Segment segment = this.head;
            while (true) {
                long j3 = segment.limit - segment.pos;
                if (j >= j3) {
                    j -= j3;
                    segment = segment.next;
                } else {
                    return segment.data[segment.pos + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                j4 += segment2.limit - segment2.pos;
            } while (j4 < 0);
            return segment2.data[segment2.pos + ((int) j4)];
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final short readShort() {
        int i;
        int i2;
        if (this.size < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 2: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.head;
        int i3 = segment.pos;
        int i4 = segment.limit;
        if (i4 - i3 < 2) {
            i = (readByte() & 255) << 8;
            i2 = readByte() & 255;
        } else {
            byte[] bArr = segment.data;
            int i5 = i3 + 1;
            byte b = bArr[i3];
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            this.size -= 2;
            if (i6 == i4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            i = (b & 255) << 8;
            i2 = b2 & 255;
        }
        return (short) (i | i2);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readInt() {
        int i;
        int i2;
        if (this.size < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 4: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.head;
        int i3 = segment.pos;
        int i4 = segment.limit;
        if (i4 - i3 < 4) {
            i = ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
            i2 = readByte() & 255;
        } else {
            byte[] bArr = segment.data;
            int i5 = i3 + 1;
            byte b = bArr[i3];
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            this.size -= 4;
            if (i8 == i4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            i = ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
            i2 = b4 & 255;
        }
        return i | i2;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readLong() {
        if (this.size < 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 8: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        long j = bArr[i];
        int i4 = i3 + 1;
        long j2 = bArr[i3];
        int i5 = i4 + 1;
        long j3 = bArr[i4];
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        int i8 = i7 + 1;
        long j6 = bArr[i7];
        int i9 = i8 + 1;
        long j7 = bArr[i8];
        int i10 = i9 + 1;
        long j8 = bArr[i9];
        this.size -= 8;
        if (i10 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i10;
        }
        return ((j7 & 255) << 8) | ((j6 & 255) << 16) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | (j8 & 255);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba A[EDGE_INSN: B:50:0x00ba->B:41:0x00ba BREAK  A[LOOP:0: B:5:0x000f->B:53:?], SYNTHETIC] */
    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readDecimalLong() {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[EDGE_INSN: B:43:0x00a4->B:38:0x00a4 BREAK  A[LOOP:0: B:5:0x000b->B:47:?], SYNTHETIC] */
    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lab
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.alibaba.griver.lottie.okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L90
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L39
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-97)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L71
            r11 = 70
            if (r10 > r11) goto L71
            int r11 = r10 + (-65)
        L37:
            int r11 = r11 + 10
        L39:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L49
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L49:
            com.alibaba.griver.lottie.okio.Buffer r0 = new com.alibaba.griver.lottie.okio.Buffer
            r0.<init>()
            com.alibaba.griver.lottie.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.alibaba.griver.lottie.okio.Buffer r0 = r0.writeByte(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r0 = r0.readUtf8()
            r1.append(r0)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L71:
            if (r0 == 0) goto L75
            r1 = 1
            goto L90
        L75:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L90:
            if (r8 != r9) goto L9c
            com.alibaba.griver.lottie.okio.Segment r7 = r6.pop()
            r15.head = r7
            com.alibaba.griver.lottie.okio.SegmentPool.recycle(r6)
            goto L9e
        L9c:
            r6.pos = r8
        L9e:
            if (r1 != 0) goto La4
            com.alibaba.griver.lottie.okio.Segment r6 = r15.head
            if (r6 != 0) goto Lb
        La4:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lab:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
    
        if (r19 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a3, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int selectPrefix(com.alibaba.griver.lottie.okio.Options r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 165
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.okio.Buffer.selectPrefix(com.alibaba.griver.lottie.okio.Options, boolean):int");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 < j) {
            buffer.write(this, j2);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount > Integer.MAX_VALUE: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.head;
                if (segment.pos + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                String str = new String(segment.data, segment.pos, (int) j, charset);
                segment.pos = (int) (segment.pos + j);
                this.size -= j;
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j = this.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return readUtf8Line(indexOf);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("limit < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\n not found: limit=");
        sb2.append(Math.min(size(), j));
        sb2.append(" content=");
        sb2.append(buffer.readByteString().hex());
        sb2.append(Typography.ellipsis);
        throw new EOFException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1L);
        return readUtf82;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((b & 248) != 240) {
            skip(1L);
            return REPLACEMENT_CHARACTER;
        } else {
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.size < j) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < ");
            sb.append(i2);
            sb.append(": ");
            sb.append(this.size);
            sb.append(" (to read code point prefixed 0x");
            sb.append(Integer.toHexString(b));
            sb.append(")");
            throw new EOFException(sb.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        return i > 1114111 ? REPLACEMENT_CHARACTER : ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.limit - this.head.pos);
            long j2 = min;
            this.size -= j2;
            j -= j2;
            this.head.pos += min;
            if (this.head.pos == this.head.limit) {
                Segment segment = this.head;
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeUtf8(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("beginIndex < 0: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("endIndex < beginIndex: ");
                sb2.append(i2);
                sb2.append(" < ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i2 > str.length()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endIndex > string.length: ");
                sb3.append(i2);
                sb3.append(" > ");
                sb3.append(str.length());
                throw new IllegalArgumentException(sb3.toString());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment writableSegment = writableSegment(1);
                        byte[] bArr = writableSegment.data;
                        int i3 = writableSegment.limit - i;
                        int min = Math.min(i2, 8192 - i3);
                        bArr[i + i3] = (byte) charAt;
                        i++;
                        while (i < min) {
                            char charAt2 = str.charAt(i);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i + i3] = (byte) charAt2;
                            i++;
                        }
                        int i4 = (i3 + i) - writableSegment.limit;
                        writableSegment.limit += i4;
                        this.size += i4;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | 128);
                        } else if (charAt < 55296 || charAt > 57343) {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | 128);
                            writeByte((charAt & '?') | 128);
                        } else {
                            int i5 = i + 1;
                            char charAt3 = i5 < i2 ? str.charAt(i5) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                writeByte(63);
                                i = i5;
                            } else {
                                int i6 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i6 >> 18) | 240);
                                writeByte(((i6 >> 12) & 63) | 128);
                                writeByte(((i6 >> 6) & 63) | 128);
                                writeByte((i6 & 63) | 128);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("beginIndex < 0: ");
                sb.append(i);
                throw new IllegalAccessError(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("endIndex < beginIndex: ");
                sb2.append(i2);
                sb2.append(" < ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(Util.UTF_8)) {
                    return writeUtf8(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return write(bytes, 0, bytes.length);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endIndex > string.length: ");
                sb3.append(i2);
                sb3.append(" > ");
                sb3.append(str.length());
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer write(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return write(bArr, 0, bArr.length);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i3 - i, 8192 - writableSegment.limit);
            System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
            i += min;
            writableSegment.limit += min;
        }
        this.size += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i, 8192 - writableSegment.limit);
            byteBuffer.get(writableSegment.data, writableSegment.limit, min);
            i -= min;
            writableSegment.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        writableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        int i = j < 100000000 ? j < 10000 ? j < 100 ? j >= 10 ? 2 : 1 : j < 1000 ? 3 : 4 : j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8 : j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        if (z) {
            i++;
        }
        Segment writableSegment = writableSegment(i);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit + i;
        while (j != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        writableSegment.limit += i;
        this.size += i;
        return this;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSink
    public final Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (writableSegment.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment writableSegment(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
    }

    @Override // com.alibaba.griver.lottie.okio.Sink
    public final void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            if (j < buffer.head.limit - buffer.head.pos) {
                Segment segment = this.head;
                Segment segment2 = segment != null ? segment.prev : null;
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        buffer.head.writeTo(segment2, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                buffer.head = buffer.head.split((int) j);
            }
            Segment segment3 = buffer.head;
            long j2 = segment3.limit - segment3.pos;
            buffer.head = segment3.pop();
            Segment segment4 = this.head;
            if (segment4 == null) {
                this.head = segment3;
                segment3.prev = segment3;
                segment3.next = segment3;
            } else {
                segment4.prev.push(segment3).compact();
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // com.alibaba.griver.lottie.okio.Source
    public final long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            }
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b) {
        return indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b, long j) {
        return indexOf(b, j, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.size;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (segment = this.head) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j6 = (segment.limit - segment.pos) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.next;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = segment.data;
            int min = (int) Math.min(segment.limit, (segment.pos + j5) - j4);
            for (int i = (int) ((segment.pos + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.pos) + j4;
                }
            }
            j4 += segment.limit - segment.pos;
            segment = segment.next;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException("fromIndex < 0");
            }
            Segment segment = this.head;
            long j3 = -1;
            if (segment == null) {
                return -1L;
            }
            long j4 = this.size;
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    j4 -= segment.limit - segment.pos;
                }
            } else {
                while (true) {
                    long j5 = (segment.limit - segment.pos) + j2;
                    if (j5 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j2 = j5;
                }
                j4 = j2;
            }
            byte b = byteString.getByte(0);
            int size = byteString.size();
            long j6 = (this.size - size) + 1;
            long j7 = j;
            Segment segment2 = segment;
            long j8 = j4;
            while (j8 < j6) {
                byte[] bArr2 = segment2.data;
                int min = (int) Math.min(segment2.limit, (segment2.pos + j6) - j8);
                int i = (int) ((segment2.pos + j7) - j8);
                while (i < min) {
                    if (bArr2[i] == b) {
                        bArr = bArr2;
                        if (rangeEquals(segment2, i + 1, byteString, 1, size)) {
                            return (i - segment2.pos) + j8;
                        }
                    } else {
                        bArr = bArr2;
                    }
                    i++;
                    bArr2 = bArr;
                }
                j8 += segment2.limit - segment2.pos;
                segment2 = segment2.next;
                j7 = j8;
                j3 = -1;
            }
            return j3;
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final long indexOfElement(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.prev;
                j3 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j4 = (segment.limit - segment.pos) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.next;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i = (int) ((segment.pos + j) - j3);
                int i2 = segment.limit;
                while (i < i2) {
                    byte b3 = bArr[i];
                    if (b3 != b && b3 != b2) {
                        i++;
                    }
                    return (i - segment.pos) + j3;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                j = j3;
            }
            return -1L;
        }
        byte[] internalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i = (int) ((segment.pos + j) - j3);
            int i3 = segment.limit;
            while (i < i3) {
                byte b4 = bArr2[i];
                for (byte b5 : internalArray) {
                    if (b4 == b5) {
                        return (i - segment.pos) + j3;
                    }
                }
                i++;
            }
            j3 += segment.limit - segment.pos;
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // com.alibaba.griver.lottie.okio.BufferedSource
    public final boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.alibaba.griver.lottie.okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    final List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        }
    }

    public final ByteString md5() {
        return digest(MD5Util.ALGORIGTHM_MD5);
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                messageDigest.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    messageDigest.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac(HereOauthManager.HASHING_ALGORITHM, byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    mac.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.size;
            if (j != buffer.size) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.head;
            Segment segment2 = buffer.head;
            int i = segment.pos;
            int i2 = segment2.pos;
            while (j2 < this.size) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                int i3 = 0;
                while (i3 < min) {
                    if (segment.data[i] != segment2.data[i2]) {
                        return false;
                    }
                    i3++;
                    i++;
                    i2++;
                }
                if (i == segment.limit) {
                    segment = segment.next;
                    i = segment.pos;
                }
                if (i2 == segment2.limit) {
                    segment2 = segment2.next;
                    i2 = segment2.pos;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public final String toString() {
        return snapshot().toString();
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public final Buffer m50clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("size > Integer.MAX_VALUE: ");
            sb.append(this.size);
            throw new IllegalArgumentException(sb.toString());
        }
        return snapshot((int) j);
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    /* loaded from: classes6.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public final int next() {
            if (this.offset == this.buffer.size) {
                throw new IllegalStateException();
            }
            long j = this.offset;
            return j == -1 ? seek(0L) : seek(j + (this.end - this.start));
        }

        public final int seek(long j) {
            if (j < -1 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
            }
            if (j == -1 || j == this.buffer.size) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j2 = this.buffer.size;
            Segment segment = this.buffer.head;
            Segment segment2 = this.buffer.head;
            long j3 = 0;
            if (this.segment != null) {
                long j4 = this.offset - (this.start - r4.pos);
                if (j4 > j) {
                    segment2 = this.segment;
                    j2 = j4;
                } else {
                    segment = this.segment;
                    j3 = j4;
                }
            }
            if (j2 - j > j - j3) {
                while (j >= (segment.limit - segment.pos) + j3) {
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                }
            } else {
                while (j2 > j) {
                    segment2 = segment2.prev;
                    j2 -= segment2.limit - segment2.pos;
                }
                j3 = j2;
                segment = segment2;
            }
            if (this.readWrite && segment.shared) {
                Segment unsharedCopy = segment.unsharedCopy();
                if (this.buffer.head == segment) {
                    this.buffer.head = unsharedCopy;
                }
                segment = segment.push(unsharedCopy);
                segment.prev.pop();
            }
            this.segment = segment;
            this.offset = j;
            this.data = segment.data;
            this.start = segment.pos + ((int) (j - j3));
            int i = segment.limit;
            this.end = i;
            return i - this.start;
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("newSize < 0: ");
                    sb.append(j);
                    throw new IllegalArgumentException(sb.toString());
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    Segment segment = this.buffer.head.prev;
                    long j4 = segment.limit - segment.pos;
                    if (j4 <= j3) {
                        this.buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                        j3 -= j4;
                    } else {
                        segment.limit = (int) (segment.limit - j3);
                        break;
                    }
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment writableSegment = this.buffer.writableSegment(1);
                    int min = (int) Math.min(j5, 8192 - writableSegment.limit);
                    writableSegment.limit += min;
                    j5 -= min;
                    if (z) {
                        this.segment = writableSegment;
                        this.offset = j2;
                        this.data = writableSegment.data;
                        this.start = writableSegment.limit - min;
                        this.end = writableSegment.limit;
                        z = false;
                    }
                }
            }
            this.buffer.size = j;
            return j2;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("minByteCount <= 0: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (i > 8192) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("minByteCount > Segment.SIZE: ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else {
                Buffer buffer = this.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer");
                }
                if (!this.readWrite) {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                long j = buffer.size;
                Segment writableSegment = this.buffer.writableSegment(i);
                int i2 = 8192 - writableSegment.limit;
                writableSegment.limit = 8192;
                long j2 = i2;
                this.buffer.size = j + j2;
                this.segment = writableSegment;
                this.offset = j;
                this.data = writableSegment.data;
                this.start = 8192 - i2;
                this.end = 8192;
                return j2;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
