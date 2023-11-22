package id.dana.rum.okhttp;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractorBuilder;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class OkHttpJsonRpcTelemetryBuilder {
    public final OpenTelemetry KClassImpl$Data$declaredNonStaticMembers$2;
    public final List<AttributesExtractor<Request, Response>> PlaceComponentResult = new ArrayList();
    public final HttpClientAttributesExtractorBuilder<Request, Response> BuiltInFictitiousFunctionClassFactory = HttpClientAttributesExtractor.builder(OkHttpJsonRpcAttributesGetter.INSTANCE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpJsonRpcTelemetryBuilder(OpenTelemetry openTelemetry) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = openTelemetry;
    }
}
