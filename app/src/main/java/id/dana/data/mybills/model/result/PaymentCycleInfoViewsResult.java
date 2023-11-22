package id.dana.data.mybills.model.result;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018"}, d2 = {"Lid/dana/data/mybills/model/result/PaymentCycleInfoViewsResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "moveToNextValue", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "", "Ljava/lang/Long;", "MyBillsEntityDataFactory", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PaymentCycleInfoViewsResult {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final MoneyViewEntity moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Long MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PaymentCycleInfoViewsResult) {
            PaymentCycleInfoViewsResult paymentCycleInfoViewsResult = (PaymentCycleInfoViewsResult) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == paymentCycleInfoViewsResult.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.PlaceComponentResult, paymentCycleInfoViewsResult.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, paymentCycleInfoViewsResult.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, paymentCycleInfoViewsResult.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, paymentCycleInfoViewsResult.getAuthRequestContext) && Intrinsics.areEqual(this.moveToNextValue, paymentCycleInfoViewsResult.moveToNextValue);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.PlaceComponentResult;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Long l = this.MyBillsEntityDataFactory;
        int hashCode3 = l == null ? 0 : l.hashCode();
        String str3 = this.getAuthRequestContext;
        return (((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.moveToNextValue.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentCycleInfoViewsResult(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
