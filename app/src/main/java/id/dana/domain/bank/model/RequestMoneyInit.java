package id.dana.domain.bank.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/bank/model/RequestMoneyInit;", "", "", "maxBankAccount", "I", "getMaxBankAccount", "()I", "", "Lid/dana/domain/bank/model/UserBank;", "userBanks", "Ljava/util/List;", "getUserBanks", "()Ljava/util/List;", "<init>", "(ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestMoneyInit {
    private final int maxBankAccount;
    private final List<UserBank> userBanks;

    public RequestMoneyInit(int i, List<UserBank> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.maxBankAccount = i;
        this.userBanks = list;
    }

    @JvmName(name = "getMaxBankAccount")
    public final int getMaxBankAccount() {
        return this.maxBankAccount;
    }

    @JvmName(name = "getUserBanks")
    public final List<UserBank> getUserBanks() {
        return this.userBanks;
    }
}
