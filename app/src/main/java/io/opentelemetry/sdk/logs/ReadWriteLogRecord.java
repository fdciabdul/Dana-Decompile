package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.logs.data.LogRecordData;

/* loaded from: classes9.dex */
public interface ReadWriteLogRecord {
    <T> ReadWriteLogRecord setAttribute(AttributeKey<T> attributeKey, T t);

    LogRecordData toLogRecordData();
}
