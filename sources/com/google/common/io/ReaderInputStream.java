package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class ReaderInputStream extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderInputStream(Reader reader, Charset charset, int i) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i) {
        this.singleByte = new byte[1];
        this.reader = (Reader) Preconditions.checkNotNull(reader);
        this.encoder = (CharsetEncoder) Preconditions.checkNotNull(charsetEncoder);
        Preconditions.checkArgument(i > 0, "bufferSize must be positive: %s", i);
        charsetEncoder.reset();
        CharBuffer allocate = CharBuffer.allocate(i);
        this.charBuffer = allocate;
        Java8Compatibility.flip(allocate);
        this.byteBuffer = ByteBuffer.allocate(i);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (read(this.singleByte) == 1) {
            return UnsignedBytes.toInt(this.singleByte[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r2 > 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r2;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int read(byte[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r10 + r11
            int r1 = r9.length
            com.google.common.base.Preconditions.checkPositionIndexes(r10, r0, r1)
            r0 = 0
            if (r11 != 0) goto La
            return r0
        La:
            boolean r1 = r8.endOfInput
            r2 = 0
        Ld:
            boolean r3 = r8.draining
            r4 = 1
            if (r3 == 0) goto L2d
            int r3 = r10 + r2
            int r5 = r11 - r2
            int r3 = r8.drain(r9, r3, r5)
            int r2 = r2 + r3
            if (r2 == r11) goto L29
            boolean r3 = r8.doneFlushing
            if (r3 != 0) goto L29
            r8.draining = r0
            java.nio.ByteBuffer r3 = r8.byteBuffer
            com.google.common.io.Java8Compatibility.clear(r3)
            goto L2d
        L29:
            if (r2 > 0) goto L2c
            r2 = -1
        L2c:
            return r2
        L2d:
            boolean r3 = r8.doneFlushing
            if (r3 == 0) goto L34
            java.nio.charset.CoderResult r3 = java.nio.charset.CoderResult.UNDERFLOW
            goto L4b
        L34:
            if (r1 == 0) goto L3f
            java.nio.charset.CharsetEncoder r3 = r8.encoder
            java.nio.ByteBuffer r5 = r8.byteBuffer
            java.nio.charset.CoderResult r3 = r3.flush(r5)
            goto L4b
        L3f:
            java.nio.charset.CharsetEncoder r3 = r8.encoder
            java.nio.CharBuffer r5 = r8.charBuffer
            java.nio.ByteBuffer r6 = r8.byteBuffer
            boolean r7 = r8.endOfInput
            java.nio.charset.CoderResult r3 = r3.encode(r5, r6, r7)
        L4b:
            boolean r5 = r3.isOverflow()
            if (r5 == 0) goto L55
            r8.startDraining(r4)
            goto Ld
        L55:
            boolean r5 = r3.isUnderflow()
            if (r5 == 0) goto L6d
            if (r1 == 0) goto L63
            r8.doneFlushing = r4
            r8.startDraining(r0)
            goto Ld
        L63:
            boolean r3 = r8.endOfInput
            if (r3 == 0) goto L69
            r1 = 1
            goto L2d
        L69:
            r8.readMoreChars()
            goto L2d
        L6d:
            boolean r5 = r3.isError()
            if (r5 == 0) goto L2d
            r3.throwException()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.read(byte[], int, int):int");
    }

    private static CharBuffer grow(CharBuffer charBuffer) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        Java8Compatibility.position(wrap, charBuffer.position());
        Java8Compatibility.limit(wrap, charBuffer.limit());
        return wrap;
    }

    private void readMoreChars() throws IOException {
        if (availableCapacity(this.charBuffer) == 0) {
            if (this.charBuffer.position() > 0) {
                Java8Compatibility.flip(this.charBuffer.compact());
            } else {
                this.charBuffer = grow(this.charBuffer);
            }
        }
        int limit = this.charBuffer.limit();
        int read = this.reader.read(this.charBuffer.array(), limit, availableCapacity(this.charBuffer));
        if (read == -1) {
            this.endOfInput = true;
        } else {
            Java8Compatibility.limit(this.charBuffer, limit + read);
        }
    }

    private static int availableCapacity(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private void startDraining(boolean z) {
        Java8Compatibility.flip(this.byteBuffer);
        if (z && this.byteBuffer.remaining() == 0) {
            this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
        } else {
            this.draining = true;
        }
    }

    private int drain(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.byteBuffer.remaining());
        this.byteBuffer.get(bArr, i, min);
        return min;
    }
}
