package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes9.dex */
enum OkHttpAttributesGetter implements HttpClientAttributesGetter<Request, Response> {
    INSTANCE;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final String method(Request request) {
        return request.method();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    public final String url(Request request) {
        return request.url().toString();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final List<String> requestHeader(Request request, String str) {
        return request.headers(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.opentelemetry.instrumentation.okhttp.v3_0.OkHttpAttributesGetter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$okhttp3$Protocol;

        static {
            int[] iArr = new int[Protocol.values().length];
            $SwitchMap$okhttp3$Protocol = iArr;
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.SPDY_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    @Nullable
    public final String flavor(Request request, @Nullable Response response) {
        if (response == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$okhttp3$Protocol[response.protocol().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return SemanticAttributes.HttpFlavorValues.SPDY;
                }
                return "2.0";
            }
            return SemanticAttributes.HttpFlavorValues.HTTP_1_1;
        }
        return "1.0";
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final Integer statusCode(Request request, Response response, @Nullable Throwable th) {
        return Integer.valueOf(response.code());
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final List<String> responseHeader(Request request, Response response, String str) {
        return response.headers(str);
    }
}
