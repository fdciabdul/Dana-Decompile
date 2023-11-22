package io.opentelemetry.exporter.internal.okhttp;

import io.opentelemetry.exporter.internal.marshal.Marshaler;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* loaded from: classes9.dex */
final class JsonRequestBody extends RequestBody {
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
    private final Marshaler marshaler;

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return -1L;
    }

    public JsonRequestBody(Marshaler marshaler) {
        this.marshaler = marshaler;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return JSON_MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        this.marshaler.writeJsonTo(bufferedSink.moveToNextValue());
    }
}
