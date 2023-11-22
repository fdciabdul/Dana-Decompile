package id.dana.cashier.model;

import id.dana.cashier.domain.model.TransactionFeeView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/TransactionFeeView;", "Lid/dana/cashier/model/TransactionFeeViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/domain/model/TransactionFeeView;)Lid/dana/cashier/model/TransactionFeeViewModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransactionFeeViewModelKt {
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final TransactionFeeViewModel KClassImpl$Data$declaredNonStaticMembers$2(TransactionFeeView transactionFeeView) {
        if (transactionFeeView == null) {
            ?? r1 = 0;
            return new TransactionFeeViewModel(r1, r1, 3, r1);
        }
        String ratio = transactionFeeView.getRatio();
        if (ratio == null) {
            ratio = "";
        }
        String amount = transactionFeeView.getAmount();
        return new TransactionFeeViewModel(ratio, amount != null ? amount : "");
    }
}
