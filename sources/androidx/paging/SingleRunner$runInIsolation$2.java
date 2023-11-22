package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", i = {0, 1}, l = {53, 59, 61, 61}, m = "invokeSuspend", n = {"myJob", "myJob"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class SingleRunner$runInIsolation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ int $priority;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleRunner$runInIsolation$2(SingleRunner singleRunner, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super SingleRunner$runInIsolation$2> continuation) {
        super(2, continuation);
        this.this$0 = singleRunner;
        this.$priority = i;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SingleRunner$runInIsolation$2 singleRunner$runInIsolation$2 = new SingleRunner$runInIsolation$2(this.this$0, this.$priority, this.$block, continuation);
        singleRunner$runInIsolation$2.L$0 = obj;
        return singleRunner$runInIsolation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SingleRunner$runInIsolation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[RETURN] */
    /* JADX WARN: Type inference failed for: r10v16, types: [androidx.paging.SingleRunner$Holder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L3c
            if (r1 == r5) goto L34
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L25
            if (r1 == r2) goto L1c
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1c:
            java.lang.Object r0 = r9.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lab
        L25:
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lac
        L2a:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L32
            goto L81
        L32:
            r10 = move-exception
            goto L96
        L34:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6c
        L3c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlin.coroutines.CoroutineContext r10 = r10.getPlaceComponentResult()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r1)
            if (r10 == 0) goto Laf
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            androidx.paging.SingleRunner r1 = r9.this$0
            androidx.paging.SingleRunner$Holder r1 = androidx.paging.SingleRunner.BuiltInFictitiousFunctionClassFactory(r1)
            int r6 = r9.$priority
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r10
            r9.label = r5
            java.lang.Object r1 = r1.getAuthRequestContext(r6, r10, r7)
            if (r1 != r0) goto L69
            return r0
        L69:
            r8 = r1
            r1 = r10
            r10 = r8
        L6c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lac
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r9.$block     // Catch: java.lang.Throwable -> L32
            r9.L$0 = r1     // Catch: java.lang.Throwable -> L32
            r9.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r10 = r10.invoke(r9)     // Catch: java.lang.Throwable -> L32
            if (r10 != r0) goto L81
            return r0
        L81:
            androidx.paging.SingleRunner r10 = r9.this$0
            androidx.paging.SingleRunner$Holder r10 = androidx.paging.SingleRunner.BuiltInFictitiousFunctionClassFactory(r10)
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r4 = 0
            r9.L$0 = r4
            r9.label = r3
            java.lang.Object r10 = r10.MyBillsEntityDataFactory(r1, r2)
            if (r10 != r0) goto Lac
            return r0
        L96:
            androidx.paging.SingleRunner r3 = r9.this$0
            androidx.paging.SingleRunner$Holder r3 = androidx.paging.SingleRunner.BuiltInFictitiousFunctionClassFactory(r3)
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r10
            r9.label = r2
            java.lang.Object r1 = r3.MyBillsEntityDataFactory(r1, r4)
            if (r1 != r0) goto Laa
            return r0
        Laa:
            r0 = r10
        Lab:
            throw r0
        Lac:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        Laf:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Internal error. coroutineScope should've created a job."
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner$runInIsolation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
