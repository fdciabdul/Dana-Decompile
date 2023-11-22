package io.opentelemetry.instrumentation.api.instrumenter.db;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface SqlClientAttributesGetter<REQUEST> extends DbClientCommonAttributesGetter<REQUEST> {
    @Nullable
    String rawStatement(REQUEST request);
}
