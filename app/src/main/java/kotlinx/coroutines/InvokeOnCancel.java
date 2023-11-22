package kotlinx.coroutines;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B&\u0012\u001d\u0010\r\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR+\u0010\r\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "", "cause", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class InvokeOnCancel extends CancelHandler {
    private final Function1<Throwable, Unit> handler;

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.handler = function1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable cause) {
        this.handler.invoke(cause);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvokeOnCancel[");
        sb.append(DebugStringsKt.getClassSimpleName(this.handler));
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        sb.append(']');
        return sb.toString();
    }
}
