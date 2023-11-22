package kotlin.contracts;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0005\u001a\u00020\u00022\u0019\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0002\b\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Lkotlin/Function1;", "Lkotlin/contracts/ContractBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "contract", "(Lkotlin/jvm/functions/Function1;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ContractBuilderKt {
    private static final void contract(Function1<? super ContractBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
    }
}
