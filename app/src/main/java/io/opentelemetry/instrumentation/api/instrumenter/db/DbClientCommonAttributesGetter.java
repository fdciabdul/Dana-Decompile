package io.opentelemetry.instrumentation.api.instrumenter.db;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface DbClientCommonAttributesGetter<REQUEST> {
    @Nullable
    String connectionString(REQUEST request);

    @Nullable
    String name(REQUEST request);

    @Nullable
    String system(REQUEST request);

    @Nullable
    String user(REQUEST request);
}
