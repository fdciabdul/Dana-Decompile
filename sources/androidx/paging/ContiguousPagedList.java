package androidx.paging;

import androidx.paging.LegacyPageFetcher;
import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import androidx.paging.PagingSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 B*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\b\u0012\u0004\u0012\u00028\u00010\u0006:\u0001BBi\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000101\u0012\u0006\u0010\t\u001a\u000208\u0012\u0006\u0010\n\u001a\u000209\u0012\u0006\u0010:\u001a\u000209\u0012\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010#\u0012\u0006\u0010=\u001a\u00020<\u0012\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\u0012\b\u0010?\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b@\u0010AJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u00020\u000b2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\f\u0010\u0017J'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u000e\u0010\u0018J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\f\u0010\u0018J)\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00112\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0019H\u0016¢\u0006\u0004\b\f\u0010\u001aJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u000e\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000e\u0010\u001dJ\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u001dJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0002¢\u0006\u0004\b\u001c\u0010\u001fJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010 R\u0016\u0010\u0013\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010#X\u0000¢\u0006\u0006\n\u0004\b\f\u0010$R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010(\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010)\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010+R\u0016\u0010%\u001a\u0004\u0018\u00018\u00008WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010,R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010\"R \u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u00100R&\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b\u0016\u00104R\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u0010\"R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u0010&R\u0014\u00106\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u0010&"}, d2 = {"Landroidx/paging/ContiguousPagedList;", "", DiskFormatter.KB, "V", "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "", "p0", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(ZZZ)V", "getAuthRequestContext", "(ZZ)V", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function2;)V", "", "MyBillsEntityDataFactory", "(I)V", "(III)V", "Landroidx/paging/PagingSource$LoadResult$Page;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "(II)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "", "(Landroidx/paging/LoadType;Ljava/util/List;)V", "(Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "Landroidx/paging/PagedList$BoundaryCallback;", "Landroidx/paging/PagedList$BoundaryCallback;", "getErrorConfigVersion", "Z", "lookAheadTest", "scheduleImpl", "moveToNextValue", "Ljava/lang/Object;", "()Z", "()Ljava/lang/Object;", "initRecordTimeStamp", "Landroidx/paging/LegacyPageFetcher;", "DatabaseTableConfigUtil", "Landroidx/paging/LegacyPageFetcher;", "Landroidx/paging/PagingSource;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroidx/paging/PagingSource;", "()Landroidx/paging/PagingSource;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "newProxyInstance", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineDispatcher;", "p3", "p4", "Landroidx/paging/PagedList$Config;", "p5", "p6", "p7", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback, LegacyPageFetcher.PageConsumer<V> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    final PagedList.BoundaryCallback<V> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final LegacyPageFetcher<K, V> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final PagingSource<K, V> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final K scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.paging.PagedList
    @JvmName(name = "MyBillsEntityDataFactory")
    public final PagingSource<K, V> MyBillsEntityDataFactory() {
        return this.initRecordTimeStamp;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList(PagingSource<K, V> pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, PagedList.BoundaryCallback<V> boundaryCallback, PagedList.Config config, PagingSource.LoadResult.Page<K, V> page, K k) {
        super(pagingSource, coroutineScope, coroutineDispatcher, new PagedStorage(), config);
        Intrinsics.checkNotNullParameter(pagingSource, "");
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        Intrinsics.checkNotNullParameter(config, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.initRecordTimeStamp = pagingSource;
        this.BuiltInFictitiousFunctionClassFactory = boundaryCallback;
        this.scheduleImpl = k;
        this.lookAheadTest = Integer.MAX_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = config.KClassImpl$Data$declaredNonStaticMembers$2 != Integer.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LegacyPageFetcher<>(coroutineScope, config, pagingSource, coroutineDispatcher, coroutineDispatcher2, this, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (config.MyBillsEntityDataFactory) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(page.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE ? page.BuiltInFictitiousFunctionClassFactory : 0, page, page.PlaceComponentResult != Integer.MIN_VALUE ? page.PlaceComponentResult : 0, 0, this, (page.BuiltInFictitiousFunctionClassFactory == Integer.MIN_VALUE || page.PlaceComponentResult == Integer.MIN_VALUE) ? false : true);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(0, page, 0, page.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE ? page.BuiltInFictitiousFunctionClassFactory : 0, this, false);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(LoadType.REFRESH, page.MyBillsEntityDataFactory);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Landroidx/paging/ContiguousPagedList$Companion;", "", "", "p0", "p1", "p2", "getAuthRequestContext", "(III)I", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static int MyBillsEntityDataFactory(int p0, int p1, int p2) {
            return p0 - (p1 - p2);
        }

        public static int getAuthRequestContext(int p0, int p1, int p2) {
            return ((p1 + p0) + 1) - p2;
        }

        private Companion() {
        }
    }

    @Override // androidx.paging.PagedList
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public final void getAuthRequestContext(LoadType p0, LoadState p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0, List<? extends V> p1) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            boolean z = false;
            boolean z2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.size() == 0;
            boolean z3 = !z2 && p0 == LoadType.PREPEND && p1.isEmpty();
            if (!z2 && p0 == LoadType.APPEND && p1.isEmpty()) {
                z = true;
            }
            BuiltInFictitiousFunctionClassFactory(z2, z3, z);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean p0, boolean p1, boolean p2) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
        }
        if (this.lookAheadTest == Integer.MAX_VALUE) {
            this.lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda2.size();
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == Integer.MIN_VALUE) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
        if (p0 || p1 || p2) {
            BuildersKt__Builders_commonKt.launch$default(getKClassImpl$Data$declaredNonStaticMembers$2(), getNetworkUserEntityData$$ExternalSyntheticLambda0(), null, new ContiguousPagedList$deferBoundaryCallbacks$1(p0, this, p1, p2, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        boolean z = this.getAuthRequestContext && this.lookAheadTest <= getBuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
        boolean z2 = this.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 >= (size() - 1) - getBuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
        if (z || z2) {
            if (z) {
                this.getAuthRequestContext = false;
            }
            if (z2) {
                this.MyBillsEntityDataFactory = false;
            }
            if (p0) {
                BuildersKt__Builders_commonKt.launch$default(getKClassImpl$Data$declaredNonStaticMembers$2(), getNetworkUserEntityData$$ExternalSyntheticLambda0(), null, new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this, z, z2, null), 2, null);
            } else {
                getAuthRequestContext(z, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(boolean p0, boolean p1) {
        if (p0) {
            Intrinsics.checkNotNull(this.BuiltInFictitiousFunctionClassFactory);
            PagedList.BoundaryCallback.MyBillsEntityDataFactory(CollectionsKt.first((List) ((PagingSource.LoadResult.Page) CollectionsKt.first((List) this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory)).MyBillsEntityDataFactory));
        }
        if (p1) {
            Intrinsics.checkNotNull(this.BuiltInFictitiousFunctionClassFactory);
            Intrinsics.checkNotNullParameter(CollectionsKt.last((List) ((PagingSource.LoadResult.Page) CollectionsKt.last((List) this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory)).MyBillsEntityDataFactory), "");
        }
    }

    @Override // androidx.paging.PagedList
    public final void PlaceComponentResult(Function2<? super LoadType, ? super LoadState, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PagedList.LoadStateManager loadStateManager = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion;
        Intrinsics.checkNotNullParameter(p0, "");
        p0.invoke(LoadType.REFRESH, loadStateManager.BuiltInFictitiousFunctionClassFactory);
        p0.invoke(LoadType.PREPEND, loadStateManager.MyBillsEntityDataFactory);
        p0.invoke(LoadType.APPEND, loadStateManager.getAuthRequestContext);
    }

    @Override // androidx.paging.PagedList
    public final void MyBillsEntityDataFactory(LoadType p0, LoadState p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // androidx.paging.PagedList
    public final void MyBillsEntityDataFactory(int p0) {
        int MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(getBuiltInFictitiousFunctionClassFactory().PlaceComponentResult, p0, this.NetworkUserEntityData$$ExternalSyntheticLambda2.getErrorConfigVersion);
        int authRequestContext = Companion.getAuthRequestContext(getBuiltInFictitiousFunctionClassFactory().PlaceComponentResult, p0, this.NetworkUserEntityData$$ExternalSyntheticLambda2.getErrorConfigVersion + this.NetworkUserEntityData$$ExternalSyntheticLambda2.lookAheadTest);
        int max = Math.max(MyBillsEntityDataFactory, this.GetContactSyncConfig);
        this.GetContactSyncConfig = max;
        if (max > 0) {
            LegacyPageFetcher<K, V> legacyPageFetcher = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            LoadState loadState = legacyPageFetcher.getErrorConfigVersion.MyBillsEntityDataFactory;
            if ((loadState instanceof LoadState.NotLoading) && !loadState.getMyBillsEntityDataFactory()) {
                legacyPageFetcher.BuiltInFictitiousFunctionClassFactory();
            }
        }
        int max2 = Math.max(authRequestContext, this.PlaceComponentResult);
        this.PlaceComponentResult = max2;
        if (max2 > 0) {
            LegacyPageFetcher<K, V> legacyPageFetcher2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            LoadState loadState2 = legacyPageFetcher2.getErrorConfigVersion.getAuthRequestContext;
            if ((loadState2 instanceof LoadState.NotLoading) && !loadState2.getMyBillsEntityDataFactory()) {
                legacyPageFetcher2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        this.lookAheadTest = Math.min(this.lookAheadTest, p0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
        BuiltInFictitiousFunctionClassFactory(true);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public final void BuiltInFictitiousFunctionClassFactory(int p0) {
        BuiltInFictitiousFunctionClassFactory(0, p0);
        this.DatabaseTableConfigUtil = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getErrorConfigVersion > 0 || this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult > 0;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public final void BuiltInFictitiousFunctionClassFactory(int p0, int p1, int p2) {
        MyBillsEntityDataFactory(p0, p1);
        BuiltInFictitiousFunctionClassFactory(0, p2);
        this.lookAheadTest += p2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 += p2;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public final void getAuthRequestContext(int p0, int p1, int p2) {
        MyBillsEntityDataFactory(p0, p1);
        BuiltInFictitiousFunctionClassFactory(p0 + p1, p2);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        MyBillsEntityDataFactory(p0, p1);
    }

    @Override // androidx.paging.PagedList
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final K BuiltInFictitiousFunctionClassFactory() {
        PagedStorage<T> pagedStorage = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        PagedList.Config builtInFictitiousFunctionClassFactory = getBuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter(builtInFictitiousFunctionClassFactory, "");
        PagingState<K, V> pagingState = pagedStorage.MyBillsEntityDataFactory.isEmpty() ? null : new PagingState<>(CollectionsKt.toList(pagedStorage.MyBillsEntityDataFactory), Integer.valueOf(pagedStorage.getErrorConfigVersion + pagedStorage.getAuthRequestContext), new PagingConfig(builtInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, builtInFictitiousFunctionClassFactory.PlaceComponentResult, builtInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, builtInFictitiousFunctionClassFactory.getAuthRequestContext, builtInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, 0, 32, null), pagedStorage.getErrorConfigVersion);
        K PlaceComponentResult = pagingState != null ? this.initRecordTimeStamp.PlaceComponentResult(pagingState) : null;
        return PlaceComponentResult == null ? this.scheduleImpl : PlaceComponentResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        if ((!r1.isEmpty()) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if ((!r1.isEmpty()) != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean BuiltInFictitiousFunctionClassFactory(androidx.paging.LoadType r10, androidx.paging.PagingSource.LoadResult.Page<?, V> r11) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.ContiguousPagedList.BuiltInFictitiousFunctionClassFactory(androidx.paging.LoadType, androidx.paging.PagingSource$LoadResult$Page):boolean");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public final void getAuthRequestContext(int p0, int p1) {
        if (p1 != 0) {
            Iterator it = CollectionsKt.reversed(this.getAuthRequestContext).iterator();
            while (it.hasNext()) {
                PagedList.Callback callback = (PagedList.Callback) ((WeakReference) it.next()).get();
                if (callback != null) {
                    callback.getAuthRequestContext(p0, p1);
                }
            }
        }
    }
}
