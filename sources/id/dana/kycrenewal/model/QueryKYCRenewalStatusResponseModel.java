package id.dana.kycrenewal.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/kycrenewal/model/QueryKYCRenewalStatusResponseModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QueryKYCRenewalStatusResponseModel {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final boolean PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QueryKYCRenewalStatusResponseModel) {
            QueryKYCRenewalStatusResponseModel queryKYCRenewalStatusResponseModel = (QueryKYCRenewalStatusResponseModel) p0;
            return this.PlaceComponentResult == queryKYCRenewalStatusResponseModel.PlaceComponentResult && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, queryKYCRenewalStatusResponseModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryKYCRenewalStatusResponseModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public QueryKYCRenewalStatusResponseModel(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }
}
