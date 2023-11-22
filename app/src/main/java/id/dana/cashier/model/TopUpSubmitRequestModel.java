package id.dana.cashier.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010&\u001a\u0004\u0018\u00010\t\u0012\b\u0010'\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010\t\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\b\u0010,\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001f¢\u0006\u0004\b2\u00103J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001dX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR \u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010 R\u0014\u0010\"\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\r"}, d2 = {"Lid/dana/cashier/model/TopUpSubmitRequestModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "MyBillsEntityDataFactory", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/Boolean;", "GetContactSyncConfig", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/domain/nearbyme/model/MoneyView;", "", "Ljava/util/Map;", "isLayoutRequested", "PrepareContext", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpSubmitRequestModel {
    final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    final MoneyView initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    final Boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    Map<String, String> DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;
    String getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    String PrepareContext;
    final String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TopUpSubmitRequestModel) {
            TopUpSubmitRequestModel topUpSubmitRequestModel = (TopUpSubmitRequestModel) p0;
            return Intrinsics.areEqual(this.moveToNextValue, topUpSubmitRequestModel.moveToNextValue) && Intrinsics.areEqual(this.GetContactSyncConfig, topUpSubmitRequestModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, topUpSubmitRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, topUpSubmitRequestModel.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, topUpSubmitRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.lookAheadTest, topUpSubmitRequestModel.lookAheadTest) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, topUpSubmitRequestModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, topUpSubmitRequestModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, topUpSubmitRequestModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, topUpSubmitRequestModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, topUpSubmitRequestModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, topUpSubmitRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.PlaceComponentResult, topUpSubmitRequestModel.PlaceComponentResult) && Intrinsics.areEqual(this.getErrorConfigVersion, topUpSubmitRequestModel.getErrorConfigVersion) && Intrinsics.areEqual(this.PrepareContext, topUpSubmitRequestModel.PrepareContext) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, topUpSubmitRequestModel.DatabaseTableConfigUtil);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.moveToNextValue;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.GetContactSyncConfig;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        MoneyView moneyView = this.initRecordTimeStamp;
        int hashCode4 = moneyView == null ? 0 : moneyView.hashCode();
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.lookAheadTest;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.getAuthRequestContext;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.MyBillsEntityDataFactory;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.scheduleImpl;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.PlaceComponentResult;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.getErrorConfigVersion;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.PrepareContext;
        int hashCode15 = str13 == null ? 0 : str13.hashCode();
        Map<String, String> map = this.DatabaseTableConfigUtil;
        return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpSubmitRequestModel(moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(')');
        return sb.toString();
    }

    public TopUpSubmitRequestModel(String str, Boolean bool, String str2, MoneyView moneyView, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        this.moveToNextValue = str;
        this.GetContactSyncConfig = bool;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str2;
        this.initRecordTimeStamp = moneyView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str3;
        this.lookAheadTest = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.BuiltInFictitiousFunctionClassFactory = str6;
        this.getAuthRequestContext = str7;
        this.MyBillsEntityDataFactory = str8;
        this.scheduleImpl = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str10;
        this.PlaceComponentResult = str11;
        this.getErrorConfigVersion = str12;
        this.PrepareContext = str13;
        this.DatabaseTableConfigUtil = map;
    }
}
