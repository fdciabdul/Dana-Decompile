package id.dana.domain.saving.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/saving/interactor/SaveSavingBalanceVisibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "isVisible", "Lio/reactivex/Observable;", "buildUseCase", "(Z)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "<init>", "(Lid/dana/domain/account/AccountRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveSavingBalanceVisibility extends BaseUseCase<Boolean, Boolean> {
    private static final String DANA_BALANCE_TYPE = "dana";
    private final AccountRepository accountRepository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Boolean bool) {
        return buildUseCase(bool.booleanValue());
    }

    @Inject
    public SaveSavingBalanceVisibility(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.accountRepository = accountRepository;
    }

    public final Observable<Boolean> buildUseCase(boolean isVisible) {
        Observable<Boolean> balanceVisibility = this.accountRepository.setBalanceVisibility(Boolean.valueOf(isVisible), "dana");
        Intrinsics.checkNotNullExpressionValue(balanceVisibility, "");
        return balanceVisibility;
    }
}
