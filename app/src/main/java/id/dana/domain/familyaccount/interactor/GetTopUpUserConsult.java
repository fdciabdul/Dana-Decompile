package id.dana.domain.familyaccount.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.model.FamilyTopUpConsult;
import id.dana.domain.familyaccount.model.TopUpUserConsultResult;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u001a\u0012\b\u0012\u0006*\u00020\n0\n*\f\u0012\b\u0012\u0006*\u00020\n0\n0\u00050\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/familyaccount/interactor/GetTopUpUserConsult;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "topUpUserConsultResult", "Lid/dana/domain/user/CurrencyAmount;", "userBalance", "combineFamilyTopUpConsult", "(Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;Lid/dana/domain/user/CurrencyAmount;)Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;", "getTopUpUserConsultResult", "()Lio/reactivex/Observable;", "getUserBalance", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "familyAccountRepository", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/domain/familyaccount/FamilyAccountRepository;Lid/dana/domain/user/repository/UserRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetTopUpUserConsult extends BaseUseCase<FamilyTopUpConsult, NoParams> {
    private final FamilyAccountRepository familyAccountRepository;
    private final UserRepository userRepository;

    @Inject
    public GetTopUpUserConsult(FamilyAccountRepository familyAccountRepository, UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(familyAccountRepository, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.familyAccountRepository = familyAccountRepository;
        this.userRepository = userRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<FamilyTopUpConsult> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<FamilyTopUpConsult> zip = Observable.zip(getTopUpUserConsultResult(), getUserBalance(), new BiFunction() { // from class: id.dana.domain.familyaccount.interactor.GetTopUpUserConsult$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                FamilyTopUpConsult m2322buildUseCase$lambda0;
                m2322buildUseCase$lambda0 = GetTopUpUserConsult.m2322buildUseCase$lambda0(GetTopUpUserConsult.this, (TopUpUserConsultResult) obj, (CurrencyAmount) obj2);
                return m2322buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final FamilyTopUpConsult m2322buildUseCase$lambda0(GetTopUpUserConsult getTopUpUserConsult, TopUpUserConsultResult topUpUserConsultResult, CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(getTopUpUserConsult, "");
        Intrinsics.checkNotNullParameter(topUpUserConsultResult, "");
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        return getTopUpUserConsult.combineFamilyTopUpConsult(topUpUserConsultResult, currencyAmount);
    }

    private final Observable<TopUpUserConsultResult> getTopUpUserConsultResult() {
        return this.familyAccountRepository.getTopUpUserConsult();
    }

    private final Observable<CurrencyAmount> getUserBalance() {
        return this.userRepository.getBalance();
    }

    private final FamilyTopUpConsult combineFamilyTopUpConsult(TopUpUserConsultResult topUpUserConsultResult, CurrencyAmount userBalance) {
        return new FamilyTopUpConsult(topUpUserConsultResult, userBalance);
    }
}
