package io.opentelemetry.api.logs;

/* loaded from: classes6.dex */
public interface Logger {
    EventBuilder eventBuilder(String str);

    LogRecordBuilder logRecordBuilder();
}
