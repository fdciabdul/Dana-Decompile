package id.dana.cashier.model;

import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\b\u0010,\u001a\u0004\u0018\u00010\t\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\t\u0012\b\u00101\u001a\u0004\u0018\u00010\t\u0012\b\u00102\u001a\u0004\u0018\u00010\t\u0012\b\u00103\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0013\u0012\b\u00106\u001a\u0004\u0018\u00010\"\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\t\u0012\b\u0010;\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013\u0012\b\b\u0002\u0010=\u001a\u00020\t\u0012\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\u0004\b?\u0010@J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010#R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0013\u0010$\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b$\u0010\rR\u0013\u0010&\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u0013\u0010'\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b&\u0010\rR\u0013\u0010(\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b'\u0010\rR\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b(\u0010\u0015R\u0011\u0010*\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b)\u0010\r"}, d2 = {"Lid/dana/cashier/model/TooltipProductInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Boolean;", "", "Lid/dana/cashier/model/BenefitModel;", "Ljava/util/List;", "lookAheadTest", "scheduleImpl", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "GetContactSyncConfig", "initRecordTimeStamp", "Lid/dana/cashier/model/AddonImportantInfoModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/model/InsuranceBenefitModel;", "DatabaseTableConfigUtil", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda4", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TooltipProductInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final List<InsuranceBenefitModel> DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final List<AddonImportantInfoModel> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<BenefitModel> getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final MoneyViewModel GetContactSyncConfig;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final Boolean PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Boolean scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final List<String> isLayoutRequested;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String moveToNextValue;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TooltipProductInfoModel) {
            TooltipProductInfoModel tooltipProductInfoModel = (TooltipProductInfoModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, tooltipProductInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, tooltipProductInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, tooltipProductInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, tooltipProductInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, tooltipProductInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.scheduleImpl, tooltipProductInfoModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, tooltipProductInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, tooltipProductInfoModel.lookAheadTest) && Intrinsics.areEqual(this.moveToNextValue, tooltipProductInfoModel.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.initRecordTimeStamp, tooltipProductInfoModel.initRecordTimeStamp) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, tooltipProductInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.GetContactSyncConfig, tooltipProductInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.PrepareContext, tooltipProductInfoModel.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.newProxyInstance, tooltipProductInfoModel.newProxyInstance) && Intrinsics.areEqual(this.isLayoutRequested, tooltipProductInfoModel.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, tooltipProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.MyBillsEntityDataFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.PlaceComponentResult;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        List<BenefitModel> list = this.getAuthRequestContext;
        int hashCode5 = list == null ? 0 : list.hashCode();
        Boolean bool2 = this.scheduleImpl;
        int hashCode6 = bool2 == null ? 0 : bool2.hashCode();
        String str4 = this.getErrorConfigVersion;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.lookAheadTest;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.moveToNextValue;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.initRecordTimeStamp;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        List<InsuranceBenefitModel> list2 = this.DatabaseTableConfigUtil;
        int hashCode12 = list2 == null ? 0 : list2.hashCode();
        MoneyViewModel moneyViewModel = this.GetContactSyncConfig;
        int hashCode13 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str9 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode14 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode15 = str10 == null ? 0 : str10.hashCode();
        Boolean bool3 = this.PrepareContext;
        int hashCode16 = bool3 == null ? 0 : bool3.hashCode();
        String str11 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode17 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.newProxyInstance;
        int hashCode18 = str12 == null ? 0 : str12.hashCode();
        List<String> list3 = this.isLayoutRequested;
        int hashCode19 = list3 == null ? 0 : list3.hashCode();
        int hashCode20 = this.NetworkUserEntityData$$ExternalSyntheticLambda4.hashCode();
        List<AddonImportantInfoModel> list4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + (list4 != null ? list4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TooltipProductInfoModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(')');
        return sb.toString();
    }

    public TooltipProductInfoModel(String str, String str2, String str3, Boolean bool, List<BenefitModel> list, Boolean bool2, String str4, String str5, String str6, String str7, String str8, List<InsuranceBenefitModel> list2, MoneyViewModel moneyViewModel, String str9, String str10, Boolean bool3, String str11, String str12, List<String> list3, String str13, List<AddonImportantInfoModel> list4) {
        Intrinsics.checkNotNullParameter(str13, "");
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.BuiltInFictitiousFunctionClassFactory = bool;
        this.getAuthRequestContext = list;
        this.scheduleImpl = bool2;
        this.getErrorConfigVersion = str4;
        this.lookAheadTest = str5;
        this.moveToNextValue = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str7;
        this.initRecordTimeStamp = str8;
        this.DatabaseTableConfigUtil = list2;
        this.GetContactSyncConfig = moneyViewModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str10;
        this.PrepareContext = bool3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str11;
        this.newProxyInstance = str12;
        this.isLayoutRequested = list3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = list4;
    }
}
