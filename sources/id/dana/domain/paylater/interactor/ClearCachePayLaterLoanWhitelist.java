package id.dana.domain.paylater.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.services.ServicesRepository;
import io.reactivex.Completable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/paylater/interactor/ClearCachePayLaterLoanWhitelist;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Completable;", "Lid/dana/domain/paylater/PaylaterRepository;", "payLaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/paylater/PaylaterRepository;Lid/dana/domain/services/ServicesRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClearCachePayLaterLoanWhitelist extends CompletableUseCase<NoParams> {
    private final PaylaterRepository payLaterRepository;
    private final ServicesRepository servicesRepository;

    @Inject
    public ClearCachePayLaterLoanWhitelist(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.payLaterRepository = paylaterRepository;
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Completable ignoreElements = this.payLaterRepository.clearCachePayLaterLoanWhitelist().zipWith(this.servicesRepository.resetInMemoryCategoryHighlightedFeature(), new BiFunction() { // from class: id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Unit m2386buildUseCase$lambda0;
                m2386buildUseCase$lambda0 = ClearCachePayLaterLoanWhitelist.m2386buildUseCase$lambda0((Boolean) obj, (Boolean) obj2);
                return m2386buildUseCase$lambda0;
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Unit m2386buildUseCase$lambda0(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Unit.INSTANCE;
    }
}
