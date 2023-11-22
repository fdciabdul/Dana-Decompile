package androidx.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u000bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "p0", "Lkotlinx/coroutines/DisposableHandle;", "getAuthRequestContext", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()V", "Landroidx/lifecycle/BlockRunner;", "scheduleImpl", "Landroidx/lifecycle/BlockRunner;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/EmittedSource;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/lifecycle/EmittedSource;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private EmittedSource getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private BlockRunner<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ CoroutineLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineLiveData<T> coroutineLiveData) {
            super(0);
            this.this$0 = coroutineLiveData;
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((CoroutineLiveData) this.this$0).KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(androidx.view.LiveData<T> r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.DisposableHandle> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.view.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.view.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r6 = (androidx.view.CoroutineLiveData) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6a
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            java.lang.Object r6 = r0.L$1
            androidx.lifecycle.LiveData r6 = (androidx.view.LiveData) r6
            java.lang.Object r2 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r2 = (androidx.view.CoroutineLiveData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r2
            goto L59
        L47:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.BuiltInFictitiousFunctionClassFactory(r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            r7 = r6
            r6 = r5
        L59:
            r2 = r6
            androidx.lifecycle.MediatorLiveData r2 = (androidx.view.MediatorLiveData) r2
            r0.L$0 = r6
            r4 = 0
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = androidx.view.CoroutineLiveDataKt.PlaceComponentResult(r2, r7, r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            androidx.lifecycle.EmittedSource r7 = (androidx.view.EmittedSource) r7
            r6.getAuthRequestContext = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.CoroutineLiveData.getAuthRequestContext(androidx.lifecycle.LiveData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.view.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.view.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r0 = (androidx.view.CoroutineLiveData) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L65
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.lifecycle.EmittedSource r6 = r5.getAuthRequestContext
            if (r6 != 0) goto L3f
            goto L64
        L3f:
            r0.L$0 = r5
            r0.label = r4
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = r2.getImmediate()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            androidx.lifecycle.EmittedSource$disposeNow$2 r4 = new androidx.lifecycle.EmittedSource$disposeNow$2
            r4.<init>(r6, r3)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r0) goto L5f
            goto L61
        L5f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L61:
            if (r6 != r1) goto L64
            return r1
        L64:
            r0 = r5
        L65:
            r0.getAuthRequestContext = r3
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.CoroutineLiveData.BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        Job launch$default;
        super.BuiltInFictitiousFunctionClassFactory();
        BlockRunner<T> blockRunner = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (blockRunner != null) {
            Job job = blockRunner.getAuthRequestContext;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            blockRunner.getAuthRequestContext = null;
            if (blockRunner.MyBillsEntityDataFactory == null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(blockRunner.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, new BlockRunner$maybeRun$1(blockRunner, null), 3, null);
                blockRunner.MyBillsEntityDataFactory = launch$default;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public final void getAuthRequestContext() {
        Job launch$default;
        super.getAuthRequestContext();
        BlockRunner<T> blockRunner = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (blockRunner != null) {
            if (blockRunner.getAuthRequestContext == null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(blockRunner.NetworkUserEntityData$$ExternalSyntheticLambda0, Dispatchers.getMain().getImmediate(), null, new BlockRunner$cancel$1(blockRunner, null), 2, null);
                blockRunner.getAuthRequestContext = launch$default;
                return;
            }
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
    }
}
