package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

/* loaded from: classes6.dex */
final class BodyObservable<T> extends Observable<T> {
    private final Observable<Response<T>> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyObservable(Observable<Response<T>> observable) {
        this.getAuthRequestContext = observable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new BodyObserver(observer));
    }

    /* loaded from: classes6.dex */
    static class BodyObserver<R> implements Observer<Response<R>> {
        private final Observer<? super R> KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean PlaceComponentResult;

        @Override // io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            Response response = (Response) obj;
            if (response.MyBillsEntityDataFactory()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext((T) response.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            this.PlaceComponentResult = true;
            HttpException httpException = new HttpException(response);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(httpException);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(httpException, th));
            }
        }

        BodyObserver(Observer<? super R> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.PlaceComponentResult) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.PlaceComponentResult(assertionError);
        }
    }
}
