package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001/B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u001c¢\u0006\u0004\b-\u0010.J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0011J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0007\u0010\u0013R&\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 X\u0000¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010\"\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0080\n¢\u0006\u0006\n\u0004\b$\u0010\u0018R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0%X\u0000¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0018R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u001c\u0010+\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020)@BX\u0080\n¢\u0006\u0006\n\u0004\b(\u0010*R\u0014\u0010'\u001a\u00020\n8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010,"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "", "Key", "Value", "Landroidx/paging/ViewportHint$Access;", "p0", "Landroidx/paging/PagingState;", "MyBillsEntityDataFactory", "(Landroidx/paging/ViewportHint$Access;)Landroidx/paging/PagingState;", "Landroidx/paging/LoadType;", "", "PlaceComponentResult", "(Landroidx/paging/LoadType;)I", "p1", "Landroidx/paging/PagingSource$LoadResult$Page;", "p2", "", "(ILandroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/PageEvent;", "(Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/LoadType;)Landroidx/paging/PageEvent;", "", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PagingConfig;", "scheduleImpl", "Landroidx/paging/PagingConfig;", "getErrorConfigVersion", "", "Landroidx/paging/ViewportHint;", "lookAheadTest", "Ljava/util/Map;", "moveToNextValue", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/MutableLoadStateCollection;", "GetContactSyncConfig", "()I", "<init>", "(Landroidx/paging/PagingConfig;)V", "Holder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshotState<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    int getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Channel<Integer> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    int scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    final Channel<Integer> initRecordTimeStamp;
    int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final List<PagingSource.LoadResult.Page<Key, Value>> MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final List<PagingSource.LoadResult.Page<Key, Value>> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    MutableLoadStateCollection GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final Map<LoadType, ViewportHint> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    int lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final PagingConfig getErrorConfigVersion;

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

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.getErrorConfigVersion = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory = arrayList;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayList;
        this.initRecordTimeStamp = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.moveToNextValue = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.getAuthRequestContext(LoadType.REFRESH, LoadState.Loading.INSTANCE);
        Unit unit = Unit.INSTANCE;
        this.GetContactSyncConfig = mutableLoadStateCollection;
    }

    @JvmName(name = "getAuthRequestContext")
    public final int getAuthRequestContext() {
        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((PagingSource.LoadResult.Page) it.next()).MyBillsEntityDataFactory.size();
        }
        return i;
    }

    public final int PlaceComponentResult(LoadType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return this.PlaceComponentResult;
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.scheduleImpl;
        }
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }

    public final PageEvent<Value> MyBillsEntityDataFactory(PagingSource.LoadResult.Page<Key, Value> page, LoadType loadType) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(loadType, "");
        int i3 = WhenMappings.BuiltInFictitiousFunctionClassFactory[loadType.ordinal()];
        if (i3 == 1) {
            i = 0;
        } else if (i3 == 2) {
            i = 0 - this.lookAheadTest;
        } else if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = (this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() - this.lookAheadTest) - 1;
        }
        List listOf = CollectionsKt.listOf(new TransformablePage(i, page.MyBillsEntityDataFactory));
        int i4 = WhenMappings.BuiltInFictitiousFunctionClassFactory[loadType.ordinal()];
        if (i4 == 1) {
            PageEvent.Insert.Companion companion = PageEvent.Insert.INSTANCE;
            int i5 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.getAuthRequestContext : 0;
            i2 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.BuiltInFictitiousFunctionClassFactory : 0;
            MutableLoadStateCollection mutableLoadStateCollection = this.GetContactSyncConfig;
            return PageEvent.Insert.Companion.KClassImpl$Data$declaredNonStaticMembers$2(listOf, i5, i2, new LoadStates(mutableLoadStateCollection.PlaceComponentResult, mutableLoadStateCollection.MyBillsEntityDataFactory, mutableLoadStateCollection.BuiltInFictitiousFunctionClassFactory), null);
        } else if (i4 == 2) {
            PageEvent.Insert.Companion companion2 = PageEvent.Insert.INSTANCE;
            i2 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.getAuthRequestContext : 0;
            MutableLoadStateCollection mutableLoadStateCollection2 = this.GetContactSyncConfig;
            return PageEvent.Insert.Companion.KClassImpl$Data$declaredNonStaticMembers$2(listOf, i2, new LoadStates(mutableLoadStateCollection2.PlaceComponentResult, mutableLoadStateCollection2.MyBillsEntityDataFactory, mutableLoadStateCollection2.BuiltInFictitiousFunctionClassFactory), null);
        } else if (i4 == 3) {
            PageEvent.Insert.Companion companion3 = PageEvent.Insert.INSTANCE;
            i2 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.BuiltInFictitiousFunctionClassFactory : 0;
            MutableLoadStateCollection mutableLoadStateCollection3 = this.GetContactSyncConfig;
            return PageEvent.Insert.Companion.PlaceComponentResult(listOf, i2, new LoadStates(mutableLoadStateCollection3.PlaceComponentResult, mutableLoadStateCollection3.MyBillsEntityDataFactory, mutableLoadStateCollection3.BuiltInFictitiousFunctionClassFactory), null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean PlaceComponentResult(int p0, LoadType p1, PagingSource.LoadResult.Page<Key, Value> p2) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        int i3 = WhenMappings.BuiltInFictitiousFunctionClassFactory[p1.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if ((!this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) == false) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    }
                    if (p0 != this.PlaceComponentResult) {
                        return false;
                    }
                    this.MyBillsEntityDataFactory.add(p2);
                    if (p2.PlaceComponentResult == Integer.MIN_VALUE) {
                        i2 = RangesKt.coerceAtLeast((this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.BuiltInFictitiousFunctionClassFactory : 0) - p2.MyBillsEntityDataFactory.size(), 0);
                    } else {
                        i2 = p2.PlaceComponentResult;
                    }
                    this.BuiltInFictitiousFunctionClassFactory = i2 != Integer.MIN_VALUE ? i2 : 0;
                    this.moveToNextValue.remove(LoadType.APPEND);
                }
            } else if ((!this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) == false) {
                throw new IllegalStateException("should've received an init before prepend".toString());
            } else {
                if (p0 != this.scheduleImpl) {
                    return false;
                }
                this.MyBillsEntityDataFactory.add(0, p2);
                this.lookAheadTest++;
                if (p2.BuiltInFictitiousFunctionClassFactory == Integer.MIN_VALUE) {
                    i = RangesKt.coerceAtLeast((this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.getAuthRequestContext : 0) - p2.MyBillsEntityDataFactory.size(), 0);
                } else {
                    i = p2.BuiltInFictitiousFunctionClassFactory;
                }
                this.getAuthRequestContext = i != Integer.MIN_VALUE ? i : 0;
                this.moveToNextValue.remove(LoadType.PREPEND);
            }
        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) {
            throw new IllegalStateException("cannot receive multiple init calls".toString());
        } else {
            if (!(p0 == 0)) {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
            this.MyBillsEntityDataFactory.add(p2);
            this.lookAheadTest = 0;
            int i4 = p2.PlaceComponentResult;
            if (i4 == Integer.MIN_VALUE) {
                i4 = 0;
            }
            this.BuiltInFictitiousFunctionClassFactory = i4;
            int i5 = p2.BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = i5 != Integer.MIN_VALUE ? i5 : 0;
        }
        return true;
    }

    public final PagingState<Key, Value> MyBillsEntityDataFactory(ViewportHint.Access p0) {
        Integer valueOf;
        int size;
        List list = CollectionsKt.toList(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (p0 == null) {
            valueOf = null;
        } else {
            int i = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory ? this.getAuthRequestContext : 0;
            int i2 = -this.lookAheadTest;
            int lastIndex = CollectionsKt.getLastIndex(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            int i3 = this.lookAheadTest;
            int i4 = p0.BuiltInFictitiousFunctionClassFactory;
            if (i2 < i4) {
                int i5 = i2;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 > lastIndex - i3) {
                        size = this.getErrorConfigVersion.getAuthRequestContext;
                    } else {
                        size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i5 + this.lookAheadTest).MyBillsEntityDataFactory.size();
                    }
                    i += size;
                    if (i6 >= i4) {
                        break;
                    }
                    i5 = i6;
                }
            }
            int i7 = i + p0.getAuthRequestContext;
            if (p0.BuiltInFictitiousFunctionClassFactory < i2) {
                i7 -= this.getErrorConfigVersion.getAuthRequestContext;
            }
            valueOf = Integer.valueOf(i7);
        }
        PagingConfig pagingConfig = this.getErrorConfigVersion;
        return new PagingState<>(list, valueOf, pagingConfig, pagingConfig.BuiltInFictitiousFunctionClassFactory ? this.getAuthRequestContext : 0);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\t\u001a\u00028\u0004\"\u0004\b\u0004\u0010\u00042%\u0010\b\u001a!\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00028\u00040\u0005H\u0086Hø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\t\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "", "Key", "Value", "T", "Lkotlin/Function1;", "Landroidx/paging/PageFetcherSnapshotState;", "Lkotlin/ParameterName;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingConfig;", "Landroidx/paging/PagingConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/sync/Mutex;", "getAuthRequestContext", "Lkotlinx/coroutines/sync/Mutex;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/PageFetcherSnapshotState;", "PlaceComponentResult", "<init>", "(Landroidx/paging/PagingConfig;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder<Key, Value> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final PageFetcherSnapshotState<Key, Value> PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final PagingConfig KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Mutex MyBillsEntityDataFactory;

        public Holder(PagingConfig pagingConfig) {
            Intrinsics.checkNotNullParameter(pagingConfig, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pagingConfig;
            this.MyBillsEntityDataFactory = MutexKt.Mutex$default(false, 1, null);
            this.PlaceComponentResult = new PageFetcherSnapshotState<>(pagingConfig, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <T> java.lang.Object MyBillsEntityDataFactory(kotlin.coroutines.Continuation<? super T> r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                if (r0 == 0) goto L14
                r0 = r6
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = (androidx.paging.PageFetcherSnapshotState$Holder$withLock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r6 = r0.label
                int r6 = r6 + r2
                r0.label = r6
                goto L19
            L14:
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = new androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                r0.<init>(r5, r6)
            L19:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L3f
                if (r2 != r4) goto L37
                java.lang.Object r1 = r0.L$2
                kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                java.lang.Object r0 = r0.L$0
                androidx.paging.PageFetcherSnapshotState$Holder r0 = (androidx.paging.PageFetcherSnapshotState.Holder) r0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L56
            L37:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L3f:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.sync.Mutex r6 = r5.MyBillsEntityDataFactory
                r0.L$0 = r5
                r0.L$1 = r3
                r0.L$2 = r6
                r0.label = r4
                java.lang.Object r0 = r6.lock(r3, r0)
                if (r0 != r1) goto L53
                return r1
            L53:
                r0 = r5
                r1 = r6
                r2 = r3
            L56:
                androidx.paging.PageFetcherSnapshotState<Key, Value> r6 = r0.PlaceComponentResult     // Catch: java.lang.Throwable -> L66
                java.lang.Object r6 = r2.invoke(r6)     // Catch: java.lang.Throwable -> L66
                kotlin.jvm.internal.InlineMarker.finallyStart(r4)
                r1.unlock(r3)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
                return r6
            L66:
                r6 = move-exception
                kotlin.jvm.internal.InlineMarker.finallyStart(r4)
                r1.unlock(r3)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshotState.Holder.MyBillsEntityDataFactory(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
