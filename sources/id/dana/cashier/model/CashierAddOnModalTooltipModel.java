package id.dana.cashier.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/cashier/model/TooltipContentModel;", "getAuthRequestContext", "Lid/dana/cashier/model/TooltipContentModel;", "PlaceComponentResult", "Lid/dana/cashier/model/TooltipProductInfoModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/TooltipProductInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Lid/dana/cashier/model/TooltipContentModel;Lid/dana/cashier/model/TooltipProductInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalTooltipModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final TooltipProductInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final TooltipContentModel PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierAddOnModalTooltipModel) {
            CashierAddOnModalTooltipModel cashierAddOnModalTooltipModel = (CashierAddOnModalTooltipModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, cashierAddOnModalTooltipModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierAddOnModalTooltipModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        TooltipContentModel tooltipContentModel = this.PlaceComponentResult;
        int hashCode = tooltipContentModel == null ? 0 : tooltipContentModel.hashCode();
        TooltipProductInfoModel tooltipProductInfoModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (hashCode * 31) + (tooltipProductInfoModel != null ? tooltipProductInfoModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalTooltipModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnModalTooltipModel(TooltipContentModel tooltipContentModel, TooltipProductInfoModel tooltipProductInfoModel) {
        this.PlaceComponentResult = tooltipContentModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = tooltipProductInfoModel;
    }
}
