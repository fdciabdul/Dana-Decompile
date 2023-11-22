package id.dana.mybills.model;

import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b/\u00100J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b \u0010\rR\u0013\u0010 \u001a\u0004\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b"}, d2 = {"Lid/dana/mybills/model/BillPaymentStatusModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Boolean;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "lookAheadTest", "Ljava/lang/Long;", "scheduleImpl", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillPaymentStatusModel {
    public final Boolean BuiltInFictitiousFunctionClassFactory;
    public final String DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final MoneyViewModel initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Long scheduleImpl;
    public final MoneyViewModel moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Long lookAheadTest;

    public BillPaymentStatusModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BillPaymentStatusModel) {
            BillPaymentStatusModel billPaymentStatusModel = (BillPaymentStatusModel) p0;
            return Intrinsics.areEqual(this.GetContactSyncConfig, billPaymentStatusModel.GetContactSyncConfig) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, billPaymentStatusModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, billPaymentStatusModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, billPaymentStatusModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, billPaymentStatusModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, billPaymentStatusModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, billPaymentStatusModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, billPaymentStatusModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, billPaymentStatusModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, billPaymentStatusModel.initRecordTimeStamp) && Intrinsics.areEqual(this.moveToNextValue, billPaymentStatusModel.moveToNextValue) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, billPaymentStatusModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.PlaceComponentResult, billPaymentStatusModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, billPaymentStatusModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, billPaymentStatusModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.GetContactSyncConfig;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.getAuthRequestContext;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.getErrorConfigVersion;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Long l = this.lookAheadTest;
        int hashCode7 = l == null ? 0 : l.hashCode();
        Long l2 = this.scheduleImpl;
        int hashCode8 = l2 == null ? 0 : l2.hashCode();
        String str6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        MoneyViewModel moneyViewModel = this.initRecordTimeStamp;
        int hashCode10 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.moveToNextValue;
        int hashCode11 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str7 = this.DatabaseTableConfigUtil;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.PlaceComponentResult;
        int hashCode13 = str8 == null ? 0 : str8.hashCode();
        Boolean bool2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode14 = bool2 == null ? 0 : bool2.hashCode();
        String str9 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillPaymentStatusModel(GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(')');
        return sb.toString();
    }

    public BillPaymentStatusModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, Long l2, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, Boolean bool2, String str9) {
        this.GetContactSyncConfig = str;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = str3;
        this.BuiltInFictitiousFunctionClassFactory = bool;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.getErrorConfigVersion = str5;
        this.lookAheadTest = l;
        this.scheduleImpl = l2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str6;
        this.initRecordTimeStamp = moneyViewModel;
        this.moveToNextValue = moneyViewModel2;
        this.DatabaseTableConfigUtil = str7;
        this.PlaceComponentResult = str8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str9;
    }

    public /* synthetic */ BillPaymentStatusModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, Long l2, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, Boolean bool2, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : moneyViewModel, (i & 1024) != 0 ? null : moneyViewModel2, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : bool2, (i & 16384) == 0 ? str9 : null);
    }
}
