package id.dana.cashier.model;

import id.dana.cashier.domain.model.CashierAddOnModalTooltip;
import id.dana.cashier.domain.model.TooltipContent;
import id.dana.cashier.domain.model.TooltipProductInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;)Lid/dana/cashier/model/CashierAddOnModalTooltipModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnModalTooltipModelKt {
    public static final CashierAddOnModalTooltipModel BuiltInFictitiousFunctionClassFactory(CashierAddOnModalTooltip cashierAddOnModalTooltip) {
        Intrinsics.checkNotNullParameter(cashierAddOnModalTooltip, "");
        TooltipContent content = cashierAddOnModalTooltip.getContent();
        TooltipContentModel KClassImpl$Data$declaredNonStaticMembers$2 = content != null ? TooltipContentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(content) : null;
        TooltipProductInfo productInfo = cashierAddOnModalTooltip.getProductInfo();
        return new CashierAddOnModalTooltipModel(KClassImpl$Data$declaredNonStaticMembers$2, productInfo != null ? TooltipProductInfoModelKt.BuiltInFictitiousFunctionClassFactory(productInfo) : null);
    }
}
