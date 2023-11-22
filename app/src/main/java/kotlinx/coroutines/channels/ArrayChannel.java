package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u000209\u0012 \u0010>\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010<j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`=¢\u0006\u0004\b?\u0010@J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u0004\u0018\u00010\u00102\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$R\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b2\u00100R\u0014\u00103\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b3\u00100R\u0014\u00104\u001a\u00020\u000b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00100R\u0018\u00107\u001a\u000605j\u0002`68\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "currentSize", LottieParams.KEY_ELEMENT_ID, "", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", DataflowMonitorModel.METHOD_NAME_SEND, "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "capacity", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private final BufferOverflow onBufferOverflow;
    private volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

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

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (!(i > 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("ArrayChannel capacity must be at least 1, but ");
            sb.append(i);
            sb.append(" was specified");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        this.lock = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        ArraysKt.fill$default(objArr, AbstractChannelKt.EMPTY, 0, 0, 6, (Object) null);
        this.buffer = objArr;
        this.size = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isBufferEmpty")
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferFull")
    public final boolean isBufferFull() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isClosedForReceive")
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r1 == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = takeFirstReceiveOrPeekClosed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.Closed) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r5.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r3 = r2.tryResumeReceive(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r3 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r3 != kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r3 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        r5.size = r1;
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
    
        r0.unlock();
        r2.completeResumeReceive(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        return r2.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        enqueueElement(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object offerInternal(E r6) {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            int r1 = r5.size     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.channels.Closed r2 = r5.getClosedForSend()     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L13
            r0.unlock()
            return r2
        L13:
            kotlinx.coroutines.internal.Symbol r2 = r5.updateBufferSize(r1)     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L1d
            r0.unlock()
            return r2
        L1d:
            if (r1 != 0) goto L5e
        L1f:
            kotlinx.coroutines.channels.ReceiveOrClosed r2 = r5.takeFirstReceiveOrPeekClosed()     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L5e
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r3 == 0) goto L2f
            r5.size = r1     // Catch: java.lang.Throwable -> L67
            r0.unlock()
            return r2
        L2f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.Throwable -> L67
            r3 = 0
            kotlinx.coroutines.internal.Symbol r3 = r2.tryResumeReceive(r6, r3)     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L1f
            boolean r4 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L4f
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN     // Catch: java.lang.Throwable -> L67
            if (r3 != r4) goto L45
            r3 = 1
            goto L46
        L45:
            r3 = 0
        L46:
            if (r3 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L67
            r6.<init>()     // Catch: java.lang.Throwable -> L67
            throw r6     // Catch: java.lang.Throwable -> L67
        L4f:
            r5.size = r1     // Catch: java.lang.Throwable -> L67
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L67
            r0.unlock()
            r2.completeResumeReceive(r6)
            java.lang.Object r6 = r2.getOfferResult()
            return r6
        L5e:
            r5.enqueueElement(r1, r6)     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS     // Catch: java.lang.Throwable -> L67
            r0.unlock()
            return r6
        L67:
            r6 = move-exception
            r0.unlock()
            goto L6d
        L6c:
            throw r6
        L6d:
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.offerInternal(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r1 == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = describeTryOffer(r5);
        r3 = r6.performAtomicTrySelect(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r3 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        r4.size = r1;
        r6 = r2.getResult();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r0.unlock();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6);
        r6 = r6;
        r6.completeResumeReceive(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        return r6.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (r3 == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r3 == kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r3 == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if ((r3 instanceof kotlinx.coroutines.channels.Closed) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("performAtomicTrySelect(describeTryOffer) returned ");
        r6.append(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(r6.toString().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        r4.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r6.trySelect() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r4.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
    
        enqueueElement(r1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object offerSelectInternal(E r5, kotlinx.coroutines.selects.SelectInstance<?> r6) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r4.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            int r1 = r4.size     // Catch: java.lang.Throwable -> L91
            kotlinx.coroutines.channels.Closed r2 = r4.getClosedForSend()     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L13
            r0.unlock()
            return r2
        L13:
            kotlinx.coroutines.internal.Symbol r2 = r4.updateBufferSize(r1)     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L1d
            r0.unlock()
            return r2
        L1d:
            if (r1 != 0) goto L78
        L1f:
            kotlinx.coroutines.channels.AbstractSendChannel$TryOfferDesc r2 = r4.describeTryOffer(r5)     // Catch: java.lang.Throwable -> L91
            r3 = r2
            kotlinx.coroutines.internal.AtomicDesc r3 = (kotlinx.coroutines.internal.AtomicDesc) r3     // Catch: java.lang.Throwable -> L91
            java.lang.Object r3 = r6.performAtomicTrySelect(r3)     // Catch: java.lang.Throwable -> L91
            if (r3 != 0) goto L44
            r4.size = r1     // Catch: java.lang.Throwable -> L91
            java.lang.Object r6 = r2.getResult()     // Catch: java.lang.Throwable -> L91
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L91
            r0.unlock()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.channels.ReceiveOrClosed r6 = (kotlinx.coroutines.channels.ReceiveOrClosed) r6
            r6.completeResumeReceive(r5)
            java.lang.Object r5 = r6.getOfferResult()
            return r5
        L44:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED     // Catch: java.lang.Throwable -> L91
            if (r3 == r2) goto L78
            java.lang.Object r2 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC     // Catch: java.lang.Throwable -> L91
            if (r3 == r2) goto L1f
            java.lang.Object r5 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch: java.lang.Throwable -> L91
            if (r3 == r5) goto L72
            boolean r5 = r3 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L91
            if (r5 == 0) goto L57
            goto L72
        L57:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L91
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r6.<init>()     // Catch: java.lang.Throwable -> L91
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r6.append(r1)     // Catch: java.lang.Throwable -> L91
            r6.append(r3)     // Catch: java.lang.Throwable -> L91
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L91
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L91
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L91
            throw r5     // Catch: java.lang.Throwable -> L91
        L72:
            r4.size = r1     // Catch: java.lang.Throwable -> L91
            r0.unlock()
            return r3
        L78:
            boolean r6 = r6.trySelect()     // Catch: java.lang.Throwable -> L91
            if (r6 != 0) goto L88
            r4.size = r1     // Catch: java.lang.Throwable -> L91
            java.lang.Object r5 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch: java.lang.Throwable -> L91
            r0.unlock()
            return r5
        L88:
            r4.enqueueElement(r1, r5)     // Catch: java.lang.Throwable -> L91
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS     // Catch: java.lang.Throwable -> L91
            r0.unlock()
            return r5
        L91:
            r5 = move-exception
            r0.unlock()
            goto L97
        L96:
            throw r5
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.offerSelectInternal(java.lang.Object, kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object enqueueSend(Send send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Symbol updateBufferSize(int currentSize) {
        if (currentSize < this.capacity) {
            this.size = currentSize + 1;
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        return AbstractChannelKt.OFFER_FAILED;
    }

    private final void enqueueElement(int currentSize, E element) {
        if (currentSize < this.capacity) {
            ensureCapacity(currentSize);
            Object[] objArr = this.buffer;
            objArr[(this.head + currentSize) % objArr.length] = element;
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.onBufferOverflow == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.buffer;
        int i = this.head;
        objArr2[i % objArr2.length] = null;
        objArr2[(currentSize + i) % objArr2.length] = element;
        this.head = (i + 1) % objArr2.length;
    }

    private final void ensureCapacity(int currentSize) {
        Object[] objArr = this.buffer;
        if (currentSize >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[min];
            for (int i = 0; i < currentSize; i++) {
                Object[] objArr3 = this.buffer;
                objArr2[i] = objArr3[(this.head + i) % objArr3.length];
            }
            ArraysKt.fill((Symbol[]) objArr2, AbstractChannelKt.EMPTY, currentSize, min);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj = objArr[i2];
            Send send = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                Send send2 = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                    Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                    if (tryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = takeFirstSendOrPeekClosed.getElement();
                        send = takeFirstSendOrPeekClosed;
                        r6 = true;
                    } else {
                        takeFirstSendOrPeekClosed.undeliveredElement();
                        send2 = takeFirstSendOrPeekClosed;
                    }
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i) % objArr2.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            if (r6) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r1 == r8.capacity) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        r3 = describeTryPoll();
        r7 = r9.performAtomicTrySelect(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r7 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r2 = r3.getResult();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r5 = r2;
        r2 = r2.getElement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r7 == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r7 == kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r7 != kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        r8.size = r1;
        r8.buffer[r8.head] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if ((r7 instanceof kotlinx.coroutines.channels.Closed) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        r2 = r7;
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("performAtomicTrySelect(describeTryOffer) returned ");
        r1.append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        throw new java.lang.IllegalStateException(r1.toString().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        if (r2 == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.Closed) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r8.size = r1;
        r9 = r8.buffer;
        r9[(r8.head + r1) % r9.length] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
    
        if (r9.trySelect() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
    
        r8.size = r1;
        r8.buffer[r8.head] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
    
        return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        r8.head = (r8.head + 1) % r8.buffer.length;
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
    
        if (r3 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5.completeResumeSend();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c9, code lost:
    
        return r4;
     */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object pollSelectInternal(kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean wasClosed) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.buffer[this.head];
                if (function1 != null && obj != AbstractChannelKt.EMPTY) {
                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                this.buffer[this.head] = AbstractChannelKt.EMPTY;
                this.head = (this.head + 1) % this.buffer.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "getBufferDebugString")
    protected String getBufferDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(buffer:capacity=");
        sb.append(this.capacity);
        sb.append(",size=");
        sb.append(this.size);
        sb.append(')');
        return sb.toString();
    }
}
