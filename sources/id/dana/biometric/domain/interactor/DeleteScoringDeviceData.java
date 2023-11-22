package id.dana.biometric.domain.interactor;

import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/domain/interactor/DeleteScoringDeviceData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "getAuthRequestContext", "Lid/dana/biometric/domain/RiskTrackerRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/biometric/domain/RiskTrackerRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeleteScoringDeviceData extends BaseUseCase<Unit, NoParams> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final RiskTrackerRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Unit> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.PlaceComponentResult.clearData();
    }

    @Inject
    public DeleteScoringDeviceData(RiskTrackerRepository riskTrackerRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerRepository, "");
        this.PlaceComponentResult = riskTrackerRepository;
    }
}
