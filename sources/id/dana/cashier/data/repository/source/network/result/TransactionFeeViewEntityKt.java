package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.TransactionFeeView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/TransactionFeeViewEntity;", "Lid/dana/cashier/domain/model/TransactionFeeView;", "toTransactionFeeView", "(Lid/dana/cashier/data/repository/source/network/result/TransactionFeeViewEntity;)Lid/dana/cashier/domain/model/TransactionFeeView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransactionFeeViewEntityKt {
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final TransactionFeeView toTransactionFeeView(TransactionFeeViewEntity transactionFeeViewEntity) {
        if (transactionFeeViewEntity == null) {
            ?? r1 = 0;
            return new TransactionFeeView(r1, r1, 3, r1);
        }
        String ratio = transactionFeeViewEntity.getRatio();
        if (ratio == null) {
            ratio = "";
        }
        String amount = transactionFeeViewEntity.getAmount();
        return new TransactionFeeView(ratio, amount != null ? amount : "");
    }
}
