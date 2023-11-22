package id.dana.domain.autoroute.interactor;

import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/autoroute/model/AutoRouteInit;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/autoroute/repository/AutoRouteRepository;", "autoRouteRepository", "Lid/dana/domain/autoroute/repository/AutoRouteRepository;", "<init>", "(Lid/dana/domain/autoroute/repository/AutoRouteRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAutoRouteInitialSetting extends BaseUseCase<AutoRouteInit, NoParams> {
    private final AutoRouteRepository autoRouteRepository;

    @Inject
    public GetAutoRouteInitialSetting(AutoRouteRepository autoRouteRepository) {
        Intrinsics.checkNotNullParameter(autoRouteRepository, "");
        this.autoRouteRepository = autoRouteRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<AutoRouteInit> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<AutoRouteInit> doOnNext = this.autoRouteRepository.getInitialSetting(true).doOnNext(new Consumer() { // from class: id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetAutoRouteInitialSetting.m2248buildUseCase$lambda0(GetAutoRouteInitialSetting.this, (AutoRouteInit) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final void m2248buildUseCase$lambda0(GetAutoRouteInitialSetting getAutoRouteInitialSetting, AutoRouteInit autoRouteInit) {
        Intrinsics.checkNotNullParameter(getAutoRouteInitialSetting, "");
        AutoRouteRepository autoRouteRepository = getAutoRouteInitialSetting.autoRouteRepository;
        Boolean autorouteAssetExist = autoRouteInit.getAutorouteAssetExist();
        autoRouteRepository.saveAutoRouteAssetState(autorouteAssetExist != null ? autorouteAssetExist.booleanValue() : false);
    }
}
