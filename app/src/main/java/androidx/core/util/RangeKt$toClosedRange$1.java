package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.ranges.ClosedRange;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u0018\u0010\u0004\u001a\u0006*\u00028\u00008\u00008WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0006\u001a\u0006*\u00028\u00008\u00008WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003"}, d2 = {"Landroidx/core/util/RangeKt$toClosedRange$1;", "Lkotlin/ranges/ClosedRange;", "getEndInclusive", "()Ljava/lang/Comparable;", "PlaceComponentResult", "getStart", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RangeKt$toClosedRange$1<T> implements ClosedRange<T> {
    final /* synthetic */ Range<T> PlaceComponentResult;

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    @Override // kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        return ClosedRange.DefaultImpls.contains(this, comparable);
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getEndInclusive")
    public final Comparable getEndInclusive() {
        return this.PlaceComponentResult.getUpper();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getStart")
    public final Comparable getStart() {
        return this.PlaceComponentResult.getLower();
    }
}
