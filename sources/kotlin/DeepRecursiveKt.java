package kotlin;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b*v\b\u0002\u0010\u0010\"7\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\f¢\u0006\u0002\b\u000f27\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\f¢\u0006\u0002\b\u000f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "R", "Lkotlin/DeepRecursiveFunction;", "value", BridgeDSL.INVOKE, "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "", "UNDEFINED_RESULT", "Ljava/lang/Object;", "getUNDEFINED_RESULT$annotations", "()V", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "DeepRecursiveFunctionBlock"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    private static /* synthetic */ void DeepRecursiveFunctionBlock$annotations() {
    }

    private static /* synthetic */ void getUNDEFINED_RESULT$annotations() {
    }

    public static final <T, R> R invoke(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "");
        return (R) new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), t).runCallLoop();
    }

    static {
        Result.Companion companion = Result.INSTANCE;
        UNDEFINED_RESULT = Result.m3179constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }
}
