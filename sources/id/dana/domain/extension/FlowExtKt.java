package id.dana.domain.extension;

import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aC\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00022\u0014\b\u0004\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "T", "Lkotlinx/coroutines/flow/Flow;", HummerConstants.HUMMER_NEXT, "catchResumeNext", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/social/Result;", "Lkotlin/Function1;", "", "assertion", "test", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result$Success;", "toFlowResult", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FlowExtKt {
    public static final <T> Object test(Flow<? extends Result<? extends T>> flow, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        Object collect = flow.collect(new FlowExtKt$test$2(function1), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    private static final <T> Object test$$forInline(Flow<? extends Result<? extends T>> flow, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        FlowExtKt$test$2 flowExtKt$test$2 = new FlowExtKt$test$2(function1);
        InlineMarker.mark(0);
        flow.collect(flowExtKt$test$2, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final <T> Flow<Result.Success<T>> toFlowResult(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        return FlowKt.flow(new FlowExtKt$toFlowResult$1(t, null));
    }

    public static final <T> Flow<T> catchResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(flow2, "");
        return FlowKt.m4649catch(flow, new FlowExtKt$catchResumeNext$1(flow2, null));
    }
}
