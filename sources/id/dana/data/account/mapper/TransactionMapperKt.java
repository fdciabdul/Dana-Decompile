package id.dana.data.account.mapper;

import id.dana.data.account.TransactionEntity;
import id.dana.domain.account.model.Transaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/account/TransactionEntity;", "Lid/dana/domain/account/model/Transaction;", "toTransaction", "(Lid/dana/data/account/TransactionEntity;)Lid/dana/domain/account/model/Transaction;", "toTransactionEntity", "(Lid/dana/domain/account/model/Transaction;)Lid/dana/data/account/TransactionEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransactionMapperKt {
    public static final TransactionEntity toTransactionEntity(Transaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "");
        return new TransactionEntity(transaction.getType(), transaction.getDate());
    }

    public static final Transaction toTransaction(TransactionEntity transactionEntity) {
        Intrinsics.checkNotNullParameter(transactionEntity, "");
        String type = transactionEntity.getType();
        if (type == null) {
            type = "";
        }
        String date = transactionEntity.getDate();
        return new Transaction(type, date != null ? date : "");
    }
}
