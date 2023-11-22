package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010#\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020\u0019\u0012\b\b\u0002\u0010%\u001a\u00020\u0019¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\rX\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118\u0001X\u0080\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\f\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0014\u0010\b\u001a\u00020!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010\u001b"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", "", "T", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(I)Ljava/lang/Object;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "PlaceComponentResult", "Landroidx/paging/DifferCallback;", "getAuthRequestContext", "Landroidx/paging/DifferCallback;", "MyBillsEntityDataFactory", "", "moveToNextValue", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getErrorConfigVersion", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "scheduleImpl", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "lookAheadTest", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "p1", "p2", "p3", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final AsyncPagingDataDiffer$differBase$1 PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Flow<CombinedLoadStates> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Flow<Unit> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final DiffUtil.ItemCallback<T> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final AtomicInteger lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final DifferCallback MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CoroutineDispatcher moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CoroutineDispatcher getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ListUpdateCallback NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.paging.PagingDataDiffer, androidx.paging.AsyncPagingDataDiffer$differBase$1] */
    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback, final CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(itemCallback, "");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        this.BuiltInFictitiousFunctionClassFactory = itemCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = listUpdateCallback;
        this.moveToNextValue = coroutineDispatcher;
        this.getErrorConfigVersion = coroutineDispatcher2;
        final DifferCallback differCallback = new DifferCallback(this) { // from class: androidx.paging.AsyncPagingDataDiffer$differCallback$1
            final /* synthetic */ AsyncPagingDataDiffer<T> getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.getAuthRequestContext = this;
            }

            @Override // androidx.paging.DifferCallback
            public final void getAuthRequestContext(int p0, int p1) {
                ListUpdateCallback listUpdateCallback2;
                if (p1 > 0) {
                    listUpdateCallback2 = ((AsyncPagingDataDiffer) this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    listUpdateCallback2.PlaceComponentResult(p0, p1);
                }
            }

            @Override // androidx.paging.DifferCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
                ListUpdateCallback listUpdateCallback2;
                if (p1 > 0) {
                    listUpdateCallback2 = ((AsyncPagingDataDiffer) this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    listUpdateCallback2.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
                }
            }

            @Override // androidx.paging.DifferCallback
            public final void PlaceComponentResult(int p0, int p1) {
                ListUpdateCallback listUpdateCallback2;
                if (p1 > 0) {
                    listUpdateCallback2 = ((AsyncPagingDataDiffer) this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    listUpdateCallback2.getAuthRequestContext(p0, p1, null);
                }
            }
        };
        this.MyBillsEntityDataFactory = differCallback;
        PagingDataDiffer<T> pagingDataDiffer = new PagingDataDiffer<T>(this, differCallback, coroutineDispatcher) { // from class: androidx.paging.AsyncPagingDataDiffer$differBase$1
            final /* synthetic */ AsyncPagingDataDiffer<T> PlaceComponentResult;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.PlaceComponentResult = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
            @Override // androidx.paging.PagingDataDiffer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object MyBillsEntityDataFactory(androidx.paging.NullPaddedList<T> r7, androidx.paging.NullPaddedList<T> r8, int r9, kotlin.jvm.functions.Function0<kotlin.Unit> r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) {
                /*
                    r6 = this;
                    boolean r0 = r11 instanceof androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1
                    if (r0 == 0) goto L14
                    r0 = r11
                    androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1 r0 = (androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r11 = r0.label
                    int r11 = r11 + r2
                    r0.label = r11
                    goto L19
                L14:
                    androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1 r0 = new androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1
                    r0.<init>(r6, r11)
                L19:
                    java.lang.Object r11 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L47
                    if (r2 != r3) goto L3f
                    int r9 = r0.I$0
                    java.lang.Object r7 = r0.L$3
                    r10 = r7
                    kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
                    java.lang.Object r7 = r0.L$2
                    r8 = r7
                    androidx.paging.NullPaddedList r8 = (androidx.paging.NullPaddedList) r8
                    java.lang.Object r7 = r0.L$1
                    androidx.paging.NullPaddedList r7 = (androidx.paging.NullPaddedList) r7
                    java.lang.Object r0 = r0.L$0
                    androidx.paging.AsyncPagingDataDiffer$differBase$1 r0 = (androidx.paging.AsyncPagingDataDiffer$differBase$1) r0
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L9a
                L3f:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L47:
                    kotlin.ResultKt.throwOnFailure(r11)
                    int r11 = r7.MyBillsEntityDataFactory()
                    r2 = 0
                    if (r11 != 0) goto L60
                    r10.invoke()
                    androidx.paging.AsyncPagingDataDiffer<T> r7 = r6.PlaceComponentResult
                    androidx.paging.DifferCallback r7 = r7.MyBillsEntityDataFactory
                    int r8 = r8.MyBillsEntityDataFactory()
                    r7.getAuthRequestContext(r2, r8)
                    goto Lb0
                L60:
                    int r11 = r8.MyBillsEntityDataFactory()
                    if (r11 != 0) goto L75
                    r10.invoke()
                    androidx.paging.AsyncPagingDataDiffer<T> r8 = r6.PlaceComponentResult
                    androidx.paging.DifferCallback r8 = r8.MyBillsEntityDataFactory
                    int r7 = r7.MyBillsEntityDataFactory()
                    r8.KClassImpl$Data$declaredNonStaticMembers$2(r2, r7)
                    goto Lb0
                L75:
                    androidx.paging.AsyncPagingDataDiffer<T> r11 = r6.PlaceComponentResult
                    kotlinx.coroutines.CoroutineDispatcher r11 = androidx.paging.AsyncPagingDataDiffer.getAuthRequestContext(r11)
                    kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
                    androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 r2 = new androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1
                    androidx.paging.AsyncPagingDataDiffer<T> r5 = r6.PlaceComponentResult
                    r2.<init>(r7, r8, r5, r4)
                    kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                    r0.L$0 = r6
                    r0.L$1 = r7
                    r0.L$2 = r8
                    r0.L$3 = r10
                    r0.I$0 = r9
                    r0.label = r3
                    java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r2, r0)
                    if (r11 != r1) goto L99
                    return r1
                L99:
                    r0 = r6
                L9a:
                    androidx.paging.NullPaddedDiffResult r11 = (androidx.paging.NullPaddedDiffResult) r11
                    r10.invoke()
                    androidx.paging.AsyncPagingDataDiffer<T> r10 = r0.PlaceComponentResult
                    androidx.recyclerview.widget.ListUpdateCallback r10 = androidx.paging.AsyncPagingDataDiffer.KClassImpl$Data$declaredNonStaticMembers$2(r10)
                    androidx.paging.NullPaddedListDiffHelperKt.PlaceComponentResult(r7, r10, r8, r11)
                    int r7 = androidx.paging.NullPaddedListDiffHelperKt.KClassImpl$Data$declaredNonStaticMembers$2(r7, r11, r8, r9)
                    java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
                Lb0:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AsyncPagingDataDiffer$differBase$1.MyBillsEntityDataFactory(androidx.paging.NullPaddedList, androidx.paging.NullPaddedList, int, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // androidx.paging.PagingDataDiffer
            public final boolean PlaceComponentResult() {
                return this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
        this.PlaceComponentResult = pagingDataDiffer;
        this.lookAheadTest = new AtomicInteger(0);
        this.getAuthRequestContext = pagingDataDiffer.lookAheadTest;
        this.scheduleImpl = FlowKt.asSharedFlow(pagingDataDiffer.getAuthRequestContext);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final T BuiltInFictitiousFunctionClassFactory(int p0) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = this.PlaceComponentResult;
            asyncPagingDataDiffer$differBase$1.moveToNextValue = true;
            asyncPagingDataDiffer$differBase$1.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            UiReceiver uiReceiver = asyncPagingDataDiffer$differBase$1.initRecordTimeStamp;
            if (uiReceiver != null) {
                uiReceiver.getAuthRequestContext(asyncPagingDataDiffer$differBase$1.scheduleImpl.PlaceComponentResult(p0));
            }
            PagePresenter<T> pagePresenter = asyncPagingDataDiffer$differBase$1.scheduleImpl;
            if (p0 < 0 || p0 >= pagePresenter.MyBillsEntityDataFactory + pagePresenter.getAuthRequestContext + pagePresenter.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("Index: ");
                sb.append(p0);
                sb.append(", Size: ");
                sb.append(pagePresenter.MyBillsEntityDataFactory + pagePresenter.getAuthRequestContext + pagePresenter.PlaceComponentResult);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            int i = p0 - pagePresenter.MyBillsEntityDataFactory;
            return (i < 0 || i >= pagePresenter.getAuthRequestContext) ? null : pagePresenter.getAuthRequestContext(i);
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
    }
}
