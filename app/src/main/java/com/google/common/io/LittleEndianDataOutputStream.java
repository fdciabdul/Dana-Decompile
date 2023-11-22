package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        ((DataOutputStream) this.out).writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i) throws IOException {
        ((DataOutputStream) this.out).writeByte(i);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public final void writeBytes(String str) throws IOException {
        ((DataOutputStream) this.out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i) throws IOException {
        writeShort(i);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            writeChar(str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
        this.out.write((i >> 16) & 255);
        this.out.write((i >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j) throws IOException {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j));
        write(byteArray, 0, byteArray.length);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        ((DataOutputStream) this.out).writeUTF(str);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.out.close();
    }
}
