package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> MyBillsEntityDataFactory;

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.MyBillsEntityDataFactory = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        this.getAuthRequestContext.subscribe(new DematerializeObserver(observer, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Function<? super T, ? extends Notification<R>> PlaceComponentResult;
        Disposable getAuthRequestContext;

        DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.PlaceComponentResult = function;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            Object obj = (Object) false;
            if (this.MyBillsEntityDataFactory) {
                if (t instanceof Notification) {
                    Notification notification = (Notification) t;
                    if (notification.PlaceComponentResult()) {
                        Object obj2 = notification.MyBillsEntityDataFactory;
                        Throwable th = obj;
                        if (NotificationLite.isError(obj2)) {
                            th = NotificationLite.getError(obj2);
                        }
                        RxJavaPlugins.PlaceComponentResult(th);
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t), "The selector returned a null Notification");
                if (notification2.PlaceComponentResult()) {
                    this.getAuthRequestContext.dispose();
                    Object obj3 = notification2.MyBillsEntityDataFactory;
                    Throwable th2 = obj;
                    if (NotificationLite.isError(obj3)) {
                        th2 = NotificationLite.getError(obj3);
                    }
                    onError(th2);
                } else if (notification2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.getAuthRequestContext.dispose();
                    onComplete();
                } else {
                    Observer<? super R> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Object obj4 = notification2.MyBillsEntityDataFactory;
                    boolean z = obj;
                    if (obj4 != null) {
                        z = obj;
                        if (!NotificationLite.isError(obj4)) {
                            z = (Object) notification2.MyBillsEntityDataFactory;
                        }
                    }
                    observer.onNext((Object) z);
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                this.getAuthRequestContext.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
