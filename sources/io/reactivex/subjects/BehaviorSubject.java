package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    long BuiltInFictitiousFunctionClassFactory;
    final Lock MyBillsEntityDataFactory;
    final AtomicReference<Throwable> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final ReadWriteLock getAuthRequestContext;
    public final AtomicReference<Object> getErrorConfigVersion;
    final AtomicReference<BehaviorDisposable<T>[]> lookAheadTest;
    final Lock scheduleImpl;
    private static final Object[] moveToNextValue = new Object[0];
    static final BehaviorDisposable[] PlaceComponentResult = new BehaviorDisposable[0];
    static final BehaviorDisposable[] KClassImpl$Data$declaredNonStaticMembers$2 = new BehaviorDisposable[0];

    @CheckReturnValue
    public static <T> BehaviorSubject<T> BuiltInFictitiousFunctionClassFactory() {
        return new BehaviorSubject<>();
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> getAuthRequestContext(T t) {
        return new BehaviorSubject<>(t);
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.getAuthRequestContext = reentrantReadWriteLock;
        this.MyBillsEntityDataFactory = reentrantReadWriteLock.readLock();
        this.scheduleImpl = reentrantReadWriteLock.writeLock();
        this.lookAheadTest = new AtomicReference<>(PlaceComponentResult);
        this.getErrorConfigVersion = new AtomicReference<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicReference<>();
    }

    private BehaviorSubject(T t) {
        this();
        this.getErrorConfigVersion.lazySet(ObjectHelper.PlaceComponentResult(t, "defaultValue is null"));
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (BuiltInFictitiousFunctionClassFactory(behaviorDisposable)) {
            if (behaviorDisposable.PlaceComponentResult) {
                PlaceComponentResult(behaviorDisposable);
                return;
            } else if (behaviorDisposable.PlaceComponentResult) {
                return;
            } else {
                synchronized (behaviorDisposable) {
                    if (behaviorDisposable.PlaceComponentResult) {
                        return;
                    }
                    if (behaviorDisposable.scheduleImpl) {
                        return;
                    }
                    BehaviorSubject<T> behaviorSubject = behaviorDisposable.getErrorConfigVersion;
                    Lock lock = behaviorSubject.MyBillsEntityDataFactory;
                    lock.lock();
                    behaviorDisposable.BuiltInFictitiousFunctionClassFactory = behaviorSubject.BuiltInFictitiousFunctionClassFactory;
                    Object obj = behaviorSubject.getErrorConfigVersion.get();
                    lock.unlock();
                    behaviorDisposable.MyBillsEntityDataFactory = obj != null;
                    behaviorDisposable.scheduleImpl = true;
                    if (obj == null || behaviorDisposable.test(obj)) {
                        return;
                    }
                    while (!behaviorDisposable.PlaceComponentResult) {
                        synchronized (behaviorDisposable) {
                            appendOnlyLinkedArrayList = behaviorDisposable.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (appendOnlyLinkedArrayList == null) {
                                behaviorDisposable.MyBillsEntityDataFactory = false;
                                return;
                            }
                            behaviorDisposable.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                        }
                        appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(behaviorDisposable);
                    }
                    return;
                }
            }
        }
        Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
        if (th == ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
            observer.onComplete();
        } else {
            observer.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        KClassImpl$Data$declaredNonStaticMembers$2(next);
        for (BehaviorDisposable<T> behaviorDisposable : this.lookAheadTest.get()) {
            behaviorDisposable.BuiltInFictitiousFunctionClassFactory(next, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, th)) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        Object error = NotificationLite.error(th);
        AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.lookAheadTest;
        BehaviorDisposable<T>[] behaviorDisposableArr = KClassImpl$Data$declaredNonStaticMembers$2;
        BehaviorDisposable<T>[] andSet = atomicReference.getAndSet(behaviorDisposableArr);
        if (andSet != behaviorDisposableArr) {
            KClassImpl$Data$declaredNonStaticMembers$2(error);
        }
        for (BehaviorDisposable<T> behaviorDisposable : andSet) {
            behaviorDisposable.BuiltInFictitiousFunctionClassFactory(error, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2)) {
            Object complete = NotificationLite.complete();
            AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.lookAheadTest;
            BehaviorDisposable<T>[] behaviorDisposableArr = KClassImpl$Data$declaredNonStaticMembers$2;
            BehaviorDisposable<T>[] andSet = atomicReference.getAndSet(behaviorDisposableArr);
            if (andSet != behaviorDisposableArr) {
                KClassImpl$Data$declaredNonStaticMembers$2(complete);
            }
            for (BehaviorDisposable<T> behaviorDisposable : andSet) {
                behaviorDisposable.BuiltInFictitiousFunctionClassFactory(complete, this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final boolean PlaceComponentResult() {
        return this.lookAheadTest.get().length != 0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Object obj = this.getErrorConfigVersion.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.lookAheadTest.get();
            if (behaviorDisposableArr == KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    final void PlaceComponentResult(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.lookAheadTest.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (behaviorDisposableArr[i] == behaviorDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = PlaceComponentResult;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, behaviorDisposableArr, behaviorDisposableArr2));
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        this.scheduleImpl.lock();
        this.BuiltInFictitiousFunctionClassFactory++;
        this.getErrorConfigVersion.lazySet(obj);
        this.scheduleImpl.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        long BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        AppendOnlyLinkedArrayList<Object> NetworkUserEntityData$$ExternalSyntheticLambda0;
        volatile boolean PlaceComponentResult;
        final Observer<? super T> getAuthRequestContext;
        final BehaviorSubject<T> getErrorConfigVersion;
        boolean scheduleImpl;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.getAuthRequestContext = observer;
            this.getErrorConfigVersion = behaviorSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.getErrorConfigVersion.PlaceComponentResult(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        final void BuiltInFictitiousFunctionClassFactory(Object obj, long j) {
            if (this.PlaceComponentResult) {
                return;
            }
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                synchronized (this) {
                    if (this.PlaceComponentResult) {
                        return;
                    }
                    if (this.BuiltInFictitiousFunctionClassFactory == j) {
                        return;
                    }
                    if (this.MyBillsEntityDataFactory) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.getAuthRequestContext(obj);
                        return;
                    }
                    this.scheduleImpl = true;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            return this.PlaceComponentResult || NotificationLite.accept(obj, this.getAuthRequestContext);
        }
    }
}
