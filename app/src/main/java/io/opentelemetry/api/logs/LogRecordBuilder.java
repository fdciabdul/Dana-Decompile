package io.opentelemetry.api.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import j$.time.Instant;
import j$.util.function.BiConsumer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public interface LogRecordBuilder {
    void emit();

    LogRecordBuilder setAllAttributes(Attributes attributes);

    <T> LogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t);

    LogRecordBuilder setBody(String str);

    LogRecordBuilder setContext(Context context);

    LogRecordBuilder setEpoch(long j, TimeUnit timeUnit);

    LogRecordBuilder setEpoch(Instant instant);

    LogRecordBuilder setSeverity(Severity severity);

    LogRecordBuilder setSeverityText(String str);

    /* renamed from: io.opentelemetry.api.logs.LogRecordBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static LogRecordBuilder $default$setAllAttributes(final LogRecordBuilder logRecordBuilder, Attributes attributes) {
            if (attributes != null && !attributes.isEmpty()) {
                attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.logs.LogRecordBuilder$$ExternalSyntheticLambda0
                    @Override // j$.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        LogRecordBuilder.this.setAttribute((AttributeKey) obj, obj2);
                    }

                    @Override // j$.util.function.BiConsumer
                    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                    }
                });
            }
            return logRecordBuilder;
        }
    }
}
