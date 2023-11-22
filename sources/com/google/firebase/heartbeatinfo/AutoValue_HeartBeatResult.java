package com.google.firebase.heartbeatinfo;

import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_HeartBeatResult extends HeartBeatResult {
    private final List<String> usedDates;
    private final String userAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_HeartBeatResult(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.userAgent = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.usedDates = list;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final String getUserAgent() {
        return this.userAgent;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final List<String> getUsedDates() {
        return this.usedDates;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HeartBeatResult{userAgent=");
        sb.append(this.userAgent);
        sb.append(", usedDates=");
        sb.append(this.usedDates);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeartBeatResult) {
            HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
            return this.userAgent.equals(heartBeatResult.getUserAgent()) && this.usedDates.equals(heartBeatResult.getUsedDates());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }
}
