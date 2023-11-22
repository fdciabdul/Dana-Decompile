package kotlin;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u0005\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t2\u0006\u0010\u0004\u001a\u00028\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\nJ&\u0010\f\u001a\u00020\u000b*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\u0002¢\u0006\u0004\b\f\u0010\r\u0082\u0001\u0001\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/DeepRecursiveScope;", "T", "R", "", "value", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "S", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", BridgeDSL.INVOKE, "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Void;", "<init>", "()V", "Lkotlin/DeepRecursiveScopeImpl;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DeepRecursiveScope<T, R> {
    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object callRecursive(T t, Continuation<? super R> continuation);

    public abstract <U, S> Object callRecursive(DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, Continuation<? super S> continuation);

    private DeepRecursiveScope() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    public final Void invoke(DeepRecursiveFunction<?, ?> deepRecursiveFunction, Object obj) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
