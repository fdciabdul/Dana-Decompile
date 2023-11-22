package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    LongAddables() {
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public final void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public final void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public final long sum() {
            return get();
        }
    }
}
