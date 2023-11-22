package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.LoadStates;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u0010J1\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0007\u0010\u0010R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0016X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR \u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001f@BX\u0086\n¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0015R\u001c\u0010\u0014\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0007\u0010 "}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "Landroidx/paging/LoadState;", "p0", "p1", "p2", "p3", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadState;", "Landroidx/paging/LoadType;", "", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)Z", "Landroidx/paging/CombinedLoadStates;", "getAuthRequestContext", "()Landroidx/paging/CombinedLoadStates;", "", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "lookAheadTest", "Lkotlinx/coroutines/flow/MutableStateFlow;", "scheduleImpl", "Landroidx/paging/LoadState;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/LoadStates;", "Landroidx/paging/LoadStates;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableCombinedLoadStateCollection {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    LoadStates getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    LoadStates scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LoadState moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> BuiltInFictitiousFunctionClassFactory = new CopyOnWriteArrayList<>();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Flow<CombinedLoadStates> MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final MutableStateFlow<CombinedLoadStates> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private LoadState NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private LoadState KClassImpl$Data$declaredNonStaticMembers$2;

    public MutableCombinedLoadStateCollection() {
        LoadState.NotLoading notLoading;
        LoadState.NotLoading notLoading2;
        LoadState.NotLoading notLoading3;
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        notLoading = LoadState.NotLoading.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = notLoading;
        LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
        notLoading2 = LoadState.NotLoading.getAuthRequestContext;
        this.moveToNextValue = notLoading2;
        LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
        notLoading3 = LoadState.NotLoading.getAuthRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = notLoading3;
        LoadStates.Companion companion4 = LoadStates.INSTANCE;
        this.scheduleImpl = LoadStates.Companion.BuiltInFictitiousFunctionClassFactory();
        MutableStateFlow<CombinedLoadStates> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.getAuthRequestContext = MutableStateFlow;
        this.MyBillsEntityDataFactory = FlowKt.filterNotNull(MutableStateFlow);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(LoadType loadType, LoadState loadState) {
        LoadStates BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(loadType, "");
        Intrinsics.checkNotNullParameter(loadState, "");
        this.PlaceComponentResult = true;
        LoadStates loadStates = this.scheduleImpl;
        Intrinsics.checkNotNullParameter(loadType, "");
        Intrinsics.checkNotNullParameter(loadState, "");
        int i = LoadStates.WhenMappings.MyBillsEntityDataFactory[loadType.ordinal()];
        if (i == 1) {
            BuiltInFictitiousFunctionClassFactory = LoadStates.BuiltInFictitiousFunctionClassFactory(loadStates, null, null, loadState, 3);
        } else if (i == 2) {
            BuiltInFictitiousFunctionClassFactory = LoadStates.BuiltInFictitiousFunctionClassFactory(loadStates, null, loadState, null, 5);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            BuiltInFictitiousFunctionClassFactory = LoadStates.BuiltInFictitiousFunctionClassFactory(loadStates, loadState, null, null, 6);
        }
        this.scheduleImpl = BuiltInFictitiousFunctionClassFactory;
        boolean z = !Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, loadStates);
        KClassImpl$Data$declaredNonStaticMembers$2();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CombinedLoadStates getAuthRequestContext() {
        if (this.PlaceComponentResult) {
            return new CombinedLoadStates(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.getErrorConfigVersion);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        LoadState loadState = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        LoadState loadState2 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        LoadState loadState3 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        LoadStates loadStates = this.getErrorConfigVersion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2(loadState, loadState2, loadState3, loadStates == null ? null : loadStates.BuiltInFictitiousFunctionClassFactory);
        LoadState loadState4 = this.moveToNextValue;
        LoadState loadState5 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        LoadState loadState6 = this.scheduleImpl.PlaceComponentResult;
        LoadStates loadStates2 = this.getErrorConfigVersion;
        this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2(loadState4, loadState5, loadState6, loadStates2 == null ? null : loadStates2.PlaceComponentResult);
        LoadState loadState7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LoadState loadState8 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        LoadState loadState9 = this.scheduleImpl.MyBillsEntityDataFactory;
        LoadStates loadStates3 = this.getErrorConfigVersion;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(loadState7, loadState8, loadState9, loadStates3 != null ? loadStates3.MyBillsEntityDataFactory : null);
        CombinedLoadStates authRequestContext = getAuthRequestContext();
        if (authRequestContext != null) {
            this.getAuthRequestContext.setValue(authRequestContext);
            Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(authRequestContext);
            }
        }
    }

    private static LoadState KClassImpl$Data$declaredNonStaticMembers$2(LoadState p0, LoadState p1, LoadState p2, LoadState p3) {
        return p3 == null ? p2 : (!(p0 instanceof LoadState.Loading) || ((p1 instanceof LoadState.NotLoading) && (p3 instanceof LoadState.NotLoading)) || (p3 instanceof LoadState.Error)) ? p3 : p0;
    }
}
