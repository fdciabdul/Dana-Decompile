package j$.util;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Comparators$NaturalOrderComparator implements java.util.Comparator, Comparator {
    private static final /* synthetic */ Comparators$NaturalOrderComparator[] $VALUES;
    public static final Comparators$NaturalOrderComparator INSTANCE;

    static {
        Comparators$NaturalOrderComparator comparators$NaturalOrderComparator = new Comparators$NaturalOrderComparator();
        INSTANCE = comparators$NaturalOrderComparator;
        $VALUES = new Comparators$NaturalOrderComparator[]{comparators$NaturalOrderComparator};
    }

    private Comparators$NaturalOrderComparator() {
    }

    public static Comparators$NaturalOrderComparator valueOf(String str) {
        return (Comparators$NaturalOrderComparator) Enum.valueOf(Comparators$NaturalOrderComparator.class, str);
    }

    public static Comparators$NaturalOrderComparator[] values() {
        return (Comparators$NaturalOrderComparator[]) $VALUES.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    @Override // java.util.Comparator
    public final java.util.Comparator reversed() {
        return Collections.reverseOrder();
    }

    public final /* synthetic */ java.util.Comparator thenComparing(Function function) {
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
        return Comparator.CC.getAuthRequestContext(this, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return Comparator.CC.BuiltInFictitiousFunctionClassFactory(this, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function), comparator);
    }

    public final /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.MyBillsEntityDataFactory(this, toDoubleFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.MyBillsEntityDataFactory(this, ToDoubleFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toDoubleFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.PlaceComponentResult(this, toIntFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return Comparator.CC.PlaceComponentResult(this, ToIntFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toIntFunction));
    }

    public final /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.PlaceComponentResult(this, toLongFunction);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return Comparator.CC.PlaceComponentResult(this, ToLongFunction.VivifiedWrapper.MyBillsEntityDataFactory(toLongFunction));
    }
}
