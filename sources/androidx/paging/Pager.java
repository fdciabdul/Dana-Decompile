package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B7\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\f¢\u0006\u0004\b\u000f\u0010\u0010BM\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\f¢\u0006\u0004\b\u000f\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/Pager;", "", "Key", "Value", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "Landroidx/paging/PagingConfig;", "p0", "p1", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "p2", "<init>", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "Landroidx/paging/RemoteMediator;", "p3", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;B)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Pager<Key, Value> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Flow<PagingData<Value>> PlaceComponentResult;

    @ExperimentalPagingApi
    private Pager(PagingConfig pagingConfig, Key key, Function0<? extends PagingSource<Key, Value>> function0, byte b) {
        Pager$flow$2 pager$flow$2;
        Intrinsics.checkNotNullParameter(pagingConfig, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (function0 instanceof SuspendingPagingSourceFactory) {
            pager$flow$2 = new Pager$flow$1(function0);
        } else {
            pager$flow$2 = new Pager$flow$2(function0, null);
        }
        this.PlaceComponentResult = new PageFetcher(pager$flow$2, key, pagingConfig).PlaceComponentResult;
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private Pager(PagingConfig pagingConfig, Key key, Function0<? extends PagingSource<Key, Value>> function0) {
        this(pagingConfig, key, function0, (byte) 0);
        Intrinsics.checkNotNullParameter(pagingConfig, "");
        Intrinsics.checkNotNullParameter(function0, "");
    }
}
