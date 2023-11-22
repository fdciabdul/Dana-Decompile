package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;

/* loaded from: classes6.dex */
final class AutoValue_InstrumentDescriptor extends C$AutoValue_InstrumentDescriptor {
    private volatile transient int hashCode;
    private volatile transient boolean hashCode$Memoized;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentDescriptor(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        super(str, str2, str3, instrumentType, instrumentValueType);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_InstrumentDescriptor, io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public final int hashCode() {
        if (!this.hashCode$Memoized) {
            synchronized (this) {
                if (!this.hashCode$Memoized) {
                    this.hashCode = super.hashCode();
                    this.hashCode$Memoized = true;
                }
            }
        }
        return this.hashCode;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_InstrumentDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoValue_InstrumentDescriptor) && hashCode() == obj.hashCode() && super.equals(obj);
    }
}
