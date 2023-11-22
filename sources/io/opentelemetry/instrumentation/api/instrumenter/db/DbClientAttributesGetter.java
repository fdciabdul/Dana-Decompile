package io.opentelemetry.instrumentation.api.instrumenter.db;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface DbClientAttributesGetter<REQUEST> extends DbClientCommonAttributesGetter<REQUEST> {
    @Nullable
    String operation(REQUEST request);

    @Nullable
    String statement(REQUEST request);
}
