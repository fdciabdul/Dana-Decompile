package kotlinx.coroutines.selects;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P", "Q", "R", "", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Q, Continuation<? super R>, Object> $$block;
    final /* synthetic */ P $$param;
    final /* synthetic */ SelectClause2<P, Q> $$this_invoke;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnbiasedSelectBuilderImpl$invoke$3(SelectClause2<? super P, ? extends Q> selectClause2, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.$$this_invoke = selectClause2;
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$$param = p;
        this.$$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$$this_invoke.registerSelectClause2(this.this$0.getInstance(), this.$$param, this.$$block);
    }
}
