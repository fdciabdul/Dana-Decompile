package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.exporter.internal.marshal.Marshaler;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes9.dex */
public final class GrpcRequestBody extends RequestBody {
    private static final byte COMPRESSED_FLAG = 1;
    private static final MediaType GRPC_MEDIA_TYPE = MediaType.parse("application/grpc");
    private static final int HEADER_LENGTH = 5;
    private static final byte UNCOMPRESSED_FLAG = 0;
    private final boolean compressed;
    private final int contentLength;
    private final Marshaler marshaler;
    private final int messageSize;

    public GrpcRequestBody(Marshaler marshaler, boolean z) {
        this.marshaler = marshaler;
        this.compressed = z;
        int binarySerializedSize = marshaler.getBinarySerializedSize();
        this.messageSize = binarySerializedSize;
        if (z) {
            this.contentLength = -1;
        } else {
            this.contentLength = binarySerializedSize + 5;
        }
    }

    @Override // okhttp3.RequestBody
    @Nullable
    public final MediaType contentType() {
        return GRPC_MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        if (!this.compressed) {
            bufferedSink.PlaceComponentResult(0);
            bufferedSink.BuiltInFictitiousFunctionClassFactory(this.messageSize);
            this.marshaler.writeBinaryTo(bufferedSink.moveToNextValue());
            return;
        }
        Buffer buffer = new Buffer();
        try {
            BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(new GzipSink(buffer));
            try {
                this.marshaler.writeBinaryTo(BuiltInFictitiousFunctionClassFactory.moveToNextValue());
                BuiltInFictitiousFunctionClassFactory.close();
                bufferedSink.PlaceComponentResult(1);
                int i = (int) buffer.getAuthRequestContext;
                bufferedSink.BuiltInFictitiousFunctionClassFactory(i);
                bufferedSink.write(buffer, i);
                buffer.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                buffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
