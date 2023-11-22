package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"E", "Lkotlinx/coroutines/channels/SendChannel;", LottieParams.KEY_ELEMENT_ID, "Lkotlinx/coroutines/channels/ChannelResult;", "", "trySendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes3.dex */
final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e) {
        Object runBlocking$default;
        Object mo42trySendJP2dKIU = sendChannel.mo42trySendJP2dKIU(e);
        if (mo42trySendJP2dKIU instanceof ChannelResult.Failed) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e, null), 1, null);
            return ((ChannelResult) runBlocking$default).getHolder();
        }
        Unit unit = (Unit) mo42trySendJP2dKIU;
        return ChannelResult.INSTANCE.m4647successJP2dKIU(Unit.INSTANCE);
    }
}
