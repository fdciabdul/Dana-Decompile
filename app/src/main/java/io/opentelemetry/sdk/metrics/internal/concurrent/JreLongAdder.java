package io.opentelemetry.sdk.metrics.internal.concurrent;

import io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;

/* loaded from: classes6.dex */
final class JreLongAdder implements LongAdder {
    private final java.util.concurrent.atomic.LongAdder delegate = new java.util.concurrent.atomic.LongAdder();

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ void decrement() {
        add(-1L);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 double, still in use, count: 1, list:
          (r0v0 double) from 0x0004: RETURN (r0v0 double)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:81)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:446)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:95)
        */
    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ double doubleValue() {
        /*
            r2 = this;
            double r0 = io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder.CC.$default$doubleValue(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.metrics.internal.concurrent.JreLongAdder.doubleValue():double");
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ float floatValue() {
        return LongAdder.CC.$default$floatValue(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ void increment() {
        add(1L);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ int intValue() {
        return LongAdder.CC.$default$intValue(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final /* synthetic */ long longValue() {
        long sum;
        sum = sum();
        return sum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final void add(long j) {
        this.delegate.add(j);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final long sum() {
        return this.delegate.sum();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final void reset() {
        this.delegate.reset();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public final long sumThenReset() {
        return this.delegate.sumThenReset();
    }

    public final String toString() {
        return this.delegate.toString();
    }
}
