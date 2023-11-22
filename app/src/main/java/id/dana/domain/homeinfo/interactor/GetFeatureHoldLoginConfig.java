package id.dana.domain.homeinfo.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/homeinfo/interactor/GetFeatureHoldLoginConfig;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lkotlin/Unit;)Lio/reactivex/Completable;", "Lid/dana/domain/homeinfo/repository/HomeConfigRepository;", "homeConfigRepository", "Lid/dana/domain/homeinfo/repository/HomeConfigRepository;", "<init>", "(Lid/dana/domain/homeinfo/repository/HomeConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetFeatureHoldLoginConfig extends CompletableUseCase<Unit> {
    private final HomeConfigRepository homeConfigRepository;

    @Inject
    public GetFeatureHoldLoginConfig(HomeConfigRepository homeConfigRepository) {
        Intrinsics.checkNotNullParameter(homeConfigRepository, "");
        this.homeConfigRepository = homeConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Unit params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeConfigRepository.getFeatureHoldLoginConfig();
    }
}
