package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Deprecated(message = "AsyncPagedListDiffer is deprecated and has been replaced by AsyncPagingDataDiffer", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer<T>", imports = {"androidx.paging.AsyncPagingDataDiffer"}))
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u000245B#\b\u0017\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u000300\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u000001¢\u0006\u0004\b2\u00103J9\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0001¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R4\u0010\u0013\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u0017\u0012\u000b\u0012\t\u0018\u00010\u0018¢\u0006\u0002\b\u0017\u0012\u0004\u0012\u00020\b0\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R)\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u001b0\u001aX\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0012\u0010#\u001a\u00020!X\u0081\u0002¢\u0006\u0006\n\u0004\b \u0010\"R\u0012\u0010&\u001a\u00020\u000fX\u0081\u0002¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010$\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010*R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0012\u0010/\u001a\u00020,X\u0081\"¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Landroidx/paging/AsyncPagedListDiffer;", "", "T", "Landroidx/paging/PagedList;", "p0", "p1", "Ljava/lang/Runnable;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;Ljava/lang/Runnable;)V", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "PlaceComponentResult", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "getAuthRequestContext", "", "()I", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/reflect/KFunction2;", "Landroidx/paging/LoadType;", "Lkotlin/ParameterName;", "Landroidx/paging/LoadState;", "Lkotlin/reflect/KFunction;", "", "Lkotlin/Function2;", "MyBillsEntityDataFactory", "Ljava/util/List;", "Landroidx/paging/PagedList$LoadStateManager;", "Landroidx/paging/PagedList$LoadStateManager;", "getErrorConfigVersion", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "lookAheadTest", "Landroidx/paging/PagedList;", "moveToNextValue", "Landroidx/paging/PagedList$Callback;", "Landroidx/paging/PagedList$Callback;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "GetContactSyncConfig", "Landroidx/recyclerview/widget/ListUpdateCallback;", "DatabaseTableConfigUtil", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "OnCurrentListChangedWrapper", "PagedListListener"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public class AsyncPagedListDiffer<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CopyOnWriteArrayList<PagedListListener<T>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public ListUpdateCallback DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final KFunction<Unit> BuiltInFictitiousFunctionClassFactory;
    final List<Function2<LoadType, LoadState, Unit>> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    int lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final AsyncDifferConfig<T> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final PagedList.LoadStateManager getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    Executor scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public PagedList<T> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public PagedList<T> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final PagedList.Callback NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003H&¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "", "T", "Landroidx/paging/PagedList;", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
    /* loaded from: classes2.dex */
    public interface PagedListListener<T> {
        void KClassImpl$Data$declaredNonStaticMembers$2(PagedList<T> p0, PagedList<T> p1);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B1\u0012(\u0010\u0005\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR3\u0010\r\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\nX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$OnCurrentListChangedWrapper;", "", "T", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "Landroidx/paging/PagedList;", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "Lkotlin/Function2;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function2;", "PlaceComponentResult", "<init>", "(Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Function2<PagedList<T>, PagedList<T>, Unit> PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        public OnCurrentListChangedWrapper(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "");
            this.PlaceComponentResult = function2;
        }

        @Override // androidx.paging.AsyncPagedListDiffer.PagedListListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PagedList<T> p0, PagedList<T> p1) {
            this.PlaceComponentResult.invoke(p0, p1);
        }
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer(\n                Dispatchers.Main,\n                Dispatchers.IO,\n                diffCallback,\n                listUpdateCallback\n            )", imports = {"androidx.paging.AsyncPagingDataDiffer", "kotlinx.coroutines.Dispatchers"}))
    public AsyncPagedListDiffer(RecyclerView.Adapter<?> adapter, DiffUtil.ItemCallback<T> itemCallback) {
        Executor executor;
        Intrinsics.checkNotNullParameter(adapter, "");
        Intrinsics.checkNotNullParameter(itemCallback, "");
        executor = ArchTaskExecutor.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(executor, "");
        this.scheduleImpl = executor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            final /* synthetic */ AsyncPagedListDiffer<T> MyBillsEntityDataFactory;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.MyBillsEntityDataFactory = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public final void MyBillsEntityDataFactory(LoadType p0, LoadState p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Iterator<T> it = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(p0, p1);
                }
            }
        };
        this.getErrorConfigVersion = loadStateManager;
        this.BuiltInFictitiousFunctionClassFactory = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.MyBillsEntityDataFactory = new CopyOnWriteArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PagedList.Callback(this) { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            final /* synthetic */ AsyncPagedListDiffer<T> getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.getAuthRequestContext = this;
            }

            @Override // androidx.paging.PagedList.Callback
            public final void PlaceComponentResult(int p0, int p1) {
                ListUpdateCallback listUpdateCallback = this.getAuthRequestContext.DatabaseTableConfigUtil;
                if (listUpdateCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    listUpdateCallback = null;
                }
                listUpdateCallback.PlaceComponentResult(p0, p1);
            }

            @Override // androidx.paging.PagedList.Callback
            public final void getAuthRequestContext(int p0, int p1) {
                ListUpdateCallback listUpdateCallback = this.getAuthRequestContext.DatabaseTableConfigUtil;
                if (listUpdateCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    listUpdateCallback = null;
                }
                listUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
            }

            @Override // androidx.paging.PagedList.Callback
            public final void BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
                ListUpdateCallback listUpdateCallback = this.getAuthRequestContext.DatabaseTableConfigUtil;
                if (listUpdateCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    listUpdateCallback = null;
                }
                listUpdateCallback.getAuthRequestContext(p0, p1, null);
            }
        };
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(adapter);
        Intrinsics.checkNotNullParameter(adapterListUpdateCallback, "");
        this.DatabaseTableConfigUtil = adapterListUpdateCallback;
        AsyncDifferConfig<T> PlaceComponentResult = new AsyncDifferConfig.Builder(itemCallback).PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.getAuthRequestContext = PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PagedList<T> p0, PagedList<T> p1, Runnable p2) {
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            ((PagedListListener) it.next()).KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        }
        if (p2 != null) {
            p2.run();
        }
    }

    @JvmName(name = "getAuthRequestContext")
    public final int getAuthRequestContext() {
        PagedList<T> pagedList = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (pagedList == null) {
            pagedList = this.moveToNextValue;
        }
        if (pagedList == null) {
            return 0;
        }
        return pagedList.size();
    }
}
