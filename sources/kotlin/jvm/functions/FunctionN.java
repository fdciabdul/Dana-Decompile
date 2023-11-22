package kotlin.jvm.functions;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.FunctionBase;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J(\u0010\u0007\u001a\u00028\u00002\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/jvm/functions/FunctionN;", "R", "Lkotlin/Function;", "Lkotlin/jvm/internal/FunctionBase;", "", "", "args", BridgeDSL.INVOKE, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "getArity", "()I", "arity"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface FunctionN<R> extends Function<R>, FunctionBase<R> {
    @Override // kotlin.jvm.internal.FunctionBase
    @JvmName(name = "getArity")
    int getArity();

    R invoke(Object... args);
}
