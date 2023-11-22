package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u000201BW\u0012\u0006\u0010\u0005\u001a\u00020#\u0012\u0006\u0010\u0007\u001a\u00020\u0010\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0015\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010!\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b.\u0010/J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\t\u0010\u001aR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0012\u0010 \u001a\u00020\u001eX\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010!X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010'"}, d2 = {"Landroidx/paging/LegacyPageFetcher;", "", DiskFormatter.KB, "V", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/PagingSource$LoadResult$Page;", "p1", "", "MyBillsEntityDataFactory", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadParams;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagedList$Config;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAuthRequestContext", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/CoroutineDispatcher;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/CoroutineDispatcher;", "PlaceComponentResult", "", "()Z", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "lookAheadTest", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/PagedList$LoadStateManager;", "Landroidx/paging/PagedList$LoadStateManager;", "getErrorConfigVersion", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Lkotlinx/coroutines/CoroutineScope;", "moveToNextValue", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/PagingSource;", "Landroidx/paging/PagingSource;", "scheduleImpl", "p2", "p3", "p4", "p5", "p6", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/LegacyPageFetcher$PageConsumer;Landroidx/paging/LegacyPageFetcher$KeyProvider;)V", "KeyProvider", "PageConsumer"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LegacyPageFetcher<K, V> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final PagingSource<K, V> scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PagedList.Config BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    PagedList.LoadStateManager getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final CoroutineDispatcher PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final PageConsumer<V> lookAheadTest;
    final AtomicBoolean getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CoroutineDispatcher NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final KeyProvider<K> KClassImpl$Data$declaredNonStaticMembers$2;
    private final CoroutineScope moveToNextValue;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b`\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00018\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00018\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004"}, d2 = {"Landroidx/paging/LegacyPageFetcher$KeyProvider;", "", DiskFormatter.KB, "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Object;", "PlaceComponentResult"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface KeyProvider<K> {
        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        K BuiltInFictitiousFunctionClassFactory();

        @JvmName(name = "PlaceComponentResult")
        K PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroidx/paging/LegacyPageFetcher$PageConsumer;", "", "V", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/PagingSource$LoadResult$Page;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/LoadState;", "", "getAuthRequestContext", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface PageConsumer<V> {
        boolean BuiltInFictitiousFunctionClassFactory(LoadType p0, PagingSource.LoadResult.Page<?, V> p1);

        void getAuthRequestContext(LoadType p0, LoadState p1);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.PREPEND.ordinal()] = 1;
            iArr[LoadType.APPEND.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    public LegacyPageFetcher(CoroutineScope coroutineScope, PagedList.Config config, PagingSource<K, V> pagingSource, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, PageConsumer<V> pageConsumer, KeyProvider<K> keyProvider) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(config, "");
        Intrinsics.checkNotNullParameter(pagingSource, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        Intrinsics.checkNotNullParameter(pageConsumer, "");
        Intrinsics.checkNotNullParameter(keyProvider, "");
        this.moveToNextValue = coroutineScope;
        this.BuiltInFictitiousFunctionClassFactory = config;
        this.scheduleImpl = pagingSource;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coroutineDispatcher;
        this.PlaceComponentResult = coroutineDispatcher2;
        this.lookAheadTest = pageConsumer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = keyProvider;
        this.getAuthRequestContext = new AtomicBoolean(false);
        this.getErrorConfigVersion = new PagedList.LoadStateManager(this) { // from class: androidx.paging.LegacyPageFetcher$loadStateManager$1
            final /* synthetic */ LegacyPageFetcher<K, V> getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.getAuthRequestContext = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public final void MyBillsEntityDataFactory(LoadType p0, LoadState p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                this.getAuthRequestContext.lookAheadTest.getAuthRequestContext(p0, p1);
            }
        };
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext.get();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0, PagingSource.LoadParams<K> p1) {
        BuildersKt__Builders_commonKt.launch$default(this.moveToNextValue, this.PlaceComponentResult, null, new LegacyPageFetcher$scheduleLoad$1(this, p1, p0, null), 2, null);
    }

    public final void MyBillsEntityDataFactory(LoadType p0, PagingSource.LoadResult.Page<K, V> p1) {
        LoadState.NotLoading notLoading;
        if (MyBillsEntityDataFactory()) {
            return;
        }
        if (this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(p0, p1)) {
            int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.ordinal()];
            if (i == 1) {
                BuiltInFictitiousFunctionClassFactory();
                return;
            } else if (i == 2) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            } else {
                throw new IllegalStateException("Can only fetch more during append/prepend");
            }
        }
        PagedList.LoadStateManager loadStateManager = this.getErrorConfigVersion;
        if (p1.MyBillsEntityDataFactory.isEmpty()) {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            notLoading = LoadState.NotLoading.Companion.BuiltInFictitiousFunctionClassFactory();
        } else {
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            notLoading = LoadState.NotLoading.getAuthRequestContext;
        }
        loadStateManager.KClassImpl$Data$declaredNonStaticMembers$2(p0, notLoading);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        K PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        if (PlaceComponentResult == null) {
            LoadType loadType = LoadType.PREPEND;
            PagingSource.LoadResult.Page.Companion companion = PagingSource.LoadResult.Page.INSTANCE;
            MyBillsEntityDataFactory(loadType, PagingSource.LoadResult.Page.Companion.MyBillsEntityDataFactory());
            return;
        }
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(LoadType.PREPEND, LoadState.Loading.INSTANCE);
        KClassImpl$Data$declaredNonStaticMembers$2(LoadType.PREPEND, new PagingSource.LoadParams.Prepend(PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        K BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            LoadType loadType = LoadType.APPEND;
            PagingSource.LoadResult.Page.Companion companion = PagingSource.LoadResult.Page.INSTANCE;
            MyBillsEntityDataFactory(loadType, PagingSource.LoadResult.Page.Companion.MyBillsEntityDataFactory());
            return;
        }
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(LoadType.APPEND, LoadState.Loading.INSTANCE);
        KClassImpl$Data$declaredNonStaticMembers$2(LoadType.APPEND, new PagingSource.LoadParams.Append(BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
    }

    public static final /* synthetic */ void PlaceComponentResult(LegacyPageFetcher legacyPageFetcher, LoadType loadType, Throwable th) {
        if (legacyPageFetcher.MyBillsEntityDataFactory()) {
            return;
        }
        legacyPageFetcher.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(loadType, new LoadState.Error(th));
    }

    public static final /* synthetic */ void PlaceComponentResult(LegacyPageFetcher legacyPageFetcher) {
        legacyPageFetcher.scheduleImpl.MyBillsEntityDataFactory.getAuthRequestContext();
        legacyPageFetcher.getAuthRequestContext.set(true);
    }
}
