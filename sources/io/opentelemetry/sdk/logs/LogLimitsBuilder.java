package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.internal.Utils;

/* loaded from: classes6.dex */
public final class LogLimitsBuilder {
    private static final int DEFAULT_LOG_MAX_ATTRIBUTE_LENGTH = Integer.MAX_VALUE;
    private static final int DEFAULT_LOG_MAX_NUM_ATTRIBUTES = 128;
    private int maxNumAttributes = 128;
    private int maxAttributeValueLength = Integer.MAX_VALUE;

    public final LogLimitsBuilder setMaxNumberOfAttributes(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfAttributes must be greater than 0");
        this.maxNumAttributes = i;
        return this;
    }

    public final LogLimitsBuilder setMaxAttributeValueLength(int i) {
        Utils.checkArgument(i >= 0, "maxAttributeValueLength must be non-negative");
        this.maxAttributeValueLength = i;
        return this;
    }

    public final LogLimits build() {
        return LogLimits.create(this.maxNumAttributes, this.maxAttributeValueLength);
    }
}
