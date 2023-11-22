package io.opentelemetry.exporter.internal.okhttp;

import io.opentelemetry.exporter.internal.marshal.Marshaler;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* loaded from: classes9.dex */
final class ProtoRequestBody extends RequestBody {
    private static final MediaType PROTOBUF_MEDIA_TYPE = MediaType.parse("application/x-protobuf");
    private final int contentLength;
    private final Marshaler marshaler;

    public ProtoRequestBody(Marshaler marshaler) {
        this.marshaler = marshaler;
        this.contentLength = marshaler.getBinarySerializedSize();
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return PROTOBUF_MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        this.marshaler.writeBinaryTo(bufferedSink.moveToNextValue());
    }
}
