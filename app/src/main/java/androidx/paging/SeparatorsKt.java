package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a?\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001am\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\u000b*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\f2\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u000b*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2.\u0010\u0002\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011H\u0080@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "T", "p0", "", "p1", "", "p2", "p3", "Landroidx/paging/TransformablePage;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "R", "", "p4", "", "PlaceComponentResult", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/TransformablePage;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SeparatorsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00cb -> B:29:0x00d4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R, T extends R> java.lang.Object BuiltInFictitiousFunctionClassFactory(androidx.paging.TransformablePage<T> r12, kotlin.jvm.functions.Function3<? super T, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super androidx.paging.TransformablePage<R>> r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.BuiltInFictitiousFunctionClassFactory(androidx.paging.TransformablePage, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> TransformablePage<T> BuiltInFictitiousFunctionClassFactory(T t, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(iArr, "");
        return new TransformablePage<>(iArr, CollectionsKt.listOf(t), i, CollectionsKt.listOf(Integer.valueOf(i2)));
    }

    public static final <R, T extends R> void PlaceComponentResult(List<TransformablePage<R>> list, R r, TransformablePage<T> transformablePage, TransformablePage<T> transformablePage2, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        int[] iArr = transformablePage == null ? null : transformablePage.MyBillsEntityDataFactory;
        int[] iArr2 = transformablePage2 != null ? transformablePage2.MyBillsEntityDataFactory : null;
        if (iArr != null && iArr2 != null) {
            iArr = CollectionsKt.toIntArray(CollectionsKt.sorted(ArraysKt.distinct(ArraysKt.plus(iArr, iArr2))));
        } else if (iArr == null && iArr2 != null) {
            iArr = iArr2;
        } else if (iArr == null || iArr2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(iArr, "");
        if (r != null) {
            list.add(BuiltInFictitiousFunctionClassFactory(r, iArr, i, i2));
        }
    }
}
