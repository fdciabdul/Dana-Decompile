package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes6.dex */
public final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    final Subject<T> KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    AppendOnlyLinkedArrayList<Object> getAuthRequestContext;

    public SerializedSubject(Subject<T> subject) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = subject;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(observer);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            synchronized (this) {
                if (!this.BuiltInFictitiousFunctionClassFactory) {
                    if (this.MyBillsEntityDataFactory) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.getAuthRequestContext = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.MyBillsEntityDataFactory = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(disposable);
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.MyBillsEntityDataFactory) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.getAuthRequestContext = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.next(t));
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.BuiltInFictitiousFunctionClassFactory) {
                z = true;
            } else {
                this.BuiltInFictitiousFunctionClassFactory = true;
                if (this.MyBillsEntityDataFactory) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                        this.getAuthRequestContext = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.PlaceComponentResult[0] = NotificationLite.error(th);
                    return;
                }
                this.MyBillsEntityDataFactory = true;
            }
            if (z) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.MyBillsEntityDataFactory) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.getAuthRequestContext = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.complete());
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    this.MyBillsEntityDataFactory = false;
                    return;
                }
                this.getAuthRequestContext = null;
            }
            appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory((AppendOnlyLinkedArrayList.NonThrowingPredicate<? super Object>) this);
        }
    }

    @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
    public final boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
