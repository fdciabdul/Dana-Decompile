package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes6.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {
    AppendOnlyLinkedArrayList<Object> BuiltInFictitiousFunctionClassFactory;
    volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Observer<? super T> PlaceComponentResult;
    final boolean getAuthRequestContext;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, (byte) 0);
    }

    private SerializedObserver(Observer<? super T> observer, byte b) {
        this.PlaceComponentResult = observer;
        this.getAuthRequestContext = false;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, disposable)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = disposable;
            this.PlaceComponentResult.onSubscribe(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.isDisposed();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        if (t == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            if (this.MyBillsEntityDataFactory) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.BuiltInFictitiousFunctionClassFactory;
                if (appendOnlyLinkedArrayList2 == null) {
                    appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>();
                    this.BuiltInFictitiousFunctionClassFactory = appendOnlyLinkedArrayList2;
                }
                appendOnlyLinkedArrayList2.getAuthRequestContext(NotificationLite.next(t));
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onNext(t);
            do {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.BuiltInFictitiousFunctionClassFactory;
                    if (appendOnlyLinkedArrayList == null) {
                        this.MyBillsEntityDataFactory = false;
                        return;
                    }
                    this.BuiltInFictitiousFunctionClassFactory = null;
                }
            } while (!appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory((Observer<? super T>) this.PlaceComponentResult));
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                z = true;
            } else if (this.MyBillsEntityDataFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.BuiltInFictitiousFunctionClassFactory;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.BuiltInFictitiousFunctionClassFactory = appendOnlyLinkedArrayList;
                }
                Object error = NotificationLite.error(th);
                if (this.getAuthRequestContext) {
                    appendOnlyLinkedArrayList.getAuthRequestContext(error);
                } else {
                    appendOnlyLinkedArrayList.PlaceComponentResult[0] = error;
                }
                return;
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.MyBillsEntityDataFactory = true;
            }
            if (z) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.PlaceComponentResult.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            if (this.MyBillsEntityDataFactory) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.BuiltInFictitiousFunctionClassFactory;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.BuiltInFictitiousFunctionClassFactory = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.complete());
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onComplete();
        }
    }
}
