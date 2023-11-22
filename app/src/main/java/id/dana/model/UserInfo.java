package id.dana.model;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b<\u0010=J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\f\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u0004\u0018\u00010\u001dX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010\rR\u0014\u0010\"\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\rR\u0014\u0010!\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010\rR\u0014\u0010#\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010\rR\u0012\u0010&\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010\rR\u0014\u0010(\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\rR\u0014\u0010$\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010\r"}, d2 = {"Lid/dana/model/UserInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/model/CurrencyAmountModel;", "getAuthRequestContext", "Z", "()Z", "PlaceComponentResult", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "lookAheadTest", "Lid/dana/model/KybInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/model/KybInfo;", "Lid/dana/model/KycInfo;", "GetContactSyncConfig", "Lid/dana/model/KycInfo;", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda7", "I", "PrepareContext", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/CurrencyAmountModel;Ljava/lang/String;ILjava/lang/String;Lid/dana/model/KycInfo;Lid/dana/model/KybInfo;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserInfo {
    public CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public KycInfo DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public KybInfo NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public int PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public boolean PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public String newProxyInstance;
    public boolean getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public boolean scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String GetContactSyncConfig;
    public String isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean moveToNextValue;

    public UserInfo() {
        this(null, null, null, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 524287, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) p0;
            return Intrinsics.areEqual(this.initRecordTimeStamp, userInfo.initRecordTimeStamp) && Intrinsics.areEqual(this.newProxyInstance, userInfo.newProxyInstance) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, userInfo.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userInfo.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, userInfo.NetworkUserEntityData$$ExternalSyntheticLambda1) && this.PrepareContext == userInfo.PrepareContext && Intrinsics.areEqual(this.GetContactSyncConfig, userInfo.GetContactSyncConfig) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, userInfo.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, userInfo.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, userInfo.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, userInfo.lookAheadTest) && this.moveToNextValue == userInfo.moveToNextValue && this.PlaceComponentResult == userInfo.PlaceComponentResult && this.getAuthRequestContext == userInfo.getAuthRequestContext && this.scheduleImpl == userInfo.scheduleImpl && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, userInfo.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, userInfo.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, userInfo.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.isLayoutRequested, userInfo.isLayoutRequested);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.initRecordTimeStamp;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.newProxyInstance;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        CurrencyAmountModel currencyAmountModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = currencyAmountModel == null ? 0 : currencyAmountModel.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        int i = this.PrepareContext;
        String str5 = this.GetContactSyncConfig;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        KycInfo kycInfo = this.DatabaseTableConfigUtil;
        int hashCode7 = kycInfo == null ? 0 : kycInfo.hashCode();
        KybInfo kybInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode8 = kybInfo == null ? 0 : kybInfo.hashCode();
        String str6 = this.getErrorConfigVersion;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.lookAheadTest;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.moveToNextValue;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        boolean z2 = this.PlaceComponentResult;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        boolean z3 = this.getAuthRequestContext;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        boolean z4 = this.scheduleImpl;
        int i5 = !z4 ? z4 ? 1 : 0 : 1;
        String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.isLayoutRequested;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfo(initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(')');
        return sb.toString();
    }

    private UserInfo(String str, String str2, String str3, CurrencyAmountModel currencyAmountModel, String str4, int i, String str5, KycInfo kycInfo, KybInfo kybInfo, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, String str8, String str9, String str10, String str11) {
        this.initRecordTimeStamp = str;
        this.newProxyInstance = str2;
        this.MyBillsEntityDataFactory = str3;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str4;
        this.PrepareContext = i;
        this.GetContactSyncConfig = str5;
        this.DatabaseTableConfigUtil = kycInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = kybInfo;
        this.getErrorConfigVersion = str6;
        this.lookAheadTest = str7;
        this.moveToNextValue = z;
        this.PlaceComponentResult = z2;
        this.getAuthRequestContext = z3;
        this.scheduleImpl = z4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str10;
        this.isLayoutRequested = str11;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, CurrencyAmountModel currencyAmountModel, String str4, int i, String str5, KycInfo kycInfo, KybInfo kybInfo, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, String str8, String str9, String str10, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : currencyAmountModel, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : kycInfo, (i2 & 256) != 0 ? null : kybInfo, (i2 & 512) != 0 ? null : str6, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? false : z, (i2 & 4096) != 0 ? false : z2, (i2 & 8192) != 0 ? false : z3, (i2 & 16384) != 0 ? false : z4, (i2 & 32768) != 0 ? null : str8, (i2 & 65536) != 0 ? null : str9, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str10, (i2 & 262144) != 0 ? null : str11);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }
}
