package id.dana.domain.services.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/services/interactor/GetFavoriteServiceWithCacheFirst;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/services/ServicesRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetFavoriteServiceWithCacheFirst extends BaseUseCase<ThirdPartyCategoryService, NoParams> {
    private final ServicesRepository servicesRepository;

    @Inject
    public GetFavoriteServiceWithCacheFirst(ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ThirdPartyCategoryService> buildUseCase(NoParams params) {
        Observable<ThirdPartyCategoryService> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(params, "");
        ThirdPartyCategoryService inMemoryFavoriteServiceCache = this.servicesRepository.getInMemoryFavoriteServiceCache();
        Observable filter = inMemoryFavoriteServiceCache != null ? Observable.just(inMemoryFavoriteServiceCache).filter(new Predicate() { // from class: id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m2496buildUseCase$lambda1$lambda0;
                m2496buildUseCase$lambda1$lambda0 = GetFavoriteServiceWithCacheFirst.m2496buildUseCase$lambda1$lambda0((ThirdPartyCategoryService) obj);
                return m2496buildUseCase$lambda1$lambda0;
            }
        }) : null;
        if (filter == null) {
            filter = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(filter, "");
        }
        Observable<ThirdPartyCategoryService> doOnNext = this.servicesRepository.getFavoriteServicesCache(false).filter(new Predicate() { // from class: id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m2497buildUseCase$lambda2;
                m2497buildUseCase$lambda2 = GetFavoriteServiceWithCacheFirst.m2497buildUseCase$lambda2((ThirdPartyCategoryService) obj);
                return m2497buildUseCase$lambda2;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetFavoriteServiceWithCacheFirst.m2498buildUseCase$lambda3(GetFavoriteServiceWithCacheFirst.this, (ThirdPartyCategoryService) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        Observable<ThirdPartyCategoryService> favoriteServiceFromRemoteSource = this.servicesRepository.getFavoriteServiceFromRemoteSource();
        Intrinsics.checkNotNullExpressionValue(favoriteServiceFromRemoteSource, "");
        Single firstOrError = Observable.concat(filter, doOnNext, favoriteServiceFromRemoteSource).firstOrError();
        if (firstOrError instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) firstOrError).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(firstOrError));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m2496buildUseCase$lambda1$lambda0(ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
        List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService.getThirdPartyServices();
        return !(thirdPartyServices == null || thirdPartyServices.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final boolean m2497buildUseCase$lambda2(ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
        List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService.getThirdPartyServices();
        return !(thirdPartyServices == null || thirdPartyServices.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final void m2498buildUseCase$lambda3(GetFavoriteServiceWithCacheFirst getFavoriteServiceWithCacheFirst, ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(getFavoriteServiceWithCacheFirst, "");
        getFavoriteServiceWithCacheFirst.servicesRepository.setInMemoryFavoriteServiceCache(thirdPartyCategoryService);
    }
}
