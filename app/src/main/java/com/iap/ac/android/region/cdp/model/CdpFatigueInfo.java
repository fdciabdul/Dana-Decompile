package com.iap.ac.android.region.cdp.model;

import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseField;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseTable;

@IAPDatabaseTable
/* loaded from: classes3.dex */
public class CdpFatigueInfo {
    public static final String ACTION_CLICK = "CLICK";
    public static final String ACTION_CLOSE = "CLOSE";
    public static final String ACTION_EXPOSURE = "EXPOSURE";
    public static final String PERIOD_DAY = "DAY";
    public static final String PERIOD_HOUR = "HOUR";
    public static final String PERIOD_MONTH = "MONTH";
    public static final String PERIOD_WEEK = "WEEK";
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String action;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String deliverId;
    @IAPDatabaseField(canBeNull = false, generatedId = true)

    /* renamed from: id  reason: collision with root package name */
    public long f7608id;
    @IAPDatabaseField
    public int limitTimes;
    @IAPDatabaseField(uniqueCombo = true)
    public String locale;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String period;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String spaceCode;
    @IAPDatabaseField(uniqueCombo = true)
    public String userId;

    public String toString() {
        StringBuilder a2 = a.a(a.a(a.a("CdpFatigueInfo{, period='"), this.period, '\'', ", action='"), this.action, '\'', ", limitTimes=");
        a2.append(this.limitTimes);
        a2.append(", deliverId='");
        StringBuilder a3 = a.a(a2, this.deliverId, '\'', ", spaceCode='");
        a3.append(this.spaceCode);
        a3.append('\'');
        a3.append('}');
        return a3.toString();
    }
}
