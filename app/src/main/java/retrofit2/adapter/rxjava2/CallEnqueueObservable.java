package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes6.dex */
final class CallEnqueueObservable<T> extends Observable<Response<T>> {
    private final Call<T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueObservable(Call<T> call) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = call;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Response<T>> observer) {
        Call<T> BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        CallCallback callCallback = new CallCallback(BuiltInFictitiousFunctionClassFactory, observer);
        observer.onSubscribe(callCallback);
        if (callCallback.isDisposed()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(callCallback);
    }

    /* loaded from: classes6.dex */
    static final class CallCallback<T> implements Disposable, Callback<T> {
        private volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Observer<? super Response<T>> MyBillsEntityDataFactory;
        private final Call<?> PlaceComponentResult;
        boolean getAuthRequestContext = false;

        CallCallback(Call<?> call, Observer<? super Response<T>> observer) {
            this.PlaceComponentResult = call;
            this.MyBillsEntityDataFactory = observer;
        }

        @Override // retrofit2.Callback
        public final void PlaceComponentResult(Call<T> call, Response<T> response) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.onNext(response);
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                this.getAuthRequestContext = true;
                this.MyBillsEntityDataFactory.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                if (this.getAuthRequestContext) {
                    RxJavaPlugins.PlaceComponentResult(th);
                } else if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                } else {
                    try {
                        this.MyBillsEntityDataFactory.onError(th);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
                    }
                }
            }
        }

        @Override // retrofit2.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<T> call, Throwable th) {
            if (call.MyBillsEntityDataFactory()) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.onError(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.PlaceComponentResult.getAuthRequestContext();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
