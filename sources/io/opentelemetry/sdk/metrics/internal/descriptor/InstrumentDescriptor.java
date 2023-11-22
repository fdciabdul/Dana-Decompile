package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* loaded from: classes6.dex */
public abstract class InstrumentDescriptor {
    private final SourceInfo sourceInfo = SourceInfo.CC.fromCurrentStack();

    public abstract String getDescription();

    public abstract String getName();

    public abstract InstrumentType getType();

    public abstract String getUnit();

    public abstract InstrumentValueType getValueType();

    public abstract int hashCode();

    public static InstrumentDescriptor create(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        return new AutoValue_InstrumentDescriptor(str, str2, str3, instrumentType, instrumentValueType);
    }

    public final SourceInfo getSourceInfo() {
        return this.sourceInfo;
    }
}
