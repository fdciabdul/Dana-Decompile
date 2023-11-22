package com.uc.crashsdk.export;

/* loaded from: classes8.dex */
public class VersionInfo {
    public String mBuildSeq;
    public String mSubVersion;
    public String mVersion;

    public VersionInfo() {
        this.mVersion = "1.0.0.0";
        this.mSubVersion = "beta";
        this.mBuildSeq = "150101000000";
    }

    public VersionInfo(VersionInfo versionInfo) {
        this.mVersion = "1.0.0.0";
        this.mSubVersion = "beta";
        this.mBuildSeq = "150101000000";
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildSeq = versionInfo.mBuildSeq;
    }
}
