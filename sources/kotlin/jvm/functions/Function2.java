package kotlin.jvm.functions;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Function;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u0000*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00020\u0004J \u0010\u0007\u001a\u00028\u00022\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H¦\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/jvm/functions/Function2;", "P1", "P2", "R", "Lkotlin/Function;", "p1", "p2", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Function2<P1, P2, R> extends Function<R> {
    R invoke(P1 p1, P2 p2);
}
