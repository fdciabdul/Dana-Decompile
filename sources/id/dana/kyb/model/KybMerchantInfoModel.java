package id.dana.kyb.model;

import android.graphics.Bitmap;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010-\u001a\u00020\t\u0012\u0006\u0010.\u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\t\u0012\u0006\u00102\u001a\u00020\t\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010:\u001a\u00020\"\u0012\b\b\u0002\u0010;\u001a\u00020\"\u0012\b\b\u0002\u0010<\u001a\u00020\t\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b?\u0010@J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0017\u0010\r\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0017\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0013\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0011\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u0003X\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u0003X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0013\u0010!\u001a\u0004\u0018\u00010\u001eX\u0007¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0011\u0010\u001f\u001a\u00020\"X\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010#R\u0011\u0010$\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0011\u0010%\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0013\u0010&\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0011\u0010'\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b&\u0010\u0014R\u0011\u0010(\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b%\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b$\u0010\u0014R\u0013\u0010+\u001a\u0004\u0018\u00010)X\u0007¢\u0006\u0006\n\u0004\b(\u0010*R\u0011\u0010,\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b'\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\"X\u0007¢\u0006\u0006\n\u0004\b,\u0010#"}, d2 = {"Lid/dana/kyb/model/KybMerchantInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/kyb/model/BalanceModel;", "getAuthRequestContext", "Lid/dana/kyb/model/BalanceModel;", "BuiltInFictitiousFunctionClassFactory", "Landroid/graphics/Bitmap;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/Bitmap;", "PlaceComponentResult", "Ljava/lang/String;", "newProxyInstance", "Z", "MyBillsEntityDataFactory", "()Z", "isLayoutRequested", "PrepareContext", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kyb/model/KybQrisModel;", "getErrorConfigVersion", "Lid/dana/kyb/model/KybQrisModel;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "initRecordTimeStamp", "GetContactSyncConfig", "Lid/dana/kyb/model/MerchantContractInfoModel;", "Lid/dana/kyb/model/MerchantContractInfoModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/model/BalanceModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZLid/dana/kyb/model/MerchantContractInfoModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Landroid/graphics/Bitmap;Lid/dana/kyb/model/KybQrisModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybMerchantInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final MerchantContractInfoModel NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Bitmap PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final MoneyViewModel isLayoutRequested;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final boolean scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final BalanceModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final KybQrisModel lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final MoneyViewModel getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybMerchantInfoModel) {
            KybMerchantInfoModel kybMerchantInfoModel = (KybMerchantInfoModel) p0;
            return Intrinsics.areEqual(this.DatabaseTableConfigUtil, kybMerchantInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.GetContactSyncConfig, kybMerchantInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybMerchantInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, kybMerchantInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.initRecordTimeStamp, kybMerchantInfoModel.initRecordTimeStamp) && Intrinsics.areEqual(this.newProxyInstance, kybMerchantInfoModel.newProxyInstance) && this.getAuthRequestContext == kybMerchantInfoModel.getAuthRequestContext && this.MyBillsEntityDataFactory == kybMerchantInfoModel.MyBillsEntityDataFactory && this.scheduleImpl == kybMerchantInfoModel.scheduleImpl && this.moveToNextValue == kybMerchantInfoModel.moveToNextValue && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.isLayoutRequested, kybMerchantInfoModel.isLayoutRequested) && Intrinsics.areEqual(this.getErrorConfigVersion, kybMerchantInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.PlaceComponentResult, kybMerchantInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, kybMerchantInfoModel.lookAheadTest);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.DatabaseTableConfigUtil;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        int hashCode3 = this.GetContactSyncConfig.hashCode();
        int hashCode4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode();
        BalanceModel balanceModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = balanceModel == null ? 0 : balanceModel.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        int hashCode7 = this.initRecordTimeStamp.hashCode();
        String str3 = this.newProxyInstance;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        boolean z = this.getAuthRequestContext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.MyBillsEntityDataFactory;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.scheduleImpl;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        boolean z4 = this.moveToNextValue;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        boolean z5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i5 = z5 ? 1 : z5 ? 1 : 0;
        MerchantContractInfoModel merchantContractInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode9 = merchantContractInfoModel == null ? 0 : merchantContractInfoModel.hashCode();
        int hashCode10 = this.isLayoutRequested.hashCode();
        int hashCode11 = this.getErrorConfigVersion.hashCode();
        int hashCode12 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
        Bitmap bitmap = this.PlaceComponentResult;
        int hashCode13 = bitmap == null ? 0 : bitmap.hashCode();
        KybQrisModel kybQrisModel = this.lookAheadTest;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (kybQrisModel != null ? kybQrisModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybMerchantInfoModel(DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(')');
        return sb.toString();
    }

    private KybMerchantInfoModel(String str, String str2, String str3, String str4, BalanceModel balanceModel, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, MerchantContractInfoModel merchantContractInfoModel, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str8, Bitmap bitmap, KybQrisModel kybQrisModel) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.DatabaseTableConfigUtil = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str2;
        this.GetContactSyncConfig = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str4;
        this.BuiltInFictitiousFunctionClassFactory = balanceModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.initRecordTimeStamp = str6;
        this.newProxyInstance = str7;
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = z2;
        this.scheduleImpl = z3;
        this.moveToNextValue = z4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = merchantContractInfoModel;
        this.isLayoutRequested = moneyViewModel;
        this.getErrorConfigVersion = moneyViewModel2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str8;
        this.PlaceComponentResult = bitmap;
        this.lookAheadTest = kybQrisModel;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    public /* synthetic */ KybMerchantInfoModel(String str, String str2, String str3, String str4, BalanceModel balanceModel, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, MerchantContractInfoModel merchantContractInfoModel, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str8, Bitmap bitmap, KybQrisModel kybQrisModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, str3, str4, (i & 16) != 0 ? null : balanceModel, (i & 32) != 0 ? null : str5, str6, (i & 128) != 0 ? null : str7, z, z2, z3, z4, z5, (i & 8192) != 0 ? null : merchantContractInfoModel, (i & 16384) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (32768 & i) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel2, (65536 & i) != 0 ? "NONE" : str8, (131072 & i) != 0 ? null : bitmap, (i & 262144) != 0 ? null : kybQrisModel);
    }
}
