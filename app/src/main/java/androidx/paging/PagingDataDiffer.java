package androidx.paging;

import androidx.paging.LoadStates;
import androidx.paging.PagePresenter;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u001c\u0012\b\b\u0002\u0010\t\u001a\u00020(¢\u0006\u0004\b5\u00106J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJG\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H¦@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0014\u0010\f\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u0013\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#X\u0006¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u001d\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010)R \u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010+\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00104\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PagingDataDiffer;", "", "T", "Landroidx/paging/PagingData;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/LoadStates;", "p1", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "", "PlaceComponentResult", "()Z", "Landroidx/paging/NullPaddedList;", "", "p2", "Lkotlin/Function0;", "p3", "MyBillsEntityDataFactory", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getAuthRequestContext", "Landroidx/paging/SingleRunner;", "Landroidx/paging/SingleRunner;", "Landroidx/paging/MutableCombinedLoadStateCollection;", "Landroidx/paging/MutableCombinedLoadStateCollection;", "Landroidx/paging/DifferCallback;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/paging/DifferCallback;", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "moveToNextValue", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getErrorConfigVersion", "Lkotlinx/coroutines/flow/Flow;", "lookAheadTest", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "initRecordTimeStamp", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/PagePresenter;", "scheduleImpl", "Landroidx/paging/PagePresenter;", "Landroidx/paging/PagingDataDiffer$processPageEventCallback$1;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroidx/paging/PagingDataDiffer$processPageEventCallback$1;", "Landroidx/paging/UiReceiver;", "Landroidx/paging/UiReceiver;", "<init>", "(Landroidx/paging/DifferCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingDataDiffer<T> {
    final MutableCombinedLoadStateCollection BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    volatile boolean moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final MutableSharedFlow<Unit> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final DifferCallback MyBillsEntityDataFactory;
    private final PagingDataDiffer$processPageEventCallback$1 NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final SingleRunner PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    volatile int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final Flow<CombinedLoadStates> lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final CopyOnWriteArrayList<Function0<Unit>> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CoroutineDispatcher NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    UiReceiver initRecordTimeStamp;
    PagePresenter<T> scheduleImpl;

    public abstract Object MyBillsEntityDataFactory(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, int i, Function0<Unit> function0, Continuation<? super Integer> continuation);

    public boolean PlaceComponentResult() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.paging.PagingDataDiffer$processPageEventCallback$1] */
    public PagingDataDiffer(DifferCallback differCallback, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(differCallback, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.MyBillsEntityDataFactory = differCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coroutineDispatcher;
        PagePresenter.Companion companion = PagePresenter.INSTANCE;
        this.scheduleImpl = PagePresenter.Companion.MyBillsEntityDataFactory();
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        this.BuiltInFictitiousFunctionClassFactory = mutableCombinedLoadStateCollection;
        this.getErrorConfigVersion = new CopyOnWriteArrayList<>();
        this.PlaceComponentResult = new SingleRunner(false, 1, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PagePresenter.ProcessPageEventCallback(this) { // from class: androidx.paging.PagingDataDiffer$processPageEventCallback$1
            final /* synthetic */ PagingDataDiffer<T> KClassImpl$Data$declaredNonStaticMembers$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public final void BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
                DifferCallback differCallback2;
                differCallback2 = ((PagingDataDiffer) this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory;
                differCallback2.PlaceComponentResult(p0, p1);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public final void MyBillsEntityDataFactory(int p0, int p1) {
                DifferCallback differCallback2;
                differCallback2 = ((PagingDataDiffer) this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory;
                differCallback2.getAuthRequestContext(p0, p1);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public final void getAuthRequestContext(int p0, int p1) {
                DifferCallback differCallback2;
                differCallback2 = ((PagingDataDiffer) this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory;
                differCallback2.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public final void PlaceComponentResult(LoadStates p0, LoadStates p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p0, p1);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(LoadType loadType, LoadState loadState) {
                MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection2;
                LoadState loadState2;
                MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection3;
                Intrinsics.checkNotNullParameter(loadType, "");
                Intrinsics.checkNotNullParameter(loadState, "");
                mutableCombinedLoadStateCollection2 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(loadType, "");
                LoadStates loadStates = mutableCombinedLoadStateCollection2.scheduleImpl;
                if (loadStates == null) {
                    loadState2 = null;
                } else {
                    Intrinsics.checkNotNullParameter(loadType, "");
                    int i = LoadStates.WhenMappings.MyBillsEntityDataFactory[loadType.ordinal()];
                    if (i == 1) {
                        loadState2 = loadStates.MyBillsEntityDataFactory;
                    } else if (i == 2) {
                        loadState2 = loadStates.PlaceComponentResult;
                    } else if (i == 3) {
                        loadState2 = loadStates.BuiltInFictitiousFunctionClassFactory;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (Intrinsics.areEqual(loadState2, loadState)) {
                    return;
                }
                mutableCombinedLoadStateCollection3 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                mutableCombinedLoadStateCollection3.KClassImpl$Data$declaredNonStaticMembers$2(loadType, loadState);
            }
        };
        this.lookAheadTest = mutableCombinedLoadStateCollection.MyBillsEntityDataFactory;
        this.getAuthRequestContext = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        Function0<Unit> function0 = new Function0<Unit>(this) { // from class: androidx.paging.PagingDataDiffer.1
            final /* synthetic */ PagingDataDiffer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getAuthRequestContext.tryEmit(Unit.INSTANCE);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        this.getErrorConfigVersion.add(function0);
    }

    public final void BuiltInFictitiousFunctionClassFactory(LoadStates p0, LoadStates p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl, p0) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, p1)) {
            return;
        }
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        mutableCombinedLoadStateCollection.PlaceComponentResult = true;
        mutableCombinedLoadStateCollection.scheduleImpl = p0;
        mutableCombinedLoadStateCollection.getErrorConfigVersion = p1;
        mutableCombinedLoadStateCollection.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final Object BuiltInFictitiousFunctionClassFactory(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        Object authRequestContext;
        authRequestContext = this.PlaceComponentResult.getAuthRequestContext(0, new PagingDataDiffer$collectFrom$2(this, pagingData, null), continuation);
        return authRequestContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authRequestContext : Unit.INSTANCE;
    }
}
