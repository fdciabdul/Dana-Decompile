package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* loaded from: classes7.dex */
final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    private final List<LogRequest> logRequests;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.logRequests = list;
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    @Encodable.Field(name = "logRequest")
    public final List<LogRequest> getLogRequests() {
        return this.logRequests;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BatchedLogRequest{logRequests=");
        sb.append(this.logRequests);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.logRequests.equals(((BatchedLogRequest) obj).getLogRequests());
        }
        return false;
    }

    public final int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }
}
