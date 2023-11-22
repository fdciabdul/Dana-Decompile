package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

/* loaded from: classes.dex */
public class AppendOnlyLinkedArrayList<T> {
    Object[] BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2 = 4;
    public final Object[] PlaceComponentResult;
    int getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList() {
        Object[] objArr = new Object[5];
        this.PlaceComponentResult = objArr;
        this.BuiltInFictitiousFunctionClassFactory = objArr;
    }

    public final void getAuthRequestContext(T t) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = this.getAuthRequestContext;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.BuiltInFictitiousFunctionClassFactory[i] = objArr;
            this.BuiltInFictitiousFunctionClassFactory = objArr;
            i2 = 0;
        }
        this.BuiltInFictitiousFunctionClassFactory[i2] = t;
        this.getAuthRequestContext = i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0017, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.PlaceComponentResult
            int r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
        L4:
            if (r0 == 0) goto L1c
            r2 = 0
        L7:
            if (r2 >= r1) goto L17
            r3 = r0[r2]
            if (r3 == 0) goto L17
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L14
            return
        L14:
            int r2 = r2 + 1
            goto L7
        L17:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <U> boolean BuiltInFictitiousFunctionClassFactory(org.reactivestreams.Subscriber<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.PlaceComponentResult
            int r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
        L4:
            r2 = 0
            if (r0 == 0) goto L1d
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 == 0) goto L18
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L15
            r5 = 1
            return r5
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(org.reactivestreams.Subscriber):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <U> boolean BuiltInFictitiousFunctionClassFactory(io.reactivex.Observer<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.PlaceComponentResult
            int r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
        L4:
            r2 = 0
            if (r0 == 0) goto L1d
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 == 0) goto L18
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L15
            r5 = 1
            return r5
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(io.reactivex.Observer):boolean");
    }
}
