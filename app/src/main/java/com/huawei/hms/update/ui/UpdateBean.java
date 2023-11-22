package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7507a;
    public String b;
    public ArrayList c;
    public boolean d = true;

    public static <T> T a(T t) {
        return t;
    }

    public String getClientAppName() {
        return (String) a(this.b);
    }

    public boolean getResolutionInstallHMS() {
        return this.f7507a;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.c);
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.d))).booleanValue();
    }

    public void setClientAppId(String str) {
    }

    public void setClientAppName(String str) {
        this.b = str;
    }

    public void setClientPackageName(String str) {
    }

    public void setClientVersionCode(int i) {
    }

    public void setHmsOrApkUpgrade(boolean z) {
    }

    public void setNeedConfirm(boolean z) {
        this.d = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.f7507a = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.c = arrayList;
    }
}
