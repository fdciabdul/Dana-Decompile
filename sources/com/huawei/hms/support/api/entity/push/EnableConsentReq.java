package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class EnableConsentReq implements IMessageEntity {
    @Packed
    public boolean enable;
    @Packed
    public String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConsentReq{");
        sb.append("packageName:");
        sb.append(this.packageName);
        sb.append(", enable:");
        sb.append(this.enable);
        sb.append('}');
        return sb.toString();
    }
}
