package io.opentelemetry.exporter.internal.marshal;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes9.dex */
public abstract class CodedOutputStream {
    private static final int DEFAULT_BUFFER_SIZE;
    private static final ThreadLocal<OutputStreamEncoder> THREAD_LOCAL_CODED_OUTPUT_STREAM;

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeUInt32SizeNoTag(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeUInt64SizeNoTag(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    static int encodeZigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    static long encodeZigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void flush() throws IOException;

    abstract void write(byte b) throws IOException;

    abstract void write(byte[] bArr, int i, int i2) throws IOException;

    abstract void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeFixed32NoTag(int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeFixed64NoTag(long j) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeInt32NoTag(int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeUInt32NoTag(int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeUInt64NoTag(long j) throws IOException;

    static {
        int i;
        try {
            i = Integer.parseInt(System.getProperty("otel.experimental.otlp.buffer-size"));
        } catch (Throwable unused) {
            i = 51200;
        }
        DEFAULT_BUFFER_SIZE = i;
        THREAD_LOCAL_CODED_OUTPUT_STREAM = new ThreadLocal<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedOutputStream newInstance(OutputStream outputStream) {
        ThreadLocal<OutputStreamEncoder> threadLocal = THREAD_LOCAL_CODED_OUTPUT_STREAM;
        OutputStreamEncoder outputStreamEncoder = threadLocal.get();
        if (outputStreamEncoder == null) {
            OutputStreamEncoder outputStreamEncoder2 = new OutputStreamEncoder(outputStream);
            threadLocal.set(outputStreamEncoder2);
            return outputStreamEncoder2;
        }
        outputStreamEncoder.reset(outputStream);
        return outputStreamEncoder;
    }

    private CodedOutputStream() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeSInt32NoTag(int i) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    final void writeSFixed32NoTag(int i) throws IOException {
        writeFixed32NoTag(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    final void writeSInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    final void writeSFixed64NoTag(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    final void writeFloatNoTag(float f) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeDoubleNoTag(double d) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeBoolNoTag(boolean z) throws IOException {
        write(z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeEnumNoTag(int i) throws IOException {
        writeInt32NoTag(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeUInt32SizeNoTag(i);
        }
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeLengthDelimitedFieldSize(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i) {
            super();
            this.buffer = new byte[i];
            this.limit = i;
        }

        final void buffer(byte b) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
            this.totalBytesWritten++;
        }

        final void bufferUInt32NoTag(int i) {
            while ((i & (-128)) != 0) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                this.totalBytesWritten++;
                i >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long j) {
            while (((-128) & j) != 0) {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                this.totalBytesWritten++;
                j >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr2[i2] = (byte) j;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.position = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            int i2 = i + 1;
            bArr[i] = (byte) (j & 255);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((j >> 16) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (255 & (j >> 24));
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.position = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.totalBytesWritten += 8;
        }
    }

    /* loaded from: classes9.dex */
    static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private OutputStream out;

        OutputStreamEncoder(OutputStream outputStream) {
            super(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            this.out = outputStream;
        }

        final void reset(OutputStream outputStream) {
            this.out = outputStream;
            this.position = 0;
            this.totalBytesWritten = 0;
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, i, i2);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void write(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // io.opentelemetry.exporter.internal.marshal.CodedOutputStream
        final void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.limit - this.position >= i2) {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } else {
                int i3 = this.limit - this.position;
                System.arraycopy(bArr, i, this.buffer, this.position, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.position = this.limit;
                this.totalBytesWritten += i3;
                doFlush();
                if (i2 <= this.limit) {
                    System.arraycopy(bArr, i4, this.buffer, 0, i2);
                    this.position = i2;
                } else {
                    this.out.write(bArr, i4, i2);
                }
            }
            this.totalBytesWritten += i2;
        }

        private void flushIfNotAvailable(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }
}
