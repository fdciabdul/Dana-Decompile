package androidx.work;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/work/Operation;", "Landroidx/work/Operation$State$SUCCESS;", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class OperationKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object MyBillsEntityDataFactory(kotlin.coroutines.Continuation<? super androidx.work.Operation.State.SUCCESS> r3) {
        /*
            boolean r0 = r3 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L14
            r0 = r3
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r3 = r0.label
            int r3 = r3 + r2
            r0.label = r3
            goto L19
        L14:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r3)
        L19:
            java.lang.Object r3 = r0.result
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            if (r1 == 0) goto L3a
            r2 = 1
            if (r1 != r2) goto L32
            java.lang.Object r0 = r0.L$0
            com.google.common.util.concurrent.ListenableFuture r0 = (com.google.common.util.concurrent.ListenableFuture) r0
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        L32:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r0)
            throw r3
        L3a:
            kotlin.ResultKt.throwOnFailure(r3)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.MyBillsEntityDataFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
