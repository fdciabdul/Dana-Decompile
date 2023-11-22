package id.dana.domain.paylater.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.paylater.model.PayLaterLoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/paylater/interactor/GetPayLaterCacheLoanWhitelist;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/PaylaterRepository;", "payLaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "<init>", "(Lid/dana/domain/paylater/PaylaterRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPayLaterCacheLoanWhitelist extends BaseUseCase<PayLaterLoanWhitelist, NoParams> {
    private final PaylaterRepository payLaterRepository;

    @Inject
    public GetPayLaterCacheLoanWhitelist(PaylaterRepository paylaterRepository) {
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        this.payLaterRepository = paylaterRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PayLaterLoanWhitelist> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<PayLaterLoanWhitelist> zip = Observable.zip(this.payLaterRepository.getPayLaterCacheWhitelistValue(), this.payLaterRepository.getPayLaterLoanStatus(), this.payLaterRepository.getPaylaterCicilConfig(), new Function3() { // from class: id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                PayLaterLoanWhitelist m2387buildUseCase$lambda0;
                m2387buildUseCase$lambda0 = GetPayLaterCacheLoanWhitelist.m2387buildUseCase$lambda0((LoanWhitelist) obj, (List) obj2, (PaylaterCicilMethodConfig) obj3);
                return m2387buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final PayLaterLoanWhitelist m2387buildUseCase$lambda0(LoanWhitelist loanWhitelist, List list, PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        return new PayLaterLoanWhitelist(loanWhitelist, list, paylaterCicilMethodConfig);
    }
}
