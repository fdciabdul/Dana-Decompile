package androidx.paging;

import androidx.paging.HintHandler;
import androidx.paging.ViewportHint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002 !B^\u0012(\u0010\u0019\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR9\u0010\u0014\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00108\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageFetcher;", "", "Key", "Value", "", "PlaceComponentResult", "()V", "Landroidx/paging/PagingConfig;", "getAuthRequestContext", "Landroidx/paging/PagingConfig;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource;", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/ConflatedEventBus;", "", "Landroidx/paging/ConflatedEventBus;", "moveToNextValue", "p0", "p1", "p2", "Landroidx/paging/RemoteMediator;", "p3", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;)V", "GenerationInfo", "PagerUiReceiver"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcher<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ConflatedEventBus<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Flow<PagingData<Value>> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Key getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<Continuation<? super PagingSource<Key, Value>>, Object> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PagingConfig MyBillsEntityDataFactory;
    private final ConflatedEventBus<Unit> moveToNextValue;

    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcher(Function1<? super Continuation<? super PagingSource<Key, Value>>, ? extends Object> function1, Key key, PagingConfig pagingConfig) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(pagingConfig, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.getAuthRequestContext = key;
        this.MyBillsEntityDataFactory = pagingConfig;
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ConflatedEventBus<>(defaultConstructorMarker, i, defaultConstructorMarker);
        this.moveToNextValue = new ConflatedEventBus<>(defaultConstructorMarker, i, defaultConstructorMarker);
        this.PlaceComponentResult = SimpleChannelFlowKt.BuiltInFictitiousFunctionClassFactory(new PageFetcher$flow$1(null, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object PlaceComponentResult(androidx.paging.PageFetcher r4, androidx.paging.PagingSource r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof androidx.paging.PageFetcher$generateNewPagingSource$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = (androidx.paging.PageFetcher$generateNewPagingSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            androidx.paging.PagingSource r5 = (androidx.paging.PagingSource) r5
            java.lang.Object r4 = r0.L$0
            androidx.paging.PageFetcher r4 = (androidx.paging.PageFetcher) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super androidx.paging.PagingSource<Key, Value>>, java.lang.Object> r6 = r4.BuiltInFictitiousFunctionClassFactory
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            androidx.paging.PagingSource r6 = (androidx.paging.PagingSource) r6
            boolean r0 = r6 instanceof androidx.paging.LegacyPagingSource
            if (r0 == 0) goto L5d
            r0 = r6
            androidx.paging.LegacyPagingSource r0 = (androidx.paging.LegacyPagingSource) r0
            androidx.paging.PagingConfig r1 = r4.MyBillsEntityDataFactory
            int r1 = r1.getAuthRequestContext
            r0.MyBillsEntityDataFactory(r1)
        L5d:
            if (r6 != r5) goto L60
            r3 = 0
        L60:
            if (r3 == 0) goto L8c
            androidx.paging.PageFetcher$generateNewPagingSource$3 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$3
            r0.<init>(r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.paging.InvalidateCallbackTracker<kotlin.jvm.functions.Function0<kotlin.Unit>> r2 = r6.MyBillsEntityDataFactory
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r5 == 0) goto L84
            androidx.paging.PageFetcher$generateNewPagingSource$4 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$4
            r0.<init>(r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.paging.InvalidateCallbackTracker<kotlin.jvm.functions.Function0<kotlin.Unit>> r4 = r5.MyBillsEntityDataFactory
            r4.MyBillsEntityDataFactory(r0)
        L84:
            if (r5 == 0) goto L8b
            androidx.paging.InvalidateCallbackTracker<kotlin.jvm.functions.Function0<kotlin.Unit>> r4 = r5.MyBillsEntityDataFactory
            r4.getAuthRequestContext()
        L8b:
            return r6
        L8c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher.PlaceComponentResult(androidx.paging.PageFetcher, androidx.paging.PagingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(Boolean.TRUE);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0004B)\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nX\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "", "Key", "Value", "Landroidx/paging/UiReceiver;", "Landroidx/paging/ViewportHint;", "p0", "", "getAuthRequestContext", "(Landroidx/paging/ViewportHint;)V", "Landroidx/paging/PageFetcherSnapshot;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/ConflatedEventBus;", "MyBillsEntityDataFactory", "Landroidx/paging/ConflatedEventBus;", "p1", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/ConflatedEventBus;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PagerUiReceiver<Key, Value> implements UiReceiver {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final PageFetcherSnapshot<Key, Value> getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final ConflatedEventBus<Unit> BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ PageFetcher<Key, Value> PlaceComponentResult;

        public PagerUiReceiver(PageFetcher pageFetcher, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, ConflatedEventBus<Unit> conflatedEventBus) {
            Intrinsics.checkNotNullParameter(pageFetcher, "");
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "");
            Intrinsics.checkNotNullParameter(conflatedEventBus, "");
            this.PlaceComponentResult = pageFetcher;
            this.getAuthRequestContext = pageFetcherSnapshot;
            this.BuiltInFictitiousFunctionClassFactory = conflatedEventBus;
        }

        @Override // androidx.paging.UiReceiver
        public final void getAuthRequestContext(final ViewportHint p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            PageFetcherSnapshot<Key, Value> pageFetcherSnapshot = this.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(p0, "");
            HintHandler hintHandler = pageFetcherSnapshot.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            hintHandler.getAuthRequestContext.PlaceComponentResult(p0 instanceof ViewportHint.Access ? (ViewportHint.Access) p0 : null, new Function2<HintHandler.HintFlow, HintHandler.HintFlow, Unit>() { // from class: androidx.paging.HintHandler$processHint$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(HintHandler.HintFlow hintFlow, HintHandler.HintFlow hintFlow2) {
                    invoke2(hintFlow, hintFlow2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HintHandler.HintFlow hintFlow, HintHandler.HintFlow hintFlow2) {
                    Intrinsics.checkNotNullParameter(hintFlow, "");
                    Intrinsics.checkNotNullParameter(hintFlow2, "");
                    if (HintHandlerKt.KClassImpl$Data$declaredNonStaticMembers$2(ViewportHint.this, hintFlow.PlaceComponentResult, LoadType.PREPEND)) {
                        ViewportHint viewportHint = ViewportHint.this;
                        hintFlow.PlaceComponentResult = viewportHint;
                        if (viewportHint != null) {
                            hintFlow.KClassImpl$Data$declaredNonStaticMembers$2.tryEmit(viewportHint);
                        }
                    }
                    if (HintHandlerKt.KClassImpl$Data$declaredNonStaticMembers$2(ViewportHint.this, hintFlow2.PlaceComponentResult, LoadType.APPEND)) {
                        ViewportHint viewportHint2 = ViewportHint.this;
                        hintFlow2.PlaceComponentResult = viewportHint2;
                        if (viewportHint2 != null) {
                            hintFlow2.KClassImpl$Data$declaredNonStaticMembers$2.tryEmit(viewportHint2);
                        }
                    }
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B9\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "", "Key", "Value", "Lkotlinx/coroutines/Job;", "PlaceComponentResult", "Lkotlinx/coroutines/Job;", "getAuthRequestContext", "Landroidx/paging/PageFetcherSnapshot;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/PagingState;", "MyBillsEntityDataFactory", "Landroidx/paging/PagingState;", "p0", "p1", "p2", "<init>", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    static final class GenerationInfo<Key, Value> {
        final PageFetcherSnapshot<Key, Value> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final PagingState<Key, Value> PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Job getAuthRequestContext;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, PagingState<Key, Value> pagingState, Job job) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "");
            Intrinsics.checkNotNullParameter(job, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pageFetcherSnapshot;
            this.PlaceComponentResult = pagingState;
            this.getAuthRequestContext = job;
        }
    }

    public static final /* synthetic */ Flow KClassImpl$Data$declaredNonStaticMembers$2(PageFetcherSnapshot pageFetcherSnapshot, Job job, RemoteMediatorAccessor remoteMediatorAccessor) {
        if (remoteMediatorAccessor != null) {
            return CancelableChannelFlowKt.BuiltInFictitiousFunctionClassFactory(job, new PageFetcher$injectRemoteEvents$1(remoteMediatorAccessor, pageFetcherSnapshot, new MutableLoadStateCollection(), null));
        }
        return pageFetcherSnapshot.getErrorConfigVersion;
    }
}
