package id.dana.domain.account.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/account/interactor/SetBalanceVisibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/account/interactor/SetBalanceVisibility$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/account/interactor/SetBalanceVisibility$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "<init>", "(Lid/dana/domain/account/AccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetBalanceVisibility extends BaseUseCase<Boolean, Params> {
    private final AccountRepository accountRepository;

    @Inject
    public SetBalanceVisibility(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> balanceVisibility = this.accountRepository.setBalanceVisibility(Boolean.valueOf(params.getNewState()), params.getBalanceType());
        Intrinsics.checkNotNullExpressionValue(balanceVisibility, "");
        return balanceVisibility;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/domain/account/interactor/SetBalanceVisibility$Params;", "", "", "balanceType", "Ljava/lang/String;", "getBalanceType", "()Ljava/lang/String;", "setBalanceType", "(Ljava/lang/String;)V", "", "newState", "Z", "getNewState", "()Z", "setNewState", "(Z)V", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private String balanceType;
        private boolean newState;

        public Params(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.newState = z;
            this.balanceType = str;
        }

        @JvmName(name = "getNewState")
        public final boolean getNewState() {
            return this.newState;
        }

        @JvmName(name = "setNewState")
        public final void setNewState(boolean z) {
            this.newState = z;
        }

        @JvmName(name = "getBalanceType")
        public final String getBalanceType() {
            return this.balanceType;
        }

        @JvmName(name = "setBalanceType")
        public final void setBalanceType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.balanceType = str;
        }
    }
}
