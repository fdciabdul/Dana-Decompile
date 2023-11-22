package io.opentelemetry.instrumentation.api.instrumenter.http;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface HttpServerAttributesGetter<REQUEST, RESPONSE> extends HttpCommonAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String flavor(REQUEST request);

    @Nullable
    String route(REQUEST request);

    @Nullable
    String scheme(REQUEST request);

    @Nullable
    @Deprecated
    String serverName(REQUEST request);

    @Nullable
    String target(REQUEST request);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerAttributesGetter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC<REQUEST, RESPONSE> {
        @Nullable
        @Deprecated
        public static String $default$serverName(HttpServerAttributesGetter httpServerAttributesGetter, Object obj) {
            throw new UnsupportedOperationException("This method is deprecated and will be removed in the next release");
        }
    }
}
