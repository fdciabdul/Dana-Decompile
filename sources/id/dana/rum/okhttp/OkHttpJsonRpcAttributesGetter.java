package id.dana.rum.okhttp;

import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public enum OkHttpJsonRpcAttributesGetter implements HttpClientAttributesGetter<Request, Response> {
    INSTANCE;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    public final String url(Request request) {
        return request.url().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.rum.okhttp.OkHttpJsonRpcAttributesGetter$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Protocol.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[Protocol.SPDY_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    public final String flavor(Request request, Response response) {
        if (response == null) {
            return null;
        }
        int i = AnonymousClass1.PlaceComponentResult[response.protocol().ordinal()];
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
    public final String method(Request request) {
        return request.method();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final List<String> requestHeader(Request request, String str) {
        return request.headers(str);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final Integer statusCode(Request request, Response response, Throwable th) {
        int code = response.code();
        String header = response.header("Content-Type");
        if (code == 200 && header != null && header.contains("application/json") && response.body() != null) {
            try {
                if (!new JSONObject(response.peekBody(LongCompanionObject.MAX_VALUE).string()).getJSONObject("result").getBoolean("success")) {
                    return 503;
                }
            } catch (IOException | JSONException unused) {
            }
        }
        return Integer.valueOf(code);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final List<String> responseHeader(Request request, Response response, String str) {
        return response.headers(str);
    }
}
