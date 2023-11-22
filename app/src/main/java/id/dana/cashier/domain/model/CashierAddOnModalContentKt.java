package id.dana.cashier.domain.model;

import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalContentResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalContentResult;", "Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "toCashierAddOnModalContent", "(Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalContentResult;)Lid/dana/cashier/domain/model/CashierAddOnModalContent;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnModalContentKt {
    public static final CashierAddOnModalContent toCashierAddOnModalContent(CashierAddOnModalContentResult cashierAddOnModalContentResult) {
        Intrinsics.checkNotNullParameter(cashierAddOnModalContentResult, "");
        return new CashierAddOnModalContent(cashierAddOnModalContentResult.getEnable(), cashierAddOnModalContentResult.getPeriode_en_US(), cashierAddOnModalContentResult.getPeriode_id_ID(), cashierAddOnModalContentResult.getContent_title_en_US(), cashierAddOnModalContentResult.getContent_title_id_ID(), cashierAddOnModalContentResult.getTnc_desc_en_US(), cashierAddOnModalContentResult.getTnc_desc_id_ID());
    }
}
