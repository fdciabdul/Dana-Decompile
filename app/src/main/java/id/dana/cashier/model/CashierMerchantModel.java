package id.dana.cashier.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010:\u001a\u00020\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010@\u001a\u00020\u0007¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0016\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010 \u001a\u0004\u0018\u00010\u001fX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010$\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0&8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010'R\u0014\u0010)\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010*\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0014\u0010+\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010,\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010\u0017R\u0014\u0010-\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR\u0014\u0010.\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010\u0017R\u0014\u0010/\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010\u0017"}, d2 = {"Lid/dana/cashier/model/CashierMerchantModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Ljava/lang/String;", "hashCode", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "PrepareContext", "Z", "()Z", "scheduleImpl", "Lid/dana/cashier/model/CashierKybOrderDetailModel;", "moveToNextValue", "Lid/dana/cashier/model/CashierKybOrderDetailModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "GetContactSyncConfig", "", "()Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isLayoutRequested", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/CashierKybOrderDetailModel;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierMerchantModel implements Parcelable {
    public static final Parcelable.Creator<CashierMerchantModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String newProxyInstance;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String scheduleImpl;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public String isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public String PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String initRecordTimeStamp;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String GetContactSyncConfig;
    public CashierKybOrderDetailModel moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    public CashierMerchantModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, 524287, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierMerchantModel) {
            CashierMerchantModel cashierMerchantModel = (CashierMerchantModel) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.GetContactSyncConfig, cashierMerchantModel.GetContactSyncConfig) && Intrinsics.areEqual(this.isLayoutRequested, cashierMerchantModel.isLayoutRequested) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, cashierMerchantModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.getErrorConfigVersion, cashierMerchantModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierMerchantModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierMerchantModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, cashierMerchantModel.PlaceComponentResult) && Intrinsics.areEqual(this.scheduleImpl, cashierMerchantModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.lookAheadTest, cashierMerchantModel.lookAheadTest) && Intrinsics.areEqual(this.moveToNextValue, cashierMerchantModel.moveToNextValue) && this.PrepareContext == cashierMerchantModel.PrepareContext && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.getAuthRequestContext, cashierMerchantModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.initRecordTimeStamp, cashierMerchantModel.initRecordTimeStamp) && Intrinsics.areEqual(this.newProxyInstance, cashierMerchantModel.newProxyInstance) && this.BuiltInFictitiousFunctionClassFactory == cashierMerchantModel.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.GetContactSyncConfig;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.isLayoutRequested;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.DatabaseTableConfigUtil;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.getErrorConfigVersion;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.MyBillsEntityDataFactory;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.PlaceComponentResult;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.scheduleImpl;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.lookAheadTest;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        CashierKybOrderDetailModel cashierKybOrderDetailModel = this.moveToNextValue;
        int hashCode12 = cashierKybOrderDetailModel == null ? 0 : cashierKybOrderDetailModel.hashCode();
        boolean z = this.PrepareContext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str12 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode13 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.getAuthRequestContext;
        int hashCode14 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode15 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.initRecordTimeStamp;
        int hashCode16 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.newProxyInstance;
        int hashCode17 = str16 != null ? str16.hashCode() : 0;
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + i) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierMerchantModel(NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.lookAheadTest);
        CashierKybOrderDetailModel cashierKybOrderDetailModel = this.moveToNextValue;
        if (cashierKybOrderDetailModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            cashierKybOrderDetailModel.writeToParcel(p0, p1);
        }
        p0.writeInt(this.PrepareContext ? 1 : 0);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.newProxyInstance);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
    }

    public CashierMerchantModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, CashierKybOrderDetailModel cashierKybOrderDetailModel, boolean z, String str12, String str13, String str14, String str15, String str16, boolean z2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.GetContactSyncConfig = str2;
        this.isLayoutRequested = str3;
        this.DatabaseTableConfigUtil = str4;
        this.getErrorConfigVersion = str5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str6;
        this.MyBillsEntityDataFactory = str7;
        this.PlaceComponentResult = str8;
        this.scheduleImpl = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str10;
        this.lookAheadTest = str11;
        this.moveToNextValue = cashierKybOrderDetailModel;
        this.PrepareContext = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str12;
        this.getAuthRequestContext = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str14;
        this.initRecordTimeStamp = str15;
        this.newProxyInstance = str16;
        this.BuiltInFictitiousFunctionClassFactory = z2;
    }

    public /* synthetic */ CashierMerchantModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, CashierKybOrderDetailModel cashierKybOrderDetailModel, boolean z, String str12, String str13, String str14, String str15, String str16, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : cashierKybOrderDetailModel, (i & 4096) != 0 ? false : z, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : str15, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str16, (i & 262144) != 0 ? false : z2);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPrepareContext() {
        return this.PrepareContext;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    private final List<String> PlaceComponentResult() {
        return CollectionsKt.listOf((Object[]) new String[]{this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.newProxyInstance, this.PlaceComponentResult, this.getAuthRequestContext, this.initRecordTimeStamp});
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        String str;
        if (p0 != null) {
            List<String> PlaceComponentResult = PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            for (String str2 : PlaceComponentResult) {
                String str3 = str2;
                if (!(str3 == null || StringsKt.isBlank(str3))) {
                    if (sb.length() == 0) {
                        sb.append(str2);
                    } else if (Intrinsics.areEqual(str2, this.getAuthRequestContext)) {
                        sb.append(p0.getString(R.string.cashier_acquirer_name_merchant_info_prepend, str2));
                    } else if (Intrinsics.areEqual(str2, this.initRecordTimeStamp)) {
                        sb.append(p0.getString(R.string.cashier_merchant_pan_merchant_info_prepend, str2));
                    } else {
                        sb.append(p0.getString(R.string.cashier_general_merchant_info_prepend, str2));
                    }
                }
            }
            str = sb.toString();
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierMerchantModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierMerchantModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CashierMerchantModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CashierKybOrderDetailModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierMerchantModel[] newArray(int i) {
            return new CashierMerchantModel[i];
        }
    }
}
