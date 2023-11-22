package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.internal.AttributeUtil;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ImmutableExceptionEventData implements ExceptionEventData {
    @Override // io.opentelemetry.sdk.trace.data.EventData
    public /* synthetic */ int getDroppedAttributesCount() {
        return EventData.CC.$default$getDroppedAttributesCount(this);
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final String getName() {
        return "exception";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SpanLimits getSpanLimits();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExceptionEventData create(SpanLimits spanLimits, long j, Throwable th, Attributes attributes) {
        return new AutoValue_ImmutableExceptionEventData(j, th, attributes, spanLimits);
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        Throwable exception = getException();
        Attributes additionalAttributes = getAdditionalAttributes();
        AttributesBuilder builder = Attributes.CC.builder();
        builder.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_TYPE, (AttributeKey<String>) exception.getClass().getCanonicalName());
        String message = exception.getMessage();
        if (message != null) {
            builder.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_MESSAGE, (AttributeKey<String>) message);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            exception.printStackTrace(printWriter);
            printWriter.close();
            builder.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_STACKTRACE, (AttributeKey<String>) stringWriter.toString());
            builder.putAll(additionalAttributes);
            SpanLimits spanLimits = getSpanLimits();
            return AttributeUtil.applyAttributesLimit(builder.build(), spanLimits.getMaxNumberOfAttributesPerEvent(), spanLimits.getMaxAttributeValueLength());
        } catch (Throwable th) {
            try {
                printWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final int getTotalAttributeCount() {
        return getAttributes().size();
    }
}
