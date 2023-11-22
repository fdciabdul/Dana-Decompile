package id.dana.domain.account.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import io.reactivex.functions.Function4;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/account/interactor/GetAllBalanceVisibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "<init>", "(Lid/dana/domain/account/AccountRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAllBalanceVisibility extends BaseUseCase<List<? extends Boolean>, NoParams> {
    private final AccountRepository accountRepository;

    @Inject
    public GetAllBalanceVisibility(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<Boolean>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<Boolean>> zip = Observable.zip(this.accountRepository.getBalanceVisibility(), this.accountRepository.getGoalsBalanceVisibility(), this.accountRepository.getInvestmentBalanceVisibility(), this.accountRepository.getEmasBalanceVisibility(), new Function4() { // from class: id.dana.domain.account.interactor.GetAllBalanceVisibility$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                List m2244buildUseCase$lambda0;
                m2244buildUseCase$lambda0 = GetAllBalanceVisibility.m2244buildUseCase$lambda0((Boolean) obj, (Boolean) obj2, (Boolean) obj3, (Boolean) obj4);
                return m2244buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final List m2244buildUseCase$lambda0(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        Intrinsics.checkNotNullParameter(bool4, "");
        return CollectionsKt.listOf((Object[]) new Boolean[]{bool, bool2, bool3, bool4});
    }
}
