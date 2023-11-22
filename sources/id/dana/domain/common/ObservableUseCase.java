package id.dana.domain.common;

import id.dana.domain.PostExecutionThread;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Deprecated
/* loaded from: classes4.dex */
public abstract class ObservableUseCase<T, P> {
    private final PostExecutionThread postExecutionThread;
    private final ThreadExecutor threadExecutor;

    protected abstract Observable<T> buildUseCaseObservable(P p);

    public ObservableUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public Observable<T> execute(P p) {
        return buildUseCaseObservable(p).subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor)).observeOn(this.postExecutionThread.getScheduler());
    }

    public Observable<T> execute() {
        return execute(null);
    }
}
