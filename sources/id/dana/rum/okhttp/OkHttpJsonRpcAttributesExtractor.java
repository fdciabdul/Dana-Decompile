package id.dana.rum.okhttp;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/rum/okhttp/OkHttpJsonRpcAttributesExtractor;", "Lio/opentelemetry/instrumentation/api/instrumenter/AttributesExtractor;", "Lokhttp3/Request;", "Lokhttp3/Response;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkHttpJsonRpcAttributesExtractor implements AttributesExtractor<Request, Response> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final /* synthetic */ void onEnd(AttributesBuilder attributesBuilder, Context context, Request request, Response response, Throwable th) {
        Response response2 = response;
        Intrinsics.checkNotNullParameter(attributesBuilder, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request, "");
        if ((response2 != null ? response2.body() : null) != null) {
            int code = response2.code();
            String header = response2.header("Content-Type");
            if (code == 200 && header != null && StringsKt.contains$default((CharSequence) header, (CharSequence) "application/json", false, 2, (Object) null)) {
                try {
                    JSONObject jSONObject = new JSONObject(response2.peekBody(LongCompanionObject.MAX_VALUE).string()).getJSONObject("result");
                    if (jSONObject.getBoolean("success")) {
                        return;
                    }
                    attributesBuilder.put("error", true);
                    if (jSONObject.has("errorCode")) {
                        attributesBuilder.put("exception.type", jSONObject.getString("errorCode"));
                    }
                    if (jSONObject.has("errorMsg")) {
                        attributesBuilder.put("exception.message", jSONObject.getString("errorMsg"));
                    }
                    if (jSONObject.has("errorMessage")) {
                        attributesBuilder.put("exception.message", jSONObject.getString("errorMessage"));
                    }
                } catch (IOException | JSONException unused) {
                }
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final /* synthetic */ void onStart(AttributesBuilder attributesBuilder, Context context, Request request) {
        Intrinsics.checkNotNullParameter(attributesBuilder, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request, "");
    }
}
