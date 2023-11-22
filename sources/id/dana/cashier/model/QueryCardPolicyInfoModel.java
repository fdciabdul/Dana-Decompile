package id.dana.cashier.model;

import id.dana.domain.payasset.model.CardScheme;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f\u0012\b\u0010$\u001a\u0004\u0018\u00010\f\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\u0010&\u001a\u0004\u0018\u00010\f\u0012\b\u0010'\u001a\u0004\u0018\u00010\f\u0012\b\u0010(\u001a\u0004\u0018\u00010\f\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\f\u0012\b\u0010+\u001a\u0004\u0018\u00010\f\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\f\u0012\b\u0010.\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\"\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\b\u00101\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0013\u0010!\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b!\u0010#R\u0013\u0010 \u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013"}, d2 = {"Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "MyBillsEntityDataFactory", "()Z", "BuiltInFictitiousFunctionClassFactory", "", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "moveToNextValue", "lookAheadTest", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "scheduleImpl", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Ljava/lang/Boolean;", "DatabaseTableConfigUtil", "GetContactSyncConfig", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "Ljava/util/List;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/model/DailyLimitAmountConfModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class QueryCardPolicyInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final Boolean DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final List<String> GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Boolean scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final DailyLimitAmountConfModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QueryCardPolicyInfoModel) {
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = (QueryCardPolicyInfoModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, queryCardPolicyInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, queryCardPolicyInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, queryCardPolicyInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, queryCardPolicyInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.lookAheadTest, queryCardPolicyInfoModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, queryCardPolicyInfoModel.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, queryCardPolicyInfoModel.moveToNextValue) && Intrinsics.areEqual(this.getErrorConfigVersion, queryCardPolicyInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, queryCardPolicyInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, queryCardPolicyInfoModel.initRecordTimeStamp) && Intrinsics.areEqual(this.GetContactSyncConfig, queryCardPolicyInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        return false;
    }

    public final int hashCode() {
        Map<String, String> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = map == null ? 0 : map.hashCode();
        String str = this.PlaceComponentResult;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.getAuthRequestContext;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.MyBillsEntityDataFactory;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.lookAheadTest;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Boolean bool = this.scheduleImpl;
        int hashCode7 = bool == null ? 0 : bool.hashCode();
        String str6 = this.moveToNextValue;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.getErrorConfigVersion;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        Boolean bool2 = this.DatabaseTableConfigUtil;
        int hashCode10 = bool2 == null ? 0 : bool2.hashCode();
        String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.initRecordTimeStamp;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        List<String> list = this.GetContactSyncConfig;
        int hashCode13 = list == null ? 0 : list.hashCode();
        DailyLimitAmountConfModel dailyLimitAmountConfModel = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode14 = dailyLimitAmountConfModel == null ? 0 : dailyLimitAmountConfModel.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCardPolicyInfoModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(')');
        return sb.toString();
    }

    public QueryCardPolicyInfoModel(Map<String, String> map, String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, Boolean bool2, String str8, String str9, List<String> list, DailyLimitAmountConfModel dailyLimitAmountConfModel, String str10) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = str3;
        this.MyBillsEntityDataFactory = str4;
        this.lookAheadTest = str5;
        this.scheduleImpl = bool;
        this.moveToNextValue = str6;
        this.getErrorConfigVersion = str7;
        this.DatabaseTableConfigUtil = bool2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str8;
        this.initRecordTimeStamp = str9;
        this.GetContactSyncConfig = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = dailyLimitAmountConfModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str10;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return Intrinsics.areEqual(this.DatabaseTableConfigUtil, Boolean.FALSE) || Intrinsics.areEqual(this.scheduleImpl, Boolean.TRUE);
    }

    public final boolean MyBillsEntityDataFactory() {
        if (!Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, CardScheme.AMERICAN_EXPRESS)) {
            String str = this.PlaceComponentResult;
            if (!(str != null ? StringsKt.startsWith$default(str, "37", false, 2, (Object) null) : false)) {
                return false;
            }
        }
        return true;
    }
}
