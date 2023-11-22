package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {
    private final String appIdentifier;
    private final int deliveryMechanism;
    private final DevelopmentPlatformProvider developmentPlatformProvider;
    private final String installUuid;
    private final String versionCode;
    private final String versionName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.appIdentifier = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.versionCode = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.versionName = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.installUuid = str4;
        this.deliveryMechanism = i;
        if (developmentPlatformProvider == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.developmentPlatformProvider = developmentPlatformProvider;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String appIdentifier() {
        return this.appIdentifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String versionCode() {
        return this.versionCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String versionName() {
        return this.versionName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String installUuid() {
        return this.installUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final int deliveryMechanism() {
        return this.deliveryMechanism;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final DevelopmentPlatformProvider developmentPlatformProvider() {
        return this.developmentPlatformProvider;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppData{appIdentifier=");
        sb.append(this.appIdentifier);
        sb.append(", versionCode=");
        sb.append(this.versionCode);
        sb.append(", versionName=");
        sb.append(this.versionName);
        sb.append(", installUuid=");
        sb.append(this.installUuid);
        sb.append(", deliveryMechanism=");
        sb.append(this.deliveryMechanism);
        sb.append(", developmentPlatformProvider=");
        sb.append(this.developmentPlatformProvider);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.AppData) {
            StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
            return this.appIdentifier.equals(appData.appIdentifier()) && this.versionCode.equals(appData.versionCode()) && this.versionName.equals(appData.versionName()) && this.installUuid.equals(appData.installUuid()) && this.deliveryMechanism == appData.deliveryMechanism() && this.developmentPlatformProvider.equals(appData.developmentPlatformProvider());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.appIdentifier.hashCode();
        int hashCode2 = this.versionCode.hashCode();
        int hashCode3 = this.versionName.hashCode();
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ this.installUuid.hashCode()) * 1000003) ^ this.deliveryMechanism) * 1000003) ^ this.developmentPlatformProvider.hashCode();
    }
}
