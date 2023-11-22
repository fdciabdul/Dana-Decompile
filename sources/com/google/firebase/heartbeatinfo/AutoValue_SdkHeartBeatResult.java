package com.google.firebase.heartbeatinfo;

/* loaded from: classes7.dex */
final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {
    private final long millis;
    private final String sdkName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SdkHeartBeatResult(String str, long j) {
        if (str == null) {
            throw new NullPointerException("Null sdkName");
        }
        this.sdkName = str;
        this.millis = j;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final String getSdkName() {
        return this.sdkName;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final long getMillis() {
        return this.millis;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SdkHeartBeatResult{sdkName=");
        sb.append(this.sdkName);
        sb.append(", millis=");
        sb.append(this.millis);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SdkHeartBeatResult) {
            SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
            return this.sdkName.equals(sdkHeartBeatResult.getSdkName()) && this.millis == sdkHeartBeatResult.getMillis();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.sdkName.hashCode();
        long j = this.millis;
        return ((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
