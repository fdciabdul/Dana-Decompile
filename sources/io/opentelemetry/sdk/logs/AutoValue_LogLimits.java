package io.opentelemetry.sdk.logs;

/* loaded from: classes6.dex */
final class AutoValue_LogLimits extends LogLimits {
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogLimits(int i, int i2) {
        this.maxNumberOfAttributes = i;
        this.maxAttributeValueLength = i2;
    }

    @Override // io.opentelemetry.sdk.logs.LogLimits
    public final int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    @Override // io.opentelemetry.sdk.logs.LogLimits
    public final int getMaxAttributeValueLength() {
        return this.maxAttributeValueLength;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogLimits{maxNumberOfAttributes=");
        sb.append(this.maxNumberOfAttributes);
        sb.append(", maxAttributeValueLength=");
        sb.append(this.maxAttributeValueLength);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogLimits) {
            LogLimits logLimits = (LogLimits) obj;
            return this.maxNumberOfAttributes == logLimits.getMaxNumberOfAttributes() && this.maxAttributeValueLength == logLimits.getMaxAttributeValueLength();
        }
        return false;
    }

    public final int hashCode() {
        return ((this.maxNumberOfAttributes ^ 1000003) * 1000003) ^ this.maxAttributeValueLength;
    }
}
