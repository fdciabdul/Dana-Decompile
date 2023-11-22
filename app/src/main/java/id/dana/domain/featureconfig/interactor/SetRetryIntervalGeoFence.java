package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence;", "Lid/dana/domain/UseCase;", "", "Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/geofence/GeoFenceRepository;", "geoFenceRepository", "Lid/dana/domain/geofence/GeoFenceRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/geofence/GeoFenceRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetRetryIntervalGeoFence extends UseCase<Boolean, Params> {
    private final GeoFenceRepository geoFenceRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SetRetryIntervalGeoFence(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(geoFenceRepository, "");
        this.geoFenceRepository = geoFenceRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<Boolean> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.geoFenceRepository.setRetryInterval(params.getMaxRetry());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params;", "", "", "maxRetry", "I", "getMaxRetry$domain_productionRelease", "()I", "setMaxRetry$domain_productionRelease", "(I)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int maxRetry;

        public /* synthetic */ Params(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params$Companion;", "", "", "maxRetry", "Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params;", "forRetryInterval", "(I)Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forRetryInterval(int maxRetry) {
                return new Params(maxRetry, null);
            }
        }

        private Params(int i) {
            this.maxRetry = i;
        }

        @JvmName(name = "getMaxRetry$domain_productionRelease")
        /* renamed from: getMaxRetry$domain_productionRelease  reason: from getter */
        public final int getMaxRetry() {
            return this.maxRetry;
        }

        @JvmName(name = "setMaxRetry$domain_productionRelease")
        public final void setMaxRetry$domain_productionRelease(int i) {
            this.maxRetry = i;
        }
    }
}
