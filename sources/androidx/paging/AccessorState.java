package androidx.paging;

import androidx.paging.LoadState;
import id.dana.kyb.domain.constant.TransactionQueryType;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0011¢\u0006\u0004\b\t\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001c"}, d2 = {"Landroidx/paging/AccessorState;", "", "Key", "Value", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/PagingState;", "p1", "", "getAuthRequestContext", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)Z", "Landroidx/paging/LoadStates;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/LoadStates;", "Landroidx/paging/LoadState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "Lkotlin/Pair;", "()Lkotlin/Pair;", "", "Landroidx/paging/AccessorState$BlockState;", "[Landroidx/paging/AccessorState$BlockState;", "MyBillsEntityDataFactory", "Landroidx/paging/LoadState$Error;", "[Landroidx/paging/LoadState$Error;", "PlaceComponentResult", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "Lkotlin/collections/ArrayDeque;", "<init>", "()V", "BlockState", "PendingRequest"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final class AccessorState<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final LoadState.Error[] PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final ArrayDeque<PendingRequest<Key, Value>> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final BlockState[] MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "<init>", "(Ljava/lang/String;I)V", "UNBLOCKED", TransactionQueryType.COMPLETED, "REQUIRES_REFRESH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[BlockState.values().length];
            iArr[BlockState.COMPLETED.ordinal()] = 1;
            iArr[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            iArr[BlockState.UNBLOCKED.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            int[] iArr2 = new int[LoadType.values().length];
            iArr2[LoadType.REFRESH.ordinal()] = 1;
            BuiltInFictitiousFunctionClassFactory = iArr2;
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i = 0; i < length; i++) {
            blockStateArr[i] = BlockState.UNBLOCKED;
        }
        this.MyBillsEntityDataFactory = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            errorArr[i2] = null;
        }
        this.PlaceComponentResult = errorArr;
        this.getAuthRequestContext = new ArrayDeque<>();
    }

    public final LoadStates BuiltInFictitiousFunctionClassFactory() {
        return new LoadStates(KClassImpl$Data$declaredNonStaticMembers$2(LoadType.REFRESH), KClassImpl$Data$declaredNonStaticMembers$2(LoadType.PREPEND), KClassImpl$Data$declaredNonStaticMembers$2(LoadType.APPEND));
    }

    private final LoadState KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0) {
        LoadState.NotLoading BuiltInFictitiousFunctionClassFactory;
        LoadState.NotLoading notLoading;
        LoadState.NotLoading notLoading2;
        BlockState blockState = this.MyBillsEntityDataFactory[p0.ordinal()];
        ArrayDeque<PendingRequest<Key, Value>> arrayDeque = this.getAuthRequestContext;
        boolean z = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<PendingRequest<Key, Value>> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().PlaceComponentResult == p0) {
                    z = true;
                    break;
                }
            }
        }
        if (z && blockState != BlockState.REQUIRES_REFRESH) {
            return LoadState.Loading.INSTANCE;
        }
        LoadState.Error error = this.PlaceComponentResult[p0.ordinal()];
        if (error != null) {
            return error;
        }
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[blockState.ordinal()];
        if (i == 1) {
            if (WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.ordinal()] == 1) {
                LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
                BuiltInFictitiousFunctionClassFactory = LoadState.NotLoading.getAuthRequestContext;
            } else {
                LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
                BuiltInFictitiousFunctionClassFactory = LoadState.NotLoading.Companion.BuiltInFictitiousFunctionClassFactory();
            }
            return BuiltInFictitiousFunctionClassFactory;
        } else if (i == 2) {
            LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
            notLoading = LoadState.NotLoading.getAuthRequestContext;
            return notLoading;
        } else if (i == 3) {
            LoadState.NotLoading.Companion companion4 = LoadState.NotLoading.INSTANCE;
            notLoading2 = LoadState.NotLoading.getAuthRequestContext;
            return notLoading2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean getAuthRequestContext(LoadType p0, PagingState<Key, Value> p1) {
        PendingRequest<Key, Value> pendingRequest;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Iterator<PendingRequest<Key, Value>> it = this.getAuthRequestContext.iterator();
        while (true) {
            if (!it.hasNext()) {
                pendingRequest = null;
                break;
            }
            pendingRequest = it.next();
            if (pendingRequest.PlaceComponentResult == p0) {
                break;
            }
        }
        PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
        if (pendingRequest2 != null) {
            Intrinsics.checkNotNullParameter(p1, "");
            pendingRequest2.getAuthRequestContext = p1;
            return false;
        }
        BlockState blockState = this.MyBillsEntityDataFactory[p0.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && p0 != LoadType.REFRESH) {
            this.getAuthRequestContext.add(new PendingRequest<>(p0, p1));
            return false;
        } else if (blockState == BlockState.UNBLOCKED || p0 == LoadType.REFRESH) {
            if (p0 == LoadType.REFRESH) {
                LoadType loadType = LoadType.REFRESH;
                Intrinsics.checkNotNullParameter(loadType, "");
                this.PlaceComponentResult[loadType.ordinal()] = null;
            }
            if (this.PlaceComponentResult[p0.ordinal()] == null) {
                return this.getAuthRequestContext.add(new PendingRequest<>(p0, p1));
            }
            return false;
        } else {
            return false;
        }
    }

    public final Pair<LoadType, PagingState<Key, Value>> getAuthRequestContext() {
        PendingRequest<Key, Value> pendingRequest;
        Iterator<PendingRequest<Key, Value>> it = this.getAuthRequestContext.iterator();
        while (true) {
            if (!it.hasNext()) {
                pendingRequest = null;
                break;
            }
            pendingRequest = it.next();
            PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
            if (pendingRequest2.PlaceComponentResult != LoadType.REFRESH && this.MyBillsEntityDataFactory[pendingRequest2.PlaceComponentResult.ordinal()] == BlockState.UNBLOCKED) {
                break;
            }
        }
        PendingRequest<Key, Value> pendingRequest3 = pendingRequest;
        if (pendingRequest3 == null) {
            return null;
        }
        return TuplesKt.to(pendingRequest3.PlaceComponentResult, pendingRequest3.getAuthRequestContext);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "", "Key", "Value", "Landroidx/paging/LoadType;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/LoadType;", "PlaceComponentResult", "Landroidx/paging/PagingState;", "MyBillsEntityDataFactory", "Landroidx/paging/PagingState;", "getAuthRequestContext", "p0", "p1", "<init>", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PendingRequest<Key, Value> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final LoadType PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        PagingState<Key, Value> getAuthRequestContext;

        public PendingRequest(LoadType loadType, PagingState<Key, Value> pagingState) {
            Intrinsics.checkNotNullParameter(loadType, "");
            Intrinsics.checkNotNullParameter(pagingState, "");
            this.PlaceComponentResult = loadType;
            this.getAuthRequestContext = pagingState;
        }
    }
}
