package io.opentelemetry.api.trace;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ArrayBasedTraceState extends ArrayBasedTraceState {
    private final List<String> entries;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ArrayBasedTraceState(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Null entries");
        }
        this.entries = list;
    }

    @Override // io.opentelemetry.api.trace.ArrayBasedTraceState
    final List<String> getEntries() {
        return this.entries;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayBasedTraceState{entries=");
        sb.append(this.entries);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ArrayBasedTraceState) {
            return this.entries.equals(((ArrayBasedTraceState) obj).getEntries());
        }
        return false;
    }

    public final int hashCode() {
        return this.entries.hashCode() ^ 1000003;
    }
}
