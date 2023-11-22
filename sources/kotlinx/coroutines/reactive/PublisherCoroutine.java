package kotlinx.coroutines.reactive;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006B7\u0012\u0006\u0010G\u001a\u000209\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000D\u0012\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0004\bH\u0010IJ\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJX\u0010&\u001a\u00020\u0003\"\u0004\b\u0001\u0010\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001f2\u0006\u0010!\u001a\u00028\u00002(\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\u00032\u0006\u0010!\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010\u0014J \u00102\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0006\u0010!\u001a\u00028\u0000H\u0016ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u0010\tR\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R&\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00030\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b?\u0010@R&\u0010C\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000D8\bX\u0089\u0004¢\u0006\u0006\n\u0004\bE\u0010F\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "cancel", "()V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "elem", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "onCancelled", "value", "onCompleted", "(Lkotlin/Unit;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", LottieParams.KEY_ELEMENT_ID, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "n", "request", "(J)V", DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "unlockAndCheckCompleted", "cancelled", "Z", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "Lkotlin/coroutines/CoroutineContext;", "exceptionOnCancelHandler", "Lkotlin/jvm/functions/Function2;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lorg/reactivestreams/Subscriber;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription, SelectClause2<T, SendChannel<? super T>> {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    private volatile /* synthetic */ long _nRequested;
    private volatile boolean cancelled;
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    private final Mutex mutex;
    public final Subscriber<T> subscriber;

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose  reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ void mo4671invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext coroutineContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
        this._nRequested = 0L;
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    @JvmName(name = "getChannel")
    public final SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "isClosedForSend")
    public final boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable cause) {
        return cancelCoroutine(cause);
    }

    public final Void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo42trySendJP2dKIU(T element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.INSTANCE.m4646failurePtdJZtk();
        }
        Throwable doLockedNext = doLockedNext(element);
        if (doLockedNext == null) {
            return ChannelResult.INSTANCE.m4647successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.INSTANCE.m4645closedJP2dKIU(doLockedNext);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object send(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = (kotlinx.coroutines.reactive.PublisherCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = new kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.reactive.PublisherCoroutine r0 = (kotlinx.coroutines.reactive.PublisherCoroutine) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.mutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r6, r2, r0, r3, r2)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            java.lang.Throwable r5 = r0.doLockedNext(r5)
            if (r5 != 0) goto L55
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L55:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "getOnSend")
    public final SelectClause2<T, SendChannel<T>> getOnSend() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public final <R> void registerSelectClause2(SelectInstance<? super R> select, T element, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(this, null, CoroutineStart.UNDISPATCHED, new PublisherCoroutine$registerSelectClause2$1(this, select, new PublisherCoroutine$registerSelectClause2$clause$1(this, element, block, null), null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable doLockedNext(T elem) {
        if (elem == null) {
            unlockAndCheckCompleted();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            unlockAndCheckCompleted();
            return getCancellationException();
        } else {
            try {
                this.subscriber.onNext(elem);
                while (true) {
                    long j = this._nRequested;
                    if (j < 0 || j == LongCompanionObject.MAX_VALUE) {
                        break;
                    }
                    long j2 = j - 1;
                    if (_nRequested$FU.compareAndSet(this, j, j2)) {
                        if (j2 == 0) {
                            return null;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean close = close(th);
                unlockAndCheckCompleted();
                if (close) {
                    return th;
                }
                this.exceptionOnCancelHandler.invoke(th, get$context());
                return getCancellationException();
            }
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        try {
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
        if (this._nRequested != -2) {
            this._nRequested = -2L;
            if (!this.cancelled) {
                if (cause == null) {
                    try {
                        this.subscriber.onComplete();
                    } catch (Throwable th) {
                        CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), th);
                    }
                } else {
                    try {
                        this.subscriber.onError(cause);
                    } catch (Throwable th2) {
                        if (th2 != cause) {
                            ExceptionsKt.addSuppressed(cause, th2);
                        }
                        CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), cause);
                    }
                }
                Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            } else if (cause != null && !handled) {
                this.exceptionOnCancelHandler.invoke(cause, get$context());
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long n) {
        long j;
        long j2;
        if (n <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("non-positive subscription request ");
            sb.append(n);
            cancelCoroutine(new IllegalArgumentException(sb.toString()));
            return;
        }
        do {
            j = this._nRequested;
            if (j < 0) {
                return;
            }
            long j3 = j + n;
            j2 = (j3 < 0 || n == LongCompanionObject.MAX_VALUE) ? Long.MAX_VALUE : j3;
            if (j == j2) {
                return;
            }
        } while (!_nRequested$FU.compareAndSet(this, j, j2));
        if (j == 0) {
            unlockAndCheckCompleted();
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        long j;
        do {
            j = this._nRequested;
            if (j == -2) {
                return;
            }
            if (!(j >= 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!_nRequested$FU.compareAndSet(this, j, -1L));
        if (j == 0) {
            doLockedSignalCompleted(cause, handled);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Unit value) {
        signalCompleted(null, false);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancel() {
        this.cancelled = true;
        super.cancel(null);
    }
}
