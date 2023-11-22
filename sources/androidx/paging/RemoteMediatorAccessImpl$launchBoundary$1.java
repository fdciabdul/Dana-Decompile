package androidx.paging;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessImpl$launchBoundary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchBoundary$1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Continuation<? super RemoteMediatorAccessImpl$launchBoundary$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteMediatorAccessImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteMediatorAccessImpl$launchBoundary$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RemoteMediatorAccessImpl$launchBoundary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SingleRunner singleRunner;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            singleRunner = ((RemoteMediatorAccessImpl) this.this$0).getAuthRequestContext;
            this.label = 1;
            if (singleRunner.getAuthRequestContext(1, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u008a@"}, d2 = {"", "Key", "Value", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {345}, m = "invokeSuspend", n = {GriverMonitorConstants.KEY_LOAD_TYPE}, s = {"L$0"})
    /* renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = remoteMediatorAccessImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0057 -> B:17:0x005b). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r7.L$0
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                kotlin.ResultKt.throwOnFailure(r8)
                r3 = r1
                r1 = r0
                r0 = r7
                goto L5b
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                r8 = r7
            L22:
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r1 = r8.this$0
                androidx.paging.AccessorStateHolder r1 = androidx.paging.RemoteMediatorAccessImpl.KClassImpl$Data$declaredNonStaticMembers$2(r1)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r3 = new kotlin.jvm.functions.Function1<androidx.paging.AccessorState<Key, Value>, kotlin.Pair<? extends androidx.paging.LoadType, ? extends androidx.paging.PagingState<Key, Value>>>() { // from class: androidx.paging.RemoteMediatorAccessImpl.launchBoundary.1.1.1
                    static {
                        /*
                            androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1) androidx.paging.RemoteMediatorAccessImpl.launchBoundary.1.1.1.INSTANCE androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00051.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 1
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00051.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                        /*
                            r0 = this;
                            androidx.paging.AccessorState r1 = (androidx.paging.AccessorState) r1
                            kotlin.Pair r1 = r0.invoke(r1)
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00051.invoke(java.lang.Object):java.lang.Object");
                    }

                    public final kotlin.Pair<androidx.paging.LoadType, androidx.paging.PagingState<Key, Value>> invoke(androidx.paging.AccessorState<Key, Value> r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            kotlin.Pair r2 = r2.getAuthRequestContext()
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00051.invoke(androidx.paging.AccessorState):kotlin.Pair");
                    }
                }
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                java.lang.Object r1 = r1.PlaceComponentResult(r3)
                kotlin.Pair r1 = (kotlin.Pair) r1
                if (r1 != 0) goto L37
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L37:
                java.lang.Object r3 = r1.component1()
                androidx.paging.LoadType r3 = (androidx.paging.LoadType) r3
                java.lang.Object r1 = r1.component2()
                androidx.paging.PagingState r1 = (androidx.paging.PagingState) r1
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r1 = r8.this$0
                androidx.paging.RemoteMediator r1 = androidx.paging.RemoteMediatorAccessImpl.MyBillsEntityDataFactory(r1)
                r4 = r8
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r8.L$0 = r3
                r8.label = r2
                java.lang.Object r1 = r1.MyBillsEntityDataFactory()
                if (r1 != r0) goto L57
                return r0
            L57:
                r6 = r0
                r0 = r8
                r8 = r1
                r1 = r6
            L5b:
                androidx.paging.RemoteMediator$MediatorResult r8 = (androidx.paging.RemoteMediator.MediatorResult) r8
                boolean r4 = r8 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                if (r4 == 0) goto L72
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r4 = r0.this$0
                androidx.paging.AccessorStateHolder r4 = androidx.paging.RemoteMediatorAccessImpl.KClassImpl$Data$declaredNonStaticMembers$2(r4)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r5 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                r5.<init>()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r4.PlaceComponentResult(r5)
                goto L86
            L72:
                boolean r4 = r8 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                if (r4 == 0) goto L86
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r4 = r0.this$0
                androidx.paging.AccessorStateHolder r4 = androidx.paging.RemoteMediatorAccessImpl.KClassImpl$Data$declaredNonStaticMembers$2(r4)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r5 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                r5.<init>()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r4.PlaceComponentResult(r5)
            L86:
                r8 = r0
                r0 = r1
                goto L22
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
