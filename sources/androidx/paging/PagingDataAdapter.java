package androidx.paging;

import androidx.paging.LoadState;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B)\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000!\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u001dR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010 "}, d2 = {"Landroidx/paging/PagingDataAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getItemCount", "()I", "p0", "", "getItemId", "(I)J", "", "", "setHasStableIds", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "setStateRestorationPolicy", "(Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;)V", "Landroidx/paging/ItemSnapshotList;", "PlaceComponentResult", "()Landroidx/paging/ItemSnapshotList;", "Landroidx/paging/AsyncPagingDataDiffer;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/AsyncPagingDataDiffer;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "Lkotlinx/coroutines/flow/Flow;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Z", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlinx/coroutines/CoroutineDispatcher;", "p1", "p2", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final AsyncPagingDataDiffer<T> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Flow<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Flow<CombinedLoadStates> BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    private PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(itemCallback, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(itemCallback, new AdapterListUpdateCallback(this), coroutineDispatcher, coroutineDispatcher2);
        this.getAuthRequestContext = asyncPagingDataDiffer;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: androidx.paging.PagingDataAdapter.1
            final /* synthetic */ PagingDataAdapter<T, VH> BuiltInFictitiousFunctionClassFactory;

            {
                this.BuiltInFictitiousFunctionClassFactory = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeInserted(int p0, int p1) {
                PagingDataAdapter.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(p0, p1);
            }
        });
        Function1<CombinedLoadStates, Unit> function1 = new Function1<CombinedLoadStates, Unit>(this) { // from class: androidx.paging.PagingDataAdapter.2

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            private boolean MyBillsEntityDataFactory = true;
            final /* synthetic */ PagingDataAdapter<T, VH> PlaceComponentResult;

            {
                this.PlaceComponentResult = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                CombinedLoadStates combinedLoadStates2 = combinedLoadStates;
                Intrinsics.checkNotNullParameter(combinedLoadStates2, "");
                if (this.MyBillsEntityDataFactory) {
                    this.MyBillsEntityDataFactory = false;
                } else if (combinedLoadStates2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory instanceof LoadState.NotLoading) {
                    PagingDataAdapter.getAuthRequestContext(this.PlaceComponentResult);
                    PagingDataAdapter<T, VH> pagingDataAdapter = this.PlaceComponentResult;
                    AnonymousClass2 anonymousClass2 = this;
                    Intrinsics.checkNotNullParameter(anonymousClass2, "");
                    AsyncPagingDataDiffer<T> asyncPagingDataDiffer2 = pagingDataAdapter.getAuthRequestContext;
                    Intrinsics.checkNotNullParameter(anonymousClass2, "");
                    AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = asyncPagingDataDiffer2.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(anonymousClass2, "");
                    MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = asyncPagingDataDiffer$differBase$1.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullParameter(anonymousClass2, "");
                    mutableCombinedLoadStateCollection.BuiltInFictitiousFunctionClassFactory.remove(anonymousClass2);
                }
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer2 = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(function1, "");
        AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = asyncPagingDataDiffer2.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(function1, "");
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = asyncPagingDataDiffer$differBase$1.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(function1, "");
        mutableCombinedLoadStateCollection.BuiltInFictitiousFunctionClassFactory.add(function1);
        CombinedLoadStates authRequestContext = mutableCombinedLoadStateCollection.getAuthRequestContext();
        if (authRequestContext != null) {
            function1.invoke(authRequestContext);
        }
        this.BuiltInFictitiousFunctionClassFactory = asyncPagingDataDiffer.getAuthRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = asyncPagingDataDiffer.scheduleImpl;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult = true;
        super.setStateRestorationPolicy(p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int p0) {
        return super.getItemId(p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean p0) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public final ItemSnapshotList<T> PlaceComponentResult() {
        PagePresenter<T> pagePresenter = this.getAuthRequestContext.PlaceComponentResult.scheduleImpl;
        int i = pagePresenter.MyBillsEntityDataFactory;
        int i2 = pagePresenter.PlaceComponentResult;
        List<TransformablePage<T>> list = pagePresenter.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TransformablePage) it.next()).PlaceComponentResult);
        }
        return new ItemSnapshotList<>(i, i2, arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        PagePresenter<T> pagePresenter = this.getAuthRequestContext.PlaceComponentResult.scheduleImpl;
        return pagePresenter.MyBillsEntityDataFactory + pagePresenter.getAuthRequestContext + pagePresenter.PlaceComponentResult;
    }

    public static final /* synthetic */ void getAuthRequestContext(PagingDataAdapter pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || pagingDataAdapter.PlaceComponentResult) {
            return;
        }
        pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }
}
