package id.dana.familyaccount.view.summary;

import id.dana.familyaccount.constants.FamilyAccountTransactionType;
import id.dana.familyaccount.view.summary.TransactionTypeSourceType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/familyaccount/view/summary/TransactionTypeViewState;", "", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "getAuthRequestContext", "", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransactionTypeViewState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final TransactionTypeSourceType getAuthRequestContext;

    public TransactionTypeViewState(@FamilyAccountTransactionType String str) {
        TransactionTypeSourceType.Companion companion = TransactionTypeSourceType.INSTANCE;
        this.getAuthRequestContext = TransactionTypeSourceType.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str);
    }
}
