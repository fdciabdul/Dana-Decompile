package io.opentelemetry.api.baggage;

/* loaded from: classes9.dex */
public interface BaggageEntryMetadata {
    String getValue();

    /* renamed from: io.opentelemetry.api.baggage.BaggageEntryMetadata$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static BaggageEntryMetadata empty() {
            return ImmutableEntryMetadata.EMPTY;
        }

        public static BaggageEntryMetadata create(String str) {
            return ImmutableEntryMetadata.create(str);
        }
    }
}
