package kotlinx.coroutines.selects;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u000f\u001a\u00020\t\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00010\r2\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R-\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0012`\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "timeMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", BridgeDSL.INVOKE, "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "clauses", "Ljava/util/ArrayList;", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "instance", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "getInstance", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UnbiasedSelectBuilderImpl<R> implements SelectBuilder<R> {
    public final ArrayList<Function0<Unit>> clauses;
    private final SelectBuilderImpl<R> instance;

    @JvmName(name = "getInstance")
    public final SelectBuilderImpl<R> getInstance() {
        return this.instance;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public final <Q> void invoke(final SelectClause1<? extends Q> selectClause1, final Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.clauses.add(new Function0<Unit>() { // from class: kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$invoke$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                selectClause1.registerSelectClause1(this.getInstance(), function2);
            }
        });
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public final void onTimeout(final long timeMillis, final Function1<? super Continuation<? super R>, ? extends Object> block) {
        this.clauses.add(new Function0<Unit>(this) { // from class: kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$onTimeout$1
            final /* synthetic */ UnbiasedSelectBuilderImpl<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getInstance().onTimeout(timeMillis, block);
            }
        });
    }
}
