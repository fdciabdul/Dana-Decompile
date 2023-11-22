package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\f\u001a\u00020\n2\u0019\u0010\u000b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\bH&¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u000e\u001a\u00028\u0000H&ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00058'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00178'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", LottieParams.KEY_ELEMENT_ID, DataflowMonitorModel.METHOD_NAME_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SendChannel<E> {
    boolean close(Throwable cause);

    @JvmName(name = "getOnSend")
    SelectClause2<E, SendChannel<E>> getOnSend();

    /* renamed from: invokeOnClose */
    void mo4671invokeOnClose(Function1<? super Throwable, Unit> handler);

    @JvmName(name = "isClosedForSend")
    boolean isClosedForSend();

    Object send(E e, Continuation<? super Unit> continuation);

    /* renamed from: trySend-JP2dKIU */
    Object mo42trySendJP2dKIU(E element);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
