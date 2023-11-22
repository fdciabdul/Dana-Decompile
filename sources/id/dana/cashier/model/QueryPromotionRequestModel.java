package id.dana.cashier.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017"}, d2 = {"Lid/dana/cashier/model/QueryPromotionRequestModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "PlaceComponentResult", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "getErrorConfigVersion", "", "Ljava/util/List;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryPromotionRequestModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<String> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QueryPromotionRequestModel) {
            QueryPromotionRequestModel queryPromotionRequestModel = (QueryPromotionRequestModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, queryPromotionRequestModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, queryPromotionRequestModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, queryPromotionRequestModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, queryPromotionRequestModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, queryPromotionRequestModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, queryPromotionRequestModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, queryPromotionRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.moveToNextValue, queryPromotionRequestModel.moveToNextValue);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getAuthRequestContext.hashCode();
        int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        int hashCode4 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode5 = this.MyBillsEntityDataFactory.hashCode();
        int hashCode6 = this.getErrorConfigVersion.hashCode();
        int hashCode7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        List<String> list = this.moveToNextValue;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryPromotionRequestModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    public QueryPromotionRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.PlaceComponentResult = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.MyBillsEntityDataFactory = str5;
        this.getErrorConfigVersion = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str7;
        this.moveToNextValue = list;
    }
}
