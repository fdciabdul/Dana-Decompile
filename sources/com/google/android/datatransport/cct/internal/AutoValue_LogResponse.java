package com.google.android.datatransport.cct.internal;

/* loaded from: classes7.dex */
final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public final long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogResponse{nextRequestWaitMillis=");
        sb.append(this.nextRequestWaitMillis);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis();
    }

    public final int hashCode() {
        long j = this.nextRequestWaitMillis;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }
}
