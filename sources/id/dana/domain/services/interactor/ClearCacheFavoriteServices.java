package id.dana.domain.services.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.services.ServicesRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/services/interactor/ClearCacheFavoriteServices;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Completable;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/services/ServicesRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClearCacheFavoriteServices extends CompletableUseCase<NoParams> {
    private final ServicesRepository servicesRepository;

    @Inject
    public ClearCacheFavoriteServices(ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Completable ignoreElements = Observable.zip(this.servicesRepository.clearCacheFavoriteServices(), this.servicesRepository.resetInMemoryFavoriteServiceCache(), this.servicesRepository.resetInMemoryCategoryHighlightedFeature(), new Function3() { // from class: id.dana.domain.services.interactor.ClearCacheFavoriteServices$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Unit m2493buildUseCase$lambda0;
                m2493buildUseCase$lambda0 = ClearCacheFavoriteServices.m2493buildUseCase$lambda0((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
                return m2493buildUseCase$lambda0;
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Unit m2493buildUseCase$lambda0(Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        return Unit.INSTANCE;
    }
}
