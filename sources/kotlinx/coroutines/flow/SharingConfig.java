package kotlinx.coroutines.flow;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\t8\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/flow/SharingConfig;", "T", "", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "", "extraBufferCapacity", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlinx/coroutines/flow/Flow;", "upstream", "Lkotlinx/coroutines/flow/Flow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SharingConfig<T> {
    public final CoroutineContext context;
    public final int extraBufferCapacity;
    public final BufferOverflow onBufferOverflow;
    public final Flow<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public SharingConfig(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow, CoroutineContext coroutineContext) {
        this.upstream = flow;
        this.extraBufferCapacity = i;
        this.onBufferOverflow = bufferOverflow;
        this.context = coroutineContext;
    }
}
