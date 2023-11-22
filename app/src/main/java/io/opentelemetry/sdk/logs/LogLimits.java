package io.opentelemetry.sdk.logs;

/* loaded from: classes6.dex */
public abstract class LogLimits {
    private static final LogLimits DEFAULT = new LogLimitsBuilder().build();

    public abstract int getMaxAttributeValueLength();

    public abstract int getMaxNumberOfAttributes();

    public static LogLimits getDefault() {
        return DEFAULT;
    }

    public static LogLimitsBuilder builder() {
        return new LogLimitsBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogLimits create(int i, int i2) {
        return new AutoValue_LogLimits(i, i2);
    }

    public LogLimitsBuilder toBuilder() {
        return new LogLimitsBuilder().setMaxNumberOfAttributes(getMaxNumberOfAttributes()).setMaxAttributeValueLength(getMaxAttributeValueLength());
    }
}
