package id.dana.domain.geofence.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/geofence/interactor/PoiNotify;", "Lid/dana/domain/UseCase;", "", "", "", "listPoiId", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/geofence/GeoFenceRepository;", "geoFenceRepository", "Lid/dana/domain/geofence/GeoFenceRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/geofence/GeoFenceRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PoiNotify extends UseCase<Boolean, List<? extends String>> {
    private final GeoFenceRepository geoFenceRepository;

    @Override // id.dana.domain.UseCase
    public final /* bridge */ /* synthetic */ Observable<Boolean> buildUseCaseObservable(List<? extends String> list) {
        return buildUseCaseObservable2((List<String>) list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PoiNotify(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(geoFenceRepository, "");
        this.geoFenceRepository = geoFenceRepository;
    }

    /* renamed from: buildUseCaseObservable  reason: avoid collision after fix types in other method */
    protected final Observable<Boolean> buildUseCaseObservable2(List<String> listPoiId) {
        Intrinsics.checkNotNullParameter(listPoiId, "");
        return this.geoFenceRepository.notifyPOIs(listPoiId);
    }
}
