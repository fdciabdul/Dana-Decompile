package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {
    private final int arch;
    private final int availableProcessors;
    private final long diskSpace;
    private final boolean isEmulator;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final int state;
    private final long totalRam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_DeviceData(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.arch = i;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.model = str;
        this.availableProcessors = i2;
        this.totalRam = j;
        this.diskSpace = j2;
        this.isEmulator = z;
        this.state = i3;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.manufacturer = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.modelClass = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int arch() {
        return this.arch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String model() {
        return this.model;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int availableProcessors() {
        return this.availableProcessors;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long totalRam() {
        return this.totalRam;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long diskSpace() {
        return this.diskSpace;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final boolean isEmulator() {
        return this.isEmulator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int state() {
        return this.state;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String manufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String modelClass() {
        return this.modelClass;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceData{arch=");
        sb.append(this.arch);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", availableProcessors=");
        sb.append(this.availableProcessors);
        sb.append(", totalRam=");
        sb.append(this.totalRam);
        sb.append(", diskSpace=");
        sb.append(this.diskSpace);
        sb.append(", isEmulator=");
        sb.append(this.isEmulator);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", modelClass=");
        sb.append(this.modelClass);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.DeviceData) {
            StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
            return this.arch == deviceData.arch() && this.model.equals(deviceData.model()) && this.availableProcessors == deviceData.availableProcessors() && this.totalRam == deviceData.totalRam() && this.diskSpace == deviceData.diskSpace() && this.isEmulator == deviceData.isEmulator() && this.state == deviceData.state() && this.manufacturer.equals(deviceData.manufacturer()) && this.modelClass.equals(deviceData.modelClass());
        }
        return false;
    }

    public final int hashCode() {
        int i = this.arch;
        int hashCode = this.model.hashCode();
        int i2 = this.availableProcessors;
        long j = this.totalRam;
        int i3 = (int) (j ^ (j >>> 32));
        long j2 = this.diskSpace;
        int i4 = (int) (j2 ^ (j2 >>> 32));
        return ((((((((((((((((i ^ 1000003) * 1000003) ^ hashCode) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ (this.isEmulator ? 1231 : 1237)) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }
}
