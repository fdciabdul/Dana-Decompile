package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\u0010\u0007\u001a+\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0001¢\u0006\u0002\b\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lkotlin/Function2;", "Landroidx/paging/SimpleProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "p0", "Lkotlinx/coroutines/flow/Flow;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleChannelFlowKt {
    public static final <T> Flow<T> BuiltInFictitiousFunctionClassFactory(Function2<? super SimpleProducerScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Flow<T> buffer$default;
        Intrinsics.checkNotNullParameter(function2, "");
        buffer$default = FlowKt__ContextKt.buffer$default(FlowKt.flow(new SimpleChannelFlowKt$simpleChannelFlow$1(function2, null)), -2, null, 2, null);
        return buffer$default;
    }
}
