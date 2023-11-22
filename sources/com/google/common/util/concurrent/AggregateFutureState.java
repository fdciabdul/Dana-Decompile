package com.google.common.util.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    private volatile int remaining;
    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    abstract void addInitialException(Set<Throwable> set);

    static /* synthetic */ int access$306(AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.remaining - 1;
        aggregateFutureState.remaining = i;
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.util.concurrent.AggregateFutureState$1] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    static {
        AtomicHelper synchronizedAtomicHelper;
        ?? r1 = 0;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Error | RuntimeException e) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            r1 = e;
        }
        ATOMIC_HELPER = synchronizedAtomicHelper;
        if (r1 != 0) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", r1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateFutureState(int i) {
        this.remaining = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set == null) {
            Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
            addInitialException(newConcurrentHashSet);
            ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, newConcurrentHashSet);
            return (Set) Objects.requireNonNull(this.seenExceptions);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    /* loaded from: classes7.dex */
    static abstract class AtomicHelper {
        abstract void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        abstract int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState);

        private AtomicHelper() {
        }
    }

    /* loaded from: classes7.dex */
    static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        final void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        final int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    /* loaded from: classes7.dex */
    static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        final void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (((AggregateFutureState) aggregateFutureState).seenExceptions == set) {
                    ((AggregateFutureState) aggregateFutureState).seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        final int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            int access$306;
            synchronized (aggregateFutureState) {
                access$306 = AggregateFutureState.access$306(aggregateFutureState);
            }
            return access$306;
        }
    }
}
