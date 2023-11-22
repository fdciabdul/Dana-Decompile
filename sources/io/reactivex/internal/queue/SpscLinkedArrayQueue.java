package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes6.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    static final int KClassImpl$Data$declaredNonStaticMembers$2 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object moveToNextValue = new Object();
    AtomicReferenceArray<Object> BuiltInFictitiousFunctionClassFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    AtomicReferenceArray<Object> PlaceComponentResult;
    final int getAuthRequestContext;
    final int lookAheadTest;
    long scheduleImpl;
    final AtomicLong getErrorConfigVersion = new AtomicLong();
    final AtomicLong MyBillsEntityDataFactory = new AtomicLong();

    public SpscLinkedArrayQueue(int i) {
        int BuiltInFictitiousFunctionClassFactory = Pow2.BuiltInFictitiousFunctionClassFactory(Math.max(8, i));
        int i2 = BuiltInFictitiousFunctionClassFactory - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(BuiltInFictitiousFunctionClassFactory + 1);
        this.PlaceComponentResult = atomicReferenceArray;
        this.lookAheadTest = i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.min(BuiltInFictitiousFunctionClassFactory / 4, KClassImpl$Data$declaredNonStaticMembers$2);
        this.BuiltInFictitiousFunctionClassFactory = atomicReferenceArray;
        this.getAuthRequestContext = i2;
        this.scheduleImpl = (long) (i2 - 1);
        this.getErrorConfigVersion.lazySet(0L);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.PlaceComponentResult;
        long j = this.getErrorConfigVersion.get();
        int i = this.lookAheadTest;
        int i2 = ((int) j) & i;
        if (j < this.scheduleImpl) {
            return getAuthRequestContext(atomicReferenceArray, t, j, i2);
        }
        long j2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + j;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            this.scheduleImpl = j2 - 1;
            return getAuthRequestContext(atomicReferenceArray, t, j, i2);
        }
        long j3 = j + 1;
        if (atomicReferenceArray.get(((int) j3) & i) == null) {
            return getAuthRequestContext(atomicReferenceArray, t, j, i2);
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.PlaceComponentResult = atomicReferenceArray2;
        this.scheduleImpl = (i + j) - 1;
        atomicReferenceArray2.lazySet(i2, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, moveToNextValue);
        this.getErrorConfigVersion.lazySet(j3);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.BuiltInFictitiousFunctionClassFactory;
        long j = this.MyBillsEntityDataFactory.get();
        int i = this.getAuthRequestContext;
        int i2 = ((int) j) & i;
        T t = (T) atomicReferenceArray.get(i2);
        boolean z = t == moveToNextValue;
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i2, null);
            this.MyBillsEntityDataFactory.lazySet(j + 1);
            return t;
        } else if (z) {
            int i3 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i3);
            atomicReferenceArray.lazySet(i3, null);
            this.BuiltInFictitiousFunctionClassFactory = atomicReferenceArray2;
            T t2 = (T) atomicReferenceArray2.get(i2);
            if (t2 != null) {
                atomicReferenceArray2.lazySet(i2, null);
                this.MyBillsEntityDataFactory.lazySet(j + 1);
            }
            return t2;
        } else {
            return null;
        }
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.BuiltInFictitiousFunctionClassFactory;
        long j = this.MyBillsEntityDataFactory.get();
        int i = this.getAuthRequestContext;
        int i2 = ((int) j) & i;
        T t = (T) atomicReferenceArray.get(i2);
        if (t == moveToNextValue) {
            int i3 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i3);
            atomicReferenceArray.lazySet(i3, null);
            this.BuiltInFictitiousFunctionClassFactory = atomicReferenceArray2;
            return (T) atomicReferenceArray2.get(i2);
        }
        return t;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final boolean PlaceComponentResult(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.PlaceComponentResult;
        long j = this.getErrorConfigVersion.get();
        int i = this.lookAheadTest;
        long j2 = 2 + j;
        if (atomicReferenceArray.get(((int) j2) & i) != null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.PlaceComponentResult = atomicReferenceArray2;
            int i2 = ((int) j) & i;
            atomicReferenceArray2.lazySet(i2 + 1, t2);
            atomicReferenceArray2.lazySet(i2, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, moveToNextValue);
            this.getErrorConfigVersion.lazySet(j2);
        } else {
            int i3 = ((int) j) & i;
            atomicReferenceArray.lazySet(i3 + 1, t2);
            atomicReferenceArray.lazySet(i3, t);
            this.getErrorConfigVersion.lazySet(j2);
        }
        return true;
    }

    private boolean getAuthRequestContext(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        atomicReferenceArray.lazySet(i, t);
        this.getErrorConfigVersion.lazySet(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return this.getErrorConfigVersion.get() == this.MyBillsEntityDataFactory.get();
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        long j = this.MyBillsEntityDataFactory.get();
        while (true) {
            long j2 = this.getErrorConfigVersion.get();
            long j3 = this.MyBillsEntityDataFactory.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }
}
