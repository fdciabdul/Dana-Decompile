package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Deprecated(message = "PositionalDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Int, T>", imports = {"androidx.paging.PagingSource"}))
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 \u0015*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0005\u0015\u0016\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ%\u0010\b\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0004\b\b\u0010\u000eJ%\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PositionalDataSource;", "", "T", "Landroidx/paging/DataSource;", "", "Landroidx/paging/DataSource$Params;", "p0", "Landroidx/paging/DataSource$BaseResult;", "MyBillsEntityDataFactory", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "p1", "", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/PositionalDataSource$LoadInitialCallback;)V", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "getAuthRequestContext", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Landroidx/paging/PositionalDataSource$LoadRangeCallback;)V", "<init>", "()V", "Companion", "LoadInitialCallback", "LoadInitialParams", "LoadRangeCallback", "LoadRangeParams"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "T", "", "", "p0", "", "p1", "", "PlaceComponentResult", "(Ljava/util/List;I)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadInitialCallback<T> {
        public abstract void PlaceComponentResult(List<? extends T> p0, int p1);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "T", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadRangeCallback<T> {
    }

    public abstract void MyBillsEntityDataFactory(LoadInitialParams p0, LoadInitialCallback<T> p1);

    public abstract void getAuthRequestContext(LoadRangeParams p0, LoadRangeCallback<T> p1);

    @Override // androidx.paging.DataSource
    public final /* synthetic */ DataSource MyBillsEntityDataFactory(Function function) {
        Intrinsics.checkNotNullParameter(function, "");
        return new WrapperPositionalDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final /* synthetic */ Integer PlaceComponentResult(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00058\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "", "getAuthRequestContext", "I", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "p0", "p1", "p2", "p3", "<init>", "(IIIZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadInitialParams {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;
        public final int getAuthRequestContext;

        public LoadInitialParams(int i, int i2, int i3, boolean z) {
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.getAuthRequestContext = i3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            if (!(i >= 0)) {
                throw new IllegalStateException(Intrinsics.stringPlus("invalid start position: ", Integer.valueOf(i)).toString());
            }
            if (!(i2 >= 0)) {
                throw new IllegalStateException(Intrinsics.stringPlus("invalid load size: ", Integer.valueOf(i2)).toString());
            }
            if (!(i3 >= 0)) {
                throw new IllegalStateException(Intrinsics.stringPlus("invalid page size: ", Integer.valueOf(i3)).toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(II)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadRangeParams {
        public final int MyBillsEntityDataFactory;
        public final int PlaceComponentResult;

        public LoadRangeParams(int i, int i2) {
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = i2;
        }
    }

    @Override // androidx.paging.DataSource
    public final Object MyBillsEntityDataFactory(DataSource.Params<Integer> params, Continuation<? super DataSource.BaseResult<T>> continuation) {
        if (params.getAuthRequestContext == LoadType.REFRESH) {
            int i = params.MyBillsEntityDataFactory;
            int i2 = 0;
            if (params.BuiltInFictitiousFunctionClassFactory != null) {
                int intValue = params.BuiltInFictitiousFunctionClassFactory.intValue();
                if (!params.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    i2 = Math.max(0, intValue - (i / 2));
                } else {
                    i = Math.max(i / params.PlaceComponentResult, 2) * params.PlaceComponentResult;
                    i2 = Math.max(0, ((intValue - (i / 2)) / params.PlaceComponentResult) * params.PlaceComponentResult);
                }
            }
            final LoadInitialParams loadInitialParams = new LoadInitialParams(i2, i, params.PlaceComponentResult, params.getKClassImpl$Data$declaredNonStaticMembers$2());
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            MyBillsEntityDataFactory(loadInitialParams, new LoadInitialCallback<T>(this) { // from class: androidx.paging.PositionalDataSource$loadInitial$2$1
                final /* synthetic */ PositionalDataSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
                }

                @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
                public final void PlaceComponentResult(List<? extends T> p0, int p1) {
                    int i3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
                        CancellableContinuation<DataSource.BaseResult<T>> cancellableContinuation = cancellableContinuationImpl2;
                        DataSource.BaseResult.Companion companion = DataSource.BaseResult.INSTANCE;
                        DataSource.BaseResult PlaceComponentResult = DataSource.BaseResult.Companion.PlaceComponentResult();
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m3179constructorimpl(PlaceComponentResult));
                        return;
                    }
                    PositionalDataSource.LoadInitialParams loadInitialParams2 = loadInitialParams;
                    DataSource.BaseResult baseResult = new DataSource.BaseResult(p0, p1 == 0 ? null : Integer.valueOf(p1), Integer.valueOf(p0.size() + p1), p1, Integer.MIN_VALUE);
                    if (loadInitialParams2.KClassImpl$Data$declaredNonStaticMembers$2) {
                        int i4 = loadInitialParams2.getAuthRequestContext;
                        if (baseResult.PlaceComponentResult == Integer.MIN_VALUE || (i3 = baseResult.MyBillsEntityDataFactory) == Integer.MIN_VALUE) {
                            throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
                        }
                        if (i3 > 0 && baseResult.BuiltInFictitiousFunctionClassFactory.size() % i4 != 0) {
                            int i5 = baseResult.PlaceComponentResult;
                            int size = baseResult.BuiltInFictitiousFunctionClassFactory.size();
                            int i6 = baseResult.MyBillsEntityDataFactory;
                            StringBuilder sb = new StringBuilder();
                            sb.append("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize ");
                            sb.append(baseResult.BuiltInFictitiousFunctionClassFactory.size());
                            sb.append(", position ");
                            sb.append(baseResult.PlaceComponentResult);
                            sb.append(", totalCount ");
                            sb.append(i5 + size + i6);
                            sb.append(", pageSize ");
                            sb.append(i4);
                            throw new IllegalArgumentException(sb.toString());
                        } else if (baseResult.PlaceComponentResult % i4 != 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Initial load must be pageSize aligned.Position = ");
                            sb2.append(baseResult.PlaceComponentResult);
                            sb2.append(", pageSize = ");
                            sb2.append(i4);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    }
                    CancellableContinuation<DataSource.BaseResult<T>> cancellableContinuation2 = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m3179constructorimpl(baseResult));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        Integer num = params.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNull(num);
        int intValue2 = num.intValue();
        int i3 = params.PlaceComponentResult;
        if (params.getAuthRequestContext == LoadType.PREPEND) {
            i3 = Math.min(i3, intValue2);
            intValue2 -= i3;
        }
        final LoadRangeParams loadRangeParams = new LoadRangeParams(intValue2, i3);
        CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl3.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
        getAuthRequestContext(loadRangeParams, new LoadRangeCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadRange$2$1
        });
        Object result2 = cancellableContinuationImpl3.getResult();
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }
}
