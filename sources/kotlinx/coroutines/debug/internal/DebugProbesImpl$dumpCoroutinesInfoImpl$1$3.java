package kotlinx.coroutines.debug.internal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "R", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "owner", BridgeDSL.INVOKE, "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$1$3<R> extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, R> {
    final /* synthetic */ Function2<DebugProbesImpl.CoroutineOwner<?>, CoroutineContext, R> $$create;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$1$3(Function2<? super DebugProbesImpl.CoroutineOwner<?>, ? super CoroutineContext, ? extends R> function2) {
        super(1);
        this.$$create = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        boolean isFinished;
        CoroutineContext context;
        isFinished = DebugProbesImpl.INSTANCE.isFinished(coroutineOwner);
        if (isFinished || (context = coroutineOwner.info.getContext()) == null) {
            return null;
        }
        return this.$$create.invoke(coroutineOwner, context);
    }
}
