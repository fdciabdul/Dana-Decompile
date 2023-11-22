package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "onUndeliveredElement", "Lkotlinx/coroutines/channels/Channel;", "Channel", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/channels/Channel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChannelKt {
    public static /* synthetic */ Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return Channel(i, bufferOverflow, function1);
    }

    public static final <E> Channel<E> Channel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        ArrayChannel arrayChannel;
        ArrayChannel arrayChannel2;
        if (i == -2) {
            return new ArrayChannel(bufferOverflow == BufferOverflow.SUSPEND ? Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() : 1, bufferOverflow, function1);
        } else if (i == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) == 0) {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            return new ConflatedChannel(function1);
        } else if (i == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                arrayChannel = new RendezvousChannel(function1);
            } else {
                arrayChannel = new ArrayChannel(1, bufferOverflow, function1);
            }
            return arrayChannel;
        } else if (i == Integer.MAX_VALUE) {
            return new LinkedListChannel(function1);
        } else {
            if (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                arrayChannel2 = new ConflatedChannel(function1);
            } else {
                arrayChannel2 = new ArrayChannel(i, bufferOverflow, function1);
            }
            return arrayChannel2;
        }
    }
}
