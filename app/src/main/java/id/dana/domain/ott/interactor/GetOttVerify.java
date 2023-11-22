package id.dana.domain.ott.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.ott.OttVerifyResult;
import id.dana.domain.ott.repository.OttRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/ott/interactor/GetOttVerify;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/ott/OttVerifyResult;", "", "ottValue", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/ott/repository/OttRepository;", "ottRepository", "Lid/dana/domain/ott/repository/OttRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/ott/repository/OttRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetOttVerify extends UseCase<OttVerifyResult, String> {
    private final OttRepository ottRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetOttVerify(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OttRepository ottRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(ottRepository, "");
        this.ottRepository = ottRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<OttVerifyResult> buildUseCaseObservable(String ottValue) {
        Intrinsics.checkNotNullParameter(ottValue, "");
        return this.ottRepository.getOttVerify(ottValue);
    }
}
