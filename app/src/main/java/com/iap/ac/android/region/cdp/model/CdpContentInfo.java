package com.iap.ac.android.region.cdp.model;

import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseField;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseTable;
import java.util.List;

@IAPDatabaseTable
/* loaded from: classes3.dex */
public class CdpContentInfo {
    public static final String CONTENT_TYPE_HTML = "HTML";
    public static final String CONTENT_TYPE_IMAGE = "IMAGE";
    public static final String CONTENT_TYPE_NATIVE_DYNAMIC = "NATIVE-DYNAMIC";
    public static final String CONTENT_TYPE_TEXT = "TEXT";
    public static final String CONTENT_TYPE_URL = "URL";
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String contentCode;
    @IAPDatabaseField
    public String contentData;
    @IAPDatabaseField
    public String contentType;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String deliverId;
    @IAPDatabaseField
    public String extInfo;
    public List<CdpFatigueInfo> fatigueInfos;
    @IAPDatabaseField(canBeNull = false, generatedId = true)

    /* renamed from: id  reason: collision with root package name */
    public int f7607id;
    @IAPDatabaseField(uniqueCombo = true)
    public String locale;
    @IAPDatabaseField(canBeNull = false)
    public String spaceCode;
    @IAPDatabaseField
    public String trackingCode;
    @IAPDatabaseField(uniqueCombo = true)
    public String userId;

    public String toString() {
        StringBuilder a2 = a.a(a.a(a.a(a.a(a.a(a.a(a.a(a.a("CdpContentInfo{, deliverId='"), this.deliverId, '\'', ", contentCode='"), this.contentCode, '\'', ", spaceCode='"), this.spaceCode, '\'', ", contentType='"), this.contentType, '\'', ", contentData='"), this.contentData, '\'', ", trackingCode='"), this.trackingCode, '\'', ", extInfo='"), this.extInfo, '\'', ", fatigueInfos=");
        a2.append(this.fatigueInfos);
        a2.append('}');
        return a2.toString();
    }
}
