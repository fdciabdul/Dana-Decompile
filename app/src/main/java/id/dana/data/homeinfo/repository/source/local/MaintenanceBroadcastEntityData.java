package id.dana.data.homeinfo.repository.source.local;

import id.dana.data.homeinfo.repository.source.MaintenanceBroadcastRepository;
import id.dana.domain.maintenance.model.BroadcastSavingStateResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastEntityData;", "Lid/dana/data/homeinfo/repository/source/MaintenanceBroadcastRepository;", "", "lastDismissedBroadcast", "Lio/reactivex/Observable;", "Lid/dana/domain/maintenance/model/BroadcastSavingStateResult;", "getBroadcastSavingState", "(Ljava/lang/String;)Lio/reactivex/Observable;", "setBroadcastSavingState", "Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastPreference;", "maintenanceBroadcastPreference", "Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastPreference;", "<init>", "(Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MaintenanceBroadcastEntityData implements MaintenanceBroadcastRepository {
    private final MaintenanceBroadcastPreference maintenanceBroadcastPreference;

    @Inject
    public MaintenanceBroadcastEntityData(MaintenanceBroadcastPreference maintenanceBroadcastPreference) {
        Intrinsics.checkNotNullParameter(maintenanceBroadcastPreference, "");
        this.maintenanceBroadcastPreference = maintenanceBroadcastPreference;
    }

    @Override // id.dana.data.homeinfo.repository.source.MaintenanceBroadcastRepository
    public final Observable<BroadcastSavingStateResult> setBroadcastSavingState(String lastDismissedBroadcast) {
        Intrinsics.checkNotNullParameter(lastDismissedBroadcast, "");
        if (lastDismissedBroadcast.length() > 0) {
            this.maintenanceBroadcastPreference.saveLastDismissedBroadcast(lastDismissedBroadcast);
        }
        Observable<BroadcastSavingStateResult> just = Observable.just(new BroadcastSavingStateResult(true));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.homeinfo.repository.source.MaintenanceBroadcastRepository
    public final Observable<BroadcastSavingStateResult> getBroadcastSavingState(String lastDismissedBroadcast) {
        Intrinsics.checkNotNullParameter(lastDismissedBroadcast, "");
        Observable<BroadcastSavingStateResult> just = Observable.just(new BroadcastSavingStateResult(!Intrinsics.areEqual(this.maintenanceBroadcastPreference.getLastDismissedBroadcast(), lastDismissedBroadcast)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
