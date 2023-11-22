package io.opentelemetry.api.baggage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableEntryMetadata extends ImmutableEntryMetadata {
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEntryMetadata(String str) {
        if (str == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str;
    }

    @Override // io.opentelemetry.api.baggage.ImmutableEntryMetadata, io.opentelemetry.api.baggage.BaggageEntryMetadata
    public final String getValue() {
        return this.value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableEntryMetadata{value=");
        sb.append(this.value);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntryMetadata) {
            return this.value.equals(((ImmutableEntryMetadata) obj).getValue());
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
