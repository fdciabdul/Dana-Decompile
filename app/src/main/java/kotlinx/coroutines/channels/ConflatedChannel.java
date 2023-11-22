package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010,\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010*j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`+¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00058EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00058EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00058EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 R\u0018\u0010&\u001a\u00060$j\u0002`%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", LottieParams.KEY_ELEMENT_ID, "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "updateValueLocked", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    private final ReentrantLock lock;
    private Object value;

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isBufferAlwaysEmpty")
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferAlwaysFull")
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferFull")
    public final boolean isBufferFull() {
        return false;
    }

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.lock = new ReentrantLock();
        this.value = AbstractChannelKt.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isBufferEmpty")
    public final boolean isBufferEmpty() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.value == AbstractChannelKt.EMPTY;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r1 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((r1 instanceof kotlinx.coroutines.channels.Closed) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2 = r1.tryResumeReceive(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r2 != kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r0.unlock();
        r1.completeResumeReceive(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        return r1.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        r5 = updateValueLocked(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r5 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r4.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        r1 = takeFirstReceiveOrPeekClosed();
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object offerInternal(E r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r4.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            kotlinx.coroutines.channels.Closed r1 = r4.getClosedForSend()     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L11
            r0.unlock()
            return r1
        L11:
            java.lang.Object r1 = r4.value     // Catch: java.lang.Throwable -> L5f
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY     // Catch: java.lang.Throwable -> L5f
            if (r1 != r2) goto L52
        L17:
            kotlinx.coroutines.channels.ReceiveOrClosed r1 = r4.takeFirstReceiveOrPeekClosed()     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L52
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L25
            r0.unlock()
            return r1
        L25:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> L5f
            r2 = 0
            kotlinx.coroutines.internal.Symbol r2 = r1.tryResumeReceive(r5, r2)     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L17
            boolean r3 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch: java.lang.Throwable -> L5f
            if (r3 == 0) goto L45
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN     // Catch: java.lang.Throwable -> L5f
            if (r2 != r3) goto L3b
            r2 = 1
            goto L3c
        L3b:
            r2 = 0
        L3c:
            if (r2 == 0) goto L3f
            goto L45
        L3f:
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L5f
            r5.<init>()     // Catch: java.lang.Throwable -> L5f
            throw r5     // Catch: java.lang.Throwable -> L5f
        L45:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5f
            r0.unlock()
            r1.completeResumeReceive(r5)
            java.lang.Object r5 = r1.getOfferResult()
            return r5
        L52:
            kotlinx.coroutines.internal.UndeliveredElementException r5 = r4.updateValueLocked(r5)     // Catch: java.lang.Throwable -> L5f
            if (r5 != 0) goto L5e
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS     // Catch: java.lang.Throwable -> L5f
            r0.unlock()
            return r5
        L5e:
            throw r5     // Catch: java.lang.Throwable -> L5f
        L5f:
            r5 = move-exception
            r0.unlock()
            goto L65
        L64:
            throw r5
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ConflatedChannel.offerInternal(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r5 = r1.getResult();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r0.unlock();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r5.completeResumeReceive(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        return r5.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r2 == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r2 == kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r2 == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.Closed) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("performAtomicTrySelect(describeTryOffer) returned ");
        r5.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        throw new java.lang.IllegalStateException(r5.toString().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r5.trySelect() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        r4 = updateValueLocked(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r4 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r3.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        r1 = describeTryOffer(r4);
        r2 = r5.performAtomicTrySelect(r1);
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object offerSelectInternal(E r4, kotlinx.coroutines.selects.SelectInstance<?> r5) {
        /*
            r3 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r3.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            kotlinx.coroutines.channels.Closed r1 = r3.getClosedForSend()     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L11
            r0.unlock()
            return r1
        L11:
            java.lang.Object r1 = r3.value     // Catch: java.lang.Throwable -> L87
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY     // Catch: java.lang.Throwable -> L87
            if (r1 != r2) goto L6c
        L17:
            kotlinx.coroutines.channels.AbstractSendChannel$TryOfferDesc r1 = r3.describeTryOffer(r4)     // Catch: java.lang.Throwable -> L87
            r2 = r1
            kotlinx.coroutines.internal.AtomicDesc r2 = (kotlinx.coroutines.internal.AtomicDesc) r2     // Catch: java.lang.Throwable -> L87
            java.lang.Object r2 = r5.performAtomicTrySelect(r2)     // Catch: java.lang.Throwable -> L87
            if (r2 != 0) goto L3a
            java.lang.Object r5 = r1.getResult()     // Catch: java.lang.Throwable -> L87
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L87
            r0.unlock()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlinx.coroutines.channels.ReceiveOrClosed r5 = (kotlinx.coroutines.channels.ReceiveOrClosed) r5
            r5.completeResumeReceive(r4)
            java.lang.Object r4 = r5.getOfferResult()
            return r4
        L3a:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED     // Catch: java.lang.Throwable -> L87
            if (r2 == r1) goto L6c
            java.lang.Object r1 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC     // Catch: java.lang.Throwable -> L87
            if (r2 == r1) goto L17
            java.lang.Object r4 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch: java.lang.Throwable -> L87
            if (r2 == r4) goto L68
            boolean r4 = r2 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L87
            if (r4 == 0) goto L4d
            goto L68
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L87
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            r5.<init>()     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r5.append(r1)     // Catch: java.lang.Throwable -> L87
            r5.append(r2)     // Catch: java.lang.Throwable -> L87
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L87
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L87
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L87
            throw r4     // Catch: java.lang.Throwable -> L87
        L68:
            r0.unlock()
            return r2
        L6c:
            boolean r5 = r5.trySelect()     // Catch: java.lang.Throwable -> L87
            if (r5 != 0) goto L7a
            java.lang.Object r4 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch: java.lang.Throwable -> L87
            r0.unlock()
            return r4
        L7a:
            kotlinx.coroutines.internal.UndeliveredElementException r4 = r3.updateValueLocked(r4)     // Catch: java.lang.Throwable -> L87
            if (r4 != 0) goto L86
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS     // Catch: java.lang.Throwable -> L87
            r0.unlock()
            return r4
        L86:
            throw r4     // Catch: java.lang.Throwable -> L87
        L87:
            r4 = move-exception
            r0.unlock()
            goto L8d
        L8c:
            throw r4
        L8d:
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ConflatedChannel.offerSelectInternal(java.lang.Object, kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.value == AbstractChannelKt.EMPTY) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.value;
            this.value = AbstractChannelKt.EMPTY;
            Unit unit = Unit.INSTANCE;
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollSelectInternal(SelectInstance<?> select) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.value == AbstractChannelKt.EMPTY) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            } else if (!select.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            } else {
                Object obj = this.value;
                this.value = AbstractChannelKt.EMPTY;
                Unit unit = Unit.INSTANCE;
                return obj;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean wasClosed) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException updateValueLocked = updateValueLocked(AbstractChannelKt.EMPTY);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (updateValueLocked != null) {
                throw updateValueLocked;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final UndeliveredElementException updateValueLocked(Object element) {
        Function1<E, Unit> function1;
        Object obj = this.value;
        UndeliveredElementException undeliveredElementException = null;
        if (obj != AbstractChannelKt.EMPTY && (function1 = this.onUndeliveredElement) != null) {
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null);
        }
        this.value = element;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "getBufferDebugString")
    protected String getBufferDebugString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(value=");
            sb.append(this.value);
            sb.append(')');
            return sb.toString();
        } finally {
            reentrantLock.unlock();
        }
    }
}
