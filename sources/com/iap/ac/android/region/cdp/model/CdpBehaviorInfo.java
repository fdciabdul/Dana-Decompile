package com.iap.ac.android.region.cdp.model;

import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseField;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseTable;

@IAPDatabaseTable
/* loaded from: classes3.dex */
public class CdpBehaviorInfo {
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String action;
    @IAPDatabaseField
    public int count;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String deliverId;
    @IAPDatabaseField(canBeNull = false, generatedId = true)

    /* renamed from: id  reason: collision with root package name */
    public long f7606id;
    @IAPDatabaseField
    public int lastUploadCount;
    @IAPDatabaseField(uniqueCombo = true)
    public String locale;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String period;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public long periodStartTime;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String spaceCode;
    @IAPDatabaseField(uniqueCombo = true)
    public String userId;

    public String toString() {
        StringBuilder a2 = a.a(a.a(a.a(a.a(a.a("CdpBehaviorInfo{, spaceCode='"), this.spaceCode, '\'', ", deliverId='"), this.deliverId, '\'', ", action='"), this.action, '\'', ", period='"), this.period, '\'', ", periodStartTime=");
        a2.append(this.periodStartTime);
        a2.append(", count=");
        a2.append(this.count);
        a2.append(", lastUploadCount=");
        a2.append(this.lastUploadCount);
        a2.append('}');
        return a2.toString();
    }
}
