package kotlin.comparisons;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "reversed", "()Ljava/util/Comparator;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReverseOrderComparator implements Comparator<Comparable<? super Object>>, j$.util.Comparator {
    public static final ReverseOrderComparator INSTANCE = new ReverseOrderComparator();

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
    public final /* synthetic */ java.util.Comparator<Comparable<? super Object>> thenComparing(java.util.function.Function function) {
        return thenComparing(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator<Comparable<? super Object>> thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return thenComparing(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function), comparator);
    }

    public final /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.MyBillsEntityDataFactory(this, toDoubleFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator<Comparable<? super Object>> thenComparingDouble(java.util.function.ToDoubleFunction<? super Comparable<? super Object>> toDoubleFunction) {
        return thenComparingDouble(ToDoubleFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toDoubleFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.PlaceComponentResult(this, toIntFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator<Comparable<? super Object>> thenComparingInt(java.util.function.ToIntFunction<? super Comparable<? super Object>> toIntFunction) {
        return thenComparingInt(ToIntFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toIntFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.PlaceComponentResult(this, toLongFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator<Comparable<? super Object>> thenComparingLong(java.util.function.ToLongFunction<? super Comparable<? super Object>> toLongFunction) {
        return thenComparingLong(ToLongFunction.VivifiedWrapper.MyBillsEntityDataFactory(toLongFunction));
    }

    private ReverseOrderComparator() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    /* renamed from: compare  reason: avoid collision after fix types in other method */
    public final int compare2(Comparable<Object> a2, Comparable<Object> b) {
        Intrinsics.checkNotNullParameter(a2, "");
        Intrinsics.checkNotNullParameter(b, "");
        return b.compareTo(a2);
    }

    @Override // java.util.Comparator
    public final java.util.Comparator<Comparable<? super Object>> reversed() {
        return NaturalOrderComparator.INSTANCE;
    }
}
