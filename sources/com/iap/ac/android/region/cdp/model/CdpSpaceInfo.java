package com.iap.ac.android.region.cdp.model;

import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseField;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseTable;
import java.util.List;

@IAPDatabaseTable
/* loaded from: classes3.dex */
public class CdpSpaceInfo {
    public static final String SPACE_TYPE_ANNOUNCEMENT = "ANNOUNCEMENT";
    public static final String SPACE_TYPE_BADGE = "BADGE";
    public static final String SPACE_TYPE_BANNER = "BANNER";
    public static final String SPACE_TYPE_CAROUSEL = "CAROUSEL";
    public static final String SPACE_TYPE_CORNERMARK = "CORNERMARK";
    public static final String SPACE_TYPE_LAUNCHER = "LAUNCHER";
    public static final String SPACE_TYPE_POPUP = "POPUP";
    public static final String UPDATE_POLICY_ALWAYS = "ALWAYS";
    public static final String UPDATE_POLICY_DAY = "DAY";
    public static final String UPDATE_POLICY_HOUR = "HOUR";
    public static final String UPDATE_POLICY_INTERVAL = "INTERVAL";
    public static final String UPDATE_POLICY_WEEK = "WEEK";
    @IAPDatabaseField
    public int carouselTime;
    public List<CdpContentInfo> contentInfos;
    @IAPDatabaseField
    public String extInfo;
    @IAPDatabaseField
    public int height;
    @IAPDatabaseField(canBeNull = false, generatedId = true)

    /* renamed from: id  reason: collision with root package name */
    public int f7609id;
    @IAPDatabaseField(uniqueCombo = true)
    public String locale;
    @IAPDatabaseField(canBeNull = false, uniqueCombo = true)
    public String spaceCode;
    @IAPDatabaseField
    public String type;
    @IAPDatabaseField
    public String updatePolicy;
    @IAPDatabaseField(uniqueCombo = true)
    public String userId;
    @IAPDatabaseField
    public int width;

    public String toString() {
        StringBuilder a2 = a.a(a.a(a.a(a.a("CdpSpaceInfo{, spaceCode='"), this.spaceCode, '\'', ", type='"), this.type, '\'', ", updatePolicy='"), this.updatePolicy, '\'', ", carouselTime=");
        a2.append(this.carouselTime);
        a2.append(", height=");
        a2.append(this.height);
        a2.append(", width=");
        a2.append(this.width);
        a2.append(", cdpContentInfos=");
        a2.append(this.contentInfos);
        a2.append(", extInfo='");
        a2.append(this.extInfo);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
