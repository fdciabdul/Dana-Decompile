package id.dana.feeds.data.activation;

import id.dana.domain.social.model.InitFeed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$2", f = "FeedInitEntityRepository.kt", i = {0, 1}, l = {110, 111}, m = "invokeSuspend", n = {"intervalInMillis", "intervalInMillis"}, s = {"J$0", "J$0"})
/* loaded from: classes2.dex */
public final class FeedInitEntityRepository$initFeedPeriodically$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<InitFeed> $initFeed;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ FeedInitEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInitEntityRepository$initFeedPeriodically$2(FeedInitEntityRepository feedInitEntityRepository, Ref.ObjectRef<InitFeed> objectRef, Continuation<? super FeedInitEntityRepository$initFeedPeriodically$2> continuation) {
        super(2, continuation);
        this.this$0 = feedInitEntityRepository;
        this.$initFeed = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedInitEntityRepository$initFeedPeriodically$2(this.this$0, this.$initFeed, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedInitEntityRepository$initFeedPeriodically$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0080 -> B:14:0x0045). Please submit an issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            long r4 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L44
        L14:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1c:
            long r4 = r9.J$0
            java.lang.Object r1 = r9.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L6d
        L2a:
            kotlin.ResultKt.throwOnFailure(r10)
            id.dana.feeds.data.activation.FeedInitEntityRepository r10 = r9.this$0
            boolean r10 = id.dana.feeds.data.activation.FeedInitEntityRepository.lookAheadTest(r10)
            if (r10 == 0) goto L84
            id.dana.feeds.data.activation.FeedInitEntityRepository r10 = r9.this$0
            java.lang.Integer r10 = id.dana.feeds.data.activation.FeedInitEntityRepository.moveToNextValue(r10)
            int r10 = r10.intValue()
            long r4 = (long) r10
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
        L44:
            r10 = r9
        L45:
            id.dana.feeds.data.activation.FeedInitEntityRepository r1 = r10.this$0
            kotlin.jvm.internal.Ref$ObjectRef<id.dana.domain.social.model.InitFeed> r6 = r10.$initFeed
            T r6 = r6.element
            id.dana.domain.social.model.InitFeed r6 = (id.dana.domain.social.model.InitFeed) r6
            boolean r1 = id.dana.feeds.data.activation.FeedInitEntityRepository.BuiltInFictitiousFunctionClassFactory(r1, r6)
            if (r1 == 0) goto L84
            kotlin.jvm.internal.Ref$ObjectRef<id.dana.domain.social.model.InitFeed> r1 = r10.$initFeed
            id.dana.feeds.data.activation.FeedInitEntityRepository r6 = r10.this$0
            r7 = r10
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r10.L$0 = r1
            r10.J$0 = r4
            r10.label = r3
            java.lang.Object r6 = id.dana.feeds.data.activation.FeedInitEntityRepository.MyBillsEntityDataFactory(r6, r7)
            if (r6 != r0) goto L67
            return r0
        L67:
            r8 = r0
            r0 = r10
            r10 = r6
            r5 = r4
            r4 = r1
            r1 = r8
        L6d:
            r4.element = r10
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r4 = 0
            r0.L$0 = r4
            r0.J$0 = r5
            r0.label = r2
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r10)
            if (r10 != r1) goto L80
            return r1
        L80:
            r10 = r0
            r0 = r1
            r4 = r5
            goto L45
        L84:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
