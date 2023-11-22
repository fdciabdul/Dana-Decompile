package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.common.ObservableUseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/IsCScanBEnabled;", "Lid/dana/domain/common/ObservableUseCase;", "", "Ljava/lang/Void;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Ljava/lang/Void;)Lio/reactivex/Observable;", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "globalNetworkRepository", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/globalnetwork/GlobalNetworkRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IsCScanBEnabled extends ObservableUseCase<Boolean, Void> {
    private final GlobalNetworkRepository globalNetworkRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public IsCScanBEnabled(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(globalNetworkRepository, "");
        this.globalNetworkRepository = globalNetworkRepository;
    }

    @Override // id.dana.domain.common.ObservableUseCase
    public final Observable<Boolean> buildUseCaseObservable(Void params) {
        Observable<Boolean> isCScanBEnabled = this.globalNetworkRepository.isCScanBEnabled();
        Intrinsics.checkNotNullExpressionValue(isCScanBEnabled, "");
        return isCScanBEnabled;
    }
}
