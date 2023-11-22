package com.alipay.mobile.map.model;

import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class LBSWifiInfo {

    /* renamed from: a  reason: collision with root package name */
    private LBSWifiItemInfo f7195a;
    private List<LBSWifiItemInfo> b;

    public LBSWifiInfo(LBSWifiItemInfo lBSWifiItemInfo, List<LBSWifiItemInfo> list) {
        this.f7195a = lBSWifiItemInfo;
        this.b = list;
    }

    public LBSWifiItemInfo getConnectionWifi() {
        return this.f7195a;
    }

    public List<LBSWifiItemInfo> getScanWifiList() {
        List<LBSWifiItemInfo> list = this.b;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }
}
