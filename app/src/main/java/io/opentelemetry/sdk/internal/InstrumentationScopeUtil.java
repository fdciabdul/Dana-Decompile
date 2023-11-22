package io.opentelemetry.sdk.internal;

import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfoBuilder;

/* loaded from: classes9.dex */
public final class InstrumentationScopeUtil {
    public static InstrumentationLibraryInfo toInstrumentationLibraryInfo(InstrumentationScopeInfo instrumentationScopeInfo) {
        return InstrumentationLibraryInfo.create(instrumentationScopeInfo.getName(), instrumentationScopeInfo.getVersion(), instrumentationScopeInfo.getSchemaUrl());
    }

    public static InstrumentationScopeInfo toInstrumentationScopeInfo(InstrumentationLibraryInfo instrumentationLibraryInfo) {
        InstrumentationScopeInfoBuilder builder = InstrumentationScopeInfo.builder(instrumentationLibraryInfo.getName());
        if (instrumentationLibraryInfo.getVersion() != null) {
            builder.setVersion(instrumentationLibraryInfo.getVersion());
        }
        if (instrumentationLibraryInfo.getSchemaUrl() != null) {
            builder.setSchemaUrl(instrumentationLibraryInfo.getSchemaUrl());
        }
        return builder.build();
    }

    private InstrumentationScopeUtil() {
    }
}
