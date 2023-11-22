package com.ipification.mobile.sdk.android.model;

import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.im.data.IMInfo;
import id.dana.data.socialshare.ShareAppKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/model/IMSession;", "", "", "Lcom/ipification/mobile/sdk/im/data/IMInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMSession {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    public IMSession() {
        this(null, null, null, null, null, 31, null);
    }

    private IMSession(String str, String str2, String str3, String str4, String str5) {
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = str3;
        this.getAuthRequestContext = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
    }

    public /* synthetic */ IMSession(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final List<IMInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        if (this.PlaceComponentResult != null) {
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            String str = IPConfiguration.Companion.MyBillsEntityDataFactory().H;
            String str2 = this.PlaceComponentResult;
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(new IMInfo(ShareAppKey.WHATSAPP, str, null, str2));
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
            String str3 = IPConfiguration.Companion.MyBillsEntityDataFactory().id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
            String str4 = IPConfiguration.Companion.MyBillsEntityDataFactory().E;
            String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str5 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(new IMInfo(ShareAppKey.TELEGRAM, str3, str4, str5));
        }
        if (this.MyBillsEntityDataFactory != null) {
            IPConfiguration.Companion companion3 = IPConfiguration.INSTANCE;
            String str6 = IPConfiguration.Companion.MyBillsEntityDataFactory().com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String;
            String str7 = this.MyBillsEntityDataFactory;
            if (str7 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(new IMInfo("viber", str6, null, str7));
        }
        return arrayList;
    }
}
