package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010:\u001a\u000209\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010;\u001a\u00020\u000e\u0012\u0006\u0010<\u001a\u00020\u000e¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\u00032\u0019\u0010\u0013\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u000b¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00028\u0000H\u0096Aø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001d\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$R \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0005X\u0084\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048G¢\u0006\u0006\u001a\u0004\b*\u0010)R\u0014\u0010,\u001a\u00020\u000e8\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R#\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190.8\u0017X\u0096\u0005ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b2\u00100R&\u00108\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000005048\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "cancel", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "(Ljava/util/concurrent/CancellationException;)V", "", "cancelInternal", "(Ljava/lang/Throwable;)V", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", LottieParams.KEY_ELEMENT_ID, DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "_channel", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "getChannel", "channel", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> _channel;

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this._channel.close(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @JvmName(name = "getOnReceive")
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @JvmName(name = "getOnReceiveCatching")
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

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

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo4632receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object obj = this._channel.mo4632receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return obj;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return this._channel.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo4633tryReceivePtdJZtk() {
        return this._channel.mo4633tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo42trySendJP2dKIU(E element) {
        return this._channel.mo42trySendJP2dKIU(element);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "get_channel")
    public final Channel<E> get_channel() {
        return this._channel;
    }

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this._channel = channel;
    }

    @JvmName(name = "getChannel")
    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cause) {
        if (isCancelled()) {
            return;
        }
        if (cause == null) {
            ChannelCoroutine<E> channelCoroutine = this;
            cause = new JobCancellationException(channelCoroutine.cancellationExceptionMessage(), null, channelCoroutine);
        }
        cancelInternal(cause);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable cause) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.JobSupport
    public /* synthetic */ void cancel() {
        ChannelCoroutine<E> channelCoroutine = this;
        cancelInternal(new JobCancellationException(channelCoroutine.cancellationExceptionMessage(), null, channelCoroutine));
    }
}
