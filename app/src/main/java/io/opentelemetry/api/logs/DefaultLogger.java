package io.opentelemetry.api.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.context.Context;
import j$.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* loaded from: classes6.dex */
class DefaultLogger implements Logger {
    private final boolean hasDomain;
    private static final Logger INSTANCE_WITH_DOMAIN = new DefaultLogger(true);
    private static final Logger INSTANCE_NO_DOMAIN = new DefaultLogger(false);
    private static final EventBuilder NOOP_LOG_RECORD_BUILDER = new NoopLogRecordBuilder();

    private DefaultLogger(boolean z) {
        this.hasDomain = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Logger getInstance(boolean z) {
        return z ? INSTANCE_WITH_DOMAIN : INSTANCE_NO_DOMAIN;
    }

    @Override // io.opentelemetry.api.logs.Logger
    public EventBuilder eventBuilder(String str) {
        if (!this.hasDomain) {
            ValidationUtil.log("Cannot emit event from Logger without event domain. Please use LoggerBuilder#setEventDomain(String) when obtaining Logger.", Level.WARNING);
        }
        return NOOP_LOG_RECORD_BUILDER;
    }

    @Override // io.opentelemetry.api.logs.Logger
    public LogRecordBuilder logRecordBuilder() {
        return NOOP_LOG_RECORD_BUILDER;
    }

    /* loaded from: classes6.dex */
    static final class NoopLogRecordBuilder implements EventBuilder {
        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final void emit() {
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final /* synthetic */ LogRecordBuilder setAllAttributes(Attributes attributes) {
            return LogRecordBuilder.CC.$default$setAllAttributes(this, attributes);
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final <T> LogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setBody(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setContext(Context context) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setEpoch(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setEpoch(Instant instant) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setSeverity(Severity severity) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public final LogRecordBuilder setSeverityText(String str) {
            return this;
        }

        private NoopLogRecordBuilder() {
        }
    }
}
