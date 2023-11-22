package io.opentelemetry.sdk.logs.data;

/* loaded from: classes9.dex */
final class AutoValue_StringBody extends StringBody {
    private final String asString;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StringBody(String str) {
        if (str == null) {
            throw new NullPointerException("Null asString");
        }
        this.asString = str;
    }

    @Override // io.opentelemetry.sdk.logs.data.StringBody, io.opentelemetry.sdk.logs.data.Body
    public final String asString() {
        return this.asString;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringBody{asString=");
        sb.append(this.asString);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StringBody) {
            return this.asString.equals(((StringBody) obj).asString());
        }
        return false;
    }

    public final int hashCode() {
        return this.asString.hashCode() ^ 1000003;
    }
}
