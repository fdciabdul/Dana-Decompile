package kotlin.comparisons;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003B\u001f\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\t\u0010\nR'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00038\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\n"}, d2 = {"Lkotlin/comparisons/ReversedComparator;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "()Ljava/util/Comparator;", "comparator", "Ljava/util/Comparator;", "getComparator", "<init>", "(Ljava/util/Comparator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ReversedComparator<T> implements Comparator<T>, j$.util.Comparator {
    private final Comparator<T> comparator;

    public final /* synthetic */ Comparator thenComparing(Function function) {
        return Comparator.CC.getAuthRequestContext(this, function);
    }

    public final /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.BuiltInFictitiousFunctionClassFactory(this, function, comparator);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, comparator);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
        return thenComparing(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return thenComparing(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function), comparator);
    }

    public final /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.MyBillsEntityDataFactory(this, toDoubleFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return thenComparingDouble(ToDoubleFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toDoubleFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.PlaceComponentResult(this, toIntFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return thenComparingInt(ToIntFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toIntFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.PlaceComponentResult(this, toLongFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return thenComparingLong(ToLongFunction.VivifiedWrapper.MyBillsEntityDataFactory(toLongFunction));
    }

    public ReversedComparator(java.util.Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        this.comparator = comparator;
    }

    @JvmName(name = "getComparator")
    public final java.util.Comparator<T> getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public final int compare(T a2, T b) {
        return this.comparator.compare(b, a2);
    }

    @Override // java.util.Comparator
    public final java.util.Comparator<T> reversed() {
        return this.comparator;
    }
}
