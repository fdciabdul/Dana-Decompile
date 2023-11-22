package id.dana.cashier.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/cashier/model/QueryPromotionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/Boolean;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/cashier/model/VoucherCashierModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "MyBillsEntityDataFactory", "p1", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryPromotionModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<VoucherCashierModel> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QueryPromotionModel) {
            QueryPromotionModel queryPromotionModel = (QueryPromotionModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, queryPromotionModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, queryPromotionModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return ((bool == null ? 0 : bool.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryPromotionModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public QueryPromotionModel(Boolean bool, List<VoucherCashierModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
        this.MyBillsEntityDataFactory = list;
    }
}
