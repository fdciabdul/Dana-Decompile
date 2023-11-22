package io.opentelemetry.api.baggage;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableEntry extends ImmutableEntry {
    private final BaggageEntryMetadata metadata;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEntry(String str, BaggageEntryMetadata baggageEntryMetadata) {
        if (str == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str;
        if (baggageEntryMetadata == null) {
            throw new NullPointerException("Null metadata");
        }
        this.metadata = baggageEntryMetadata;
    }

    @Override // io.opentelemetry.api.baggage.BaggageEntry
    public final String getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.api.baggage.BaggageEntry
    public final BaggageEntryMetadata getMetadata() {
        return this.metadata;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableEntry{value=");
        sb.append(this.value);
        sb.append(", metadata=");
        sb.append(this.metadata);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntry) {
            ImmutableEntry immutableEntry = (ImmutableEntry) obj;
            return this.value.equals(immutableEntry.getValue()) && this.metadata.equals(immutableEntry.getMetadata());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.value.hashCode() ^ 1000003) * 1000003) ^ this.metadata.hashCode();
    }
}
