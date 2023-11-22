package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {
    private final boolean isRooted;
    private final String osCodeName;
    private final String osRelease;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.osRelease = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.osCodeName = str2;
        this.isRooted = z;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String osRelease() {
        return this.osRelease;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String osCodeName() {
        return this.osCodeName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final boolean isRooted() {
        return this.isRooted;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OsData{osRelease=");
        sb.append(this.osRelease);
        sb.append(", osCodeName=");
        sb.append(this.osCodeName);
        sb.append(", isRooted=");
        sb.append(this.isRooted);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.OsData) {
            StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
            return this.osRelease.equals(osData.osRelease()) && this.osCodeName.equals(osData.osCodeName()) && this.isRooted == osData.isRooted();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.osRelease.hashCode();
        return ((((hashCode ^ 1000003) * 1000003) ^ this.osCodeName.hashCode()) * 1000003) ^ (this.isRooted ? 1231 : 1237);
    }
}
