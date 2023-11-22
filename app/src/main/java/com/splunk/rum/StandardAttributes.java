package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes.dex */
public final class StandardAttributes {
    public static final AttributeKey<String> KClassImpl$Data$declaredNonStaticMembers$2 = AttributeKey.CC.stringKey("app.version");
    public static final AttributeKey<String> getAuthRequestContext = AttributeKey.CC.stringKey("app.build.type");
    public static final AttributeKey<String> PlaceComponentResult = SemanticAttributes.HTTP_URL;

    private StandardAttributes() {
    }
}
