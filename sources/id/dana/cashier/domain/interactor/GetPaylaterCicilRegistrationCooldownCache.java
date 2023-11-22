package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.paylater.PaylaterRegistrationCooldownCache;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetPaylaterCicilRegistrationCooldownCache;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/paylater/PaylaterRegistrationCooldownCache;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPaylaterCicilRegistrationCooldownCache extends BaseUseCase<PaylaterRegistrationCooldownCache, NoParams> {
    private final CashierRepository cashierRepository;

    @Inject
    public GetPaylaterCicilRegistrationCooldownCache(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PaylaterRegistrationCooldownCache> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<PaylaterRegistrationCooldownCache> zip = Observable.zip(this.cashierRepository.getPaylaterCicilRegistrationCacheCooldownCount(), this.cashierRepository.getPaylaterCicilRegistrationCacheCooldownDelay(), new BiFunction() { // from class: id.dana.cashier.domain.interactor.GetPaylaterCicilRegistrationCooldownCache$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                PaylaterRegistrationCooldownCache m581buildUseCase$lambda0;
                m581buildUseCase$lambda0 = GetPaylaterCicilRegistrationCooldownCache.m581buildUseCase$lambda0((Integer) obj, (Long) obj2);
                return m581buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final PaylaterRegistrationCooldownCache m581buildUseCase$lambda0(Integer num, Long l) {
        Intrinsics.checkNotNullParameter(num, "");
        Intrinsics.checkNotNullParameter(l, "");
        return new PaylaterRegistrationCooldownCache(num.intValue(), l.longValue());
    }
}
