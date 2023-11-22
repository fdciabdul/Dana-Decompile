package id.dana.domain;

import dagger.internal.Preconditions;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

@Deprecated
/* loaded from: classes2.dex */
public abstract class UseCase<T, P> {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final PostExecutionThread postExecutionThread;
    private final ThreadExecutor threadExecutor;

    protected abstract Observable<T> buildUseCaseObservable(P p);

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void execute(DisposableObserver<T> disposableObserver) {
        execute(disposableObserver, null);
    }

    public void execute(DisposableObserver<T> disposableObserver, P p) {
        Preconditions.getAuthRequestContext(disposableObserver);
        addDisposable((Disposable) buildUseCaseObservable(p).subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor)).observeOn(this.postExecutionThread.getScheduler()).subscribeWith(disposableObserver));
    }

    public void executeInBackground(DisposableObserver<T> disposableObserver) {
        executeInBackground(disposableObserver, null);
    }

    public void executeInBackground(DisposableObserver<T> disposableObserver, P p) {
        Preconditions.getAuthRequestContext(disposableObserver);
        addDisposable((Disposable) buildUseCaseObservable(p).subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor)).subscribeWith(disposableObserver));
    }

    public void dispose() {
        this.disposables.MyBillsEntityDataFactory();
    }

    private void addDisposable(Disposable disposable) {
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.disposables);
        this.disposables.getAuthRequestContext(disposable);
    }
}
