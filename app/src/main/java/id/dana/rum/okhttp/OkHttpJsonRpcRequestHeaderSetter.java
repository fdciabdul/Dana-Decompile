package id.dana.rum.okhttp;

import io.opentelemetry.context.propagation.TextMapSetter;
import okhttp3.Request;

/* loaded from: classes5.dex */
enum OkHttpJsonRpcRequestHeaderSetter implements TextMapSetter<Request.Builder> {
    INSTANCE;

    @Override // io.opentelemetry.context.propagation.TextMapSetter
    public final void set(Request.Builder builder, String str, String str2) {
        if (builder == null) {
            return;
        }
        builder.header(str, str2);
    }
}
