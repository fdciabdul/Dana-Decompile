package kotlinx.coroutines.channels;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001IJ\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u00002\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b \u0010!J4\u0010%\u001a\u00020\u00072\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"H\u0082\u0010¢\u0006\u0004\b%\u0010&R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u00100\u001a\u00060.j\u0002`/8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0011\u00103\u001a\u000202X\u0007¢\u0006\u0006\n\u0004\b3\u00104R$\u00109\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00118C@CX\u0082\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0013\"\u0004\b7\u00108R\u0014\u0010:\u001a\u00020\u000b8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u000b8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010;R$\u0010A\u001a\u0002022\u0006\u00105\u001a\u0002028C@CX\u0082\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R0\u0010D\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0Bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"`C8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010H\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00118C@CX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0013\"\u0004\bG\u00108"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "", "cancelInternal", "(Ljava/lang/Throwable;)Z", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", LottieParams.KEY_ELEMENT_ID, "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "capacity", "I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "()I", "setSize", "(I)V", GriverMonitorConstants.KEY_SIZE, "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getTail", "setTail", "tail", "Subscriber"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private volatile /* synthetic */ long _head;
    private volatile /* synthetic */ int _size;
    private volatile /* synthetic */ long _tail;
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    public final int capacity;
    private final List<Subscriber<E>> subscribers;

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferAlwaysFull")
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @JvmName(name = "getHead")
    /* renamed from: getHead  reason: from getter */
    private final long get_head() {
        return this._head;
    }

    @JvmName(name = "setHead")
    private final void setHead(long j) {
        this._head = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getTail")
    /* renamed from: getTail  reason: from getter */
    public final long get_tail() {
        return this._tail;
    }

    @JvmName(name = "setTail")
    private final void setTail(long j) {
        this._tail = j;
    }

    @JvmName(name = "getSize")
    /* renamed from: getSize  reason: from getter */
    private final int get_size() {
        return this._size;
    }

    @JvmName(name = "setSize")
    private final void setSize(int i) {
        this._size = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferFull")
    public final boolean isBufferFull() {
        return get_size() >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public final ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable cause) {
        if (super.close(cause)) {
            checkSubOffers();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public final void cancel(CancellationException cause) {
        cancelInternal(cause);
    }

    private final boolean cancelInternal(Throwable cause) {
        boolean close = close(cause);
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        while (it.hasNext()) {
            it.next().cancelInternal$kotlinx_coroutines_core(cause);
        }
        return close;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object offerInternal(E element) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = get_size();
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            long j = get_tail();
            this.buffer[(int) (j % this.capacity)] = element;
            setSize(i + 1);
            setTail(j + 1);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object offerSelectInternal(E element, SelectInstance<?> select) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = get_size();
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (!select.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            long j = get_tail();
            this.buffer[(int) (j % this.capacity)] = element;
            setSize(i + 1);
            setTail(j + 1);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkSubOffers() {
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
    
        throw new java.lang.AssertionError();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r14, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r15) {
        /*
            r13 = this;
            r0 = 0
        L1:
            java.util.concurrent.locks.ReentrantLock r1 = r13.bufferLock
            java.util.concurrent.locks.Lock r1 = (java.util.concurrent.locks.Lock) r1
            r1.lock()
            if (r14 == 0) goto L25
            long r2 = r13.get_tail()     // Catch: java.lang.Throwable -> L22
            r14.setSubHead(r2)     // Catch: java.lang.Throwable -> L22
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r2 = r13.subscribers     // Catch: java.lang.Throwable -> L22
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L22
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r3 = r13.subscribers     // Catch: java.lang.Throwable -> L22
            r3.add(r14)     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L25
            r1.unlock()
            return
        L22:
            r14 = move-exception
            goto Lcc
        L25:
            if (r15 == 0) goto L3c
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r14 = r13.subscribers     // Catch: java.lang.Throwable -> L22
            r14.remove(r15)     // Catch: java.lang.Throwable -> L22
            long r2 = r13.get_head()     // Catch: java.lang.Throwable -> L22
            long r14 = r15.get_subHead()     // Catch: java.lang.Throwable -> L22
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 == 0) goto L3c
            r1.unlock()
            return
        L3c:
            long r14 = r13.computeMinHead()     // Catch: java.lang.Throwable -> L22
            long r2 = r13.get_tail()     // Catch: java.lang.Throwable -> L22
            long r4 = r13.get_head()     // Catch: java.lang.Throwable -> L22
            long r14 = kotlin.ranges.RangesKt.coerceAtMost(r14, r2)     // Catch: java.lang.Throwable -> L22
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 > 0) goto L54
            r1.unlock()
            return
        L54:
            int r6 = r13.get_size()     // Catch: java.lang.Throwable -> L22
        L58:
            int r7 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r7 >= 0) goto Lc8
            java.lang.Object[] r7 = r13.buffer     // Catch: java.lang.Throwable -> L22
            int r8 = r13.capacity     // Catch: java.lang.Throwable -> L22
            long r9 = (long) r8     // Catch: java.lang.Throwable -> L22
            long r9 = r4 % r9
            int r10 = (int) r9     // Catch: java.lang.Throwable -> L22
            r7[r10] = r0     // Catch: java.lang.Throwable -> L22
            r7 = 0
            r9 = 1
            if (r6 < r8) goto L6c
            r8 = 1
            goto L6d
        L6c:
            r8 = 0
        L6d:
            r10 = 1
            long r4 = r4 + r10
            r13.setHead(r4)     // Catch: java.lang.Throwable -> L22
            int r6 = r6 + (-1)
            r13.setSize(r6)     // Catch: java.lang.Throwable -> L22
            if (r8 == 0) goto L58
        L7a:
            kotlinx.coroutines.channels.Send r8 = r13.takeFirstSendOrPeekClosed()     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L81
            goto L58
        L81:
            boolean r12 = r8 instanceof kotlinx.coroutines.channels.Closed
            if (r12 != 0) goto L58
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.lang.Throwable -> L22
            kotlinx.coroutines.internal.Symbol r12 = r8.tryResumeSend(r0)     // Catch: java.lang.Throwable -> L22
            if (r12 == 0) goto L7a
            boolean r14 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch: java.lang.Throwable -> L22
            if (r14 == 0) goto La2
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN     // Catch: java.lang.Throwable -> L22
            if (r12 != r14) goto L99
            r7 = 1
        L99:
            if (r7 == 0) goto L9c
            goto La2
        L9c:
            java.lang.AssertionError r14 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L22
            r14.<init>()     // Catch: java.lang.Throwable -> L22
            throw r14     // Catch: java.lang.Throwable -> L22
        La2:
            java.lang.Object[] r14 = r13.buffer     // Catch: java.lang.Throwable -> L22
            int r15 = r13.capacity     // Catch: java.lang.Throwable -> L22
            long r4 = (long) r15     // Catch: java.lang.Throwable -> L22
            long r4 = r2 % r4
            int r15 = (int) r4     // Catch: java.lang.Throwable -> L22
            java.lang.Object r4 = r8.getElement()     // Catch: java.lang.Throwable -> L22
            r14[r15] = r4     // Catch: java.lang.Throwable -> L22
            int r6 = r6 + 1
            r13.setSize(r6)     // Catch: java.lang.Throwable -> L22
            long r2 = r2 + r10
            r13.setTail(r2)     // Catch: java.lang.Throwable -> L22
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L22
            r1.unlock()
            r8.completeResumeSend()
            r13.checkSubOffers()
            r14 = r0
            r15 = r14
            goto L1
        Lc8:
            r1.unlock()
            return
        Lcc:
            r1.unlock()
            goto Ld1
        Ld0:
            throw r14
        Ld1:
            goto Ld0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber, kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber):void");
    }

    private final long computeMinHead() {
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        long j = LongCompanionObject.MAX_VALUE;
        while (it.hasNext()) {
            j = RangesKt.coerceAtMost(j, it.next().get_subHead());
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E elementAt(long index) {
        return (E) this.buffer[(int) (index % this.capacity)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b&\u0010'J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00048UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u00060\"j\u0002`#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "checkOffer", "()Z", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "needsToCheckOfferWithoutLock", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private volatile /* synthetic */ long _subHead;
        private final ArrayBroadcastChannel<E> broadcastChannel;
        private final ReentrantLock subLock;

        @Override // kotlinx.coroutines.channels.AbstractChannel
        @JvmName(name = "isBufferAlwaysEmpty")
        protected final boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.broadcastChannel = arrayBroadcastChannel;
            this.subLock = new ReentrantLock();
            this._subHead = 0L;
        }

        @JvmName(name = "getSubHead")
        /* renamed from: getSubHead  reason: from getter */
        public final long get_subHead() {
            return this._subHead;
        }

        @JvmName(name = "setSubHead")
        public final void setSubHead(long j) {
            this._subHead = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @JvmName(name = "isBufferEmpty")
        public final boolean isBufferEmpty() {
            return get_subHead() >= this.broadcastChannel.get_tail();
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        @JvmName(name = "isBufferAlwaysFull")
        protected final boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        @JvmName(name = "isBufferFull")
        public final boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public final boolean close(Throwable cause) {
            boolean close = super.close(cause);
            if (close) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
                ReentrantLock reentrantLock = this.subLock;
                reentrantLock.lock();
                try {
                    setSubHead(this.broadcastChannel.get_tail());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return close;
        }

        public final boolean checkOffer() {
            Closed closed;
            boolean z = false;
            while (true) {
                closed = null;
                if (!needsToCheckOfferWithoutLock() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    E e = (E) peekUnderLock();
                    if (e != AbstractChannelKt.POLL_FAILED) {
                        if (e instanceof Closed) {
                            closed = (Closed) e;
                            break;
                        }
                        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed == null || (takeFirstReceiveOrPeekClosed instanceof Closed)) {
                            break;
                        }
                        Symbol tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
                        if (tryResumeReceive != null) {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                                    throw new AssertionError();
                                }
                            }
                            setSubHead(get_subHead() + 1);
                            this.subLock.unlock();
                            takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                            z = true;
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected final Object pollInternal() {
            boolean z;
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z2 = peekUnderLock instanceof Closed;
                if (z2 || peekUnderLock == AbstractChannelKt.POLL_FAILED) {
                    z = false;
                } else {
                    setSubHead(get_subHead() + 1);
                    z = true;
                }
                reentrantLock.unlock();
                Closed closed = z2 ? (Closed) peekUnderLock : null;
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() ? true : z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected final Object pollSelectInternal(SelectInstance<?> select) {
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = false;
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (!select.trySelect()) {
                        peekUnderLock = SelectKt.getALREADY_SELECTED();
                    } else {
                        setSubHead(get_subHead() + 1);
                        z = true;
                    }
                }
                reentrantLock.unlock();
                Closed closed = peekUnderLock instanceof Closed ? (Closed) peekUnderLock : null;
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() ? true : z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        private final Object peekUnderLock() {
            long j = get_subHead();
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j < this.broadcastChannel.get_tail()) {
                Object elementAt = this.broadcastChannel.elementAt(j);
                Closed<?> closedForReceive2 = getClosedForReceive();
                return closedForReceive2 != null ? closedForReceive2 : elementAt;
            } else if (closedForReceive == null) {
                Closed<?> closedForReceive3 = getClosedForReceive();
                return closedForReceive3 == null ? AbstractChannelKt.POLL_FAILED : closedForReceive3;
            } else {
                return closedForReceive;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "getBufferDebugString")
    protected final String getBufferDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(buffer:capacity=");
        sb.append(this.buffer.length);
        sb.append(",size=");
        sb.append(get_size());
        sb.append(')');
        return sb.toString();
    }
}
