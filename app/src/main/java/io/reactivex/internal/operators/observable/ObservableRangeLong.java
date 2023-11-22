package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class ObservableRangeLong extends Observable<Long> {
    private final long BuiltInFictitiousFunctionClassFactory;
    private final long KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableRangeLong(long j, long j2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.BuiltInFictitiousFunctionClassFactory = j2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j, j + this.BuiltInFictitiousFunctionClassFactory);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }

    /* loaded from: classes9.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.index = j;
            this.end = j2;
        }

        final void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Long> observer = this.downstream;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                observer.onNext(Long.valueOf(j2));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Long poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }
    }
}
