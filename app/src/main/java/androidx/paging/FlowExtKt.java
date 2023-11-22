package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a`\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u0006\u001a2\b\u0001\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0003\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001an\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u000126\u0010\n\u001a2\b\u0001\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0003\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\b\u001al\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00012<\u0010\u0006\u001a8\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0002¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\b\"\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "Lkotlin/coroutines/Continuation;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "R", "p1", "PlaceComponentResult", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "MyBillsEntityDataFactory", "Ljava/lang/Object;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FlowExtKt {
    private static final Object PlaceComponentResult = new Object();

    public static final <T, R> Flow<R> PlaceComponentResult(Flow<? extends T> flow, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(function3, "");
        return FlowKt.flow(new FlowExtKt$simpleScan$1(null, flow, function3, null));
    }

    public static final <T> Flow<T> KClassImpl$Data$declaredNonStaticMembers$2(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(function3, "");
        return FlowKt.flow(new FlowExtKt$simpleRunningReduce$1(flow, function3, null));
    }

    public static final <T, R> Flow<R> MyBillsEntityDataFactory(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(function3, "");
        return SimpleChannelFlowKt.BuiltInFictitiousFunctionClassFactory(new FlowExtKt$simpleTransformLatest$1(flow, function3, null));
    }
}
