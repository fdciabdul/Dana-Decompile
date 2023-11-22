package id.dana.base;

import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* loaded from: classes4.dex */
public abstract class BasePresenter implements DisposableHandler {
    private CompositeDisposable disposables;

    public void addDisposable(Disposable disposable) {
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.disposables);
        this.disposables.getAuthRequestContext(disposable);
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.disposables.dispose();
    }
}
