package id.dana.biometric.domain.interactor;

import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/domain/interactor/PageEndAndZip;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/biometric/domain/model/BiometricDataSize;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "PlaceComponentResult", "Lid/dana/biometric/domain/RiskTrackerRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/biometric/domain/RiskTrackerRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PageEndAndZip extends BaseUseCase<BiometricDataSize, NoParams> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final RiskTrackerRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<BiometricDataSize> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable flatMap = this.getAuthRequestContext.onPageEndAndZip().flatMap(new Function() { // from class: id.dana.biometric.domain.interactor.PageEndAndZip$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PageEndAndZip.MyBillsEntityDataFactory(PageEndAndZip.this, (BiometricDataSize) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public PageEndAndZip(RiskTrackerRepository riskTrackerRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerRepository, "");
        this.getAuthRequestContext = riskTrackerRepository;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(PageEndAndZip pageEndAndZip, BiometricDataSize biometricDataSize) {
        Intrinsics.checkNotNullParameter(pageEndAndZip, "");
        Intrinsics.checkNotNullParameter(biometricDataSize, "");
        pageEndAndZip.getAuthRequestContext.clearData();
        return Observable.just(biometricDataSize);
    }
}
