package io.opentelemetry.api.baggage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class ImmutableEntry implements BaggageEntry {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableEntry create(String str, BaggageEntryMetadata baggageEntryMetadata) {
        return new AutoValue_ImmutableEntry(str, baggageEntryMetadata);
    }
}
