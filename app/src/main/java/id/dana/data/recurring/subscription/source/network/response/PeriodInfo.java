package id.dana.data.recurring.subscription.source.network.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/data/recurring/subscription/source/network/response/PeriodInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Integer;", "getAuthRequestContext", "", "Ljava/lang/Long;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PeriodInfo {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Integer getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Long PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PeriodInfo) {
            PeriodInfo periodInfo = (PeriodInfo) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, periodInfo.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, periodInfo.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, periodInfo.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, periodInfo.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.getAuthRequestContext;
        int hashCode2 = num2 == null ? 0 : num2.hashCode();
        Long l = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = l == null ? 0 : l.hashCode();
        Long l2 = this.PlaceComponentResult;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PeriodInfo(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }
}
