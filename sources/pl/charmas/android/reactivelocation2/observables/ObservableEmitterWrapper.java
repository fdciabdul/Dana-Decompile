package pl.charmas.android.reactivelocation2.observables;

import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: classes9.dex */
public class ObservableEmitterWrapper<T> implements Observer<T> {
    private final ObservableEmitter<T> getAuthRequestContext;

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }

    public ObservableEmitterWrapper(ObservableEmitter<T> observableEmitter) {
        this.getAuthRequestContext = observableEmitter;
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (this.getAuthRequestContext.isDisposed()) {
            return;
        }
        this.getAuthRequestContext.onNext(t);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.getAuthRequestContext.isDisposed()) {
            return;
        }
        this.getAuthRequestContext.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.getAuthRequestContext.isDisposed()) {
            return;
        }
        this.getAuthRequestContext.onComplete();
    }
}
