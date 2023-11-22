package kotlinx.coroutines;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u0019\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H¦\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "Lkotlinx/coroutines/CompletionHandler;", "cause", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements Function1<Throwable, Unit> {
    public abstract void invoke(Throwable cause);
}
