package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.sdk.trace.data.EventData;

/* loaded from: classes6.dex */
public interface ExceptionEventData extends EventData {
    Attributes getAdditionalAttributes();

    Throwable getException();

    /* renamed from: io.opentelemetry.sdk.trace.internal.data.ExceptionEventData$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ExceptionEventData create(SpanLimits spanLimits, long j, Throwable th, Attributes attributes) {
            return ImmutableExceptionEventData.create(spanLimits, j, th, attributes);
        }
    }
}
