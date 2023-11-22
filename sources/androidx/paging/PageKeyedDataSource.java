package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
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

@Deprecated(message = "PageKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0004\u0017\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0006\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u0006\u0010\u0011J1\u0010\u0006\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H&¢\u0006\u0004\b\u0006\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "p0", "PlaceComponentResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/paging/DataSource$Params;", "Landroidx/paging/DataSource$BaseResult;", "MyBillsEntityDataFactory", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "<init>", "()V", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/util/List;Ljava/lang/Object;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadCallback<Key, Value> {
        public abstract void getAuthRequestContext(List<? extends Value> p0, Key p1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u00022\b\u0010\u0007\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\t\u0010\nJA\u0010\u000e\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u00022\b\u0010\r\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "", "p0", "p1", "p2", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "", "p3", "p4", "PlaceComponentResult", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void MyBillsEntityDataFactory(List<? extends Value> p0, Key p1, Key p2);

        public abstract void PlaceComponentResult(List<? extends Value> p0, int p1, int p2, Key p3, Key p4);
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(LoadParams<Key> p0, LoadCallback<Key, Value> p1);

    public abstract void PlaceComponentResult(LoadInitialParams<Key> p0, LoadInitialCallback<Key, Value> p1);

    public abstract void PlaceComponentResult(LoadParams<Key> p0, LoadCallback<Key, Value> p1);

    @Override // androidx.paging.DataSource
    public final /* synthetic */ DataSource MyBillsEntityDataFactory(Function function) {
        Intrinsics.checkNotNullParameter(function, "");
        return new WrapperPageKeyedDataSource(this, function);
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u00078\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "", "Key", "", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "", "I", "p0", "p1", "<init>", "(IZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadInitialParams<Key> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final boolean BuiltInFictitiousFunctionClassFactory;

        public LoadInitialParams(int i, boolean z) {
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00028\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00028\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadParams;", "", "Key", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/lang/Object;I)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadParams<Key> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Key MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public LoadParams(Key key, int i) {
            Intrinsics.checkNotNullParameter(key, "");
            this.MyBillsEntityDataFactory = key;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }

    @Override // androidx.paging.DataSource
    public final Key PlaceComponentResult(Value p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    @Override // androidx.paging.DataSource
    public final Object MyBillsEntityDataFactory(DataSource.Params<Key> params, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        final boolean z = true;
        if (params.getAuthRequestContext == LoadType.REFRESH) {
            LoadInitialParams<Key> loadInitialParams = new LoadInitialParams<>(params.MyBillsEntityDataFactory, params.getKClassImpl$Data$declaredNonStaticMembers$2());
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            PlaceComponentResult(loadInitialParams, new LoadInitialCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$loadInitial$2$1
                @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
                public final void PlaceComponentResult(List<? extends Value> p0, int p1, int p2, Key p3, Key p4) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    CancellableContinuation<DataSource.BaseResult<Value>> cancellableContinuation = cancellableContinuationImpl2;
                    DataSource.BaseResult baseResult = new DataSource.BaseResult(p0, p3, p4, p1, (p2 - p0.size()) - p1);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(baseResult));
                }

                @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
                public final void MyBillsEntityDataFactory(List<? extends Value> p0, Key p1, Key p2) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    CancellableContinuation<DataSource.BaseResult<Value>> cancellableContinuation = cancellableContinuationImpl2;
                    DataSource.BaseResult baseResult = new DataSource.BaseResult(p0, p1, p2, 0, 0, 24, null);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(baseResult));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } else if (params.BuiltInFictitiousFunctionClassFactory == null) {
            DataSource.BaseResult.Companion companion = DataSource.BaseResult.INSTANCE;
            return DataSource.BaseResult.Companion.PlaceComponentResult();
        } else if (params.getAuthRequestContext == LoadType.PREPEND) {
            LoadParams<Key> loadParams = new LoadParams<>(params.BuiltInFictitiousFunctionClassFactory, params.PlaceComponentResult);
            CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl3.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
            final boolean z2 = false;
            PlaceComponentResult(loadParams, new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$continuationAsCallback$1
                @Override // androidx.paging.PageKeyedDataSource.LoadCallback
                public final void getAuthRequestContext(List<? extends Value> p0, Key p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    CancellableContinuation<DataSource.BaseResult<Value>> cancellableContinuation = cancellableContinuationImpl4;
                    boolean z3 = z2;
                    DataSource.BaseResult baseResult = new DataSource.BaseResult(p0, z3 ? null : p1, !z3 ? null : p1, 0, 0, 24, null);
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(baseResult));
                }
            });
            Object result2 = cancellableContinuationImpl3.getResult();
            if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result2;
        } else if (params.getAuthRequestContext == LoadType.APPEND) {
            LoadParams<Key> loadParams2 = new LoadParams<>(params.BuiltInFictitiousFunctionClassFactory, params.PlaceComponentResult);
            CancellableContinuationImpl cancellableContinuationImpl5 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl5.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl6 = cancellableContinuationImpl5;
            KClassImpl$Data$declaredNonStaticMembers$2(loadParams2, new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$continuationAsCallback$1
                @Override // androidx.paging.PageKeyedDataSource.LoadCallback
                public final void getAuthRequestContext(List<? extends Value> p0, Key p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    CancellableContinuation<DataSource.BaseResult<Value>> cancellableContinuation = cancellableContinuationImpl6;
                    boolean z3 = z;
                    DataSource.BaseResult baseResult = new DataSource.BaseResult(p0, z3 ? null : p1, !z3 ? null : p1, 0, 0, 24, null);
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(baseResult));
                }
            });
            Object result3 = cancellableContinuationImpl5.getResult();
            if (result3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result3;
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type ", params.getAuthRequestContext));
        }
    }
}
