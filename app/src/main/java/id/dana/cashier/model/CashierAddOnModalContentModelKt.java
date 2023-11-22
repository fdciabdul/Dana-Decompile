package id.dana.cashier.model;

import id.dana.cashier.domain.model.CashierAddOnModalContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "Lid/dana/cashier/model/CashierAddOnModalContentModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/CashierAddOnModalContent;)Lid/dana/cashier/model/CashierAddOnModalContentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnModalContentModelKt {
    public static final CashierAddOnModalContentModel BuiltInFictitiousFunctionClassFactory(CashierAddOnModalContent cashierAddOnModalContent) {
        Intrinsics.checkNotNullParameter(cashierAddOnModalContent, "");
        return new CashierAddOnModalContentModel(cashierAddOnModalContent.getEnable(), cashierAddOnModalContent.getPeriodeEn(), cashierAddOnModalContent.getPeriodeId(), cashierAddOnModalContent.getContentTitleEn(), cashierAddOnModalContent.getContentTitleId(), cashierAddOnModalContent.getTncDescEn(), cashierAddOnModalContent.getTncDescId());
    }
}
