package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005J\u001d\u0010\t\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010 \u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001¢\u0006\u0004\b$\u0010%R \u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0005X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020\u000e8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u000e8\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00100R&\u00105\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+028\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "cancelInternal", "(Ljava/lang/Throwable;)V", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "(Lkotlin/Unit;)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", LottieParams.KEY_ELEMENT_ID, DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "_channel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isActive", "()Z", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    private final BroadcastChannel<E> _channel;

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "getOnSend")
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public void mo4671invokeOnClose(Function1<? super Throwable, Unit> handler) {
        this._channel.mo4671invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "isClosedForSend")
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return this._channel.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo42trySendJP2dKIU(E element) {
        return this._channel.mo42trySendJP2dKIU(element);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "get_channel")
    public final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @JvmName(name = "isActive")
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    @JvmName(name = "getChannel")
    public SendChannel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable cause) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit value) {
        SendChannel.DefaultImpls.close$default(this._channel, null, 1, null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(Throwable cause, boolean handled) {
        if (this._channel.close(cause) || handled) {
            return;
        }
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        boolean close = this._channel.close(cause);
        start();
        return close;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cause) {
        if (cause == null) {
            BroadcastCoroutine<E> broadcastCoroutine = this;
            cause = new JobCancellationException(broadcastCoroutine.cancellationExceptionMessage(), null, broadcastCoroutine);
        }
        cancelInternal(cause);
    }
}
