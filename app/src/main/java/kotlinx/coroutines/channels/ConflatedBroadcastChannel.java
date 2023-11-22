package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.model.KycStatus;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004=<>?B\u0007¢\u0006\u0004\b:\u0010;J?\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\u00020\f2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b!\u0010\"JX\u0010+\u001a\u00020\f\"\u0004\b\u0001\u0010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010$2\u0006\u0010\u001c\u001a\u00028\u00002(\u0010*\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(\u0012\u0006\u0012\u0004\u0018\u00010)0&H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J?\u0010-\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b-\u0010\bJ\u001b\u0010.\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J \u00103\u001a\b\u0012\u0004\u0012\u00020\f002\u0006\u0010\u001c\u001a\u00028\u0000H\u0016ø\u0001\u0001¢\u0006\u0004\b1\u00102R\u0014\u00104\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R&\u00109\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "", "close", "(Ljava/lang/Throwable;)Z", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", LottieParams.KEY_ELEMENT_ID, "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "<init>", "()V", "Companion", "Closed", TrackerKey.Property.STATE, "Subscriber"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    @Deprecated
    private static final State<Object> INITIAL_STATE;
    @Deprecated
    private static final Symbol UNDEFINED;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _updating$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU;
    private volatile /* synthetic */ Object _state = INITIAL_STATE;
    private volatile /* synthetic */ int _updating = 0;
    private volatile /* synthetic */ Object onCloseHandler = null;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Closed CLOSED = new Closed(null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "Lkotlinx/coroutines/internal/Symbol;", KycStatus.UNDEFINED, "Lkotlinx/coroutines/internal/Symbol;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Symbol symbol = new Symbol(KycStatus.UNDEFINED);
        UNDEFINED = symbol;
        INITIAL_STATE = new State<>(symbol, null);
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0018\u00010\u00038\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscribers", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "value", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class State<E> {
        public final Subscriber<E>[] subscribers;
        public final Object value;

        public State(Object obj, Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "", "closeCause", "Ljava/lang/Throwable;", "getSendException", "()Ljava/lang/Throwable;", "sendException", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable th) {
            this.closeCause = th;
        }

        @JvmName(name = "getSendException")
        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            return th == null ? new ClosedSendChannelException("Channel was closed") : th;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "isClosedForSend")
    public final boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public final ReceiveChannel<E> openSubscription() {
        Object obj;
        State state;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                if (state.value != UNDEFINED) {
                    subscriber.offerInternal(state.value);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid state ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString().toString());
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new State(state.value, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] list, Subscriber<E> subscriber) {
        if (list == null) {
            Subscriber<E>[] subscriberArr = new Subscriber[1];
            for (int i = 0; i <= 0; i++) {
                subscriberArr[0] = subscriber;
            }
            return subscriberArr;
        }
        return (Subscriber[]) ArraysKt.plus(list, subscriber);
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] list, Subscriber<E> subscriber) {
        int length = list.length;
        int indexOf = ArraysKt.indexOf(list, subscriber);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(indexOf >= 0)) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr = new Subscriber[length - 1];
        ArraysKt.copyInto$default(list, subscriberArr, 0, 0, indexOf, 6, (Object) null);
        ArraysKt.copyInto$default(list, subscriberArr, indexOf, indexOf + 1, 0, 8, (Object) null);
        return subscriberArr;
    }

    private final void invokeOnCloseHandler(Throwable cause) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.HANDLER_INVOKED || !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(onCloseHandler$FU, this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public final void mo4671invokeOnClose(Function1<? super Throwable, Unit> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Another handler was already registered: ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString());
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            handler.invoke(((Closed) obj2).closeCause);
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public final void cancel(CancellationException cause) {
        close(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal == null) {
            if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
                return null;
            }
            return Unit.INSTANCE;
        }
        throw offerInternal.getSendException();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo42trySendJP2dKIU(E element) {
        Closed offerInternal = offerInternal(element);
        return offerInternal != null ? ChannelResult.INSTANCE.m4645closedJP2dKIU(offerInternal.getSendException()) : ChannelResult.INSTANCE.m4647successJP2dKIU(Unit.INSTANCE);
    }

    private final Closed offerInternal(E element) {
        Object obj;
        if (!_updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof Closed) {
                    return (Closed) obj;
                }
                if (!(obj instanceof State)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid state ");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString().toString());
                }
            } finally {
                this._updating = 0;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new State(element, ((State) obj).subscribers)));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> subscriber : subscriberArr) {
                subscriber.offerInternal(element);
            }
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "getOnSend")
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return (SelectClause2) ((SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1
            final /* synthetic */ ConflatedBroadcastChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public final <R> void registerSelectClause2(SelectInstance<? super R> select, E param, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectSend(select, param, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> select, E element, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
        if (select.trySelect()) {
            Closed offerInternal = offerInternal(element);
            if (offerInternal != null) {
                select.resumeSelectWithException(offerInternal.getSendException());
            } else {
                UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", LottieParams.KEY_ELEMENT_ID, "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "wasClosed", "", "onCancelIdempotent", "(Z)V", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "<init>", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super(null);
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public final void onCancelIdempotent(boolean wasClosed) {
            if (wasClosed) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        public final Object offerInternal(E element) {
            return super.offerInternal(element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return;
            }
            if (obj instanceof State) {
                State state = (State) obj;
                obj2 = state.value;
                subscriberArr = state.subscribers;
                Intrinsics.checkNotNull(subscriberArr);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid state ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString().toString());
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable cause) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid state ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString().toString());
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, cause == null ? CLOSED : new Closed(cause)));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> subscriber : subscriberArr) {
                subscriber.close(cause);
            }
        }
        invokeOnCloseHandler(cause);
        return true;
    }
}
