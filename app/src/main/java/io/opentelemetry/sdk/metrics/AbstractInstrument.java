package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
abstract class AbstractInstrument {
    private final InstrumentDescriptor descriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInstrument(InstrumentDescriptor instrumentDescriptor) {
        this.descriptor = instrumentDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InstrumentDescriptor getDescriptor() {
        return this.descriptor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractInstrument) {
            return this.descriptor.equals(((AbstractInstrument) obj).descriptor);
        }
        return false;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }
}
