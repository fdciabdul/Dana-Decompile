package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes6.dex */
final class CallExecuteObservable<T> extends Observable<Response<T>> {
    private final Call<T> MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(Call<T> call) {
        this.MyBillsEntityDataFactory = call;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z;
        Call<T> BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        CallDisposable callDisposable = new CallDisposable(BuiltInFictitiousFunctionClassFactory);
        observer.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
            return;
        }
        try {
            Response<T> PlaceComponentResult = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            if (!callDisposable.isDisposed()) {
                observer.onNext(PlaceComponentResult);
            }
            if (callDisposable.isDisposed()) {
                return;
            }
            try {
                observer.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                Exceptions.MyBillsEntityDataFactory(th);
                if (z) {
                    RxJavaPlugins.PlaceComponentResult(th);
                } else if (callDisposable.isDisposed()) {
                } else {
                    try {
                        observer.onError(th);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    /* loaded from: classes6.dex */
    static final class CallDisposable implements Disposable {
        private final Call<?> KClassImpl$Data$declaredNonStaticMembers$2;
        private volatile boolean getAuthRequestContext;

        CallDisposable(Call<?> call) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = call;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext;
        }
    }
}
