package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* loaded from: classes2.dex */
public final class ObservableFromArray<T> extends Observable<T> {
    final T[] MyBillsEntityDataFactory;

    public ObservableFromArray(T[] tArr) {
        this.MyBillsEntityDataFactory = tArr;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.MyBillsEntityDataFactory);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.getAuthRequestContext) {
            return;
        }
        T[] tArr = fromArrayDisposable.KClassImpl$Data$declaredNonStaticMembers$2;
        int length = tArr.length;
        for (int i = 0; i < length && !fromArrayDisposable.isDisposed(); i++) {
            T t = tArr[i];
            if (t == null) {
                Observer<? super T> observer2 = fromArrayDisposable.MyBillsEntityDataFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("The element at index ");
                sb.append(i);
                sb.append(" is null");
                observer2.onError(new NullPointerException(sb.toString()));
                return;
            }
            fromArrayDisposable.MyBillsEntityDataFactory.onNext(t);
        }
        if (fromArrayDisposable.isDisposed()) {
            return;
        }
        fromArrayDisposable.MyBillsEntityDataFactory.onComplete();
    }

    /* loaded from: classes6.dex */
    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        volatile boolean BuiltInFictitiousFunctionClassFactory;
        final T[] KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super T> MyBillsEntityDataFactory;
        int PlaceComponentResult;
        boolean getAuthRequestContext;

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.MyBillsEntityDataFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = tArr;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.getAuthRequestContext = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            int i = this.PlaceComponentResult;
            T[] tArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i != tArr.length) {
                this.PlaceComponentResult = i + 1;
                return (T) ObjectHelper.PlaceComponentResult(tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.PlaceComponentResult == this.KClassImpl$Data$declaredNonStaticMembers$2.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
