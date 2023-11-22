package id.dana.domain.sendmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/sendmoney/model/WithdrawInitBase;", "", "", "Lid/dana/domain/sendmoney/model/WithdrawInitMethodOption;", "withdrawMethodViews", "Ljava/util/List;", "getWithdrawMethodViews", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WithdrawInitBase {
    private final List<WithdrawInitMethodOption> withdrawMethodViews;

    public WithdrawInitBase(List<WithdrawInitMethodOption> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.withdrawMethodViews = list;
    }

    @JvmName(name = "getWithdrawMethodViews")
    public final List<WithdrawInitMethodOption> getWithdrawMethodViews() {
        return this.withdrawMethodViews;
    }
}
