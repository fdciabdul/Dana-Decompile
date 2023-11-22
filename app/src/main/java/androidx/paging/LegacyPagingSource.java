package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001d*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u001dB#\u0012\u0006\u0010\u0006\u001a\u00020\u0014\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011X\u0000¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u00178WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "", "Key", "Value", "Landroidx/paging/PagingSource;", "Landroidx/paging/PagingState;", "p0", "PlaceComponentResult", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "Landroidx/paging/PagingSource$LoadParams;", "Landroidx/paging/PagingSource$LoadResult;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "MyBillsEntityDataFactory", "(I)V", "Landroidx/paging/DataSource;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/DataSource;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "()Z", "I", "p1", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/DataSource;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    private static final Companion Companion = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final DataSource<Key, Value> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CoroutineDispatcher BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
            PlaceComponentResult = iArr;
        }
    }

    public LegacyPagingSource(CoroutineDispatcher coroutineDispatcher, DataSource<Key, Value> dataSource) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(dataSource, "");
        this.BuiltInFictitiousFunctionClassFactory = coroutineDispatcher;
        this.PlaceComponentResult = dataSource;
        this.MyBillsEntityDataFactory = Integer.MIN_VALUE;
        dataSource.PlaceComponentResult((DataSource.InvalidatedCallback) new AnonymousClass1(this));
        Function0<Unit> function0 = new Function0<Unit>(this) { // from class: androidx.paging.LegacyPagingSource.2
            final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            /* renamed from: androidx.paging.LegacyPagingSource$2$1 */
            /* loaded from: classes3.dex */
            public final /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {
                final /* synthetic */ LegacyPagingSource<Key, Value> PlaceComponentResult;

                AnonymousClass1(LegacyPagingSource<Key, Value> legacyPagingSource) {
                    this.PlaceComponentResult = legacyPagingSource;
                }

                public final boolean equals(Object obj) {
                    if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
                        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                    }
                    return false;
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function<?> getFunctionDelegate() {
                    return new FunctionReferenceImpl(0, this.PlaceComponentResult, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                @Override // androidx.paging.DataSource.InvalidatedCallback
                public final void getAuthRequestContext() {
                    this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                this.this$0.PlaceComponentResult.MyBillsEntityDataFactory(new AnonymousClass1(this.this$0));
                this.this$0.PlaceComponentResult.MyBillsEntityDataFactory();
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.paging.LegacyPagingSource$1 */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {
        final /* synthetic */ LegacyPagingSource<Key, Value> PlaceComponentResult;

        AnonymousClass1(LegacyPagingSource<Key, Value> legacyPagingSource) {
            this.PlaceComponentResult = legacyPagingSource;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(0, this.PlaceComponentResult, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final void getAuthRequestContext() {
            this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext();
        }
    }

    public final void MyBillsEntityDataFactory(int p0) {
        int i = this.MyBillsEntityDataFactory;
        if (!(i == Integer.MIN_VALUE || p0 == i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Page size is already set to ");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append('.');
            throw new IllegalStateException(sb.toString().toString());
        }
        this.MyBillsEntityDataFactory = p0;
    }

    @Override // androidx.paging.PagingSource
    public final Object BuiltInFictitiousFunctionClassFactory(PagingSource.LoadParams<Key> loadParams, Continuation<? super PagingSource.LoadResult<Key, Value>> continuation) {
        LoadType loadType;
        int i;
        boolean z = loadParams instanceof PagingSource.LoadParams.Refresh;
        if (z) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else if (!(loadParams instanceof PagingSource.LoadParams.Prepend)) {
            throw new NoWhenBranchMatchedException();
        } else {
            loadType = LoadType.PREPEND;
        }
        LoadType loadType2 = loadType;
        if (this.MyBillsEntityDataFactory == Integer.MIN_VALUE) {
            System.out.println((Object) "WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            if (z && loadParams.getAuthRequestContext % 3 == 0) {
                i = loadParams.getAuthRequestContext / 3;
            } else {
                i = loadParams.getAuthRequestContext;
            }
            this.MyBillsEntityDataFactory = i;
        }
        return BuildersKt.withContext(this.BuiltInFictitiousFunctionClassFactory, new LegacyPagingSource$load$2(this, new DataSource.Params(loadType2, loadParams.PlaceComponentResult(), loadParams.getAuthRequestContext, loadParams.getMyBillsEntityDataFactory(), this.MyBillsEntityDataFactory), loadParams, null), continuation);
    }

    @Override // androidx.paging.PagingSource
    public final Key PlaceComponentResult(PagingState<Key, Value> p0) {
        int i;
        Key key;
        int i2;
        PagingSource.LoadResult.Page<Key, Value> page;
        boolean z;
        int i3;
        Value value;
        Intrinsics.checkNotNullParameter(p0, "");
        int i4 = WhenMappings.PlaceComponentResult[this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.ordinal()];
        int i5 = 0;
        PagingSource.LoadResult.Page<Key, Value> page2 = null;
        boolean z2 = true;
        if (i4 == 1) {
            Integer num = p0.PlaceComponentResult;
            if (num == null) {
                return null;
            }
            int intValue = num.intValue();
            i = ((PagingState) p0).KClassImpl$Data$declaredNonStaticMembers$2;
            int i6 = intValue - i;
            for (int i7 = 0; i7 < CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory) && i6 > CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory.get(i7).MyBillsEntityDataFactory); i7++) {
                i6 -= p0.MyBillsEntityDataFactory.get(i7).MyBillsEntityDataFactory.size();
            }
            List<PagingSource.LoadResult.Page<Key, Value>> list = p0.MyBillsEntityDataFactory;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((PagingSource.LoadResult.Page) it.next()).MyBillsEntityDataFactory.isEmpty()) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (!z2) {
                i2 = ((PagingState) p0).KClassImpl$Data$declaredNonStaticMembers$2;
                int i8 = intValue - i2;
                int i9 = 0;
                while (i9 < CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory) && i8 > CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory.get(i9).MyBillsEntityDataFactory)) {
                    i8 -= p0.MyBillsEntityDataFactory.get(i9).MyBillsEntityDataFactory.size();
                    i9++;
                }
                if (i8 < 0) {
                    page = (PagingSource.LoadResult.Page) CollectionsKt.first((List) p0.MyBillsEntityDataFactory);
                } else {
                    page = p0.MyBillsEntityDataFactory.get(i9);
                }
                page2 = page;
            }
            if (page2 == null || (key = page2.getAuthRequestContext) == null) {
                key = (Key) 0;
            }
            return (Key) Integer.valueOf(((Integer) key).intValue() + i6);
        } else if (i4 != 2) {
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Integer num2 = p0.PlaceComponentResult;
            if (num2 == null) {
                return null;
            }
            int intValue2 = num2.intValue();
            List<PagingSource.LoadResult.Page<Key, Value>> list2 = p0.MyBillsEntityDataFactory;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!((PagingSource.LoadResult.Page) it2.next()).MyBillsEntityDataFactory.isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                i3 = ((PagingState) p0).KClassImpl$Data$declaredNonStaticMembers$2;
                int i10 = intValue2 - i3;
                while (i5 < CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory) && i10 > CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory.get(i5).MyBillsEntityDataFactory)) {
                    i10 -= p0.MyBillsEntityDataFactory.get(i5).MyBillsEntityDataFactory.size();
                    i5++;
                }
                Iterator<T> it3 = p0.MyBillsEntityDataFactory.iterator();
                while (it3.hasNext()) {
                    PagingSource.LoadResult.Page page3 = (PagingSource.LoadResult.Page) it3.next();
                    if ((!page3.MyBillsEntityDataFactory.isEmpty()) != false) {
                        List<PagingSource.LoadResult.Page<Key, Value>> list3 = p0.MyBillsEntityDataFactory;
                        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list3.listIterator(list3.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page<Key, Value> previous = listIterator.previous();
                            if ((!previous.MyBillsEntityDataFactory.isEmpty()) != false) {
                                if (i10 < 0) {
                                    value = (Value) CollectionsKt.first((List) page3.MyBillsEntityDataFactory);
                                } else if (i5 == CollectionsKt.getLastIndex(p0.MyBillsEntityDataFactory) && i10 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt.last((List) p0.MyBillsEntityDataFactory)).MyBillsEntityDataFactory)) {
                                    value = (Value) CollectionsKt.last((List) previous.MyBillsEntityDataFactory);
                                } else {
                                    value = p0.MyBillsEntityDataFactory.get(i5).MyBillsEntityDataFactory.get(i10);
                                }
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            value = null;
            if (value == null) {
                return null;
            }
            return this.PlaceComponentResult.PlaceComponentResult((DataSource<Key, Value>) value);
        } else {
            return null;
        }
    }

    @Override // androidx.paging.PagingSource
    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == DataSource.KeyType.POSITIONAL;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/paging/LegacyPagingSource$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
