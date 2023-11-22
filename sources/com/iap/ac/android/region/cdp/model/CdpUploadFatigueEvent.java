package com.iap.ac.android.region.cdp.model;

import com.iap.ac.android.acs.minioperation.a.a;

/* loaded from: classes3.dex */
public class CdpUploadFatigueEvent {
    public String action;
    public int count;
    public String deliverId;
    public String period;
    public long periodStartTime;
    public String recordId;

    public String toString() {
        StringBuilder a2 = a.a(a.a(a.a(a.a(a.a("CdpUploadFatigueEvent{recordId='"), this.recordId, '\'', "deliverId='"), this.deliverId, '\'', ", action='"), this.action, '\'', ", period='"), this.period, '\'', ", periodStartTime='");
        a2.append(this.periodStartTime);
        a2.append('\'');
        a2.append(", count=");
        a2.append(this.count);
        a2.append('}');
        return a2.toString();
    }
}
