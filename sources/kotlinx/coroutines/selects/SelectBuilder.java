package kotlinx.coroutines.selects;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J8\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJG\u0010\u000e\u001a\u00020\b\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\f2\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH¦\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilder;", "R", "", "", "timeMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", BridgeDSL.INVOKE, "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SelectBuilder<R> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
    }

    <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block);
}
