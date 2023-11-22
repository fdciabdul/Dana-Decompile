package io.opentelemetry.exporter.internal.grpc;

import com.google.common.io.ByteStreams;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class MarshalerInputStream extends InputStream implements Drainable, KnownLength {
    @Nullable
    private Marshaler message;
    @Nullable
    private ByteArrayInputStream partial;

    public MarshalerInputStream(Marshaler marshaler) {
        this.message = marshaler;
    }

    public final int drainTo(OutputStream outputStream) throws IOException {
        Marshaler marshaler = this.message;
        if (marshaler != null) {
            int binarySerializedSize = marshaler.getBinarySerializedSize();
            this.message.writeBinaryTo(outputStream);
            this.message = null;
            return binarySerializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            int copy = (int) ByteStreams.copy(byteArrayInputStream, outputStream);
            this.partial = null;
            return copy;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.message != null) {
            this.partial = new ByteArrayInputStream(toByteArray(this.message));
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        Marshaler marshaler = this.message;
        if (marshaler != null) {
            if (marshaler.getBinarySerializedSize() == 0) {
                this.message = null;
                this.partial = null;
                return -1;
            }
            this.partial = new ByteArrayInputStream(toByteArray(this.message));
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }

    private static byte[] toByteArray(Marshaler marshaler) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(marshaler.getBinarySerializedSize());
        marshaler.writeBinaryTo(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // java.io.InputStream
    public final int available() {
        Marshaler marshaler = this.message;
        if (marshaler != null) {
            return marshaler.getBinarySerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }
}
