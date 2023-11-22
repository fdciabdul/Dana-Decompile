package io.opentelemetry.api.logs;

/* loaded from: classes6.dex */
public interface LoggerBuilder {
    Logger build();

    LoggerBuilder setEventDomain(String str);

    LoggerBuilder setInstrumentationVersion(String str);

    LoggerBuilder setSchemaUrl(String str);
}
