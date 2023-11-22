package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class AutoValue_StaticSessionData extends StaticSessionData {
    private final StaticSessionData.AppData appData;
    private final StaticSessionData.DeviceData deviceData;
    private final StaticSessionData.OsData osData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        if (appData == null) {
            throw new NullPointerException("Null appData");
        }
        this.appData = appData;
        if (osData == null) {
            throw new NullPointerException("Null osData");
        }
        this.osData = osData;
        if (deviceData == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.deviceData = deviceData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.AppData appData() {
        return this.appData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.OsData osData() {
        return this.osData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.DeviceData deviceData() {
        return this.deviceData;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StaticSessionData{appData=");
        sb.append(this.appData);
        sb.append(", osData=");
        sb.append(this.osData);
        sb.append(", deviceData=");
        sb.append(this.deviceData);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData) {
            StaticSessionData staticSessionData = (StaticSessionData) obj;
            return this.appData.equals(staticSessionData.appData()) && this.osData.equals(staticSessionData.osData()) && this.deviceData.equals(staticSessionData.deviceData());
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.appData.hashCode() ^ 1000003) * 1000003) ^ this.osData.hashCode()) * 1000003) ^ this.deviceData.hashCode();
    }
}
