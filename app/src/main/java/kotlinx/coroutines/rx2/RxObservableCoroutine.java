package kotlinx.coroutines.rx2;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00028\u00000\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006B\u001d\u0012\u0006\u0010=\u001a\u00020<\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009¢\u0006\u0004\b>\u0010?J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJX\u0010#\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u0010\u001f\u001a\u00028\u00002(\u0010\"\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\u0012J \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040(2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\n8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b4\u00105R&\u00108\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/rx2/RxObservableCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "elem", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "onCancelled", "value", "onCompleted", "(Lkotlin/Unit;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", LottieParams.KEY_ELEMENT_ID, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "unlockAndCheckCompleted", "()V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isClosedForSend", "()Z", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lio/reactivex/ObservableEmitter;", "subscriber", "Lio/reactivex/ObservableEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/ObservableEmitter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, SelectClause2<T, SendChannel<? super T>> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal");
    private volatile /* synthetic */ int _signal;
    private final Mutex mutex;
    private final ObservableEmitter<T> subscriber;

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public final /* bridge */ /* synthetic */ void mo4671invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    public RxObservableCoroutine(CoroutineContext coroutineContext, ObservableEmitter<T> observableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = observableEmitter;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this._signal = 0;
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
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
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
            boolean r0 = r6 instanceof kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = new kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
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
            kotlinx.coroutines.rx2.RxObservableCoroutine r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine) r0
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxObservableCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "getOnSend")
    public final SelectClause2<T, SendChannel<T>> getOnSend() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public final <R> void registerSelectClause2(SelectInstance<? super R> select, T element, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(this, null, CoroutineStart.UNDISPATCHED, new RxObservableCoroutine$registerSelectClause2$1(this, select, new RxObservableCoroutine$registerSelectClause2$clause$1(this, element, block, null), null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable doLockedNext(T elem) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(elem);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean close = close(undeliverableException);
            unlockAndCheckCompleted();
            if (close) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, get$context());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isActive() || !Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return;
        }
        doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        Throwable th;
        try {
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
        if (this._signal != -2) {
            this._signal = -2;
            if (cause != null) {
                th = !DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
            } else {
                th = null;
            }
            if (th == null) {
                try {
                    this.subscriber.onComplete();
                } catch (Exception e) {
                    RxCancellableKt.handleUndeliverableException(e, get$context());
                }
            } else if ((th instanceof UndeliverableException) && !handled) {
                RxCancellableKt.handleUndeliverableException(cause, get$context());
            } else if (th != getCancellationException() || !this.subscriber.isDisposed()) {
                try {
                    this.subscriber.onError(cause);
                } catch (Exception e2) {
                    ExceptionsKt.addSuppressed(cause, e2);
                    RxCancellableKt.handleUndeliverableException(cause, get$context());
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        if (_signal$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
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
}
