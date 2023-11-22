package io.opentelemetry.api.baggage;

/* loaded from: classes9.dex */
public interface BaggageBuilder {
    Baggage build();

    BaggageBuilder put(String str, String str2);

    BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata);

    BaggageBuilder remove(String str);

    /* renamed from: io.opentelemetry.api.baggage.BaggageBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
