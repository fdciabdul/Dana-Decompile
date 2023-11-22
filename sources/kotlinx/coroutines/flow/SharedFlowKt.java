package kotlinx.coroutines.flow;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0018\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"T", "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "MutableSharedFlow", "(IILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuseSharedFlow", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "", "", "", "index", "getBufferAt", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "", "setBufferAt", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", "NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SharedFlowKt {
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    public static final /* synthetic */ Object access$getBufferAt(Object[] objArr, long j) {
        return getBufferAt(objArr, j);
    }

    public static final /* synthetic */ void access$setBufferAt(Object[] objArr, long j, Object obj) {
        setBufferAt(objArr, j, obj);
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int i, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i, i2, bufferOverflow);
    }

    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int i, int i2, BufferOverflow bufferOverflow) {
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("replay cannot be negative, but was ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!(i2 >= 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("extraBufferCapacity cannot be negative, but was ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        if (!(i > 0 || i2 > 0 || bufferOverflow == BufferOverflow.SUSPEND)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ");
            sb3.append(bufferOverflow);
            throw new IllegalArgumentException(sb3.toString().toString());
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
        }
        return new SharedFlowImpl(i, i3, bufferOverflow);
    }

    public static final Object getBufferAt(Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    public static final void setBufferAt(Object[] objArr, long j, Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }

    public static final <T> Flow<T> fuseSharedFlow(SharedFlow<? extends T> sharedFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, bufferOverflow);
    }
}
