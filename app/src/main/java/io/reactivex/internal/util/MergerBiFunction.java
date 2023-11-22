package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes9.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004a A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003c -> B:15:0x003e). Please submit an issue!!! */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object apply(java.lang.Object r7, java.lang.Object r8) throws java.lang.Exception {
        /*
            r6 = this;
            java.util.List r7 = (java.util.List) r7
            java.util.List r8 = (java.util.List) r8
            int r0 = r7.size()
            int r1 = r8.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L15
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r7 = r7.iterator()
            java.util.Iterator r8 = r8.iterator()
            boolean r0 = r7.hasNext()
            r2 = 0
            if (r0 == 0) goto L2e
            java.lang.Object r0 = r7.next()
            goto L2f
        L2e:
            r0 = r2
        L2f:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L3b
            java.lang.Object r3 = r8.next()
            r4 = r6
            goto L3e
        L3b:
            r3 = r6
        L3c:
            r4 = r3
            r3 = r2
        L3e:
            if (r0 == 0) goto L6a
            if (r3 == 0) goto L6a
            java.util.Comparator<? super T> r5 = r4.BuiltInFictitiousFunctionClassFactory
            int r5 = r5.compare(r0, r3)
            if (r5 >= 0) goto L5a
            r1.add(r0)
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L58
            java.lang.Object r0 = r7.next()
            goto L3e
        L58:
            r0 = r2
            goto L3e
        L5a:
            r1.add(r3)
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L68
            java.lang.Object r3 = r8.next()
            goto L3e
        L68:
            r3 = r4
            goto L3c
        L6a:
            if (r0 == 0) goto L7d
            r1.add(r0)
        L6f:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L8e
            java.lang.Object r8 = r7.next()
            r1.add(r8)
            goto L6f
        L7d:
            r1.add(r3)
        L80:
            boolean r7 = r8.hasNext()
            if (r7 == 0) goto L8e
            java.lang.Object r7 = r8.next()
            r1.add(r7)
            goto L80
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
