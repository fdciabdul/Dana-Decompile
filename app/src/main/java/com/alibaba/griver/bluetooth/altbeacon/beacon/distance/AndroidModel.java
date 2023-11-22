package com.alibaba.griver.bluetooth.altbeacon.beacon.distance;

import android.os.Build;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;

/* loaded from: classes6.dex */
public class AndroidModel {
    private static final String TAG = "AndroidModel";
    String mBuildNumber;
    String mManufacturer;
    String mModel;
    String mVersion;

    public AndroidModel(String str, String str2, String str3, String str4) {
        this.mVersion = str;
        this.mBuildNumber = str2;
        this.mModel = str3;
        this.mManufacturer = str4;
    }

    public static AndroidModel forThisDevice() {
        return new AndroidModel(Build.VERSION.RELEASE, Build.ID, Build.MODEL, Build.MANUFACTURER);
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getBuildNumber() {
        return this.mBuildNumber;
    }

    public void setBuildNumber(String str) {
        this.mBuildNumber = str;
    }

    public String getModel() {
        return this.mModel;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public void setManufacturer(String str) {
        this.mManufacturer = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int matchScore(AndroidModel androidModel) {
        boolean equalsIgnoreCase = this.mManufacturer.equalsIgnoreCase(androidModel.mManufacturer);
        ?? r0 = equalsIgnoreCase;
        if (equalsIgnoreCase) {
            r0 = equalsIgnoreCase;
            if (this.mModel.equals(androidModel.mModel)) {
                r0 = 2;
            }
        }
        int i = r0;
        if (r0 == 2) {
            i = r0;
            if (this.mBuildNumber.equals(androidModel.mBuildNumber)) {
                i = 3;
            }
        }
        if (i == 3 && this.mVersion.equals(androidModel.mVersion)) {
            i = 4;
        }
        LogManager.d(TAG, "Score is %s for %s compared to %s", Integer.valueOf(i), toString(), androidModel);
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mManufacturer);
        sb.append(";");
        sb.append(this.mModel);
        sb.append(";");
        sb.append(this.mBuildNumber);
        sb.append(";");
        sb.append(this.mVersion);
        return sb.toString();
    }
}
