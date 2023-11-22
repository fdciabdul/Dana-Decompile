package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

/* loaded from: classes6.dex */
final class ResultObservable<T> extends Observable<Result<T>> {
    private final Observable<Response<T>> MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultObservable(Observable<Response<T>> observable) {
        this.MyBillsEntityDataFactory = observable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Result<T>> observer) {
        this.MyBillsEntityDataFactory.subscribe(new ResultObserver(observer));
    }

    /* loaded from: classes6.dex */
    static class ResultObserver<R> implements Observer<Response<R>> {
        private final Observer<? super Result<R>> getAuthRequestContext;

        @Override // io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            this.getAuthRequestContext.onNext(Result.PlaceComponentResult((Response) obj));
        }

        ResultObserver(Observer<? super Result<R>> observer) {
            this.getAuthRequestContext = observer;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                this.getAuthRequestContext.onNext(Result.PlaceComponentResult(th));
                this.getAuthRequestContext.onComplete();
            } catch (Throwable th2) {
                try {
                    this.getAuthRequestContext.onError(th2);
                } catch (Throwable th3) {
                    Exceptions.MyBillsEntityDataFactory(th3);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.getAuthRequestContext.onComplete();
        }
    }
}
