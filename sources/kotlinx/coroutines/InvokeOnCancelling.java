package kotlinx.coroutines;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B&\u0012\u001d\u0010\n\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R+\u0010\n\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "", "cause", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvokeOnCancelling extends JobCancellingNode {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;
    private final Function1<Throwable, Unit> handler;

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancelling(Function1<? super Throwable, Unit> function1) {
        this.handler = function1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable cause) {
        if (_invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(cause);
        }
    }
}
