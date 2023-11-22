package com.splunk.rum;

import com.google.common.net.HttpHeaders;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes8.dex */
class RumResponseAttributesExtractor implements AttributesExtractor<Request, Response> {
    private final ServerTimingHeaderParser PlaceComponentResult;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public /* synthetic */ void onEnd(AttributesBuilder attributesBuilder, Context context, Request request, Response response, Throwable th) {
        Response response2 = response;
        if (response2 != null) {
            String[] PlaceComponentResult = ServerTimingHeaderParser.PlaceComponentResult(response2.header(HttpHeaders.SERVER_TIMING));
            if (PlaceComponentResult.length == 2) {
                attributesBuilder.put((AttributeKey<AttributeKey<String>>) SplunkRum.initRecordTimeStamp, (AttributeKey<String>) PlaceComponentResult[0]);
                attributesBuilder.put((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda0, (AttributeKey<String>) PlaceComponentResult[1]);
            }
            String header = response2.header("rpcid");
            if (header != null) {
                attributesBuilder.put((AttributeKey<AttributeKey<String>>) SplunkRum.KClassImpl$Data$declaredNonStaticMembers$2, (AttributeKey<String>) header);
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public /* synthetic */ void onStart(AttributesBuilder attributesBuilder, Context context, Request request) {
        attributesBuilder.put((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) SemanticAttributes.FaasTriggerValues.HTTP);
    }
}
