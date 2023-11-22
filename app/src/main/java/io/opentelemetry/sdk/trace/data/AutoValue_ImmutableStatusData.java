package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.trace.StatusCode;

/* loaded from: classes6.dex */
final class AutoValue_ImmutableStatusData extends ImmutableStatusData {
    private final String description;
    private final StatusCode statusCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableStatusData(StatusCode statusCode, String str) {
        if (statusCode == null) {
            throw new NullPointerException("Null statusCode");
        }
        this.statusCode = statusCode;
        if (str == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str;
    }

    @Override // io.opentelemetry.sdk.trace.data.StatusData
    public final StatusCode getStatusCode() {
        return this.statusCode;
    }

    @Override // io.opentelemetry.sdk.trace.data.StatusData
    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableStatusData{statusCode=");
        sb.append(this.statusCode);
        sb.append(", description=");
        sb.append(this.description);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableStatusData) {
            ImmutableStatusData immutableStatusData = (ImmutableStatusData) obj;
            return this.statusCode.equals(immutableStatusData.getStatusCode()) && this.description.equals(immutableStatusData.getDescription());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.statusCode.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode();
    }
}
