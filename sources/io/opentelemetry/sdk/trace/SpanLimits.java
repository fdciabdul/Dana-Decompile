package io.opentelemetry.sdk.trace;

/* loaded from: classes.dex */
public abstract class SpanLimits {
    private static final SpanLimits DEFAULT = new SpanLimitsBuilder().build();
    static final int DEFAULT_SPAN_MAX_ATTRIBUTE_LENGTH = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class SpanLimitsValue extends SpanLimits {
        @Override // io.opentelemetry.sdk.trace.SpanLimits
        public abstract int getMaxAttributeValueLength();
    }

    public int getMaxAttributeValueLength() {
        return Integer.MAX_VALUE;
    }

    public abstract int getMaxNumberOfAttributes();

    public abstract int getMaxNumberOfAttributesPerEvent();

    public abstract int getMaxNumberOfAttributesPerLink();

    public abstract int getMaxNumberOfEvents();

    public abstract int getMaxNumberOfLinks();

    public static SpanLimits getDefault() {
        return DEFAULT;
    }

    public static SpanLimitsBuilder builder() {
        return new SpanLimitsBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanLimits create(int i, int i2, int i3, int i4, int i5, int i6) {
        return new AutoValue_SpanLimits_SpanLimitsValue(i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    protected SpanLimits() {
    }

    public SpanLimitsBuilder toBuilder() {
        return new SpanLimitsBuilder().setMaxNumberOfAttributes(getMaxNumberOfAttributes()).setMaxNumberOfEvents(getMaxNumberOfEvents()).setMaxNumberOfLinks(getMaxNumberOfLinks()).setMaxNumberOfAttributesPerEvent(getMaxNumberOfAttributesPerEvent()).setMaxNumberOfAttributesPerLink(getMaxNumberOfAttributesPerLink()).setMaxAttributeValueLength(getMaxAttributeValueLength());
    }
}
