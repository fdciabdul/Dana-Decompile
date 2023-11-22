package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000 <*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0006=>?<@ABA\b\u0000\u0012\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000,\u0012\u0006\u0010\u000f\u001a\u00020\u001e\u0012\u0006\u00107\u001a\u00020'\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000004\u0012\u0006\u00109\u001a\u00020\u001b¢\u0006\u0004\b:\u0010;J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\tH&¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0007\u0010\u0010J\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0011H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0010R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0017\u0010\u0017\u001a\u00020\u001b8\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\f\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u001e8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000e\u0010!R\u0014\u0010\u0015\u001a\u00020\"8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010#R\u0014\u0010\u000e\u001a\u00020\"8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010\u00018'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010%R2\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t0\u00190\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u001a\u0010\u001f\u001a\u00020'8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000,8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010-\u001a\u0004\b\u0015\u0010.R\u0014\u0010*\u001a\u0004\u0018\u00010/X\u0081\u0002¢\u0006\u0006\n\u0004\b\u000e\u00100R\u001a\u00103\u001a\u00020\u00118\u0001X\u0081\u0004¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\b&\u00102R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00028\u000004X\u0001¢\u0006\u0006\n\u0004\b\u0015\u00105"}, d2 = {"Landroidx/paging/PagedList;", "", "T", "Ljava/util/AbstractList;", "Landroidx/paging/PagedList$Callback;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagedList$Callback;)V", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function2;)V", "PlaceComponentResult", "p1", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "", "get", "(I)Ljava/lang/Object;", "(I)V", "MyBillsEntityDataFactory", "(II)V", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/ref/WeakReference;", "Ljava/util/List;", "Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagedList$Config;", "()Landroidx/paging/PagedList$Config;", "Lkotlinx/coroutines/CoroutineScope;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "", "()Z", "moveToNextValue", "()Ljava/lang/Object;", "getErrorConfigVersion", "Lkotlinx/coroutines/CoroutineDispatcher;", "lookAheadTest", "Lkotlinx/coroutines/CoroutineDispatcher;", "scheduleImpl", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/paging/PagingSource;", "Landroidx/paging/PagingSource;", "()Landroidx/paging/PagingSource;", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "I", "()I", "GetContactSyncConfig", "Landroidx/paging/PagedStorage;", "Landroidx/paging/PagedStorage;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "Companion", "BoundaryCallback", "Builder", "Callback", "Config", "LoadStateManager"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PagedList<T> extends AbstractList<T> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final List<WeakReference<Function2<LoadType, LoadState, Unit>>> moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final PagedStorage<T> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final CoroutineScope KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Runnable scheduleImpl;
    final List<WeakReference<Callback>> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final int GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CoroutineDispatcher NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PagingSource<?, T> lookAheadTest;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Landroidx/paging/PagedList$BoundaryCallback;", "", "T", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)V", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class BoundaryCallback<T> {
        public static void MyBillsEntityDataFactory(T p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u0001*\b\b\u0002\u0010\u0003*\u00020\u00012\u00020\u0001"}, d2 = {"Landroidx/paging/PagedList$Builder;", "", "Key", "Value"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData, which no longer supports constructing snapshots of loaded data manually.", replaceWith = @ReplaceWith(expression = "Pager.flow", imports = {"androidx.paging.Pager"}))
    /* loaded from: classes2.dex */
    public static final class Builder<Key, Value> {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007"}, d2 = {"Landroidx/paging/PagedList$Callback;", "", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(II)V", "PlaceComponentResult", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public abstract void BuiltInFictitiousFunctionClassFactory(int p0, int p1);

        public abstract void PlaceComponentResult(int p0, int p1);

        public abstract void getAuthRequestContext(int p0, int p1);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public abstract Object BuiltInFictitiousFunctionClassFactory();

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract void MyBillsEntityDataFactory(int p0);

    public void MyBillsEntityDataFactory(LoadType p0, LoadState p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    public abstract void PlaceComponentResult(Function2<? super LoadType, ? super LoadState, Unit> p0);

    @JvmName(name = "MyBillsEntityDataFactory")
    public PagingSource<?, T> MyBillsEntityDataFactory() {
        return this.lookAheadTest;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final CoroutineScope getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final CoroutineDispatcher getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final Config getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public PagedList(PagingSource<?, T> pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, PagedStorage<T> pagedStorage, Config config) {
        Intrinsics.checkNotNullParameter(pagingSource, "");
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(pagedStorage, "");
        Intrinsics.checkNotNullParameter(config, "");
        this.lookAheadTest = pagingSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coroutineScope;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coroutineDispatcher;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = pagedStorage;
        this.BuiltInFictitiousFunctionClassFactory = config;
        this.GetContactSyncConfig = (config.PlaceComponentResult * 2) + config.BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = new ArrayList();
        this.moveToNextValue = new ArrayList();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u008d\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0012\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Landroidx/paging/PagedList$Companion;", "", DiskFormatter.KB, "T", "Landroidx/paging/PagingSource;", "p0", "Landroidx/paging/PagingSource$LoadResult$Page;", "p1", "Lkotlinx/coroutines/CoroutineScope;", "p2", "Lkotlinx/coroutines/CoroutineDispatcher;", "p3", "p4", "Landroidx/paging/PagedList$BoundaryCallback;", "p5", "Landroidx/paging/PagedList$Config;", "p6", "p7", "Landroidx/paging/PagedList;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagedList;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static <K, T> PagedList<T> KClassImpl$Data$declaredNonStaticMembers$2(PagingSource<K, T> p0, PagingSource.LoadResult.Page<K, T> p1, CoroutineScope p2, CoroutineDispatcher p3, CoroutineDispatcher p4, BoundaryCallback<T> p5, Config p6, K p7) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p6, "");
            return new ContiguousPagedList(p0, p2, p3, p4, p5, p6, p1 == null ? (PagingSource.LoadResult.Page) BuildersKt.runBlocking$default(null, new PagedList$Companion$create$resolvedInitialPage$1(p0, new PagingSource.LoadParams.Refresh(p7, p6.getAuthRequestContext, p6.MyBillsEntityDataFactory), null), 1, null) : p1, p7);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B1\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0011\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0011\u0010\u0003\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\t\u0010\b"}, d2 = {"Landroidx/paging/PagedList$Config;", "", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "p4", "<init>", "(IIZII)V", "Companion", "Builder"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Config {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final boolean MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        public Config(int i, int i2, boolean z, int i3, int i4) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = i2;
            this.MyBillsEntityDataFactory = z;
            this.getAuthRequestContext = i3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\t"}, d2 = {"Landroidx/paging/PagedList$Config$Builder;", "", "Landroidx/paging/PagedList$Config;", "PlaceComponentResult", "()Landroidx/paging/PagedList$Config;", "", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "I", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Builder {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            public int getAuthRequestContext = -1;
            public int MyBillsEntityDataFactory = -1;

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private int PlaceComponentResult = -1;

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            public boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            private int BuiltInFictitiousFunctionClassFactory = Integer.MAX_VALUE;

            public final Config PlaceComponentResult() {
                if (this.MyBillsEntityDataFactory < 0) {
                    this.MyBillsEntityDataFactory = this.getAuthRequestContext;
                }
                if (this.PlaceComponentResult < 0) {
                    this.PlaceComponentResult = this.getAuthRequestContext * 3;
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 || this.MyBillsEntityDataFactory != 0) {
                    int i = this.BuiltInFictitiousFunctionClassFactory;
                    if (i == Integer.MAX_VALUE || i >= this.getAuthRequestContext + (this.MyBillsEntityDataFactory * 2)) {
                        return new Config(this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=");
                    sb.append(this.getAuthRequestContext);
                    sb.append(", prefetchDist=");
                    sb.append(this.MyBillsEntityDataFactory);
                    sb.append(", maxSize=");
                    sb.append(this.BuiltInFictitiousFunctionClassFactory);
                    throw new IllegalArgumentException(sb.toString());
                }
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u0012\u0010\u000b\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\f\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0012\u0010\u0007\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\n"}, d2 = {"Landroidx/paging/PagedList$LoadStateManager;", "", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/LoadState;", "p1", "", "MyBillsEntityDataFactory", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/LoadState;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadStateManager {
        public LoadState BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        LoadState getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        LoadState MyBillsEntityDataFactory;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

            static {
                int[] iArr = new int[LoadType.values().length];
                iArr[LoadType.REFRESH.ordinal()] = 1;
                iArr[LoadType.PREPEND.ordinal()] = 2;
                iArr[LoadType.APPEND.ordinal()] = 3;
                BuiltInFictitiousFunctionClassFactory = iArr;
            }
        }

        public abstract void MyBillsEntityDataFactory(LoadType p0, LoadState p1);

        public LoadStateManager() {
            LoadState.NotLoading notLoading;
            LoadState.NotLoading notLoading2;
            LoadState.NotLoading notLoading3;
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            notLoading = LoadState.NotLoading.getAuthRequestContext;
            this.BuiltInFictitiousFunctionClassFactory = notLoading;
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            notLoading2 = LoadState.NotLoading.getAuthRequestContext;
            this.MyBillsEntityDataFactory = notLoading2;
            LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
            notLoading3 = LoadState.NotLoading.getAuthRequestContext;
            this.getAuthRequestContext = notLoading3;
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0, LoadState p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (Intrinsics.areEqual(this.getAuthRequestContext, p1)) {
                            return;
                        }
                        this.getAuthRequestContext = p1;
                    }
                } else if (Intrinsics.areEqual(this.MyBillsEntityDataFactory, p1)) {
                    return;
                } else {
                    this.MyBillsEntityDataFactory = p1;
                }
            } else if (Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, p1)) {
                return;
            } else {
                this.BuiltInFictitiousFunctionClassFactory = p1;
            }
            MyBillsEntityDataFactory(p0, p1);
        }
    }

    @JvmName(name = "getErrorConfigVersion")
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final int getGetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    @JvmName(name = "moveToNextValue")
    public boolean moveToNextValue() {
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0, LoadState p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BuildersKt.launch$default(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, new PagedList$dispatchStateChangeAsync$1(this, p0, p1, null), 2, null);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int p0) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(p0);
    }

    public final void getAuthRequestContext(int p0) {
        if (p0 < 0 || p0 >= size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index: ");
            sb.append(p0);
            sb.append(", Size: ");
            sb.append(size());
            throw new IndexOutOfBoundsException(sb.toString());
        }
        PagedStorage<T> pagedStorage = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        pagedStorage.getAuthRequestContext = RangesKt.coerceIn(p0 - pagedStorage.getErrorConfigVersion, 0, pagedStorage.lookAheadTest - 1);
        MyBillsEntityDataFactory(p0);
    }

    public final void getAuthRequestContext(Function2<? super LoadType, ? super LoadState, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CollectionsKt.removeAll((List) this.moveToNextValue, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$addWeakLoadStateListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Boolean invoke2(WeakReference<Function2<LoadType, LoadState, Unit>> weakReference) {
                Intrinsics.checkNotNullParameter(weakReference, "");
                return Boolean.valueOf(weakReference.get() == null);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>> weakReference) {
                return invoke2((WeakReference<Function2<LoadType, LoadState, Unit>>) weakReference);
            }
        });
        this.moveToNextValue.add(new WeakReference<>(p0));
        PlaceComponentResult(p0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Callback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CollectionsKt.removeAll((List) this.getAuthRequestContext, (Function1) new Function1<WeakReference<Callback>, Boolean>() { // from class: androidx.paging.PagedList$addWeakCallback$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<PagedList.Callback> weakReference) {
                Intrinsics.checkNotNullParameter(weakReference, "");
                return Boolean.valueOf(weakReference.get() == null);
            }
        });
        this.getAuthRequestContext.add(new WeakReference<>(p0));
    }

    public final void BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        if (p1 == 0) {
            return;
        }
        Iterator<T> it = CollectionsKt.reversed(this.getAuthRequestContext).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.PlaceComponentResult(p0, p1);
            }
        }
    }

    public final void MyBillsEntityDataFactory(int p0, int p1) {
        if (p1 == 0) {
            return;
        }
        Iterator<T> it = CollectionsKt.reversed(this.getAuthRequestContext).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.BuiltInFictitiousFunctionClassFactory(p0, p1);
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i) {
        return (T) super.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.size();
    }
}
