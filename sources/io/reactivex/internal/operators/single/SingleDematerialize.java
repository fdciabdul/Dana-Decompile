package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes9.dex */
public final class SingleDematerialize<T, R> extends Maybe<R> {
    final Function<? super T, Notification<R>> BuiltInFictitiousFunctionClassFactory;
    final Single<T> PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        this.PlaceComponentResult.MyBillsEntityDataFactory((SingleObserver) new DematerializeObserver(maybeObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {
        final Function<? super T, Notification<R>> BuiltInFictitiousFunctionClassFactory;
        final MaybeObserver<? super R> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;

        DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.MyBillsEntityDataFactory = maybeObserver;
            this.BuiltInFictitiousFunctionClassFactory = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                Notification notification = (Notification) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(t), "The selector returned a null Notification");
                Object obj = (Object) false;
                if (notification.getAuthRequestContext()) {
                    MaybeObserver<? super R> maybeObserver = this.MyBillsEntityDataFactory;
                    Object obj2 = notification.MyBillsEntityDataFactory;
                    boolean z = obj;
                    if (obj2 != null) {
                        z = obj;
                        if (!NotificationLite.isError(obj2)) {
                            z = (Object) notification.MyBillsEntityDataFactory;
                        }
                    }
                    maybeObserver.onSuccess((Object) z);
                } else if (notification.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.MyBillsEntityDataFactory.onComplete();
                } else {
                    MaybeObserver<? super R> maybeObserver2 = this.MyBillsEntityDataFactory;
                    Object obj3 = notification.MyBillsEntityDataFactory;
                    Throwable th = obj;
                    if (NotificationLite.isError(obj3)) {
                        th = NotificationLite.getError(obj3);
                    }
                    maybeObserver2.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.MyBillsEntityDataFactory.onError(th2);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }
    }
}
